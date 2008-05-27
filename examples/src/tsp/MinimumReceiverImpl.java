/* $Id$ */

package tsp;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class MinimumReceiverImpl extends UnicastRemoteObject implements
        MinimumReceiver {

    private static final long serialVersionUID = 1L;
    Client client;

    MinimumReceiverImpl(Client client) throws RemoteException {
        this.client = client;
    }

    public final void update(int min) throws RemoteException {
        // System.out.println("Got update " + min);
        client.setMin(min);
    }
}
