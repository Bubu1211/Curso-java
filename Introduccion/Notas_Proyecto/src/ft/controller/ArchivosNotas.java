package ft.controller;

import ft.domain.Note;
import ft.model.ManageFiles;
import ft.model.excepciones.EscrituraFilesEx;
import ft.model.excepciones.LecturaFileEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//recibe una nota para realizar todas las acciones
public class ArchivosNotas {

    public static void crearNota(Note nota) {
        try {
            ManageFiles.crearArchivo(nota.getTitulo(), nota.getContenido(), nota.getNombre());
            System.out.println("Nota creada satisfactoriamente");
        } catch (EscrituraFilesEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void editarNota(Note nota) {
        try {
            ManageFiles.editarArchivo(nota.getTitulo(), nota.getContenido(), nota.getNombre());
            System.out.println("Nota editada");
        } catch (EscrituraFilesEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void eliminarNota(Note nota) {
        ManageFiles.eliminarArchivo(nota.getNombre());
        System.out.println("Nota " + nota.getNombre() + " eliminada");
    }
    

    public static List<Note> listarNotas(String ruta) {
        List<Note> notas = new ArrayList<>();
        try {
            var archivos = ManageFiles.listarArchivos(ruta);
            archivos.forEach(e -> {
                try {
                    var br = new BufferedReader(new FileReader(e));
                    var titulo = br.readLine();
                    String contenido, contenidoNota = "";
                    int i=0;
                    while(true){
                        contenido = br.readLine();
                        if(contenido != null)contenidoNota = contenidoNota + contenido+"\n";
                        i++;
                        if(i==100)break;
                    }  
                    var nombre = e.getAbsolutePath();
                    var nota = new Note(nombre.substring(0, nombre.length() - 4), titulo, contenidoNota);
                    notas.add(nota);
                    br.close();

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace(System.out);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } 
            });
        } catch (LecturaFileEx ex) {
            ex.printStackTrace(System.out);
        }
        return notas;
    }
    
}
