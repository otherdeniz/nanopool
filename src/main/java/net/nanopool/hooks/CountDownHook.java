/*
   Copyright 2008-2009 Christian Vest Hansen

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package net.nanopool.hooks;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This hook decrements an {@link AtomicInteger} by one every time it is run.
 * This class is symmetric with the {@link CountUpHook}, and the two
 * together can be used to create 'current' counters by counting up and down
 * on pre- and post-conditions.
 * @author cvh
 */
public class CountDownHook implements Hook {
  /**
   * The AtomicInteger that is used for counting. You can reset and modify the
   * count with this.
   */
  public final AtomicInteger counter;
  
  /**
   * Create a new CountDownHook that uses the specified AtomicInteger for
   * counting.
   * @param counter
   */
  public CountDownHook(AtomicInteger counter) {
    if (counter == null) {
      throw new NullPointerException("counter cannot be null.");
    }
    this.counter = counter;
  }
  
  /**
   * Create a new CountDownHook with an initial count of zero.
   */
  public CountDownHook() {
    this(new AtomicInteger());
  }

  public void run(EventType type, Connection con, SQLException sqle) {
    counter.decrementAndGet();
  }
}
