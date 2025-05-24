/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_01.managers;

import java.util.HashMap;
import java.util.Map;
import poo_01.models.Client;

/**
 *
 * @author m1k1
 */
public class BankAccountManager {
    // QUESTION: aquí el profe tenía un cliente para seleccionarlo. ¿Será 
    //           necesario?
    private final Map<String, Client> clients;
    
    private static BankAccountManager instance;
    
    public BankAccountManager() {
        clients = new HashMap<>();
    }
    
    public static BankAccountManager getInstance() {
        if (instance == null) {
            instance = new BankAccountManager();
        }
        return instance;
    }
}
