package net.nanopool;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author cvh
 */
public class NanoPoolManagement implements NanoPoolManagementMBean {
    private final NanoPoolDataSource np;

    public NanoPoolManagement(DataSource np) {
        if (np == null) throw new NullPointerException(
                "DataSource parameter must be non-null and of type " +
                "net.nanopool.NanoPoolDataSource.");
        this.np = (NanoPoolDataSource)np;
    }

    public int getCurrentOpenConnectionsCount() {
        return np.fsm.countOpenConnections(np.connectors);
    }

    public int getPoolSize() {
        return np.poolSize;
    }

    public long getConnectionTimeToLive() {
        return np.timeToLive;
    }

    public String getContentionHandlerClassName() {
        try {
            return np.contentionHandler.getClass().getName();
        } catch (NullPointerException npe) {
            return "null";
        }
    }

    public String getContentionHandler() {
        return String.valueOf(np.contentionHandler);
    }

    public boolean isShutDown() {
        // this is what I'm going to call "best effort" :-p
        return np.connectors.get(0) == FsmMixin.shutdownMarker;
    }

    public String shutDown() {
        List<SQLException> faults = np.shutdown();
        if (faults.size() > 0) {
            StringWriter sos = new StringWriter();
            PrintWriter pout = new PrintWriter(sos);
            for (SQLException ex : faults) {
                ex.printStackTrace(pout);
            }
            pout.close();
            return sos.toString();
        }
        return "Shutdown completed successfully.";
    }

    public String getSourceConnectionClassName() {
        try {
            return np.source.getClass().getName();
        } catch (NullPointerException npe) {
            return "null";
        }
    }

    public String getSourceConnection() {
        return String.valueOf(np.source);
    }
}