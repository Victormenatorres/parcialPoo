package usuarios;

public class Administrador extends Usuario {

    public Administrador(String nombre, String apellidos, String direccion, String correoElectronico, String contrasena) {
        super(nombre, apellidos, direccion, correoElectronico, contrasena);
    }

    public void moderarUsuarios(Usuario usuario) {
        System.out.println("Moderando usuario: " + usuario.getNombre());
    }

    public void resolverProblemas(String reporte) {
        System.out.println("Resolviendo problema: " + reporte);
    }
}
