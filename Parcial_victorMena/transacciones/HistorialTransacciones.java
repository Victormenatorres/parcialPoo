package transacciones;

import usuarios.Usuario;
import java.util.ArrayList;
import java.util.List;

public class HistorialTransacciones {
    private Usuario usuario;
    private List<Transaccion> listaTransacciones;

    public HistorialTransacciones(Usuario usuario) {
        this.usuario = usuario;
        this.listaTransacciones = new ArrayList<>();
    }

    public void agregarTransaccion(Transaccion transaccion) {
        listaTransacciones.add(transaccion);
        System.out.println("Transacción agregada al historial de " + usuario.getNombre() + ": $" + transaccion.getMonto());
    }

    public void consultarHistorial() {
        System.out.println("Historial de transacciones de " + usuario.getNombre() + ":");
        for (Transaccion transaccion : listaTransacciones) {
            System.out.println("- $" + transaccion.getMonto() + " el " + transaccion.getFecha());
        }
    }
}
