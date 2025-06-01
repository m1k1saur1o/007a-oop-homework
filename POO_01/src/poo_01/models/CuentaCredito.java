/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_01.models;

/**
 *
 * @author Andrea
 */
public class CuentaCredito extends Account {
    public CuentaCredito(String accountNumber){
        super(accountNumber);
    }
    
    public CuentaCredito (String accountNumber, int balanceInicial){
        super (accountNumber, balanceInicial);
    }
    
    @Override
    public void realizarOperacion(){
        if(balance < 0){
            double interes = Math.abs(balance)*0.85; // 2% de interes sobre deuda
            balance -= (int) interes;
            System.out.println("Se aplicó un interés de $" + (int) interes+ " a la deuda de la cuenta de credito");
        } else{
            System.out.println("No hay deuda activa en la cuenta de credito. No se aplican intereses." );
        }
    }
}
