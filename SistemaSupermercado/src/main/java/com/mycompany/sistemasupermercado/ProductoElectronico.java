/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasupermercado;

public class ProductoElectronico extends Producto {
    private int garantia;

    public ProductoElectronico(String codigo, String nombre, double precio, int garantia) {
        super(codigo, nombre, precio, "Electrónica");
        this.garantia = garantia;
    }

    @Override
    public double calcularPrecioFinal() {
        double precioFinal = getPrecio();
        if (garantia > 2) {
            precioFinal *= 1.05;
        }
        precioFinal += calcularImpuesto(15);
        return precioFinal;
    }

    @Override
    public boolean aplicarDescuentoPorVencimiento() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f (Garantía: %d años)", getNombre(), getPrecio(), garantia);
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }
}

