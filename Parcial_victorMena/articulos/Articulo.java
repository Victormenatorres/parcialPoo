package articulos;

import java.util.Date;

public class Articulo {
    private String nombre;
    private String descripcion;
    private String estado;
    private double precioInicial;
    private Date fechaLimite;
    private Categoria categoria; 

    public Articulo(String nombre, String descripcion, String estado, double precioInicial, Date fechaLimite, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.precioInicial = precioInicial;
        this.fechaLimite = fechaLimite;
        this.categoria = categoria;
    }
    public String getDescripcion() {
        return descripcion;
    }
    
  

    public void publicar() {
        System.out.println("Artículo publicado: " + nombre);
    }

    public void editar(String nuevaDescripcion, double nuevoPrecio) {
        this.descripcion = nuevaDescripcion;
        this.precioInicial = nuevoPrecio;
        System.out.println("Artículo editado: " + nombre);
    }

    public void eliminar() {
        System.out.println("Artículo eliminado: " + nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioInicial() {
        return precioInicial;
    }

    public Categoria getCategoria() {
        return categoria;
    }
    public String getEstado() {
        return estado;
    }
}
