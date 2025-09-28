/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejs_javas1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ejercicio1 {
    private double saldo = 0; 
    private Scanner data = new Scanner(System.in);
    
    public void cajero(){
        int option;
        boolean bucle = true;
        
        System.out.println("--- EJERCICIO 1: CAJERO AUTOMATICO ---\n");
        
        do {
            menu();
            
            try {
                option = data.nextInt();
                
                switch (option){
                    case 1:
                        saldoActual();
                        break;
                    case 2:
                        depositar();
                        break;
                    case 3:
                        retirarEfectivo();
                        break;
                    case 4:
                        System.out.println("Saliendo del cajero");
                        bucle = false;
                        break;
                    default:
                        System.out.println("Seleccione opcion valida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Tipo de dato no valido para la opcion. Ingrese un número.");
                data.next();
                option = 0;
            }
        } while (bucle);
    }
    
    private void menu(){
        System.out.println("\nMenu del cajero");
        System.out.println("1- Ver el estado de cuenta");
        System.out.println("2- Ingresar saldo");
        System.out.println("3- Retirar efectivo");
        System.out.println("4- Salir del programa");
        System.out.print("Seleccione una opcion: ");
    }
    
    private void saldoActual(){
        // CORRECCIÓN 1: Se agrega el especificador de formato %.2f
        System.out.printf("El saldo actual de su cuenta es: $%.2f", saldo);
    }
    
    private void depositar(){
        System.out.print("Ingrese la cantidad a depositar: $");
        if (data.hasNextDouble()){
            double cantidad = data.nextDouble();
            if(cantidad > 0){
                saldo += cantidad;
                System.out.printf("Se depositó: $%.2f. Saldo actual: $%.2f\n", cantidad, saldo);
            }else{
                System.out.println("Error, la cantidad a depositar debe ser mayor a 0.");
            }
        }else{
            System.out.println("Tipo de dato no valido.");
            data.next();
        }
    }
    
    private void retirarEfectivo(){
        System.out.print("Cantidad a retirar: $");
        
        if(data.hasNextDouble()){
            double cantidad = data.nextDouble();
            
            if (cantidad > 0){
                if (cantidad <= saldo){
                    saldo -= cantidad;
                    System.out.printf("Retiro exitoso. El saldo actual es: $%.2f\n", saldo);
                }else{
                    System.out.println("No tiene suficiente saldo. Su saldo es: $" + saldo);
                }
            }else{
                System.out.println("La cantidad debe ser mayor a 0.");
            }
        }else{
            System.out.println("Tipo de dato invalido.");
        }
    }
}
