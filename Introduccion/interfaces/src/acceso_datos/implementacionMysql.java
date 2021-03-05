
package acceso_datos;

public class implementacionMysql implements IAccesoDatos{
    
    public String rutaBD;
    
    public implementacionMysql(String rutaBd){
        this.rutaBD = rutaBd;
    }

    ///al implementar una interface, se deben implementar todos sus métodos abstractos
    @Override
    public void insertar() {
        System.out.println("Insertar en una tabla MySQL");
    }

    @Override
    public void listar() {
        System.out.println("Mostrar bd datos de tabla");
    }

    @Override
    public void actualizar() {
        System.out.println("actualizar dato: ");
    }

    @Override
    public void eliminar() {
        System.out.println("Seguro que quiere eliminar registro?¡");
    }
    
}
