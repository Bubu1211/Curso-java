package tablas;

import java.util.ArrayList;
import java.util.List;

public class Dog {
    private int edad;
    private String nombre;
    private Owner owner;
    private List<Vacuna> vacunas;

    public List<Vacuna> getVacunas() {
        return vacunas;
    }

    public void setVacunas(List vacunas) {
        this.vacunas = vacunas;
    }

    public Dog(int edad, String nombre, Owner owner, List vacunas) {
        this.edad = edad;
        this.nombre = nombre;
        this.owner = owner;
        this.vacunas = vacunas;
    }

    
    
    public Dog(int edad, String nombre, Owner owner) {
        vacunas = new ArrayList<Vacuna>();
        this.edad = edad;
        this.nombre = nombre;
        this.owner = owner;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    
    
}
