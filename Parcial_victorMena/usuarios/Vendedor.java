package usuarios;

import articulos.Articulo;
import subastas.Subasta;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Usuario {
    private List<Articulo> articulosPublicados = new ArrayList<>();

    public Vendedor(String nombre, String apellidos, String direccion, String correoElectronico, String contrasena) {
        super(nombre, apellidos, direccion, correoElectronico, contrasena);
    }

    public void publicarArticulo(Articulo articulo) {
        articulosPublicados.add(articulo);
        System.out.println("Artículo publicado: " + articulo.getNombre());
    }

    public void gestionarSubasta(Subasta subasta) {
        System.out.println("Gestionando subasta: " + subasta.getArticulo().getNombre());
    }
}
