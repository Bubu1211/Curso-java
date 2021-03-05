package flvts.jdbc.model;

import flvts.jdbc.datos.Conexion;
import flvts.jdbc.datos.EstudiantesDAO;
import flvts.jdbc.datos.IEstudiantesDAO;
import flvts.jdbc.domain.EstudianteDTO;
import java.sql.Connection;
import java.sql.SQLException;

public class Model {
    public static void main(String[] args) {
        Connection conn = null;
        IEstudiantesDAO dao = null;
        
        try{
            conn = Conexion.getConnection();
            
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            dao = new EstudiantesDAO(conn);
            
            dao.delete(new EstudianteDTO(9));
            dao.insert(new EstudianteDTO("Saul", "Aristeo", 6.9));
            var lista = dao.select();
            lista.forEach(e->{
                System.out.println(e.toString());
            });
            
            conn.commit();
            
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
            try{
                System.out.println("Comienza rollback");
                conn.rollback();
            }catch(SQLException ex2){
                System.out.println("Fallo en el rollback");
                ex.printStackTrace(System.out);
            }
        }finally{
            try{
                Conexion.close(conn);
            }catch(SQLException ex3){
                System.out.println("Fallo al cerrar Conexión");
                ex3.printStackTrace(System.out);
            }
        }
    }
}
