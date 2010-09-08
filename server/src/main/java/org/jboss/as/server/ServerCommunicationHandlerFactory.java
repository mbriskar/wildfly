/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

/**
 *
 */
package org.jboss.as.server;

/**
 * A ServerCommunicationHandlerFactory.
 *
 * @author John E. Bailey
 */
public final class ServerCommunicationHandlerFactory {

    private static final ServerCommunicationHandlerFactory INSTANCE = new ServerCommunicationHandlerFactory();

    public static ServerCommunicationHandlerFactory getInstance() {
        return INSTANCE;
    }

    public ServerCommunicationHandler getServerCommunicationHandler(ServerEnvironment environment, MessageHandler handler) {
        return new DirectServerCommunicationHandler(environment.getProcessName(), environment.getServerManagerAddress(), environment.getServerManagerPort(), handler);
    }

    public ServerCommunicationHandler getProcessManagerCommunicationHandler(ServerEnvironment environment, MessageHandler handler) {
        return new ProcessManagerServerCommunicationHandler(environment.getProcessName(), environment.getProcessManagerAddress(), environment.getProcessManagerPort(), handler);
    }

    private ServerCommunicationHandlerFactory() {}
}
