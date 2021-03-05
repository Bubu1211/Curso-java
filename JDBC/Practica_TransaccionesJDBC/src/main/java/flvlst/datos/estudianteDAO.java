package flvlst.datos;

import flvst.entity.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class estudianteDAO {
    
    private Connection conexionTransaccional; 
    
    private static final String SQL_SELECT = "SELECT id_estudiante, nombre, apellido, promedio FROM estudiantes";
    private static final String SQL_INSERT = "INSERT INTO estudiantes( nombre, apellido, promedio) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE estudiantes SET nombre=?, apellido=?, promedio=? WHERE id_estudiante=?";
    private static final String SQL_DELETE = "DELETE FROM estudiantes WHERE id_estudiante=?";
    
    public estudianteDAO(){}
    
    public estudianteDAO(Connection conexionTransaccional){
        this.conexionTransaccional = conexionTransaccional;
    }
    
    public List<Estudiante> select() throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Estudiante> estudiantes = new ArrayList<>();
        
        try {
            conn = (this.conexionTransaccional != null)? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery(); 
            
            while(rs.next()){
                var id = rs.getInt("id_estudiante");
                var nombre = rs.getString("nombre");
                var apellido = rs.getString("apellido"); 
                var promedio = rs.getDouble("promedio");
                
                var estudiante = new Estudiante(id, nombre, apellido, promedio);
                estudiantes.add(estudiante);
                
            }
            
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.conexionTransaccional == null){
                Conexion.close(conn);
            }
        }
        
        return estudiantes;
    }
    
    public int insert(Estudiante e) throws SQLException{
        Connection conn = this.conexionTransaccional == null? Conexion.getConnection() : this.conexionTransaccional;
        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
        
        stmt.setString(1,e.getNombre());
        stmt.setString(2, e.getApellido());
        stmt.setDouble(3, e.getPromedio());
        
        int registros = stmt.executeUpdate();
        
        Conexion.close(stmt);
        if(conexionTransaccional == null){
            Conexion.close(conn);
        }
        return registros;
    }
    
    public int update(Estudiante e) throws SQLException{
        Connection conn = this.conexionTransaccional == null? Conexion.getConnection() : this.conexionTransaccional;
        PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
        
        stmt.setString(1,e.getNombre());
        stmt.setString(2,e.getApellido());
        stmt.setDouble(3, e.getPromedio());
        stmt.setInt(4, e.getIdEstudiante());
        
        int registros = stmt.executeUpdate();
        
        Conexion.close(stmt);
        if(this.conexionTransaccional == null){
            Conexion.close(conn);
        }
        
        return registros;
    }
    
    public int delete(Estudiante e) throws SQLException{
        Connection conn = this.conexionTransaccional == null? Conexion.getConnection() : this.conexionTransaccional;
        PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);
        
        stmt.setInt(1, e.getIdEstudiante());
        
        int registros = stmt.executeUpdate();
        
        Conexion.close(stmt);
        if(this.conexionTransaccional == null){
            Conexion.close(conn);
        }
        
        return registros;
    }
    
}
