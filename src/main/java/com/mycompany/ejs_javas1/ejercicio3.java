/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejs_javas1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio3 {
    
    private Scanner data = new Scanner(System.in);
    
    public void numPrimos() {
        int option = 0;
        boolean bucle = true;
        
        System.out.println("Ejercicio 3: DETERMINAR NUMEROS PRIMOS\n");
        
        do {
            menu();
            
            try {
                option = data.nextInt();
                
                switch (option) {
                    case 1:
                        determinarPrimo();
                        break;
                    case 2:
                        System.out.println("\nSaliendo del programa de numeros primos.");
                        bucle = false;
                        break;
                    default:
                        System.out.println("\nOpcion no valida. Por favor");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nDAto no valido. Ingrese un numero.");
                data.next();
            }
            
        } while (bucle);
    }
    
    private void menu() {
        System.out.println("\nMENU DE NUMEROS PRIMOS");
        System.out.println("1. Ingresar numero a evaluar");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    
    private void determinarPrimo() {
        System.out.print("Ingrese un numero entero positivo: ");
        
        try {
            int numero = data.nextInt();
            
            if (numero <= 1) {
                System.out.println("El numero " + numero + " no es primo debe ser mayor a 1");
                return;
            }
            
            boolean esPrimo = true; 
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    esPrimo = false;
                    break;
                }
            }
            
            if (esPrimo) {
                System.out.println("El numero " + numero + " es un numero primo.");
            } else {
                System.out.println("El numero " + numero + " es un numero par.");
            }
            
        } catch (InputMismatchException e) {
            System.out.println("Ingrese un numero entero valido.");
            data.next();
        }
    }
}