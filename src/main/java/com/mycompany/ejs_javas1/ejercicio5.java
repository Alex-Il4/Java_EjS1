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

public class ejercicio5 {
    
    private Scanner data = new Scanner(System.in);

    public void factorial() {
        int option = 0;
        boolean bucle = true;
        
        System.out.println("Ejercicio 5: CALCULO DE FACTORIAL\n");
        
        do {
            menu();
            
            try {
                option = data.nextInt();
                
                switch (option) {
                    case 1:
                        calcularFactorial();
                        break;
                    case 2:
                        System.out.println("\nSaliendo del programa de Factorial.");
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
        System.out.println("\n--- MENU FACTORIAL ---");
        System.out.println("1. Calcular factorial");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    
    private void calcularFactorial() {
        System.out.print("Ingrese un numero entero positivo para calcular su factorial: ");
        
        try {
            int n = data.nextInt();
            
            if (n < 0) {
                System.out.println("Error: El factorial solo se define para numeros positivos o cero.");
                return;
            }
            if (n == 0) {
                System.out.println("El factorial de 0 es: 1");
                return;
            }

            //Se usa un dato de tipo long ya que n crece de forma rapida
            long resultado = 1;
            for (int i = n; i >= 1; i--) {
                resultado *= i;
            }
            
            System.out.println("El factorial de " + n + " es: " + resultado);
            
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese un numero entero valido.");
            data.next();
        }
    }
}