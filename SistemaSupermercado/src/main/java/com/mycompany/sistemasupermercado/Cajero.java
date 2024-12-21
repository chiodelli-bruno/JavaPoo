/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasupermercado;

public class Cajero extends Empleado {
    private double ventasRealizadas;

    public Cajero(String nombre, String idEmpleado, double salarioBase) {
        super(nombre, idEmpleado, salarioBase);
        this.ventasRealizadas = 0;
    }

    @Override
    public double calcularSalario() {
        double comision = ventasRealizadas * 0.01; 
        return salarioBase + comision;
    }

    public void registrarVenta(double monto) {
        this.ventasRealizadas += monto;
    }

    public double getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(double ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public String toString() {
        return "Cajero: " + nombre + " (ID: " + idEmpleado + ")";
    }
}