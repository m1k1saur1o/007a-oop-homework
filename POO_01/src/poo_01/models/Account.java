/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_01.models;

/**
 *
 * @author m1k1
 */
public class Account {
    private final String accountNumber;
    private int balance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    
    public void mostrarInformacion() {
        System.out.println("Número de cuenta: " + this.accountNumber);
        System.out.println("Saldo Actual: " + this.balance);
    }
    
    public boolean hacerGiro(int monto){
        if(monto <= balance){
            balance -= monto;
            return true;
        }
        return false;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }
    
    public void deposit(int amount) {
        balance += amount;
    }  
}
