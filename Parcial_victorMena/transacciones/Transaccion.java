package transacciones;

import usuarios.Comprador;
import usuarios.Vendedor;
import java.util.Date;

public class Transaccion {
    private Comprador comprador;
    private Vendedor vendedor;
    private double monto;
    private Date fecha;

    public Transaccion(Comprador comprador, Vendedor vendedor, double monto) {
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.monto = monto;
        this.fecha = new Date(); // Se registra la fecha y hora actual
    }

    public void procesarPago() {
        System.out.println("Procesando pago de $" + monto + " de " + comprador.getNombre() + " a " + vendedor.getNombre());
    }

    public void confirmarPago() {
        System.out.println("Pago confirmado: $" + monto + " de " + comprador.getNombre() + " a " + vendedor.getNombre());
    }

    public Comprador getComprador() {
        return comprador;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public double getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }
}
