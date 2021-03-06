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
package net.nanopool.contention;

import java.sql.SQLException;

import net.nanopool.ManagedNanoPool;

/**
 * A ContentionHandler decides what to do when we reckon there's contention on
 * the pool. Contention on the pool usually means that, last we checked, all
 * connections was in use, so this particular thread can not get a connection
 * right away. This means that we have wait a little while before we try again,
 * and waiting is exactly what ContentionHandler implementations do. This
 * interface is provided because the pool-using applications might want to do
 * logging or other stuff, while they wait.
 * @author cvh
 * @since 1.0
 */
public interface ContentionHandler {
  /**
   * Do something to ease contention on the pool. This usually means calling
   * {@link Thread#sleep(long)} or {@link Thread#yield()}, but you could also
   * throw a form of {@link RuntimeException} or {@link SQLException} if you'd
   * rather give up on getting a connection for this particular thread - just
   * be sure to catch it in your own code!
   * <p>
   * A {@link ManagedNanoPool} instance is also provided for those
   * implementations that want to do more advanced stuff, such as resizing the
   * pool.
   * 
   * @param count
   *          The number of times that this ContentionHandler has been called
   *          within the same getConnection.
   * @param mnp
   *          The ManagedNanoPool implementation for the pool that is
   *          experiencing the contention.
   * @throws SQLException
   * @since 1.0
   */
  void handleContention(int count, ManagedNanoPool mnp) throws SQLException;
}
