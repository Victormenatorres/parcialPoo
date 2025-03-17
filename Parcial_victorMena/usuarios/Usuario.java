package usuarios;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String direccion;
    private String correoElectronico;
    private String contraseña;
    private List<String> historialTransacciones;
    private List<String> evaluaciones;

    public Usuario() {
        this.historialTransacciones = new ArrayList<>();
        this.evaluaciones = new ArrayList<>();
    }

    public Usuario(String nombre, String apellidos, String direccion, String correoElectronico, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.historialTransacciones = new ArrayList<>();
        this.evaluaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void actualizarDatos(String nuevoNombre, String nuevosApellidos, String nuevaDireccion, String nuevoCorreo) {
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) this.nombre = nuevoNombre;
        if (nuevosApellidos != null && !nuevosApellidos.isEmpty()) this.apellidos = nuevosApellidos;
        if (nuevaDireccion != null && !nuevaDireccion.isEmpty()) this.direccion = nuevaDireccion;
        if (nuevoCorreo != null && !nuevoCorreo.isEmpty()) this.correoElectronico = nuevoCorreo;
        System.out.println("Datos actualizados con éxito.");
    }

    public boolean cambiarContrasena(String actual, String nueva) {
        if (actual.equals(this.contraseña)) {
            this.contraseña = nueva;
            System.out.println("Contraseña cambiada con éxito.");
            return true;
        } else {
            System.out.println("Contraseña incorrecta.");
            return false;
        }
    }

    public void eliminarCuenta() {
        this.nombre = null;
        this.apellidos = null;
        this.direccion = null;
        this.correoElectronico = null;
        this.contraseña = null;
        this.historialTransacciones.clear();
        this.evaluaciones.clear();
        System.out.println("Cuenta eliminada con éxito.");
    }

    public void agregarTransaccion(String transaccion) {
        historialTransacciones.add(transaccion);
    }

    public void agregarEvaluacion(String evaluacion) {
        evaluaciones.add(evaluacion);
    }

    public void mostrarPerfil() {
        System.out.println("Nombre: " + nombre + " " + apellidos);
        System.out.println("Dirección: " + direccion);
        System.out.println("Correo: " + correoElectronico);
        System.out.println("Historial: " + String.join(", ", historialTransacciones));
        System.out.println("Evaluaciones: " + String.join(", ", evaluaciones));
    }
}
