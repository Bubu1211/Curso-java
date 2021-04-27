package prueba_interface;

import java.util.ArrayList;
import java.util.List;
import prueba_interface.domain.ObjetoDominio;
import prueba_interface.domain.Usuario;

public class UsuarioService implements IService{

    @Override
    public List<ObjetoDominio> listar() {
        return new ArrayList<ObjetoDominio>();
    }

    @Override
    public void mostrarDatos(ObjetoDominio o) {
        var u = (Usuario)o;
        System.out.println(u.getNombre());
    }
    
}
