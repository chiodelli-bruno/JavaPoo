/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasupermercado;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String dni;
    private List<Producto> compras;
    private static int totalClientes = 0;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.compras = new ArrayList<>();
        totalClientes++;
    }

    public void comprar(Producto producto) {
        compras.add(producto);
        System.out.println(nombre + " ha comprado " + producto.getNombre());
    }

    public void mostrarCompras() {
        System.out.println("Compras de " + nombre + ":");
        for (Producto producto : compras) {
            System.out.println(producto.toString());
            System.out.println("--------------------");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public static int getTotalClientes() {
        return totalClientes;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " (DNI: " + dni + ")";
    }
}