package test_dos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PracticaDosJDBCintroduccion {
    public static void main(String[] args) {
        try {
            
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,"root","admin");
            Statement instruccion = conexion.createStatement();
            String query = "SELECT * FROM persona WHERE id_persona=2";
            ResultSet resultado = instruccion.executeQuery(query);
            
            while(resultado.next()){
                System.out.println("id: "+resultado.getString("nombre"));
            }
            
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
