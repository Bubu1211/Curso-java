package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class AccesoDatos implements IAccesoDatos {

    public static void escribir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    PrintWriter pw;

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        var file = new File(nombreArchivo);
        return file.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
        var file = new File(nombre);
        List<Pelicula> listaPeliculas = new ArrayList<>();
        try {
            var br = new BufferedReader(new FileReader(file));
            var in = br.readLine();
            while (in != null) {
                var pelicula = new Pelicula(in);
                listaPeliculas.add(pelicula);
                in = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al listar peliculas");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Erro al listar peliculas");
        }
        return listaPeliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        var file = new File(nombreArchivo);
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file, anexar));
            pw.println(pelicula.getNombre());
            pw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Error al escribir en el archivo");
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        var file = new File(nombreArchivo);
        try {
            var br = new BufferedReader(new FileReader(file));
            var in = br.readLine();
            int numLine = 1;
            while (in != null) {
                if (in.equals(buscar) && buscar != null) {
                    return "Pelicula en catálogo \n posición: " + numLine;
                }
                numLine++;
                in = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al buscar una película");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Error al buscar una película");
        }
        return "no encontrado";
    }

    @Override
    public void crear(String nombreArchivo) throws EscrituraDatosEx {
        try {
            var file = new File(nombreArchivo);
            var pw = new PrintWriter(file);
            pw.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEx("Error al crear catálogo");
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosEx("Error al crear catálogo");
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        var file = new File(nombreArchivo);
        if (file.exists()) {
            file.delete();
            System.out.println("catálogo eliminado");

        }
    }
}
