/*
 *  Copyright 1999-2004 The Apache Software Foundation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.tomcat.jni;

/* Import needed classes */
import java.nio.ByteBuffer;

/** SSL Socket
 *
 * @author Mladen Turk
 * @version $Revision$, $Date$
 */

public class SSLSocket {

    /**
     * Attach APR socket on a SSL connection.
     * @param ctx SSLContext to use.
     * @param sock APR Socket that already did physical connect.
     * @param pool The pool to use
     * @param pool The pool to use
     * @return The new socket that has been set up.
     */
    public static native long attach(long ctx, long sock, long pool)
        throws Exception;

    /**
     * Do a SSL handshake.
     * @param thesocket The socket to close
     */
    public static native int handshake(long thesocket);

    /**
     * Shutdown a socket.
     * <br />
     * This does not actually close the socket descriptor, it just
     *      controls which calls are still valid on the socket.
     * @param thesocket The socket to close
     * @param how How to shutdown the socket.  One of:
     * <PRE>
     * SSL_SHUTDOWN_TYPE_UNSET
     * SSL_SHUTDOWN_TYPE_STANDARD
     * SSL_SHUTDOWN_TYPE_UNCLEAN
     * SSL_SHUTDOWN_TYPE_ACCURATE
     * </PRE>
     * If SSL_SHUTDOWN_TYPE_UNSET is used the default context shutdown
     * type is used.
     */
    public static native int shutdown(long thesocket, int how);

    /**
     * Close a socket.
     * @param thesocket The socket to close
     */
    public static native int close(long thesocket);


}