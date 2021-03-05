package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class testMySqlJDBC {
    public static void main(String[] args) {
        try {
            //cadena de conexion de MySql 8 diferente para cada BD
            //ip de direccion:puerto/nombreBD
            //useSSL : uso de conexión segura, useTimezone: uso de zona horaria serverTimezone: zona horaria a utilizar
            //allowPublicKeyRetrieval: permite una conexíon
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            
            //paso no requerido pero común en WEB
            //indica que clae usamos para conectarnos a la BD
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //objeto conexion, conecta con la Base de datos
            //url: cadena de conexión, usuario, contraseña
            Connection conexion = DriverManager.getConnection(url, "root", "admin");
            
            //objeto statement crea una sentencia DML para sql
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            
            //obtiene un objeto ResultSet que contiene los registros y/o resultados de la sentencia sql
            ResultSet resultado = instruccion.executeQuery(sql);
            
            while(resultado.next()){
                //lee el valor del primer registro en la columna con el nombre especificado
                System.out.print("Id persona: "+resultado.getInt("id_persona"));
                System.out.print(" nombre: "+resultado.getString("nombre"));
                System.out.print(" apellido: "+resultado.getString("apellido"));
                System.out.print(" email: "+resultado.getString("email"));
                System.out.println(" telefono: "+resultado.getString("telefono"));
            }
            //cerramos los objetos
            resultado.close();
            instruccion.close();
            conexion.close(); 
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}
