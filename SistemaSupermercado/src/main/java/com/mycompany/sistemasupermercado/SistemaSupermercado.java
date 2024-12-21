/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemasupermercado;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.List;

public class SistemaSupermercado {
    private static Supermercado supermercado = new Supermercado();
    public static void main(String[] args) {
        inicializarDatos();
        mostrarMenu();
    }
    private static void inicializarDatos() {
        supermercado.agregarProducto(new ProductoAlimenticio("A001", "Manzanas", 2.5, LocalDate.now().plusDays(10)));
        supermercado.agregarProducto(new ProductoAlimenticio("A002", "Leche", 1.8, LocalDate.now().plusDays(7)));
        supermercado.agregarProducto(new ProductoElectronico("E001", "Auriculares", 29.99, 1));
        supermercado.agregarProducto(new ProductoElectronico("E002", "Smartphone", 299.99, 2));
        supermercado.agregarProducto(new ProductoHigiene("H001", "Jabón", 1.5, "Corporal"));
        supermercado.agregarProducto(new ProductoHigiene("H002", "Champú", 3.5, "Cabello"));
        supermercado.agregarCliente(new Cliente("Juan Pérez", "12345678A"));
        supermercado.agregarCliente(new ClienteVIP("María García", "87654321B", 10));
        supermercado.agregarEmpleado(new Cajero("Ana López", "EMP001", 1500));
        supermercado.agregarEmpleado(new Gerente("Carlos Rodríguez", "EMP002", 2500, 500));
    }

    private static void mostrarMenu() {
        String[] opciones = {
            "Mostrar inventario",
            "Mostrar clientes",
            "Mostrar empleados",
            "Realizar compra",
            "Salir"
        };
        while (true) {
            int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción:",
                "Sistema de Gestión de Supermercado",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );
            switch (seleccion) {
                case 0:
                    mostrarInventario();
                    break;
                case 1:
                    mostrarClientes();
                    break;
                case 2:
                    mostrarEmpleados();
                    break;
                case 3:
                    realizarCompra();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el Sistema de Gestión de Supermercado");
                    System.exit(0);
                default:
                    return;
            }
        }
    }

    private static void mostrarInventario() {
        StringBuilder inventario = new StringBuilder("Inventario del Supermercado:\n\n");
        for (Producto producto : supermercado.getProductosDisponibles()) {
            inventario.append(producto.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, inventario.toString());
    }

    private static void mostrarClientes() {
        StringBuilder listaClientes = new StringBuilder("Clientes registrados:\n\n");
        for (Cliente cliente : supermercado.getClientes()) {
            listaClientes.append(cliente.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, listaClientes.toString());
    }
    private static void mostrarEmpleados() {
        StringBuilder listaEmpleados = new StringBuilder("Empleados del Supermercado:\n\n");
        for (Empleado empleado : supermercado.getEmpleados()) {
            listaEmpleados.append(empleado.toString())
                          .append(" - Salario: $")
                          .append(String.format("%.2f", empleado.calcularSalario()))
                          .append("\n");
        }
        JOptionPane.showMessageDialog(null, listaEmpleados.toString());
    }
    private static void realizarCompra() {
        if (!supermercado.hayProductosDisponibles()) {
            JOptionPane.showMessageDialog(null, "No hay productos disponibles en el inventario.");
            return;
        }
        Cliente clienteSeleccionado = seleccionarCliente();
        if (clienteSeleccionado == null) return;

        Producto productoSeleccionado = seleccionarProducto();
        if (productoSeleccionado == null) return;

        String promocionSeleccionada = seleccionarPromocion();

        try {
            String ticket = supermercado.registrarCompra(clienteSeleccionado, productoSeleccionado, promocionSeleccionada);
            JOptionPane.showMessageDialog(null, ticket);
            mostrarInventario();
        } catch (ExcepcionesSupermercado.ProductoNoDisponibleException | ExcepcionesSupermercado.ClienteNoRegistradoException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar la compra: " + e.getMessage());
        }
    }

    private static Cliente seleccionarCliente() {
        List<Cliente> clientes = supermercado.getClientes();
        String[] nombresClientes = clientes.stream().map(Cliente::getNombre).toArray(String[]::new);

        int seleccion = JOptionPane.showOptionDialog(
            null,
            "Seleccione un cliente:",
            "Realizar Compra",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            nombresClientes,
            nombresClientes[0]
        );

        return seleccion != JOptionPane.CLOSED_OPTION ? clientes.get(seleccion) : null;
    }

    private static Producto seleccionarProducto() {
        List<Producto> productos = supermercado.getProductosDisponibles();
        String[] nombresProductos = productos.stream().map(Producto::toString).toArray(String[]::new);

        int seleccion = JOptionPane.showOptionDialog(
            null,
            "Seleccione un producto:",
            "Realizar Compra",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            nombresProductos,
            nombresProductos[0]
        );

        return seleccion != JOptionPane.CLOSED_OPTION ? productos.get(seleccion) : null;
    }

    private static String seleccionarPromocion() {
        String[] promociones = {"Sin promoción", "2x1", "50% en la segunda unidad"};
        
        int seleccion = JOptionPane.showOptionDialog(
            null,
            "Seleccione una promoción:",
            "Aplicar Promoción",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            promociones,
            promociones[0]
        );

        return seleccion != JOptionPane.CLOSED_OPTION ? promociones[seleccion] : "Sin promoción";
    }
}

