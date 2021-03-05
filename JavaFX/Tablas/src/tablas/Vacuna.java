/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

/**
 *
 * @author Bubu
 */
public class Vacuna {
    private boolean hecha;
    private String nombre;

    public Vacuna(boolean hecha, String nombre) {
        this.hecha = hecha;
        this.nombre = nombre;
    }

    public boolean isHecha() {
        return hecha;
    }

    public void setHecha(boolean hecha) {
        this.hecha = hecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
