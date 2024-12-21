/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemasupermercado;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private List<Producto> productosDisponibles;
    private List<Cliente> clientes;
    private List<Empleado> empleados;

    public Supermercado() {
        this.productosDisponibles = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productosDisponibles.add(producto);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public String registrarCompra(Cliente cliente, Producto producto, String promocion) throws ExcepcionesSupermercado.ProductoNoDisponibleException, ExcepcionesSupermercado.ClienteNoRegistradoException {
        if (!clientes.contains(cliente)) {
            throw new ExcepcionesSupermercado.ClienteNoRegistradoException("El cliente no está registrado en el sistema.");
        }

        if (!productosDisponibles.contains(producto)) {
            throw new ExcepcionesSupermercado.ProductoNoDisponibleException("El producto no está disponible en el inventario.");
        }

        StringBuilder ticket = new StringBuilder();
        ticket.append("TICKET DE COMPRA\n");
        ticket.append("----------------\n");
        ticket.append("Cliente: ").append(cliente.getNombre()).append("\n");
        ticket.append("Producto: ").append(producto.getNombre()).append("\n");
        ticket.append("Precio original: $").append(String.format("%.2f", producto.getPrecio())).append("\n");

        double precioFinal = producto.getPrecio();

        if (promocion != null && !promocion.equals("Sin promoción")) {
            producto.aplicarPromocion(promocion);
            ticket.append("Promoción aplicada: ").append(promocion).append("\n");
            ticket.append("Precio después de promoción: $").append(String.format("%.2f", producto.getPrecio())).append("\n");
        }

        if (producto.aplicarDescuentoPorVencimiento()) {
            ticket.append("Descuento por vencimiento (30%): $").append(String.format("%.2f", producto.getPrecio() * 0.3)).append("\n");
        }

        if (cliente instanceof ClienteVIP) {
            double descuentoVIP = ((ClienteVIP) cliente).getDescuentoVIP();
            ticket.append("Descuento VIP (").append(descuentoVIP).append("%): $")
                  .append(String.format("%.2f", producto.getPrecio() * (descuentoVIP / 100))).append("\n");
            ((ClienteVIP) cliente).aplicarDescuentoVIP(producto);
        }

        precioFinal = producto.calcularPrecioFinal();
        ticket.append("Impuesto aplicado: $").append(String.format("%.2f", producto.calcularImpuesto(producto instanceof ProductoAlimenticio ? 5 : 15))).append("\n");
        ticket.append("Precio final: $").append(String.format("%.2f", precioFinal)).append("\n");

        cliente.comprar(producto);
        productosDisponibles.remove(producto);

        // Registrar la venta para el cajero (asumimos que el primer empleado es un cajero)
        for (Empleado empleado : empleados) {
            if (empleado instanceof Cajero) {
                ((Cajero) empleado).registrarVenta(precioFinal);
                break;
            }
        }

        return ticket.toString();
    }

    public boolean hayProductosDisponibles() {
        return !productosDisponibles.isEmpty();
    }

    public void mostrarInventario() {
        System.out.println("Inventario del Supermercado:");
        for (Producto producto : productosDisponibles) {
            System.out.println(producto.toString());
            System.out.println("--------------------");
        }
    }

    public void mostrarClientes() {
        System.out.println("Clientes registrados:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void mostrarEmpleados() {
        System.out.println("Empleados del Supermercado:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado + " - Salario: $" + String.format("%.2f", empleado.calcularSalario()));
        }
    }

    public List<Producto> getProductosDisponibles() {
        return productosDisponibles;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}

