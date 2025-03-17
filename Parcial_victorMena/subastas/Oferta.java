package subastas;

import usuarios.Comprador;
import java.util.Date;
import articulos.Articulo;

public class Oferta {
    private Comprador comprador;
    private double monto;
    private Date fechaHora;
    private Articulo articulo;

    // Constructor corregido con inicialización de todos los atributos
    public Oferta(Comprador comprador, double monto, Date fechaOferta, Articulo articulo) {
        if (comprador == null) {
            throw new IllegalArgumentException("El comprador no puede ser nulo");
        }
        if (articulo == null) {
            throw new IllegalArgumentException("El artículo no puede ser nulo");
        }
        this.comprador = comprador;
        this.monto = monto;
        this.fechaHora = (fechaOferta != null) ? fechaOferta : new Date(); // Usa la fecha actual si es nula
        this.articulo = articulo;
    }

    public void realizarOferta(Subasta subasta) {
        if (subasta == null) {
            System.out.println("Error: La subasta no existe.");
            return;
        }
        if (!"activa".equals(subasta.getEstado())) {
            System.out.println("No se puede ofertar, la subasta está " + subasta.getEstado());
            return;
        }
        subasta.agregarOferta(this);
        System.out.println("Oferta de $" + monto + " realizada por " + comprador.getNombre());
    }

    public Comprador getComprador() {
        return comprador;
    }

    public double getMonto() {
        return monto;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public Articulo getArticulo() {
        return articulo;
    }
}
