package notificaciones;

import usuarios.Usuario;
import subastas.Subasta;

import java.util.Date;

public class Notificacion {
    private Usuario usuario;
    private String mensaje;
    private Date fechaHora;
    private Subasta subasta;

    // Constructor corregido
    public Notificacion(Usuario usuario, String mensaje) {
        if (usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.fechaHora = new Date();
    }

    public void enviarNotificacion() {
        if (usuario == null) {
            System.out.println("Error: Usuario no definido en la notificación.");
            return;
        }
        System.out.println("Notificación enviada a " + usuario.getNombre() + ": " + mensaje);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Date getFechaHora() {
        return fechaHora;
    }
}
