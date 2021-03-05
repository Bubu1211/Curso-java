
package acceso_datos;

public interface IAccesoDatos {
    /// Todas las variables deben ser: static final (constantes) y deben estar inicializadas
    int MAX_REGISTROS = 10;
    
    ///definimos los métodos que deben usar las clases que implementen la interface
    void insertar();
    
    void listar();
    
    void actualizar();
    
    void eliminar();
    
}
