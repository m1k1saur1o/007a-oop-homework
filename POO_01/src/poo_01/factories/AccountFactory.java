/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_01.factories;

import poo_01.models.Account;
import poo_01.models.CuentaAhorro;
import poo_01.models.CuentaCorriente;
import poo_01.models.CuentaCredito;

/**
 *
 * @author m1k1
 */
public class AccountFactory {
    
    public static Account createAccount(String type, String accountNumber) {
        switch (type) {
            case "ahorro" -> {return new CuentaAhorro(accountNumber);}
            case "credito" -> {return new CuentaCredito(accountNumber);}
            case "corriente" -> {return new CuentaCorriente(accountNumber);}
            default -> throw new IllegalArgumentException("Error tipo desconocido: " + type);
        }
    }
}
