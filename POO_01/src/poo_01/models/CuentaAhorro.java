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
    
    double tasaInteres = 0.01;
    
    public CuentaAhorro(String accountNumber){
        super(accountNumber);
    }
    
    public CuentaAhorro(String accountNumber, int balanceInicial){
        super(accountNumber, balanceInicial);
        
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.println("Numero de cuenta: " + this.accountNumber);
        System.out.println("Tipo de cuenta: Ahorro");
        System.out.println("Tasa de interes: "+tasaInteres);
        System.out.println("Saldo Actual: " + this.balance);
    }
    
    @Override
    public void realizarOperacion(){
        double interes = balance * tasaInteres; //1% de interes
        balance += (int) interes;
        System.out.println("Se abonó un interés de $" + (int) interes + "a la Cuenta de Ahorro");
    }
    
}

