package clase6;

import java.util.Scanner;

public class Ejercicio412 {
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
        
        if(seleccion==1){
            System.out.println("la suma "+(num1+num2));
        }else{
            if(seleccion==2){
                System.out.println("la multiplicacion" + (num1 * num2));
            } else {
                if(seleccion==3){
                    System.out.println("la division"+(num1/num2));
                }else {
                    System.out.println("opcion no valida");
                }
             }
        }
    sc.close();
    }
}
