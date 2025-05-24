/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_01.views;

import java.util.Scanner;
import poo_01.managers.BankAccountManager;

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

    public Menu() {
        scanner = new Scanner(System.in);
        bankAccountManager = BankAccountManager.getInstance();
    }    
}
