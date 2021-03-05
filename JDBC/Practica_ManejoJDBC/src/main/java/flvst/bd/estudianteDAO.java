package flvst.bd;

import flvst.entity.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static flvst.bd.Conexion.close;

public class estudianteDAO {

    private static final String SQL_SELECTALL = "SELECT id_estudiante, nombre, apellido, promedio FROM estudiantes";
    private static final String SQL_SELECTONE = "SELECT id_estudiante, nombre, apellido, promedio FROM estudiantes WHERE id_estudiante = ?";
    private static final String SQL_SELECTPROMEDIOS = "SELECT promedio FROM estudiantes";
    private static final String SQL_INSERT = "INSERT INTO estudiantes(nombre, apellido, promedio) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE estudiantes SET nombre=?, apellido=?, promedio=? WHERE id_estudiante=?";
    private static final String SQL_DELETE = "DELETE FROM estudiantes WHERE id_estudiante=?";

    public List<Estudiante> selectAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estudiante estudiante = null;
        List<Estudiante> estudiantes = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                var id = rs.getInt("id_estudiante");
                var nombre = rs.getString("nombre");
                var apellido = rs.getString("apellido");
                double promedio = rs.getDouble("promedio");
                estudiante = new Estudiante(id, nombre, apellido, promedio);
                estudiantes.add(estudiante);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return estudiantes;
    }

    public Estudiante selectOne(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estudiante study = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTONE);
            stmt.setInt(1, estudiante.getIdEstudiante());
            rs = stmt.executeQuery();

            while (rs.next()) {
                var id = rs.getInt("id_estudiante");
                var nombre = rs.getString("nombre");
                var apellido = rs.getString("apellido");
                var promedio = rs.getDouble("promedio");
                study = new Estudiante(id, nombre, apellido, promedio);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return study;
    }

    public List<Double> selectPromedios() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Double> promedios = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTPROMEDIOS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                promedios.add(rs.getDouble("promedio"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return promedios;
    }

    public int insert(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getApellido());
            stmt.setDouble(3, estudiante.getPromedio());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int delete(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, estudiante.getIdEstudiante());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int update(Estudiante estudiante){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getApellido());
            stmt.setDouble(3, estudiante.getPromedio());
            stmt.setInt(4, estudiante.getIdEstudiante());
            registros = stmt.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        
        return registros ;
    }

}
