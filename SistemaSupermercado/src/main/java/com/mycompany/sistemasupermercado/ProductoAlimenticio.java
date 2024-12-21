/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasupermercado;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

public class ProductoAlimenticio extends Producto {
    private LocalDate fechaCaducidad;
    private boolean esPerecedero;

    public ProductoAlimenticio(String codigo, String nombre, double precio, LocalDate fechaCaducidad) {
        super(codigo, nombre, precio, "Alimentación");
        this.fechaCaducidad = fechaCaducidad;
        this.esPerecedero = ChronoUnit.DAYS.between(LocalDate.now(), fechaCaducidad) <= 30;
    }

    @Override
    public double calcularPrecioFinal() {
        double precioFinal = getPrecio();
        if (aplicarDescuentoPorVencimiento()) {
            precioFinal *= 0.7; 
        }
        precioFinal += calcularImpuesto(5);
        return precioFinal;
    }

    @Override
    public boolean aplicarDescuentoPorVencimiento() {
        long diasHastaCaducidad = ChronoUnit.DAYS.between(LocalDate.now(), fechaCaducidad);
        return diasHastaCaducidad <= 5;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%s - $%.2f (Caduca: %s)", getNombre(), getPrecio(), fechaCaducidad.format(formatter));
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public boolean isEsPerecedero() {
        return esPerecedero;
    }

    public void setEsPerecedero(boolean esPerecedero) {
        this.esPerecedero = esPerecedero;
    }
}

