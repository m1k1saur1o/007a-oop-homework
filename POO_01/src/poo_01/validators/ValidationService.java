/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_01.validators;

/**
 *
 * @author m1k1
 */
public final class ValidationService {

    private ValidationService() {
    }
    
    public static boolean validateRut(String rut) {
        if (rut == null || rut.isEmpty()) {
            return false;
        }
        if (rut.length() != 11 && rut.length() != 12) {
            return false;
        }
        return rut.matches("\\d{1,2}\\.\\d{3}\\.\\d{3}[-][0-9kK]{1}");
    }
    
    public static boolean validateAccountNumber(String accountNumber) {
        return accountNumber.length() == 9 && accountNumber.matches("\\d+");
    }
    
    public static boolean validateAccountType(String type) {
        return type.toLowerCase().equals("ahorro")
                    || type.toLowerCase().equals("corriente")
                    || type.toLowerCase().equals("credito");
    }
    
    
}
