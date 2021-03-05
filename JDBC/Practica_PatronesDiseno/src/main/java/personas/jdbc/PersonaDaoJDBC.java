package personas.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import personas.dto.PersonaDTO;

public class PersonaDaoJDBC implements PersonaDao{
    
    private String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?)";
    private String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    private String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
    private String SQL_SELECT = "SELECT * FROM persona";
    private Connection userConn;
    
    public PersonaDaoJDBC(){}
    
    public PersonaDaoJDBC(Connection userConn){
        this.userConn = userConn;
    }
    
    @Override
    public int insert(PersonaDTO persona) throws SQLException {
        Connection conn = this.userConn != null? userConn : Conexion.getConnection(); 
        PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
        
        stmt.setString(1, persona.getNombre());
        stmt.setString(2, persona.getApellido());
        stmt.setString(3, persona.getEmail());
        stmt.setString(4, persona.getTelefono());
        
        int registros = stmt.executeUpdate();
        
        Conexion.close(stmt);
        if(this.userConn == null) Conexion.close(conn);
        
        return registros;
    }

    @Override
    public int update(PersonaDTO persona) throws SQLException {
        Connection conn = this.userConn != null? userConn : Conexion.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE); 
        
        stmt.setString(1, persona.getNombre());
        stmt.setString(2, persona.getApellido());
        stmt.setString(3, persona.getEmail());
        stmt.setString(4, persona.getTelefono());
        stmt.setInt(5, persona.getId_persona());
        
        int registros = stmt.executeUpdate();
        
        Conexion.close(stmt);
        if(this.userConn == null) Conexion.close(conn);
        
        return registros;
    }

    @Override
    public int delete(PersonaDTO persona) throws SQLException {
        Connection conn = this.userConn != null? userConn : Conexion.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);
        
        stmt.setInt(1, persona.getId_persona());
        
        int registros = stmt.executeUpdate();
        
        Conexion.close(stmt);
        if(userConn == null) Conexion.close(conn);
        
        return registros;
    }

    @Override
    public List<PersonaDTO> select() throws SQLException {
        Connection conn = this.userConn != null? userConn : Conexion.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
        ResultSet rs = stmt.executeQuery();
        List<PersonaDTO> personas = new ArrayList<>();
        
        while(rs.next()){
            var id_persona = rs.getInt("id_persona");
            var nombre = rs.getString("nombre");
            var apellido = rs.getString("apellido");
            var email = rs.getString("email");
            var telefono = rs.getString("telefono");
            
            var persona = new PersonaDTO(id_persona, nombre, apellido, email, telefono);
            personas.add(persona);
        }
        
        Conexion.close(rs);
        Conexion.close(stmt);
        if(this.userConn==null) Conexion.close(conn);
        
        return personas;
    }
    
}
