/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_01.models;

/**
 *
 * @author m1k1
 */
public class Client {
    private final String rut;
    private final Account account;
    private String name;
    private String firstLastName;
    private String secondLastName;
    private String adress;
    private String city;
    private String phone;
    
    public Client(
            String rut, 
            String name, 
            String firstLastName, 
            String secondLastName, 
            String adress, 
            String city, 
            String phone, 
            Account account) {
        this.rut = rut;
        this.name = name;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.adress = adress;
        this.city = city;
        this.phone = phone;
        this.account = account;
    }

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

    public String getAdress() {
        return adress;
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

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
