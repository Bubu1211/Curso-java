package ejercicio;

import java.util.Scanner;

public class Ejercicio {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese un número: ");
        int numero1 = sc.nextInt();
        
        System.out.println("Ingrese otro número: ");
        int numero2 = sc.nextInt();
        
        System.out.println("El mayor número es: "+(numero1>numero2? numero1 : numero2));
    }

}
