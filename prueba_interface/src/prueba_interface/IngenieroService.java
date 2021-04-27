package prueba_interface;

import java.util.ArrayList;
import java.util.List;
import prueba_interface.domain.Ingeniero;
import prueba_interface.domain.ObjetoDominio;

public class IngenieroService implements IService{

    @Override
    public List<ObjetoDominio> listar() {
        
        return new ArrayList<ObjetoDominio>();
    }

    @Override
    public void mostrarDatos(ObjetoDominio o) {
        var i = (Ingeniero) o;
        System.out.println("ejecutnado: "+i.getMatricula());
    }
    
}
