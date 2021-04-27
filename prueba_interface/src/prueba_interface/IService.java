package prueba_interface;

import java.util.List;
import prueba_interface.domain.ObjetoDominio;

public interface IService {
    public List<ObjetoDominio> listar();
    public void mostrarDatos(ObjetoDominio o);
}
