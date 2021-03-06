/* $Id$ */

package ibis.rmi.registry.impl;

import ibis.rmi.AlreadyBoundException;
import ibis.rmi.NotBoundException;
import ibis.rmi.Remote;
import ibis.rmi.RemoteException;
import ibis.rmi.impl.RTS;
import ibis.rmi.registry.Registry;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistryImpl extends ibis.rmi.server.UnicastRemoteObject
        implements Registry {

    /** 
     * Generated
     */
    private static final long serialVersionUID = -542877109530651565L;

    private int port = 0;

    HashMap<String, Remote> remotes = new HashMap<String, Remote>();

    static Logger logger
            = LoggerFactory.getLogger(RegistryImpl.class.getName());

    public RegistryImpl(int port) throws RemoteException {
        if (port <= 0) {
            this.port = Registry.REGISTRY_PORT;
        } else {
            this.port = port;
        }
        if (logger.isDebugEnabled()) {
            logger.debug("port = " + this.port);
        }
        RTS.createRegistry(port, this);
    }

    public synchronized Remote lookup(String name) throws NotBoundException {
        if (! remotes.containsKey(name)) {
            if (logger.isDebugEnabled()) {
                logger.debug("lookup failed " + name);
            }
            throw new NotBoundException("lookup: " + name + " not bound");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("lookup succeeded " + name);
        }
        return remotes.get(name);
    }

    public synchronized void bind(String name, Remote obj)
            throws AlreadyBoundException {
        if (remotes.containsKey(name)) {
            throw new AlreadyBoundException("bind: " + name + " already bound");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("binding " + name);
        }
        remotes.put(name, obj);
    }

    public synchronized void rebind(String name, Remote obj) {
        if (logger.isDebugEnabled()) {
            logger.debug("rebinding " + name);
        }
        remotes.put(name, obj);
    }

    public synchronized void unbind(String name) throws NotBoundException {
        if (! remotes.containsKey(name)) {
            throw new NotBoundException("unbind: " + name + " not bound");
        }
        if (logger.isDebugEnabled()) {
            logger.debug("unbinding " + name);
        }
        remotes.remove(name);
    }

    public synchronized String[] list() {
        return remotes.keySet().toArray(new String[remotes.size()]);
    }
}
