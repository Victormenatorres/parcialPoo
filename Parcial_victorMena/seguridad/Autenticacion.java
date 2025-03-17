package seguridad;

import usuarios.Usuario;
import java.util.HashMap;
import java.util.Map;

public class Autenticacion {
    private static Map<String, String> credenciales = new HashMap<>(); // Simula una base de datos de credenciales
    private static Map<String, Usuario> usuariosRegistrados = new HashMap<>(); // Almacena los usuarios por correo

    // Método para iniciar sesión, devuelve el usuario si las credenciales son correctas
    public static Usuario iniciarSesion(String correo, String contrasena) {
        correo = correo.trim(); // Elimina espacios en blanco al inicio y final
        if (credenciales.containsKey(correo) && credenciales.get(correo).equals(contrasena)) {
            System.out.println("✅ Inicio de sesión exitoso para: " + correo);
            return usuariosRegistrados.get(correo);
        } else {
            System.out.println("❌ Error: Credenciales incorrectas.");
            return null;
        }
    }

    // Método para cerrar sesión
    public static void cerrarSesion(String correo) {
        System.out.println("🔒 Cierre de sesión exitoso para: " + correo);
    }

    // Método para verificar si el usuario es mayor de edad antes de registrarse
    public static boolean verificarEdad(int edad) {
        if (edad >= 18) {
            System.out.println("✅ Verificación de edad exitosa.");
            return true;
        } else {
            System.out.println("❌ Error: Debes ser mayor de edad para registrarte.");
            return false;
        }
    }

    // Método para registrar un nuevo usuario
    public static void registrarUsuario(Usuario usuario, String correo, String contrasena) {
        if (!credenciales.containsKey(correo)) {
            credenciales.put(correo, contrasena);
            usuariosRegistrados.put(correo, usuario);
            System.out.println("✅ Usuario registrado con éxito: " + correo);
        } else {
            System.out.println("❌ Error: El correo ya está registrado.");
        }
    }
}
