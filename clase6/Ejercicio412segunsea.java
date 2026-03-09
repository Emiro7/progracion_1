package clase6;

import java.util.Scanner;

public class Ejercicio412segunsea{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num1,num2;
        int seleccion;
       System.out.println("digete numero 1");
        num1 = sc.nextDouble();
        System.out.println("Digite numero 2");
        num2 = sc.nextDouble();
        System.out.println("digite la seleccion 1,2,3");
        seleccion = sc.nextInt();
        
        switch (seleccion) {
            case 1:
                System.out.println("la suma es: " + (num1 + num2));
                
                break;
         case 2:
                System.out.println("la multiplicacion es: " + (num1 * num2));
                 break;
         case 3:
                System.out.println("la division es: " + (num1 / num2));
                 break;
            default:
                System.out.println("opcion no valida");
                break;
        }

      sc.close();
    }
}