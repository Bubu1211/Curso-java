
package acceso_datos;

public class implementacionOracle implements IAccesoDatos{

    @Override
    public void insertar() {
        System.out.println("Insertar datos en una tabla de Oracle");
    }

    @Override
    public void listar() {
        System.out.println("listar datos de oracle ");
    }

    @Override
    public void actualizar() {
        System.out.println("actulizar datos en oracle");
    }

    @Override
    public void eliminar() {
        System.out.println("eliminar datos de BD oracle");
    }
    
}
