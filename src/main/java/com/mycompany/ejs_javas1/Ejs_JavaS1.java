/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejs_javas1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejs_JavaS1 {

    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);
        int ejOption = 0;
        boolean bucle = true;

        do {
            System.out.println("\n--- Seleccione un Ejercicio (1-9) ---");
            System.out.println("1. Ejercicio 1 (Cajero Automatico)");
            System.out.println("2. Ejercicio 2 (Calculadora Avanzada)");
            System.out.println("2. Ejercicio 3 (Numeros primos)");
            System.out.println("2. Ejercicio 4 (Serie fibonacci)");
            System.out.println("2. Ejercicio 5 (Faactorial)");
            System.out.println("2. Ejercicio 6 (Estadistica Notas)");
            System.out.println("2. Ejercicio 7 (Adivinar numero)");
            System.out.println("2. Ejercicio 8 (Sistema inventario)");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opcion: ");
            
            try {
                ejOption = data.nextInt(); 

                switch (ejOption) {
                    case 1:
                        ejercicio1 ej1 = new ejercicio1(); 
                        ej1.cajero();
                        break;
                    case 2:
                        ejercicio2 ej2 = new ejercicio2();
                        ej2.calculadora();
                        break;
                    case 3:
                        ejercicio3 ej3 = new ejercicio3();
                        ej3.numPrimos();
                        break;
                    case 4:
                        ejercicio4 ej4 = new ejercicio4();
                        ej4.fibonacci();
                        break;
                    case 5:
                        ejercicio5 ej5 = new ejercicio5();
                        ej5.factorial();
                        break;
                    case 6:
                        ejercicio6 ej6 = new ejercicio6();
                        ej6.estadisticas();
                        break;
                    case 7:
                        ejercicio7 ej7 = new ejercicio7();
                        ej7.adivinar();
                        break;
                    case 0:
                        System.out.println("\nSaliendo del programa.");
                        bucle = false; // Detiene el bucle
                        break;
                    default:
                        System.out.println("\nIngrese opcion valida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n ERROR: Entrada no valida. Por favor, ingrese un numero.");
                data.next();
                ejOption = -1; // Forzar la repetición del bucle
            }

        } while (bucle);
        // Cierra el Scanner
        data.close();
    }
}