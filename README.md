# JavaPoo
# Sistema de Gestión de Supermercado

## Descripción
Este proyecto es un Sistema de Gestión de Supermercado desarrollado en Java. Proporciona una interfaz gráfica simple utilizando JOptionPane para gestionar productos, clientes, empleados y ventas en un supermercado.

## Características Principales
- Gestión de inventario de productos (alimentos, electrónicos, productos de higiene)
- Manejo de clientes regulares y VIP
- Gestión de empleados (cajeros y gerentes)
- Sistema de ventas con aplicación de promociones y descuentos
- Cálculo de precios finales incluyendo impuestos y descuentos
- Generación de tickets detallados para cada compra

## Requisitos
- Java Development Kit (JDK) 8 o superior
- IDE Java (como NetBeans, Eclipse, o IntelliJ IDEA)

## Instalación y Ejecución
1. Clone el repositorio o descargue los archivos del proyecto.
2. Abra el proyecto en su IDE Java preferido.
3. Compile el proyecto para asegurarse de que no hay errores.
4. Ejecute la clase `SistemaSupermercado.java` para iniciar la aplicación.

## Uso
Al ejecutar el programa, se mostrará un menú con las siguientes opciones:
1. Mostrar inventario
2. Mostrar clientes
3. Mostrar empleados
4. Realizar compra
5. Salir

Seleccione la opción deseada para interactuar con el sistema.

## Estructura del Proyecto
- `SistemaSupermercado.java`: Clase principal que contiene el menú y la lógica de interacción.
- `Supermercado.java`: Clase que gestiona el inventario, clientes y empleados.
- `Producto.java`: Clase abstracta base para todos los productos.
- `ProductoAlimenticio.java`: Subclase de Producto para alimentos.
- `ProductoElectronico.java`: Subclase de Producto para electrónicos.
- `ProductoHigiene.java`: Subclase de Producto para productos de higiene.
- `Cliente.java`: Clase que representa a un cliente regular.
- `ClienteVIP.java`: Subclase de Cliente para clientes VIP.
- `Empleado.java`: Clase abstracta base para todos los empleados.
- `Cajero.java`: Subclase de Empleado para cajeros.
- `Gerente.java`: Subclase de Empleado para gerentes.
- `InterfacesSupermercado.java`: Contiene interfaces utilizadas en el proyecto.
- `ExcepcionesSupermercado.java`: Define excepciones personalizadas para el sistema.

## Contribución
Si deseas contribuir a este proyecto, por favor, crea un fork del repositorio, realiza tus cambios y envía un pull request para su revisión.
