/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author a
 */
public class Implementer extends UnicastRemoteObject implements RmiInt{

    Implementer() throws RemoteException{
        super();
    }
    
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
      
}
