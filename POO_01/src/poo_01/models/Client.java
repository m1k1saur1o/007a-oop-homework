/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_01.models;

/**
 *
 * @author m1k1
 */
public class Client implements interfaces.InfoCliente {

    private final String rut;
    private Account account;
    private String name;
    private String firstLastName;
    private String secondLastName;
    private String address;
    private String city;
    private String phone;

    public Client(
            String rut,
            String name,
            String firstLastName,
            String secondLastName,
            String address,
            String city,
            String phone,
            Account account) {

        if (!validarRut(rut)) {
            throw new IllegalArgumentException("RUT no valido");
        }

        this.rut = rut;
        this.name = name;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.account = account;
    }

    private boolean validarRut(String rut) {
        if (rut == null || rut.isEmpty()) {
            return false;
        }
        if (rut.length() != 11 && rut.length() != 12) {
            return false;
        }
        if (!rut.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}[-][0-9kK]{1}")) {
            return false;
        }
        return true;
    }

    public boolean agregarCuenta(String accountNumber, String tipoCuenta) {
        if (this.account != null) {
            System.out.println("El cliente ya tiene una cuenta activa");
            return false;
        }

        //instanciación según tipo de Cuenta
        switch (tipoCuenta.toLowerCase()) {
            case "corriente":
                this.account = new CuentaCorriente(accountNumber);
                break;
            case "ahorro":
                this.account = new CuentaAhorro(accountNumber);
                break;
            case "credito":
                this.account = new CuentaCredito(accountNumber);
                break;
            default:
                System.out.println("Tipo de cuenta no reconocido");
                return false;
        }

        System.out.println("Cuenta agregada correctamente");
        return true;
    }

    @Override
    public void mostrarDatosCliente() {
        System.out.println("========== INFORMACION DEL CLIENTE ==========");
        System.out.println("RUT: " + this.rut);
        System.out.println("Nombre completo: " + name + " " + firstLastName);

        if (this.account != null) {
            System.out.println("\n========== INFORMACION DE LA CUENTA ==========");
            this.account.mostrarInformacion();
        } else {
            System.out.println("\nEl cliente no tiene cuenta activa");
        }

    }

    public boolean registrarCliente() {
        if (validarRut(rut)) {
            System.out.println("Cliente registrado correctamente: " + name + " " + firstLastName + " " + secondLastName);
            return true;
        }
        return false;
    }

    //Getters y setter
    public String getRut() {
        return rut;
    }

    public String getName() {
        return name;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public Account getAccount() {
        return account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
