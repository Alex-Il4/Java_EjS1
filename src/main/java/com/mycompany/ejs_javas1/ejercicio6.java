/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejs_javas1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio6 {
    
    private Scanner data = new Scanner(System.in);

    public void estadisticas() {
        int option = 0;
        boolean bucle = true;
        
        System.out.println("Ejercicio 6: ESTADISTICAS DE CALIFICACIONES\n");
        
        do {
            menu();
            
            try {
                option = data.nextInt();
                
                switch (option) {
                    case 1:
                        calcularEstadisticas();
                        break;
                    case 2:
                        System.out.println("\nSaliendo del programa de Estadisticas.");
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
        System.out.println("\nMENU ESTADISTICAS");
        System.out.println("1. Ingresar notas y calcular estadisticas");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    
    private void calcularEstadisticas() {
        int n;
        try {
            System.out.print("Ingrese el numero de estudiantes: ");
            n = data.nextInt();
            
            if (n <= 0) {
                System.out.println("El numero de estudiantes debe ser mayor a cero.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Ingrese un numero entero valido para N.");
            data.next();
            return;
        }

        double sumaNotas = 0;
        double notaMasAlta = Double.MIN_VALUE; //Obtiene el valor mas bajo de la variable
        double notaMasBaja = Double.MAX_VALUE; //Obtiene el valor mas alto de la varible
        
        System.out.println("\nINGRESO DE NOTAS\n");
        for (int i = 1; i <= n; i++) {
            try {
                System.out.print("Ingrese la nota del estudiante #" + i + ": ");
                double nota = data.nextDouble();
                
                //Promedio
                sumaNotas += nota;
                
                //Nota mas alta
                if (nota > notaMasAlta) {
                    notaMasAlta = nota;
                }
                
                //Nota mas baja
                if (nota < notaMasBaja) {
                    notaMasBaja = nota;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una nota valida.");
                data.next();
                i--;
            }
        }
        double promedioGeneral = sumaNotas / n;
        System.out.println("\nRESULTADOS ESTADISTICOS");
        System.out.printf("Promedio general de las notas: %.2f%n", promedioGeneral);
        System.out.printf("La nota mas alta es: %.2f%n", notaMasAlta);
        System.out.printf("La nota mas baja es: %.2f%n", notaMasBaja);
    }
}