package pruebajdbcenjavafx.model.domain;

public class EstudianteDTO {
    private int idEstudiante;
    private String nombre;
    private String apellido;
    private double promedio;
    
    public EstudianteDTO(){}

    public EstudianteDTO(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public EstudianteDTO(String nombre, String apellido, double promedio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.promedio = promedio;
    }

    public EstudianteDTO(int idEstudiante, String nombre, String apellido, double promedio) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.promedio = promedio;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "EstudianteDTO{" + "idEstudiante=" + idEstudiante + ", nombre=" + nombre + ", apellido=" + apellido + ", promedio=" + promedio + '}';
    }
    
    
}
