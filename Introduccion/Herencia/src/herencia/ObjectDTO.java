package herencia;

public class ObjectDTO {
    public int id;
    public String nombre;

    public ObjectDTO(int id) {
        this.id = id;
    }

    public ObjectDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
