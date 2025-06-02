/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_01.views;

import java.util.Scanner;
import poo_01.managers.BankAccountManager;
import poo_01.models.Account;
import poo_01.models.Client;
import poo_01.services.MenuServices;

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
    private MenuServices menuServices;


    public Menu() {
        this.scanner = new Scanner(System.in);
        this.bankAccountManager = BankAccountManager.getInstance();
        this.menuServices = new MenuServices();
        this.clienteActual = null;
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
            System.out.print("Ingrese una opcion: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0;
            }
            
            switch (opcion) {
                case 1:
                    clienteActual = menuServices.registrarCliente(bankAccountManager, scanner, clienteActual);
                    break;
                case 2:
                    menuServices.verDatosCliente(clienteActual);
                    break;
                case 3:
                    menuServices.agregarDeposito(clienteActual, scanner);
                    break;
                case 4:
                    menuServices.realizarGiro(clienteActual, scanner);
                    break;
                case 5:
                    menuServices.consultarSaldo(clienteActual);
                    break;
                case 6:
                    System.out.println("Gracias por usar el sistema de Bank Boston.");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
            }
            
        } while (opcion != 6);
    }
     
    
    
}
