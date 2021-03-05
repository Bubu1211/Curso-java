package ft.domain;

import java.util.Objects;

public class Note {
    private String nombre;
    private String titulo;
    private String contenido;
    
    public Note(){} 
    
    //el nombre es la dirección del archivo sin la extensión
    
    public Note(String titulo, String contenido){
        this.titulo = titulo;
        this.contenido = contenido;
    }
    
    public Note(String nombre, String titulo, String contenido){
        this.nombre = nombre;
        this.contenido = contenido;
        this.titulo = titulo; 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Note{" + "nombre=" + nombre + "\n, titulo=" + titulo + ", contenido=" + contenido + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 1211 * hash + Objects.hashCode(this.titulo);
        hash = 1211 * hash + Objects.hashCode(this.contenido);
        hash= 1211 * hash + Objects.hashCode(this.nombre);
        return Math.abs(hash);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Note other = (Note) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        return true;
    }
    
    
}
