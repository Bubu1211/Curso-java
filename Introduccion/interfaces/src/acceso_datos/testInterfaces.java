
package acceso_datos;

public class testInterfaces {
    public static void main(String[] args) {
        ///no se pueden crear objetos de interfaces pero si de las clases que las implementan
        
        ///creamos un objeto de una clase que implementa IAccesoDatos
        IAccesoDatos datos = new implementacionMysql("https://flazbal");
        datos.listar();
        
        datos = new implementacionOracle();
        datos.listar();
    }
}
