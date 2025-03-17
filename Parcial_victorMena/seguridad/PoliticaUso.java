package seguridad;

import java.util.ArrayList;
import java.util.List;

public class PoliticaUso {
    private static List<String> usuariosReportados = new ArrayList<>();

    public static boolean verificarCumplimiento(String usuario) {
        if (usuariosReportados.contains(usuario)) {
            System.out.println("El usuario " + usuario + " ha sido reportado y está bajo revisión.");
            return false;
        } else {
            System.out.println("El usuario " + usuario + " cumple con las políticas de uso.");
            return true;
        }
    }

    public static void reportarUsuario(String usuario) {
        if (!usuariosReportados.contains(usuario)) {
            usuariosReportados.add(usuario);
            System.out.println("El usuario " + usuario + " ha sido reportado por incumplimiento de las normas.");
        } else {
            System.out.println("El usuario " + usuario + " ya ha sido reportado anteriormente.");
        }
    }
}
