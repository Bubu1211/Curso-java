package retos;

public class Retos {

    public static void main(String[] args) {
        int value = 1;
        int tamaño = 5;
        int vueltas = 1;
        int temp = tamaño;
        
        int matriz[][] = new int[tamaño][tamaño];
        
        int fila = 0, columna = 0;

        while(value <= temp*temp){
            
            for(columna=vueltas-1; columna<tamaño; columna++){
                matriz[fila][columna] = value;
                value++;
            }
            for(fila = vueltas; fila<tamaño; fila++){
                matriz[fila][columna-1] = value;
                value++;
            }
            vueltas++;
            tamaño--;
            for(columna=columna-vueltas ;columna>=0 ; columna--){
                matriz[fila-1][columna] = value;
                value++;
            }
            for(fila=tamaño-1;fila>vueltas-2; fila--){
                matriz[fila][columna+1] = value;
                value++;
            }
        }
        
        ///mostrar la matriz
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                System.out.print(matriz[i][j]+", ");
            }
            System.out.println("");
        }
        
    }
}
