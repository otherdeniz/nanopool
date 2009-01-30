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
package net.nanopool;

/**
 * A marker exception used for handling the mid-pool-resize special cases that
 * we have at various places, the JMX interface in particular.
 * @author cvh
 */
class CasArrayOutdatedException extends NanoPoolRuntimeException {
    static final CasArrayOutdatedException INSTANCE =
            new CasArrayOutdatedException();

    private CasArrayOutdatedException() {
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
