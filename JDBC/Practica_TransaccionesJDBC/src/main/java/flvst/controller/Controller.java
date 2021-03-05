package flvst.controller;

import flvlst.datos.Conexion;
import flvlst.datos.estudianteDAO;
import flvst.entity.Estudiante;
import java.sql.Connection;
import java.sql.SQLException;

public class Controller {
    public static void main(String[] args){
        Connection conn = null;
        
        try{
            conn = Conexion.getConnection();
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            
            estudianteDAO dao = new estudianteDAO(conn);
            dao.insert(new Estudiante("Alex", "Karev", 9.21));
            conn.commit();
            
        }catch(SQLException ex){
            System.out.println("Error en BD");
            ex.printStackTrace();
            System.out.println("Comienza rollback");
            try{
                conn.rollback();
            }catch(SQLException ex1){
                ex1.printStackTrace();
            }
        }finally{
            try{
                conn.close();
            }catch(SQLException ex2){
                ex2.printStackTrace();
            }
        }
    }
}
