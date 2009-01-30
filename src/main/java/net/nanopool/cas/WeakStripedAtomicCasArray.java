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
package net.nanopool.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author vest
 */
public class WeakStripedAtomicCasArray<T> extends StripedAtomicCasArraySupport<T> {
    public WeakStripedAtomicCasArray(int size) {
        super(size);
    }
    
    @Override
    protected boolean doCas(AtomicReference<T> atomic, T newValue, T oldValue) {
        return atomic.weakCompareAndSet(oldValue, newValue);
    }
}
