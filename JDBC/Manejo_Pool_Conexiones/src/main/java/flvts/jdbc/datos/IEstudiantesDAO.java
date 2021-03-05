package flvts.jdbc.datos;

import flvts.jdbc.domain.EstudianteDTO;
import java.sql.SQLException;
import java.util.List;

public interface IEstudiantesDAO {
    
    public List<EstudianteDTO> select() throws SQLException; 
    public int delete(EstudianteDTO estudiante) throws SQLException;
    public int insert(EstudianteDTO estudiante) throws SQLException;
    public int update(EstudianteDTO estudiante) throws SQLException;
}
