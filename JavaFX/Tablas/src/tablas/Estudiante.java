package tablas;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    
    private int idEstudiante;
    private List primerParcial;
    private List segundoParcial;
    private List tercerParcial;
    private int asistencias;
    private double calFinal;
    
    public Estudiante(){
        primerParcial = new ArrayList<Rubro>(); 
        segundoParcial = new ArrayList<Rubro>();
        tercerParcial = new ArrayList<Rubro>();
    }

}
