/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasupermercado;
public class ClienteVIP extends Cliente {
    private double descuentoVIP;

    public ClienteVIP(String nombre, String dni, double descuentoVIP) {
        super(nombre, dni);
        this.descuentoVIP = descuentoVIP;
    }

    public void aplicarDescuentoVIP(Producto producto) {
        producto.aplicarDescuento(descuentoVIP);
        System.out.println("Descuento VIP del " + descuentoVIP + "% aplicado a " + producto.getNombre());
    }

    @Override
    public void comprar(Producto producto) {
        aplicarDescuentoVIP(producto);
        super.comprar(producto);
    }

    public double getDescuentoVIP() {
        return descuentoVIP;
    }

    public void setDescuentoVIP(double descuentoVIP) {
        this.descuentoVIP = descuentoVIP;
    }

    @Override
    public String toString() {
        return "Cliente VIP: " + getNombre() + " (DNI: " + getDni() + ", Descuento: " + descuentoVIP + "%)";
    }
}