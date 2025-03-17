package notificaciones;

import usuarios.Usuario;
import subastas.Subasta;
import subastas.Oferta;

public class SistemaNotificaciones {

    public static void notificarNuevaOferta(Subasta subasta, Oferta oferta) {
        if (subasta == null || oferta == null) {
            System.out.println("Error: Subasta u oferta inválida.");
            return;
        }
        Usuario vendedor = subasta.getVendedor(); // Obtén el vendedor desde la subasta
        if (vendedor == null) {
            System.out.println("Error: No se puede notificar, vendedor no encontrado.");
            return;
        }

        String mensaje = "Nueva oferta de $" + oferta.getMonto() + " en la subasta del artículo " + subasta.getArticulo().getNombre();
        Notificacion notificacion = new Notificacion(vendedor, mensaje);
        notificacion.enviarNotificacion();
    }

    public static void notificarFinSubasta(Usuario usuario, Subasta subasta) {
        if (usuario == null || subasta == null) {
            System.out.println("Error: Usuario o subasta inválida.");
            return;
        }

        String mensaje = "La subasta del artículo " + subasta.getArticulo().getNombre() + " ha finalizado.";
        Notificacion notificacion = new Notificacion(usuario, mensaje);
        notificacion.enviarNotificacion();
    }

    public static void notificarCambioEstadoSubasta(Usuario usuario, Subasta subasta) {
        if (usuario == null || subasta == null) {
            System.out.println("Error: Usuario o subasta inválida.");
            return;
        }

        String mensaje = "La subasta del artículo " + subasta.getArticulo().getNombre() + " ha cambiado de estado a " + subasta.getEstado() + ".";
        Notificacion notificacion = new Notificacion(usuario, mensaje);
        notificacion.enviarNotificacion();
    }
}

