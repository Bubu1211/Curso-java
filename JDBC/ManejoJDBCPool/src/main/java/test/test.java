package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class test {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        
        var p = new Persona("alejandro", "Vazquez", "alamilla.com","2929292");
        //personaDao.insertar(p);
        
        personaDao.eliminar(6);
        personaDao.eliminar(7);
        personaDao.eliminar(8);
        
        List<Persona> personas = personaDao.seleccionar();
        personas.forEach(e->{
            System.out.println(e.toString());
        });
    }
}
