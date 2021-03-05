package pruebajdbcenjavafx;

import java.util.List;
import pruebajdbcenjavafx.model.datos.DML;
import pruebajdbcenjavafx.model.domain.EstudianteDTO;
import pruebajdbcenjavafx.model.main.ConnBD;

public class PruebaJDBCenJavafX {

    public static void main(String[] args) {
        ConnBD bd = new ConnBD();
        List<EstudianteDTO> li = bd.getEstudiantes();
        li.forEach(e->{
            System.out.println(e.toString());
        });
        bd.solicitud(DML.UPDATE, new EstudianteDTO(16, "Suemmy", "Rodriguez", 9.37));
        List<EstudianteDTO> l1 = bd.getEstudiantes();
        l1.forEach(E->{
                        System.out.println("E = " + E.toString());
                    });
    }
}
