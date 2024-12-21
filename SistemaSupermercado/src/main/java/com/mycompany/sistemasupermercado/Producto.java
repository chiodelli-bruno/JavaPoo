/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasupermercado;

import java.time.LocalDate;

public abstract class Producto implements InterfacesSupermercado.Promocionable, InterfacesSupermercado.ImpuestoAplicable {
    private String codigo;
    private String nombre;
    private double precio;
    private String categoria;
    private static int totalProductos = 0;

    public Producto(String codigo, String nombre, double precio, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        totalProductos++;
    }

    public abstract double calcularPrecioFinal();

    @Override
    public void aplicarDescuento(double porcentaje) {
        this.precio = this.precio * (1 - porcentaje / 100);
    }

    @Override
    public void aplicarPromocion(String tipoPromocion) {
        switch (tipoPromocion) {
            case "2x1":
                this.precio = this.precio / 2;
                break;
            case "50% en la segunda unidad":
                this.precio = this.precio * 0.75;
                break;
            default:
                System.out.println("Promoción no reconocida");
        }
    }

    @Override
    public double calcularImpuesto(double porcentaje) {
        return this.precio * (porcentaje / 100);
    }

    public abstract boolean aplicarDescuentoPorVencimiento();

    @Override
    public String toString() {
        return String.format("%s - $%.2f (%s)", nombre, precio, categoria);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static int getTotalProductos() {
        return totalProductos;
    }
}

