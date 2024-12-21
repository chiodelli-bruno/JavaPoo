/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasupermercado;

public class ProductoHigiene extends Producto {
    private String tipoDeUso;

    public ProductoHigiene(String codigo, String nombre, double precio, String tipoDeUso) {
        super(codigo, nombre, precio, "Higiene");
        this.tipoDeUso = tipoDeUso;
    }

    @Override
    public double calcularPrecioFinal() {
        double precioFinal = getPrecio();
        precioFinal += calcularImpuesto(10);
        return precioFinal;
    }

    @Override
    public boolean aplicarDescuentoPorVencimiento() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f (Uso: %s)", getNombre(), getPrecio(), tipoDeUso);
    }

    public String getTipoDeUso() {
        return tipoDeUso;
    }

    public void setTipoDeUso(String tipoDeUso) {
        this.tipoDeUso = tipoDeUso;
    }
}

