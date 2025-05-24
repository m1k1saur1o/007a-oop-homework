/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_01.views;

import java.util.Scanner;
import poo_01.managers.BankAccountManager;
import poo_01.models.Account;
import poo_01.models.Client;

/**
 *
 * @author m1k1
 */
public class Menu {
    // QUESTION: dejé el menu en otro paquete porque me hace sentido con MCV
    //           que es lo que el profe hace, creo. ¿Debería estar en otro
    //           paquete?
    // QUESTION: el profe tenía la construcción de cliente acá. ¿No debería estar
    //           en el manager? ¿Por qué el menu que es una vista lo hace?
    private final Scanner scanner;
    private final BankAccountManager bankAccountManager;
    private Client clienteActual;


    public Menu() {
        scanner = new Scanner(System.in);
        bankAccountManager = BankAccountManager.getInstance();
        clienteActual = null;
    }   
    
     public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n========= MENU =========");
            System.out.println("\n========================");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ver datos del cliente");
            System.out.println("3. Depositar ");
            System.out.println("4. Girar");
            System.out.println("5. Consultar Saldo");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }
            
            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    verDatosCliente();
                    break;
                case 3:
                    //agregarDeposito();
                    break;
                case 4:
                    //realizarGiro();
                    break;
                case 5:
                    //consultarSaldo();
                    break;
                case 6:
                    System.out.println("Gracias por usar el sistema de gestión de hotel");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            
        } while (opcion != 6);
    }
     
    private void registrarCliente() {
        System.out.println("\n===== REGISTRO DE CLIENTE =====");
        System.out.print("Ingrese RUT: ");
        String rut = scanner.nextLine();
        
        // Verificar si el cliente ya existe
        if (bankAccountManager.buscarCliente(rut) != null) {
            System.out.println("Error: Ya existe un cliente con ese RUT");
            return;
        }
        
        System.out.print("Ingrese nombre: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese apellido paterno: ");
        String firstLastName = scanner.nextLine();
        System.out.print("Ingrese apellido materno: ");
        String secondLastName = scanner.nextLine();
        System.out.print("Ingrese domicilio: ");
        String address = scanner.nextLine();
        System.out.print("Ingrese comuna: ");
        String city = scanner.nextLine();
        System.out.print("Ingrese telefono: ");
        String phone = scanner.nextLine();
        System.out.print("Ingrese N cuenta corriente: ");
        String accountNumber = scanner.nextLine(); 
        
        Account account = new Account(accountNumber);
        
        try {
            Client nuevoCliente = new Client( rut, name, firstLastName, secondLastName, address, city, phone, account);
            if (nuevoCliente.registrarCliente() && bankAccountManager.agregarCliente(nuevoCliente)) {
                System.out.println("Cliente registrado exitosamente");
                clienteActual = nuevoCliente;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
     
     
    //opcion2 
    private void verDatosCliente() {
        if (clienteActual == null) {
            System.out.println("Primero debe registrar un cliente");
            return;
        }
        
        System.out.println();
        clienteActual.mostrarInformacion();
    }   
    
    private void agregarDeposito(){
        if(clienteActual == null){
            System.out.println("Primero debes registrar un cliente.");
            return;
        }
        System.out.println("Ingrese monto a depositar:");
        int monto = Integer.parseInt(scanner.nextLine());
        
        if(monto<=0){
            System.out.println("El monto debe ser mayor a cero.");
            return;
        }
        
        clienteActual.getAccount().deposit(monto);
        System.out.println("Depósito exitoso. Saldo actual: $" + clienteActual.getAccount().getBalance() );
    }
        
    private void realizarGiro(){
        if(clienteActual == null){
            System.out.println("Primero debes registrar un cliente.");
        return;      
        }
        
        System.out.println("Ingrese un monto a retirar: ");
        int monto = Integer.parseInt(scanner.nextLine());
        
        if(monto<=0){
            System.out.println("El monto debe ser mayor a cero.");
            return;
        }
        
        boolean exito = clienteActual.getAccount().hacerGiro(monto);
        if(exito){
            System.out.println("Giro realizado. Saldo actual $ " + clienteActual.getAccount().getBalance() );
        } else{
              System.out.println("Fondos insuficientes. Saldo actual $ " + clienteActual.getAccount().getBalance() );
        }
        
    }
    
    private void consultarSaldo(){
        if(clienteActual == null){
            System.out.println("Primero debes registrar un cliente.");
            return;
        }
        System.out.println("Saldo actual $ " + clienteActual.getAccount().getBalance());
    }
    
    
    
     
}
