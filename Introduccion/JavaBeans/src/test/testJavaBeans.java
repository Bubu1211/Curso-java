
package test;

import domain.Persona;

public class testJavaBeans {
    public static void main(String[] args){
        Persona persona = new Persona();
        persona.setNombre("César");
        persona.setApellido("Lazcano");
        System.out.println(persona.toString());
    }
}
