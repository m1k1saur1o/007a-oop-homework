/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_01.models;

/**
 *
 * @author Andrea
 */
public class CuentaCorriente extends Account{
    public CuentaCorriente (String accountNumber){
        super(accountNumber);
    }
    public CuentaCorriente(String accountNumber, int balanceInicial){
        super(accountNumber, balanceInicial);
    }
    
    @Override
    public void realizarOperacion(){
        int costoMantencion = 3500;
        if (balance >= costoMantencion) {
            balance -= costoMantencion;
            System.out.println("Se aplico el costo de mantencion de $" + costoMantencion + " a la Cuenta Corriente.");
        } else {
            System.out.println("Saldo insuficiente para aplicar el costo de mantención en la Cuenta Corriente.");
        }
    }
}
