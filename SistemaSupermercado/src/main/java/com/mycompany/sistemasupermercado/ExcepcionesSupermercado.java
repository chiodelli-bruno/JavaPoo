/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasupermercado;

public class ExcepcionesSupermercado {
    public static class ProductoNoDisponibleException extends Exception {
        public ProductoNoDisponibleException(String mensaje) {
            super(mensaje);
        }
    }

    public static class ClienteNoRegistradoException extends Exception {
        public ClienteNoRegistradoException(String mensaje) {
            super(mensaje);
        }
    }
}