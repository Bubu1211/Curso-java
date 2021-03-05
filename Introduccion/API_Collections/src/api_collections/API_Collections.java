
package api_collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class API_Collections {

    public static void main(String[] args) {
        List<String> miList = new ArrayList<>();  //List tipo ArrayList
        miList.add("Lunes");            //se pueden repetir elementos
        miList.add("Martes");
        miList.add("Miércoles");
        miList.add("Jueves");
        miList.add("Viernes");
        
        miList.forEach(e -> {
            // for-each para iterar en un array o list
            System.out.println("Elemento = " + e);
        });
        
        miList.forEach(elemento->{      //función de flecha o lambda
            System.out.println("Elemento desde flecha= "+elemento);
        });
        
        //set : no garantiza un orden
        Set miSet = new HashSet();
        miSet.add("Lunes");         //no se pueden repetir elementos
        miSet.add("Martes");
        miSet.add("Miércoles");
        miSet.add("Jueves"); 
        miSet.add("Viernes");
        miSet.add("Viernes"); //el elemento repetido es rechazado
        imprimirCollection(miSet);
        
        Map<String, Integer> miMap = new HashMap<>(); //Tipo Map: clave, valor
        miMap.put("Valor1", 10);
        miMap.put("Valor2", 4);
        miMap.put("Valor2", 8); //no acepta valores duplicados, ahora el value de la key "valor2" es 8
        
        int clave = miMap.get("Valor1");   //retorna el valor que contiene la clave dada
        System.out.println("clave = " + clave);
        
        imprimirCollection(miMap.keySet());     //KeySet: retorna un Set con las claves del HashMap
        imprimirCollection(miMap.values());     //values: retorna un 
        imprimirGeneric(miList);
    }
    
    //método que usa Polimorfismo para imprimir los elementos de cualquier Collection
    public static void imprimirCollection(Collection coleccion){
        coleccion.forEach(elemento->{
            System.out.println("elemento: "+elemento);
        });
    }
    
    public static void imprimirGeneric(Collection<String> coleccion){   ///solo recibira colecciones con el tipo String
        ///permite usar métodos al ser más especificos
        coleccion.forEach(e->{
            System.out.println(e.charAt(0));
        });
    }
    
}
