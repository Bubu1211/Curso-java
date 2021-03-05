package flvlst.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    private static final String BD_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String BD_USER = "root";
    private static final String BD_PASS = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(BD_URL, BD_USER, BD_PASS);
    }

    public static void close(PreparedStatement stmt) throws SQLException {
        stmt.close();
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}
