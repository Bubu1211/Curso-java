package flvst.model.datos;

import flvst.model.domain.EstudianteDTO;
import java.sql.SQLException;
import java.util.List;

public interface IEstudianteDAO {
    
    public List<EstudianteDTO> select()throws SQLException ;
    public List<Double> selectPromedios() throws SQLException;
    public void insert(EstudianteDTO estudiante) throws SQLException;
    public void update(EstudianteDTO estudiante) throws SQLException; 
    public void delete(EstudianteDTO estudiante) throws SQLException;
}
