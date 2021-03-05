package pruebajdbcenjavafx.model.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pruebajdbcenjavafx.model.datos.Conexion;
import pruebajdbcenjavafx.model.datos.IEstudianteDAO;
import pruebajdbcenjavafx.model.domain.EstudianteDTO;

public class EstudianteDAO implements IEstudianteDAO{
    private static final String SELECT = "SELECT id_estudiante, nombre, apellido, promedio FROM estudiantes";
    private static final String INSERT = "INSERT INTO estudiantes(nombre, apellido, promedio) VALUES(?,?,?)";
    private static final String UPDATE = "UPDATE estudiantes SET nombre=?, apellido=?, promedio=? WHERE id_estudiante=?";
    private static final String DELETE = "DELETE FROM estudiantes WHERE id_estudiante = ?";
    private static Connection conexion;
    
    public EstudianteDAO(){}
    
    public EstudianteDAO(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public List<EstudianteDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<EstudianteDTO> estudiantes = new ArrayList<>();
        
        try{
            
            conn = this.conexion != null ? conexion : Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id_estudiante");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                double promedio = rs.getDouble("promedio");
                estudiantes.add(new EstudianteDTO(id, nombre, apellido, promedio));
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.conexion == null) Conexion.close(conn);
        }
        return estudiantes;
    }

    @Override
    public List<Double> selectPromedios() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Double> promedios = new ArrayList<>();
        
        try{
            
            conn = this.conexion != null ? conexion : Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                promedios.add(rs.getDouble("promedio"));
            }
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.conexion == null) Conexion.close(conn);
        }
        return promedios;
    }

    @Override
    public void insert(EstudianteDTO estudiante) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
            conn = this.conexion != null ? conexion : Conexion.getConnection();
            stmt =  conn.prepareStatement(INSERT);
            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getApellido());
            stmt.setDouble(3, estudiante.getPromedio());
            stmt.executeUpdate();
        }finally{
            Conexion.close(stmt);
            if(this.conexion == null) Conexion.close(conn);
        }
    }

    @Override
    public void update(EstudianteDTO estudiante) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
            conn = this.conexion != null ? conexion : Conexion.getConnection();
            stmt =  conn.prepareStatement(UPDATE);
            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getApellido());
            stmt.setDouble(3, estudiante.getPromedio());
            stmt.setInt(4, estudiante.getIdEstudiante());
            stmt.executeUpdate();
        }finally{
            Conexion.close(stmt);
            if(this.conexion == null) Conexion.close(conn);
        }
    }

    @Override
    public void delete(EstudianteDTO estudiante) throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
            conn = this.conexion != null ? conexion : Conexion.getConnection();
            stmt =  conn.prepareStatement(DELETE);
            stmt.setInt(1, estudiante.getIdEstudiante());
            stmt.executeUpdate();
        }finally{
            Conexion.close(stmt);
            if(this.conexion == null) Conexion.close(conn);
        }
    }
    
    
}
