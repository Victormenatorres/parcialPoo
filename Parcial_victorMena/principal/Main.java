package principal;

import usuarios.*;
import articulos.*;
import subastas.*;
import notificaciones.*;
import transacciones.*;
import seguridad.*;
import soporte.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = null;
        Subasta subasta = null;
        Inventario inventario = new Inventario(); // Inventario para manejar artículos

        // Definir categorías principales
        Categoria electronicos = new Categoria("Electrónicos");
        Categoria computadoras = new Categoria("Computadoras");
        Categoria celulares = new Categoria("Celulares");
        Categoria muebles = new Categoria("Muebles");

        // Agregar subcategorías
        electronicos.agregarSubcategoria(computadoras);
        electronicos.agregarSubcategoria(celulares);

        System.out.println("=== Bienvenido al sistema de subastas en línea ===");

        while (true) {
            usuario = null;
            while (usuario == null) {
                limpiarConsola();
                System.out.println("\nMenú de Inicio:");
                System.out.println("1. Iniciar Sesión");
                System.out.println("2. Registrarse");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = obtenerOpcion(scanner);
                switch (opcion) {
                    case 1:
                    limpiarConsola();
                        usuario = iniciarSesion(scanner);
                        break;
                    case 2:
                        limpiarConsola();
                        usuario = registrarUsuario(scanner);
                        break;
                    case 3:
                    limpiarConsola();
                        System.out.println("Saliendo del sistema...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                        pausa(scanner);
                }
            }

            while (usuario != null) {
                limpiarConsola();
                System.out.println("\nMenú Principal:");
                System.out.println("1. Crear Artículo y Publicarlo");
                System.out.println("2. Ver Inventario por Categorías");

                if (usuario instanceof Vendedor) {
                    System.out.println("3. Iniciar Subasta");
                } else {
                    System.out.println("3. Realizar Oferta");
                }

                System.out.println("4. Ver Historial de Transacciones");
                System.out.println("5. Cerrar sesión");
                System.out.print("Seleccione una opción: ");

                int opcion = obtenerOpcion(scanner);
                switch (opcion) {
                    case 1:
                    limpiarConsola();
                        Articulo articulo = crearArticulo(scanner, electronicos, muebles);
                        if (articulo != null) {
                            inventario.agregarArticulo(articulo);
                            articulo.publicar();
                        }
                        break;
                    case 2:
                    limpiarConsola();
                        electronicos.mostrarCategoriasYArticulos("");
                        muebles.mostrarCategoriasYArticulos("");
                        pausa(scanner);
                        break;
                    case 3:
                    limpiarConsola();
                        if (usuario instanceof Vendedor) {
                            System.out.print("Ingrese el nombre del artículo para la subasta: ");
                            String nombreArticulo = scanner.nextLine();
                            Articulo articuloSubasta = inventario.buscarPorNombre(nombreArticulo);

                            if (articuloSubasta != null) {
                                subasta = new Subasta(articuloSubasta, (Vendedor) usuario);
                                subasta.iniciarSubasta();
                            } else {
                                System.out.println("El artículo no existe en el inventario.");
                            }
                        } else {
                            if (subasta == null) {
                                System.out.println("¡No hay ninguna subasta activa!");
                            } else {
                                realizarOferta(scanner, subasta, usuario);
                            }
                        }
                        break;
                    case 4:
                    limpiarConsola();
                        HistorialTransacciones historial = new HistorialTransacciones(usuario);
                        historial.consultarHistorial();
                        break;
                    case 5:
                    limpiarConsola();
                        System.out.println("Cerrando sesión...");
                        usuario = null;
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
                pausa(scanner);
            }
        }
    }

    public static Articulo crearArticulo(Scanner scanner, Categoria electronicos, Categoria muebles) {
        limpiarConsola();
        System.out.println("\n--- Creación de Artículo ---");
        System.out.print("Ingrese el nombre del artículo: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el estado del artículo (Nuevo/Usado): ");
        String estado = scanner.nextLine();
        System.out.print("Ingrese el precio inicial: ");
        double precioInicial = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Ingrese la fecha límite (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        
        Date fechaLimite;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaLimite = sdf.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto. Usando fecha actual por defecto.");
            fechaLimite = new Date();
        }

        // Selección de Categoría
        System.out.println("\nSeleccione la categoría:");
        System.out.println("1. Electrónicos");
        System.out.println("2. Muebles");
        int opcion = obtenerOpcion(scanner);
        Categoria categoriaSeleccionada = (opcion == 1) ? electronicos : muebles;

        return new Articulo(nombre, descripcion, estado, precioInicial, fechaLimite, categoriaSeleccionada);
    }

    public static void realizarOferta(Scanner scanner, Subasta subasta, Usuario usuario) {
        if (!(usuario instanceof Comprador)) {
            System.out.println("Solo los compradores pueden hacer ofertas.");
            return;
        }

        limpiarConsola();
        System.out.println("\n--- Realizar Oferta ---");

        double monto = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print("Ingrese el monto de la oferta: ");
            if (scanner.hasNextDouble()) {
                monto = scanner.nextDouble();
                entradaValida = true;
            } else {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.next();
            }
        }
        scanner.nextLine();

        Oferta oferta = new Oferta((Comprador) usuario, monto, new Date(), subasta.getArticulo());
        subasta.realizarOferta(oferta);
        SistemaNotificaciones.notificarNuevaOferta(subasta, oferta);
    }

    public static Usuario registrarUsuario(Scanner scanner) {
        limpiarConsola();
        System.out.println("\n--- Registro de Usuario ---");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        System.out.print("Seleccione su rol (1. Comprador, 2. Vendedor): ");
        int rol = obtenerOpcion(scanner);

        String contrasenaEncriptada = Encriptacion.encriptarContrasena(contrasena);
        Usuario usuario;

        if (rol == 2) {
            usuario = new Vendedor(nombre, apellido, "Dirección genérica", correo, contrasenaEncriptada);
            System.out.println("Registro exitoso. Se ha registrado como VENDEDOR.");
        } else {
            usuario = new Comprador(nombre, apellido, "Dirección genérica", correo, contrasenaEncriptada);
            System.out.println("Registro exitoso. Se ha registrado como COMPRADOR.");
        }

        Autenticacion.registrarUsuario(usuario, correo, contrasenaEncriptada);
        pausa(scanner);
        return usuario;
    }

    public static Usuario iniciarSesion(Scanner scanner) {
        limpiarConsola();
        System.out.println("\n--- Iniciar Sesión ---");
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        Usuario usuario = Autenticacion.iniciarSesion(correo, contrasena);
        return usuario;
    }

    public static void limpiarConsola() { System.out.println("\n\n"); }
    public static void pausa(Scanner scanner) { System.out.println("\nPresione Enter para continuar..."); scanner.nextLine(); }
    public static int obtenerOpcion(Scanner scanner) { while (!scanner.hasNextInt()) { scanner.nextLine(); } int opcion = scanner.nextInt(); scanner.nextLine(); return opcion; }
}
