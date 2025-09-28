/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejs_javas1;
/**
 *
 * @author alex
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio4 {
    
    private Scanner data = new Scanner(System.in);

    public void fibonacci() {
        int option = 0;
        boolean bucle = true;
        
        System.out.println("Ejercicio 4: SERIE FIBONACCI\n");
        
        do {
            menu();
            
            try {
                option = data.nextInt();
                
                switch (option) {
                    case 1:
                        generarSerie();
                        break;
                    case 2:
                        System.out.println("\nSaliendo del programa de la Serie Fibonacci.");
                        bucle = false;
                        break;
                    default:
                        System.out.println("\nOpcion no valida. Por favor, ingrese 1 o 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nError: Entrada no valida. Por favor, ingrese un numero.");
                data.next();
            }
            
        } while (bucle);
    }
    
    private void menu() {
        System.out.println("\n--- MENU FIBONACCI ---");
        System.out.println("1. Generar serie");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    
    private void generarSerie() {
        System.out.print("Ingrese el numero de terminos (n) a mostrar: ");
        
        try {
            int n = data.nextInt();
            
            if (n <= 0) {
                System.out.println("Error: El numero de terminos debe ser mayor a cero.");
                return;
            }

            //Se usa el tipo de dato long porque la serie fibonacci crece exponencialmente rapido
            //Si se usara int alcanzaria el limite de forma rapida
            long a = 0;
            long b = 1;
            long c;
            
            System.out.println("Los " + n + " terminos Fibonacci son:");
            
            if (n >= 1) {
                System.out.print(a);
            }
            if (n >= 2) {
                System.out.print(", " + b);
            }
            for (int i = 3; i <= n; i++) {
                c = a + b;
                System.out.print(", " + c);
                // Actualizar los datod para la siguiente vuelta
                a = b; //a toma el valor de b
                b = c; //b toma el valor del termino c
            }
            System.out.println();
            
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese un numero entero valido.");
            data.next();
        }
    }
}