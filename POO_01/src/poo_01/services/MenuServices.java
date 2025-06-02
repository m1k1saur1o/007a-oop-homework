/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_01.services;

import java.util.Scanner;
import poo_01.models.Client;
import poo_01.managers.BankAccountManager;
import poo_01.factories.AccountFactory;
import poo_01.models.Account;

/**
 *
 * @author m1k1
 */
public class MenuServices {

    public MenuServices() {
    }
    
    public Client registrarCliente(BankAccountManager bankAccountManager, Scanner scanner, Client client) {
        System.out.println("\n===== REGISTRO DE CLIENTE =====");
        System.out.print("Ingrese RUT: ");
        String rut = scanner.nextLine();

        // Verificar si el cliente ya existe
        if (bankAccountManager.buscarCliente(rut) != null) {
            System.out.println("Error: Ya existe un cliente con ese RUT");
            return client;
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

        String accountNumber;

        while (true) {
            System.out.print("Ingrese N cuenta corriente (9 digitos): ");
            accountNumber = scanner.nextLine();

            if (accountNumber.length() == 9 && accountNumber.matches("\\d+")) {
                break;
            } else {
                System.out.println("Error: El numero de cuenta debe tener exactamente 9 digitos numericos.");
            }
        }

        String tipoDeCuenta;
        Account account;
        
        while (true) {
            System.out.print("Ingrese tipo de cuenta (Ahorro o Corriente o Credito): ");
            tipoDeCuenta = scanner.nextLine();
            if (tipoDeCuenta.toLowerCase().equals("ahorro")
                    || tipoDeCuenta.toLowerCase().equals("corriente")
                    || tipoDeCuenta.toLowerCase().equals("credito")) {
                account = AccountFactory.createAccount(tipoDeCuenta, accountNumber);   
                break;
            } else {
                System.out.println("Error: Ingrese un tipo de cuenta valido.");
            }
        }
        
        
        
        try {
            Client nuevoCliente = new Client(rut, name, firstLastName, secondLastName, address, city, phone, account);
            if (nuevoCliente.registrarCliente() && bankAccountManager.agregarCliente(nuevoCliente)) {
                System.out.println("Cliente registrado exitosamente");
                return nuevoCliente;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return client;
    }

    public void verDatosCliente(Client clienteActual) {
        if (clienteActual == null) {
            System.out.println("Primero debe registrar un cliente");
            return;
        }

        System.out.println();
        clienteActual.mostrarDatosCliente();
    }

    public void agregarDeposito(Client clienteActual, Scanner scanner) {
        if (clienteActual == null) {
            System.out.println("Primero debes registrar un cliente.");
            return;
        }
        System.out.println("Ingrese monto a depositar:");
        int monto = Integer.parseInt(scanner.nextLine());

        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a cero.");
            return;
        }

        clienteActual.getAccount().deposit(monto);
        System.out.println("Deposito exitoso. Saldo actual: $" + clienteActual.getAccount().getBalance());
    }

    public void realizarGiro(Client clienteActual, Scanner scanner) {
        if (clienteActual == null) {
            System.out.println("Primero debes registrar un cliente.");
            return;
        }

        System.out.println("Ingrese un monto a retirar: ");
        int monto = Integer.parseInt(scanner.nextLine());

        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a cero.");
            return;
        }

        boolean exito = clienteActual.getAccount().hacerGiro(monto);
        if (exito) {
            System.out.println("Giro realizado. Saldo actual $ " + clienteActual.getAccount().getBalance());
        } else {
            System.out.println("Fondos insuficientes. Saldo actual $ " + clienteActual.getAccount().getBalance());
        }

    }

    public void consultarSaldo(Client clienteActual) {
        if (clienteActual == null) {
            System.out.println("Primero debes registrar un cliente.");
            return;
        }
        System.out.println("Saldo actual $ " + clienteActual.getAccount().getBalance());
    }
}
