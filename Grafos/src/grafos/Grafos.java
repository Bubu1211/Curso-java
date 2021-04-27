package grafos;

import java.util.ArrayList;
import java.util.List;

public class Grafos {

    public static void main(String[] args) {
            
        int V = 5;
        List adj = new ArrayList<ArrayList<Integer>>(V);
        
        for(int i = 0; i<V; i++)
            adj.add(new ArrayList<Integer>());
        
        //Añadiendo aristas
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
         
        printGraph(adj);
    }
    public static void addEdge(List<List<Integer>> adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    
    public static void printGraph(List<List<Integer>> adj){
        for(int v = 0; v < adj.size(); v++){
            System.out.println(v+ " = ");
            adj.get(v).forEach(x->{
                System.out.print( x+ "->");
            });
        }
    }
}