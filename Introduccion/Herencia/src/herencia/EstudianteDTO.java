package herencia;

public class EstudianteDTO extends ObjectDTO{
    private double promedio;
    private int asistencias;
    
    public EstudianteDTO(){}

    public EstudianteDTO(double promedio, int asistencias) {
        this.promedio = promedio;
        this.asistencias = asistencias;
    }

    public EstudianteDTO(double promedio, int asistencias, int id) {
        super(id);
        this.promedio = promedio;
        this.asistencias = asistencias;
    }

    public EstudianteDTO(double promedio, int asistencias, int id, String nombre) {
        super(id, nombre);
        this.promedio = promedio;
        this.asistencias = asistencias;
    }

    public EstudianteDTO(int id) {
        super(id);
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }
    
    
    
}
