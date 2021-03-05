package personas.test;

import java.sql.Connection;
import java.sql.SQLException;
import personas.dto.PersonaDTO;
import personas.jdbc.Conexion;
import personas.jdbc.PersonaDaoJDBC;

public class test {
    public static void main(String[] args) {
        
        Connection conexion = null; 
        try{
            conexion = Conexion.getConnection();
            
            if(conexion.getAutoCommit()) conexion.setAutoCommit(false);
            
            PersonaDaoJDBC dao = new PersonaDaoJDBC(conexion);
            
            dao.delete(new PersonaDTO(10));
            var lista = dao.select();
            lista.forEach(e->{
                System.out.println(e.toString());
            });
            
            conexion.commit();
            
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
            System.out.println("Comienza rollback");
            try{
                conexion.rollback();
            }catch(SQLException ex1){
                ex1.printStackTrace(System.out);
            }
        }finally{
            try{
                conexion.close();
            }catch(SQLException ex2){
                ex2.printStackTrace(System.out);
            }
        }
    }
}
