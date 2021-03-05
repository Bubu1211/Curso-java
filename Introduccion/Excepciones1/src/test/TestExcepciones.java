
package test;

import static aritmetica.Aritmetica.division;   ///accede a un método static 

public class TestExcepciones {
    public static void main(String[] args){
        int resultado = 0;
        try{
            resultado = division(10, 0);
        }catch(Exception e){
            e.printStackTrace(System.out);
            e.getMessage(); ///obtiene el mensaje propagado en nuestra clase operaciExcepcion
        }finally{
            System.out.println("Se revisó la división");
        }
        System.out.println("resultado: "+resultado); ///imprime 0 ya que 10/0 causa excepción
    }
}
