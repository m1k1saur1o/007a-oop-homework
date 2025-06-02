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
    
    int costoMantencion = 3500;
    
    public CuentaCorriente (String accountNumber){
        super(accountNumber);
    }
    public CuentaCorriente(String accountNumber, int balanceInicial){
        super(accountNumber, balanceInicial);
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Numero de cuenta: " + this.accountNumber);
        System.out.println("Tipo de cuenta: Corriente");
        System.out.println("Costo de mantecion: "+costoMantencion);
        System.out.println("Saldo Actual: " + this.balance);
    }
    
    @Override
    public void realizarOperacion(){
        if (balance >= costoMantencion) {
            balance -= costoMantencion;
            System.out.println("Se aplico el costo de mantencion de $" + costoMantencion + " a la Cuenta Corriente.");
        } else {
            System.out.println("Saldo insuficiente para aplicar el costo de mantención en la Cuenta Corriente.");
        }
    }
}
