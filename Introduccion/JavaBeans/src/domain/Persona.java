
package domain;

import java.io.Serializable;

public class Persona implements Serializable{
    //requirimiento para ser JavaBean
    private String nombre;
    private String apellido;
    
    public Persona(){   //requirimiento para ser JavaBesn
        
    }
    
    public Persona(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    ///setters and getters: requirimiento para ser JavaBean
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

    @Override       ///opcional pero ideal para objetos POO
    public String toString()  {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
    
}
