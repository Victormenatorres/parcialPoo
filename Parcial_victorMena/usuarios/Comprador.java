package usuarios;

import subastas.Oferta;
import java.util.ArrayList;
import java.util.List;
import articulos.*;

public class Comprador extends Usuario {
    private List<Oferta> historialOfertas = new ArrayList<>();

    public Comprador(String nombre, String apellidos, String direccion, String correoElectronico, String contrasena) {
        super(nombre, apellidos, direccion, correoElectronico, contrasena);
    }

    public void ofertar(Oferta oferta) {
        historialOfertas.add(oferta);
        System.out.println("Oferta realizada: " + oferta.getMonto());
    }

    public void consultarHistorialOfertas() {
        System.out.println("Historial de ofertas:");
        for (Oferta oferta : historialOfertas) {
            System.out.println("- " + oferta.getMonto() + " por " + oferta.getArticulo().getNombre());
        }
    }
}
