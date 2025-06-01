/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_01.models;

/**
 *
 * @author m1k1
 */
public abstract class Account {
    private final String accountNumber;
    private int balance;
    
   //Constructor Principal    

    public Account(String accountNumber) {
        
        if(!validarCuenta(accountNumber)){
            throw new IllegalArgumentException("El numero de cuenta debe tener exactamente 9 digitos");
        }
         
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    //Constructor sobrecargado con saldo inicial
    public Account (String accountNumber, int balanceInicial){
        if (!validarCuenta(accountNumber)) {
            throw new IllegalArgumentException("El número de cuenta debe tener exactamente 9 dígitos.");
        }
        if (balanceInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
        this.accountNumber = accountNumber;
        this.balance = balanceInicial;
    }
    
    public void mostrarInformacion() {
        System.out.println("Numero de cuenta: " + this.accountNumber);
        System.out.println("Saldo Actual: " + this.balance);
    }
    
    public boolean hacerGiro(int monto){
        if(monto <= balance){
            balance -= monto;
            return true;
        }
        return false;
    }
    
    private boolean validarCuenta(String accountNumber) {
        
        return accountNumber != null && accountNumber.length() == 9;
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
    
    //Metodo abstracto que cada tipo de cuenta implementara de forma especifica
    public abstract void realizarOperacion();
    
}
