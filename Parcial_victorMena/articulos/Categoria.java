package articulos;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nombre;
    private List<Categoria> subcategorias;
    private List<Articulo> articulos; // Lista de artículos en esta categoría

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.subcategorias = new ArrayList<>();
        this.articulos = new ArrayList<>();
    }

    public void agregarSubcategoria(Categoria subcategoria) {
        subcategorias.add(subcategoria);
        System.out.println("Subcategoría añadida: " + subcategoria.getNombre() + " a " + nombre);
    }

    public void eliminarSubcategoria(Categoria subcategoria) {
        subcategorias.remove(subcategoria);
        System.out.println("Subcategoría eliminada: " + subcategoria.getNombre() + " de " + nombre);
    }

    public void agregarArticulo(Articulo articulo) {
        articulos.add(articulo);
        System.out.println("Artículo agregado: " + articulo.getNombre() + " a la categoría " + nombre);
    }

    public void mostrarCategoriasYArticulos(String prefijo) {
        System.out.println(prefijo + "📂 Categoría: " + nombre);
        for (Articulo articulo : articulos) {
            System.out.println(prefijo + "   🛒 " + articulo.getNombre() + " - Estado: " + articulo.getEstado());
        }
        for (Categoria subcategoria : subcategorias) {
            subcategoria.mostrarCategoriasYArticulos(prefijo + "   ");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<Categoria> getSubcategorias() {
        return subcategorias;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }
}
