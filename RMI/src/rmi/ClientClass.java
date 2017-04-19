/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Naming;

/**
 *
 * @author a
 */
public class ClientClass {
    public static void main(String[] args) {
        try {
            RmiInt stub = (RmiInt) Naming.lookup("rmi://localhost:5000/heyyo");
            System.out.println("Addition is: "+ stub.add(5, 7));
        } catch (Exception e) {
        }
    }
}
