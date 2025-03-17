package seguridad;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encriptacion {

    public static String encriptarContrasena(String contrasena) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(contrasena.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error en la encriptación: " + e.getMessage());
            return null;
        }
    }

    public static boolean verificarContrasena(String contrasena, String hashAlmacenado) {
        String hashIngresado = encriptarContrasena(contrasena);
        return hashIngresado != null && hashIngresado.equals(hashAlmacenado);
    }
}

