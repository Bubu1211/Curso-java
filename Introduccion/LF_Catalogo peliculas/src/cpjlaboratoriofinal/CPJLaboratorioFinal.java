package cpjlaboratoriofinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;
import java.util.Scanner;

public class CPJLaboratorioFinal {

    static BufferedReader br;
    static int opcion;
    static String nombreArchivo;
    static CatalogoPeliculasImpl catalogoPeliculas;

    public static void main(String[] args) {
        nombreArchivo = "C:\\Users\\ASUS\\Documents\\prueba_Catálogo_Java";
        catalogoPeliculas = new CatalogoPeliculasImpl();
        br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Bienvenido al catálogo de películas");
        do {

            System.out.println("\tElige una opción: ");
            System.out.println("1.- Iniciar catálogo de películas");
            System.out.println("2.- Agregar Película");
            System.out.println("3.- Listar Películas");
            System.out.println("4.- Buscar Película");
            System.out.println("0.- Salir");
            try {
                opcion = Integer.parseInt(br.readLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nombre del catálogo");
                        nombreArchivo = nombreArchivo +"\\"+ br.readLine()+".txt";
                        System.out.println("nombreArchivo = " + nombreArchivo);
                        catalogoPeliculas.iniciarArchivo(nombreArchivo);
                        System.out.println("catalogo = " + nombreArchivo + " creado \n");
                        break;
                    case 2:
                        System.out.println("Ingrese el nombre de la pelicula que desea agregar");
                        catalogoPeliculas.agregarPelicula(br.readLine(), nombreArchivo);
                        System.out.println("Se ha ingresado correctamente la película al catálogo: "+nombreArchivo+"\n1");
                        break;
                    case 3:
                        catalogoPeliculas.listarPeliculas(nombreArchivo);
                        break;
                    case 4:
                        System.out.println("Que película desa buscar?");
                        var buscar = br.readLine();
                        catalogoPeliculas.buscarPelicula(nombreArchivo, buscar);
                        break;
                    case 0:
                        System.out.println("Gracias por usar LF Catálogo de películas :3");
                        br.close();
                        break;
                    default:
                        System.out.println("Ingrese una opción valida por favor"); 
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } while (opcion != 0);    
    }
}
