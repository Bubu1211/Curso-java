package manejoarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ManejoArchivos {

    public static void crearArchivo(String nombreArchivo) throws FileNotFoundException {
        File archivo = new File(nombreArchivo);     //se crea objeto archivo en memoria
        PrintWriter salida = new PrintWriter(archivo);  //se abre el archivo
        salida.close();     //al llamar este método se crea el archivo 
        System.out.println("Archivo \"" + nombreArchivo + " \"creado");
    }

    public static void escribirArchivo(String nombreArchivo, String contenido) throws FileNotFoundException {
        File archivo = new File(nombreArchivo);
        PrintWriter salida = new PrintWriter(archivo);

        salida.println(contenido);  //escribe un string en el archivo

        salida.close();
        System.out.println("Archivo escrito con éxito");

    }

    public static void anexarInformacion(String nombreArchivo, String nuevoContenido) throws FileNotFoundException, IOException {
        File archivo = new File(nombreArchivo);
        //FileWriter sobreescribe un archivo con información que ya contiene
        //segundo parametro indica si se añade el contenido o no
        PrintWriter salida = new PrintWriter(new FileWriter(archivo, true)); 
        salida.println(nuevoContenido);
        System.out.println("contenido añadido");
        salida.close();
    }
    
    public static void leerArchivo(String nombreArchivo) throws FileNotFoundException, IOException{
        File archivo = new File(nombreArchivo);
        BufferedReader entrada = new BufferedReader(new FileReader(archivo));   //leer cada caracter en el archivo
        var lectura = entrada.readLine(); //lee una linea (la primera)
        while(lectura != null){
            System.out.println(lectura);
            lectura = entrada.readLine(); //lee nuevas lineas 
        }
        entrada.close();
        
    }
}
