
package aritmetica;

import excepcion.operacioExcepcion;

public class Aritmetica {
    public static int division(int numerador, int denominador) throws operacioExcepcion{
        if(denominador == 0){
            new operacioExcepcion("Divsion entre 0");
        }else{
            return numerador/denominador; 
        }
        return 0;
    }
}
