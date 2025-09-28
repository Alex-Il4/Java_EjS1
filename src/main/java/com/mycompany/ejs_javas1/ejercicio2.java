/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejs_javas1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio2 { 
    
    private Scanner data = new Scanner(System.in);

    public void calculadora() {
        int option;
        boolean bucle = true;
        
        System.out.println("Ejercicio 2: CALCULADORA AVANZADA\n");
        
        do {
            menu();
            
            try {
                option = data.nextInt();
                
                switch (option) {
                    case 1: sumar(); break;
                    case 2: restar(); break;
                    case 3: multiplicar(); break;
                    case 4: dividir(); break;
                    case 5: potencia(); break;
                    case 6: raizCuadrada(); break;
                    case 7: 
                        System.out.println("\nSaliendo de la Calculadora Avanzada.");
                        bucle = false; 
                        break;
                    default:
                        System.out.println("\nOpcion no valida. Por favor, ingrese un numero del 1 al 7.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nError: Entrada invalida. Por favor, ingrese solo numeros para las opciones.");
                data.next(); 
                option = 0;
            }
        
        } while (bucle);
    }

    private void menu() {
        System.out.println("\n--- OPERACIONES ---");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Potencia (x^y)");
        System.out.println("6. Raiz cuadrada");
        System.out.println("7. Salir");
        System.out.print("Seleccione una operacion: ");
    }
    
    private double[] leerDosNumeros() {
        double num1 = 0;
        double num2 = 0;
        
        try {
            System.out.print("Ingrese el primer numero (x): ");
            num1 = data.nextDouble();
            System.out.print("Ingrese el segundo numero (y): ");
            num2 = data.nextDouble();
            return new double[]{num1, num2};
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese un numero decimal o entero valido.");
            data.next(); 
            return null;
        }
    }
    
    private void sumar() {
        double[] nums = leerDosNumeros();
        if (nums != null) {
            double resultado = nums[0] + nums[1];
            System.out.printf("Resultado de la suma: %.2f + %.2f = %.2f%n", nums[0], nums[1], resultado);
        }
    }

    private void restar() {
        double[] nums = leerDosNumeros();
        if (nums != null) {
            double resultado = nums[0] - nums[1];
            System.out.printf("Resultado de la resta: %.2f - %.2f = %.2f%n", nums[0], nums[1], resultado);
        }
    }

    private void multiplicar() {
        double[] nums = leerDosNumeros();
        if (nums != null) {
            double resultado = nums[0] * nums[1];
            System.out.printf("Resultado de la multiplicacion: %.2f * %.2f = %.2f%n", nums[0], nums[1], resultado);
        }
    }

    private void dividir() {
        double[] nums = leerDosNumeros();
        if (nums != null) {
            if (nums[1] != 0) {
                double resultado = nums[0] / nums[1];
                System.out.printf("Resultado de la division: %.2f / %.2f = %.2f%n", nums[0], nums[1], resultado);
            } else {
                System.out.println("Error: No se puede dividir por cero (0).");
            }
        }
    }

    private void potencia() {
        double[] nums = leerDosNumeros();
        if (nums != null) {
            double resultado = Math.pow(nums[0], nums[1]);
            System.out.printf("Resultado de la potencia: %.2f ^ %.2f = %.2f%n", nums[0], nums[1], resultado);
        }
    }

    private void raizCuadrada() {
        double numero = 0;
        try {
            System.out.print("Ingrese el numero (x) para la raiz cuadrada: ");
            numero = data.nextDouble();
            
            if (numero >= 0) {
                double resultado = Math.sqrt(numero);
                System.out.printf("Resultado de la raiz cuadrada de %.2f: %.2f%n", numero, resultado);
            } else {
                System.out.println("Error: No se puede calcular la raiz cuadrada de un numero negativo en numeros reales.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Por favor, ingrese un numero decimal o entero valido.");
            data.next(); 
        }
    }
}