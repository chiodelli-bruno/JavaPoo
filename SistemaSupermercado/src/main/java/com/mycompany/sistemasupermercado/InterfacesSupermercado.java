/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasupermercado;

public class InterfacesSupermercado {
    public interface Promocionable {
        void aplicarDescuento(double porcentaje);
        void aplicarPromocion(String tipoPromocion);
    }

    public interface ImpuestoAplicable {
        double calcularImpuesto(double porcentaje);
    }
}