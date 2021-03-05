package flvts.jdbc.datos;

import flvts.jdbc.domain.EstudianteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudiantesDAO implements IEstudiantesDAO {

    private static final String SELECT = "SELECT *FROM estudiantes";
    private static final String INSERT = "INSERT INTO estudiantes(nombre, apellido, promedio) VALUES(?,?,?)";
    private static final String UPDATE = "UPDATE estudiantes SET nombre=?, apellido=?, promedio=? WHERE id_estudiante=?";
    private static final String DELETE = "DELETE FROM estudiantes WHERE id_estudiante = ?";
    private Connection conexion;

    public EstudiantesDAO() {
    }

    public EstudiantesDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<EstudianteDTO> select() throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<EstudianteDTO> estudiantes = new ArrayList<>();

        try {
            conn = this.conexion != null ? conexion : Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                var id = rs.getInt("id_estudiante");
                var nombre = rs.getString("nombre");
                var apellido = rs.getString("apellido");
                var promedio = rs.getDouble("promedio");

                estudiantes.add(new EstudianteDTO(id, nombre, apellido, promedio));
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexion == null) Conexion.close(conn);
            
        }
        return estudiantes;
    }

    @Override
    public int delete(EstudianteDTO estudiante) throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {

            conn = this.conexion != null ? conexion : Conexion.getConnection();
            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, estudiante.getIdEstudiante());
            registros = stmt.executeUpdate();
        } finally {

            Conexion.close(stmt);
            if (this.conexion == null) Conexion.close(conn);
            
        }
        return registros;
    }

    @Override
    public int insert(EstudianteDTO estudiante) throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try{
            
            conn = this.conexion != null ? conexion : Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getApellido());
            stmt.setDouble(3, estudiante.getPromedio());
            registros = stmt.executeUpdate();
        }finally{
            Conexion.close(stmt);
            if(conexion == null) Conexion.close(conn);
        }
        return registros;
    }

    @Override
    public int update(EstudianteDTO estudiante) throws SQLException {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try{
            
            conn = this.conexion != null? conexion : Conexion.getConnection();
            stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getApellido());
            stmt.setDouble(3, estudiante.getPromedio());
            stmt.setInt(4, estudiante.getIdEstudiante());
            registros = stmt.executeUpdate();
        }finally{
            Conexion.close(stmt);
            if(this.conexion == null) Conexion.close(conn);
        }
        return registros;
    }

}
