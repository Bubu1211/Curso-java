package flvst.model.main;

import flvst.model.datos.Conexion;
import flvst.model.datos.DML;
import flvst.model.datos.EstudianteDAO;
import flvst.model.datos.IEstudianteDAO;
import flvst.model.domain.EstudianteDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnBD {

    private List<EstudianteDTO> estudiantes;
    private boolean hasError;
    private String messageException;

    public ConnBD() {
        estudiantes = getListEstudiantes();
    }

    public List<EstudianteDTO> getListEstudiantes() {
        
        Connection conn = null;
        IEstudianteDAO dao = null;
        List<EstudianteDTO> estudiantes = new ArrayList<>();
        
        try {
            conn = Conexion.getConnection();
            dao = new EstudianteDAO(conn);
            hasError = false;
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            estudiantes = dao.select();
            conn.commit();
            return estudiantes;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            }
        }
        return null;
    }

    public void solicitud(DML sentencia, EstudianteDTO estudiante) {
        
        Connection conn = null;
        IEstudianteDAO dao = null;
         estudiantes = new ArrayList<>();
        try {
            
            conn = Conexion.getConnection();
            dao = new EstudianteDAO(conn);
            estudiantes = new ArrayList<EstudianteDTO>();
            hasError = false;
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }

            switch (sentencia) {
                case INSERT:
                    dao.insert(estudiante);
                    conn.commit();
                    estudiantes = dao.select();
                    break;
                case UPDATE:
                    dao.update(estudiante);
                    conn.commit();
                    estudiantes = dao.select();
                    break;
                case DELETE:
                    dao.delete(estudiante);
                    conn.commit();
                    estudiantes = dao.select();
                   
                    break;
            }

        } catch (SQLException ex) {
            try {
                messageException = "error en solicitud a la base de datos " + ex.getMessage();
                hasError = true;
                System.out.println("Comienza rollback");
                conn.rollback();
            } catch (SQLException ex1) {
                messageException = "Error en rollback " + ex1.getMessage();
                hasError = true;
            }
        } finally {
            try {
                Conexion.close(conn);
            } catch (SQLException ex3) {
                messageException = "error en cerrar la conexion " + ex3.getMessage();
            }
        }
    }
    
    public List<EstudianteDTO> getEstudiantes(){
        return this.estudiantes;
    }

    public boolean hasError() {
        return hasError;
    }

    public String getException() {
        return this.messageException;
    }

}
