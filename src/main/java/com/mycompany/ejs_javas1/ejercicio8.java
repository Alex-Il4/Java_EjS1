/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejs_javas1;
/**
 *
 * @author alex
 */
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ejercicio8 {
    
    private Scanner data = new Scanner(System.in);
    //Lista para guardar los productos
    private List<producto> productList = new ArrayList<>();

    public void inventario() {
        int option = 0;
        boolean bucle = true;
        
        System.out.println("--- EJERCICIO 8: SISTEMA DE INVENTARIO ---\n");
        
        do {
            menu();
            
            try {
                option = data.nextInt();
                data.nextLine();
                
                switch (option) {
                    case 1: 
                        registrarProducto();
                        break;
                    case 2: 
                        mostrarProductos();
                        break;
                    case 3: 
                        calcularValorTotal(); 
                        break;
                    case 4:
                        System.out.println("\nSaliendo del Sistema de Inventario.");
                        bucle = false;
                        break;
                    default:
                        System.out.println("\nOpcion no valida. Por favor, ingrese un numero del 1 al 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nError: Entrada no valida. Por favor, ingrese un numero.");
                data.next(); 
            }
            
        } while (bucle);
    }
    
    private void menu() {
        System.out.println("\n--- MENU INVENTARIO ---");
        System.out.println("1. Registrar producto");
        System.out.println("2. Mostrar productos registrados");
        System.out.println("3. Calcular valor total del inventario");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    
    private void registrarProducto() {
        String nombre;
        double precio;
        int cantidad;
        
        System.out.println("\n--- REGISTRAR PRODUCTO ---");
        System.out.print("Ingrese el nombre del producto: ");
        nombre = data.nextLine(); 
        
        try {
            System.out.print("Ingrese el precio del producto: $");
            precio = data.nextDouble();
            
            System.out.print("Ingrese la cantidad en stock: ");
            cantidad = data.nextInt();
            
            if (precio <= 0 || cantidad <= 0) {
                 System.out.println("El precio y la cantidad deben ser valores positivos.");
                 data.nextLine();
                 return;
            }
            //Se crear el nuevo objeto Producto y se agrega a la lista
            producto nuevoProducto = new producto(nombre, precio, cantidad);
            productList.add(nuevoProducto);
            
            System.out.println("Producto '" + nombre + "' registrado con exito.");
            
        } catch (InputMismatchException e) {
            System.out.println("Ingrese valores numericos validos para precio y cantidad.");
            data.next();
        } finally {
            data.nextLine();
        }
    }
    
    private void mostrarProductos() {
        if (productList.isEmpty()) {
            System.out.println("\nEl inventario esta vacio. No hay productos registrados.");
            return;
        }
        
        System.out.println("\nPRODUCTOS REGISTRADOS");
        for (int i = 0; i < productList.size(); i++) {
            producto p = productList.get(i);
            System.out.println((i + 1) + ". " + p.toString()); 
        }
    }
    
    private void calcularValorTotal() {
        if (productList.isEmpty()) {
            System.out.println("\nEl inventario esta vacio. El valor total es $0.00.");
            return;
        }
        
        int productTotal = 0;
        double valorTotal = 0;
        
        for (producto p : productList) {
            productTotal += p.getCantidad();
            valorTotal += p.getPrecio() * p.getCantidad();
        }
        
        System.out.println("\n VALOR TOTAL DEL INVENTARIO");
        System.out.printf("El valor total del inventario es: $%.2f%n, canttidad total de productos de: %d%n",valorTotal, productTotal);
    }
}