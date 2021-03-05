package api_collections;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class collections {

    public static void main(String[] args) {
        List miList = new ArrayList();       ///ordenado
        Set miSet = new HashSet();         ///Desordenado
        Map miMap = new HashMap();          ///Clave-valor

        miList.add("Usuario1");
        miList.add("Usuario2");
        
        miList.forEach(e->{
            System.out.println("ArrayList = " + e);
        });
        
        miSet.add(1);
        miSet.add(2);
        miSet.add(3);
        
        miSet.forEach(e->{
            System.out.println("miSet = " + e);
        });
        
        miMap.put("usuario-@c", 120);
        miMap.put("usuario-@123", 2390);
        miMap.put("Usuario-k", 10);
        
        Set claves = miMap.keySet();
        int[] valores = new int[miMap.size()];
        int cont = 0;
        claves.forEach(e->{
            valores[cont] = (int) miMap.get(e);
        });
        
    }

}
