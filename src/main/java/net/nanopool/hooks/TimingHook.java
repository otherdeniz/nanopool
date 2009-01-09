package net.nanopool.hooks;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import javax.sql.ConnectionPoolDataSource;

/**
 *
 * @author cvh
 */
public class TimingHook implements Hook {
    private final ReentrantReadWriteLock rwlock;
    private final ReadLock readLock;
    private final WriteLock writeLock;
    private long totalTimeMs = 0;
    private int totalConnects = 0;

    private final ThreadLocal<Long> currentStartTime = new ThreadLocal<Long>();
    private final EventType startType;
    private final EventType endType;

    public TimingHook(EventType timerStartType, EventType timerEndType) {
        this.startType = timerStartType;
        this.endType = timerEndType;
        rwlock = new ReentrantReadWriteLock(true);
        readLock = rwlock.readLock();
        writeLock = rwlock.writeLock();
    }

    public void run(EventType type, ConnectionPoolDataSource source, Connection con, SQLException sqle) {
        if (type == startType) {
            currentStartTime.set(System.nanoTime());
        } else if (type == endType) {
            long end = System.nanoTime();
            long start = currentStartTime.get();
            long spanMs = (end - start) / 1000000L;
            writeLock.lock();
            try {
                totalTimeMs += spanMs;
                totalConnects++;
            } finally {
                writeLock.unlock();
            }
        }
    }

    public double avgMs() {
        double ms = 0;
        double connects = 0;
        readLock.lock();
        try {
            ms = totalTimeMs;
            connects = totalConnects;
        } finally {
            readLock.unlock();
        }
        return ms / connects;
    }

    public long totalMs() {
        readLock.lock();
        try {
            return totalTimeMs;
        } finally {
            readLock.unlock();
        }
    }

    public int totalConnects() {
        readLock.lock();
        try {
            return totalConnects;
        } finally {
            readLock.unlock();
        }
    }

    public void reset() {
        writeLock.lock();
        try {
            totalConnects = 0;
            totalTimeMs = 0;
        } finally {
            writeLock.unlock();
        }
    }
}
