package flvst.controller;

import flvst.model.domain.EstudianteDTO;
import java.util.List;

public class Calculo {

    private static double promedioMenor, promedioMayor;
    private static double temp;

    public static double getPromedioMenor(List<EstudianteDTO> estudiantes) {

        promedioMenor = estudiantes.get(0).getPromedio();
        estudiantes.forEach(e -> {
            temp = e.getPromedio();
            if (temp < promedioMenor) {
                promedioMenor = temp;
            }
        });
        return promedioMenor;
    }
    
    public static double getPromedioMayor(List<EstudianteDTO> estudiantes) {

        promedioMayor = estudiantes.get(0).getPromedio();
        estudiantes.forEach(e -> {
            temp = e.getPromedio();
            if (temp > promedioMayor) {
                promedioMayor = temp;
            }
        });
        return promedioMayor;
    }
}
