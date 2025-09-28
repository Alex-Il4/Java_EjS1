/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.ejs_javas1;
/**
 *
 * @author alex
 */

//Clase que sivre para almacenar un producto
public class producto {
    
    private String nombre;
    private double precio;
    private int cantidad;

    //Constructor para un nuevo producto
    public producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    //Funcion para mostrar la info del producto
    public String toString() {
        return String.format("Nombre: %s | Precio: $%.2f | Cantidad: %d", nombre, precio, cantidad);
    }
}
