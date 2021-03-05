
package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import static manejoarchivos.ManejoArchivos.crearArchivo;
import static manejoarchivos.ManejoArchivos.escribirArchivo;
import static manejoarchivos.ManejoArchivos.anexarInformacion;
import static manejoarchivos.ManejoArchivos.leerArchivo;

public class TestManejoArchivos {
    public static void main(String[] args){
        var nombreArchivo = "prueba.txt";
        try {
            crearArchivo(nombreArchivo);
            escribirArchivo(nombreArchivo, "Hola desde Java \n Estoy aprendiendo xd");
            anexarInformacion(nombreArchivo, "I love program");
            leerArchivo(nombreArchivo);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }catch(IOException ex){
            ex.printStackTrace(System.out);
        }
    }
}
