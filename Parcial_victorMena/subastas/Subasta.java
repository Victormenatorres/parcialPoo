package subastas;

import articulos.Articulo;
import usuarios.Vendedor;
import java.util.ArrayList;
import java.util.List;

public class Subasta {
    private Articulo articulo;
    private Vendedor vendedor;
    private List<Oferta> ofertas;
    private String estado; // "activa", "finalizada", "cancelada"
    public Vendedor getVendedor() {
        return vendedor;
    }

    public Subasta(Articulo articulo, Vendedor vendedor) {
        this.articulo = articulo;
        this.vendedor = vendedor;
        this.ofertas = new ArrayList<>();
        this.estado = "activa";
    }

    public void iniciarSubasta() {
        System.out.println("Subasta iniciada para el artículo: " + articulo.getNombre());
    }

    public void finalizarSubasta() {
        if (!ofertas.isEmpty()) {
            Oferta mejorOferta = ofertas.get(ofertas.size() - 1);
            System.out.println("Subasta finalizada. Ganador: " + mejorOferta.getComprador().getNombre() + " con oferta de $" + mejorOferta.getMonto());
        } else {
            System.out.println("Subasta finalizada sin ofertas.");
        }
        this.estado = "finalizada";
    }

    public void cancelarSubasta() {
        System.out.println("Subasta cancelada para el artículo: " + articulo.getNombre());
        this.estado = "cancelada";
    }

    public void agregarOferta(Oferta oferta) {
        if (estado.equals("activa")) {
            ofertas.add(oferta);
            System.out.println("Nueva oferta de $" + oferta.getMonto() + " por " + oferta.getComprador().getNombre());
        } else {
            System.out.println("No se pueden agregar ofertas. La subasta está " + estado);
        }
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public String getEstado() {
        return estado;
    }

    public void realizarOferta(Oferta oferta) {
        if (estado.equals("activa")) {
            ofertas.add(oferta);
            System.out.println("Oferta aceptada: " + oferta.getMonto() + " por " + oferta.getComprador().getNombre());
        } else {
            System.out.println("No se pueden realizar ofertas. La subasta está " + estado);
        }
    }
    
    
}
