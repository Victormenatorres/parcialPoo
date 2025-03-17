package usuarios;

public class Evaluacion {
    private Usuario usuarioEvaluado;
    private Usuario usuarioQueEvalua;
    private int calificacion;
    private String comentario;

    public Evaluacion(Usuario usuarioEvaluado, Usuario usuarioQueEvalua, int calificacion, String comentario) {
        this.usuarioEvaluado = usuarioEvaluado;
        this.usuarioQueEvalua = usuarioQueEvalua;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public void agregarEvaluacion() {
        System.out.println("Evaluación agregada a " + usuarioEvaluado.getNombre() + " por " + usuarioQueEvalua.getNombre());
    }

    public void consultarEvaluaciones() {
        System.out.println("Evaluación de " + usuarioEvaluado.getNombre() + ": " + calificacion + " estrellas");
        System.out.println("Comentario: " + comentario);
    }
}
