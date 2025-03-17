package subastas;

import usuarios.Comprador;
import java.util.ArrayList;
import java.util.List;

public class HistorialOfertas {
    private Comprador usuario;
    private List<Oferta> listaOfertas;

    public HistorialOfertas(Comprador usuario) {
        this.usuario = usuario;
        this.listaOfertas = new ArrayList<>();
    }

    public void agregarOferta(Oferta oferta) {
        listaOfertas.add(oferta);
        System.out.println("Oferta agregada al historial de " + usuario.getNombre() + ": $" + oferta.getMonto());
    }

    public void obtenerHistorial() {
        System.out.println("Historial de ofertas de " + usuario.getNombre() + ":");
        for (Oferta oferta : listaOfertas) {
            System.out.println("- $" + oferta.getMonto() + " en " + oferta.getFechaHora());
        }
    }
}
