/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_01.models;

/**
 *
 * @author Andrea
 */
public class CuentaAhorro extends Account{
    
    public CuentaAhorro(String accountNumber){
        super(accountNumber);
    }
    
    public CuentaAhorro(String accountNumber, int balanceInicial){
        super(accountNumber, balanceInicial);
        
    }
    
    

    @Override
    public void realizarOperacion(){
        double interes = balance * 0.01; //1% de interes
        balance += (int) interes;
        System.out.println("Se abonó un interés de $" + (int) interes + "a la Cuenta de Ahorro");
    }
    
}
