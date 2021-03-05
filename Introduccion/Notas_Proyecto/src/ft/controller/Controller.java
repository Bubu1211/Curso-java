package ft.controller;

import ft.domain.Note;
import ft.domain.ThemeColor;
import ft.model.ManageFiles;
import ft.model.excepciones.EscrituraFilesEx;
import ft.model.excepciones.LecturaFileEx;
import java.awt.Color;
import java.util.List;

//agrega la ruta y el .txt al nombre de la nota
public class Controller {

    public static String rutaDefault = "archivos";
    public static String rutaArchivoConfiguraciones = "config\\configuracion.txt";
    public static String rutaParaUsar;
    public static ThemeColor colorDefault = new ThemeColor(new Color(255,255,255), new Color(0,0,255));
    public static ThemeColor colorParaUsar;
    
    public static String nombreNotas = "Nota";

    public Controller() {
        obtenerConfiguracion();
    }

    /*
    obtiene la configuracion de la aplicación del archivo "configuracion.txt"
     */
    private void obtenerConfiguracion() {
        try {
            //obtiene el contenido del archivo de configuraciones
            String lecturaConfiguracion = ManageFiles.leerUnArchivo(rutaArchivoConfiguraciones);

            //obtiene de la primera línea a apartir del espacio, un String en el archivo
            int indicePrimeraLinea = lecturaConfiguracion.indexOf("\n");
            //guarda la configuracion en esta aplicación
            rutaParaUsar = lecturaConfiguracion.substring(lecturaConfiguracion.indexOf(": ") + 2, indicePrimeraLinea);

            //obtener colo de fondo y de la barra
            //obtiene una cadena con los valores rgb correspondientes al color de fondo
            int indiceLineaColorFondo = lecturaConfiguracion.indexOf("\n", indicePrimeraLinea + 3);
            String valoresColorFondo = lecturaConfiguracion.substring(lecturaConfiguracion.indexOf(": ", indicePrimeraLinea) + 2, indiceLineaColorFondo);

            //obtiene una cadena con los valores rgb del color de la barra
            int indiceLineaColorBarra = lecturaConfiguracion.indexOf("\n", indiceLineaColorFondo + 3);
            String valoresColorBarra = lecturaConfiguracion.substring(lecturaConfiguracion.indexOf(": ", indiceLineaColorFondo) + 2, indiceLineaColorBarra);
            //crea y asignqa el color para usar en la app segun la configuracion
            colorParaUsar = new ThemeColor(colorByString(valoresColorFondo), colorByString(valoresColorBarra));

        } catch (LecturaFileEx ex) {
            ex.printStackTrace();
        }
    }

    /*
    retorna un Color segun los valores almancenados en la cadena
     */
    private Color colorByString(String cadena) {
        int values[] = new int[3];

        int cont = 0, contadorArray = 0;
        String conversion = "";
        do {
            try {

                String str = cadena.charAt(cont) + "";
                int temp = Integer.parseInt(str);
                conversion = conversion + str;
            } catch (NumberFormatException ex) {
                values[contadorArray] = Integer.parseInt(conversion);
                contadorArray++;
                conversion = "";
            }
            cont++;
        } while (cont < cadena.length());

        return new Color(values[0], values[1], values[2]);
    }

    /*
    guarda la configuracion dada por el usuario en el archivo
    */
    public void guardarConfiguracion(ThemeColor color, String rutaNueva, boolean cambio) {
        String contenidoConfiguracion = "rutaNotas: "+ManageFiles.stringConRuta(rutaNueva)+color.toString();
        try {
            ManageFiles.crearUnArchivo(rutaArchivoConfiguraciones, contenidoConfiguracion);
            if(cambio) ManageFiles.cambiarRuta(this.rutaParaUsar, rutaNueva); 
            System.out.println(rutaParaUsar);
            obtenerConfiguracion(); 
        } catch (EscrituraFilesEx ex) {
            ex.printStackTrace();
        }
    }
    
    public void restaurarConfiguración(){
        guardarConfiguracion(Controller.colorDefault, Controller.rutaDefault,true);
    }
    
    /*
    crea una nota
    */
    public void crearNota(Note nota){
        ArchivosNotas.crearNota(nota);
    }

    /*
    Regresa una lista de notas 
    */
    public List<Note> crearListaNotas() {
        return ArchivosNotas.listarNotas(rutaParaUsar);
    }
    
    /*
    elimina una nota
    */
    public void eliminarNota(Note nota){
        ArchivosNotas.eliminarNota(nota);
    }
    
    /*
    edita una nota
    */
    public void editarNota(Note nota){
        ArchivosNotas.editarNota(nota);
    }
}
