package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test {
    public static void main(String[] args) {
       
       //genera la conexión externa para nuestra clase DAO y la 
       Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){  // pone en false el autocommit, para manejar el commit a nuestra conveniencia
                conexion.setAutoCommit(false);
            }
            PersonaDAO dao = new PersonaDAO(conexion); //enviamos la conexion externa  a la case DAO
            
            //dos sentencias que conforman una TRANSACCIÓN
            dao.actualizar(new Persona(5, "Suemmy Leilani" ,"Ruiz Rodríguez", "ru379447@uaeh.edu.mx","55 2040 0725"));
            dao.insertar(new Persona("Katherine", "Romero", "kat@uaeh","55 658838338"));
            
            conexion.commit(); //realiza commit: enviar la transaccion a la base de datos
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
           try {
               conexion.rollback();     //comete el rollback, es decir si hay error, no hay cambios en la BD
           } catch (SQLException ex1) {
               ex1.printStackTrace(System.out);
           }
        }finally{
            try{
            conexion.close();
            }catch(SQLException ex1){
                ex1.printStackTrace(System.out);
            }
        }
    }
}
