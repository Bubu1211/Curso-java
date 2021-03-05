package mx.com.gm.peliculas.negocio;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas{

    AccesoDatos datos = new AccesoDatos();
    
    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        try {
            datos.escribir(pelicula, nombreArchivo, true);
        } catch (EscrituraDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        try { 
            List <Pelicula>peliculas = datos.listar(nombreArchivo);
            peliculas.forEach(e->{
                System.out.println("Pelicula: "+e.getNombre());
            });
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        System.out.println("Buscando...");
        try {
            System.out.println(datos.buscar(nombreArchivo, buscar));
        } catch (LecturaDatosEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            datos.crear(nombreArchivo);
        } catch (EscrituraDatosEx ex) {
            ex.printStackTrace();
        }
    }
    
}
