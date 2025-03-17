package articulos;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Articulo> listaArticulos;

    public Inventario() {
        this.listaArticulos = new ArrayList<>();
    }

    public void agregarArticulo(Articulo articulo) {
        listaArticulos.add(articulo);
        System.out.println("Artículo agregado al inventario: " + articulo.getNombre());
    }

    public void buscarArticulo(String nombre) {
        for (Articulo articulo : listaArticulos) {
            if (articulo.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Artículo encontrado: " + articulo.getNombre());
                return;
            }
        }
        System.out.println("Artículo no encontrado.");
    }

    public void listarArticulosPorCategoria(Categoria categoria) {
        System.out.println("Artículos en la categoría: " + categoria.getNombre());
        for (Articulo articulo : listaArticulos) {
            if (articulo.getCategoria().equals(categoria)) {
                System.out.println("- " + articulo.getNombre());
            }
        }
    }

    public Articulo buscarPorNombre(String nombre) {
        for (Articulo articulo : listaArticulos) {
            if (articulo.getNombre().equalsIgnoreCase(nombre)) {
                return articulo;
            }
        }
        return null; // Retorna null si no lo encuentra
    }

    public List<Articulo> getListaArticulos() {
        return listaArticulos;
    }
}
