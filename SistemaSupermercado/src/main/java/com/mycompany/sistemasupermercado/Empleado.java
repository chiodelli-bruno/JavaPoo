/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasupermercado;

public abstract class Empleado {
    protected String nombre;
    protected String idEmpleado;
    protected double salarioBase;

    public Empleado(String nombre, String idEmpleado, double salarioBase) {
        this.nombre = nombre;
        this.idEmpleado = idEmpleado;
        this.salarioBase = salarioBase;
    }

    public abstract double calcularSalario();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public String toString() {
        return "Empleado: " + nombre + " (ID: " + idEmpleado + ")";
    }
}
