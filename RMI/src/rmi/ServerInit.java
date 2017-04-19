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
public class ServerInit {
    public static void main(String[] args) {
        try {
            RmiInt stub = new Implementer();
            Naming.rebind("rmi://localhost/heyyo", stub);
        } catch (Exception e) {
            System.out.println("error occurred!!" + e.getMessage());
        }
        
    }
}
