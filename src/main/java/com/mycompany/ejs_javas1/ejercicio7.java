/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejs_javas1;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ejercicio7 {
    
    private Scanner data = new Scanner(System.in);
    
    public void adivinar() {
        int option;
        boolean bucle = true;
        
        System.out.println("Ejercicio 7: ADIVINA EL NUMERO\n");
        
        do {
            menu();
            
            try {
                option = data.nextInt();
                
                switch (option) {
                    case 1:
                        iniciarJuego();
                        break;
                    case 2:
                        System.out.println("\nSaliendo del juego de adivinar.");
                        bucle = false;
                        break;
                    default:
                        System.out.println("\nOpcion no valida. Por favor, ingrese 1 o 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada no valida. Ingrese un numero.");
                data.next();
            }
            
        } while (bucle);
    }
    
    private void menu() {
        System.out.println("\nMENU JUEGO");
        System.out.println("1. Jugar una ronda");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    
    private void iniciarJuego() {
        //Genera el numero aleatorio entre 1 y 100
        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1; 
        
        int intentos = 0;
        int intentoUsuario = 0;
        boolean adivinado = false;
        
        System.out.println("\n--- NUEVA PARTIDA ---");
        System.out.println("He generado un numero entre 1 y 100. ¡Adivina cual es!");
        
        while (!adivinado) {
            System.out.print("Intento #" + (intentos + 1) + ": Ingresa un numero: ");
            
            try {
                intentoUsuario = data.nextInt();
                intentos++;
                
                if (intentoUsuario < 1 || intentoUsuario > 100) {
                    System.out.println("Ingresa un numero dentro del rango 1 a 100.");
                    intentos--; //Evita que el intento cuente si el numero es menor a 1 o mayor a 100
                    continue;
                }
                
                if (intentoUsuario == numeroSecreto) {
                    adivinado = true;
                } else if (intentoUsuario > numeroSecreto) {
                    System.out.println("Demasiado alto.");
                } else {
                    System.out.println("Demasiado bajo.");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un numero entero.");
                data.next();
            }
        }
        System.out.println("¡Felicidades! Lo lograste en " + intentos + " intentos.");
    }
}