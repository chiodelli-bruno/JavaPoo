/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasupermercado;

public class Gerente extends Empleado {
    private double bonoGerencial;

    public Gerente(String nombre, String idEmpleado, double salarioBase, double bonoGerencial) {
        super(nombre, idEmpleado, salarioBase);
        this.bonoGerencial = bonoGerencial;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + bonoGerencial;
    }

    public double getBonoGerencial() {
        return bonoGerencial;
    }

    public void setBonoGerencial(double bonoGerencial) {
        this.bonoGerencial = bonoGerencial;
    }

    @Override
    public String toString() {
        return "Gerente: " + nombre + " (ID: " + idEmpleado + ")";
    }
}