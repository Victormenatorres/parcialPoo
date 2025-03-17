package soporte;

import usuarios.Usuario;
import java.util.ArrayList;
import java.util.List;

public class SoporteCliente {
    private Usuario usuario;
    private String mensaje;
    private String estado; // "Abierto", "En proceso", "Resuelto"
    private static List<SoporteCliente> tickets = new ArrayList<>();

    public SoporteCliente(Usuario usuario, String mensaje) {
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.estado = "Abierto";
        tickets.add(this);
    }

    public void resolverTicket() {
        this.estado = "Resuelto";
        System.out.println("El ticket de " + usuario.getNombre() + " ha sido resuelto.");
    }

    public static void listarTickets() {
        System.out.println("Lista de tickets abiertos:");
        for (SoporteCliente ticket : tickets) {
            System.out.println("Usuario: " + ticket.usuario.getNombre() + " | Estado: " + ticket.estado);
        }
    }

    public String getEstado() {
        return estado;
    }
}
