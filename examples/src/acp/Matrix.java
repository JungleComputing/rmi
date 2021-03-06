/* $Id$ */

package acp;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class Matrix extends UnicastRemoteObject implements i_Matrix {

    private static final long serialVersionUID = 1L;

    boolean[][] matrix;

    int x, y;

    Matrix[] all_matrix;

    int hosts, cpu;

    Matrix(int x, int y, boolean value) throws RemoteException {

        this.x = x;
        this.y = y;

        matrix = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value;
            }
        }
    }

    public synchronized boolean[][] getValue() throws RemoteException {
        return matrix;
    }

    public synchronized void change(int x, int[] list_change, int poz_change)
            throws RemoteException {

        for (int i = 0; i < poz_change; i++) {
            matrix[x][list_change[i]] = false;
        }
    }
}

