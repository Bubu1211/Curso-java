package ft.model;

import ft.model.excepciones.EscrituraFilesEx;
import ft.model.excepciones.LecturaFileEx;
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

//la clase solo recibe la ruta donde estará el archivo junto con su nombre, la clase agrega ".txt"
public class ManageFiles {

    /*
    crea un archivo nuevo 
     */
    public static void crearArchivo(String titulo, String contenido, String ruta) throws EscrituraFilesEx {
        File file = new File(ruta + ".txt");

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            pw.println(titulo);
            pw.println(contenido);
            pw.close();
        } catch (IOException ex) {
            throw new EscrituraFilesEx("error al crear la nota");
        }
    }

    /*
    edita un archivo ya existente 
     */
    public static void editarArchivo(String titulo, String contenido, String ruta) throws EscrituraFilesEx {
        File file = new File(ruta + ".txt");

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file, false));
            pw.println(titulo);
            pw.println(contenido);
            pw.close();
        } catch (IOException ex) {
            throw new EscrituraFilesEx("error al crear la nota");
        }
    }

    /*
    elimina el archivo con la ruta y nombre enviado
     */
    public static void eliminarArchivo(String ruta) {
        File file = new File(ruta + ".txt");
        file.delete();
    }

    /*
    Lista todos los archivos que esten en un directorio especificado
     */
    public static List<File> listarArchivos(String ruta) throws LecturaFileEx {
        File file = new File(ruta);
        List<File> archivosSalida = new ArrayList<>();
        if (file.isFile()) {
            throw new LecturaFileEx("error al listar, se envio un archivo no un folder");
        } else {
            for (File s : file.listFiles()) {
                archivosSalida.add(s);
            }
            return archivosSalida;
        }
    }

    //crea y escribe un único archivo con nombre y contenido
    public static void crearUnArchivo(String nombre, String contenido) throws EscrituraFilesEx {
        File file = new File(nombre);
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file));
            pw.println(contenido);
            pw.close();
        } catch (IOException ex) {
            throw new EscrituraFilesEx("error al crear la nota");
        }
    }

    /*
    lee un solo archivo
     */
    public static String leerUnArchivo(String nombre) throws LecturaFileEx {
        File file = new File(nombre);
        String out = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String read = "";
            while ((read = br.readLine()) != null) {
                out = out + read + "\n";
            }

        } catch (FileNotFoundException ex) {
            throw new LecturaFileEx("error al leer unico archivo");
        } catch (IOException ex) {
            throw new LecturaFileEx("error al leer unico archivo");
        }
        return out;
    }

    public static void cambiarRuta(String rutaAnterior, String rutaNueva) throws EscrituraFilesEx {
        try {
            var archivos = listarArchivos(rutaAnterior);
            archivos.forEach(e -> {
                File file = new File(rutaNueva + "\\" + e.getName());
                try {
                    BufferedReader br = new BufferedReader(new FileReader(e));
                    PrintWriter pw = new PrintWriter(new FileWriter(file));
                    String read = "";
                    int i = 0;
                    while (true) {
                        read = br.readLine();
                        if (read != null) {
                            pw.println(read);
                        }
                        i++;
                        if (i == 100) {
                            break;
                        }
                    }
                    pw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        } catch (LecturaFileEx ex) {
            ex.printStackTrace();
        }
    }

    /*
    método que recibe una cadena con una ruta y le añade las barras de escape
     */
    public static String stringConRuta(String ruta) {
        String out = "";
        for (char c : ruta.toCharArray()) {
            if (c == '\\') {
                out = out + c + "\\";
            } else {
                out = out + c;
            }
        }
        return out;
    }

}
