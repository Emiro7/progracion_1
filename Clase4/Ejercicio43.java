package Clase4;

import java.util.Scanner;

public class Ejercicio43 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // Pedir los numeros al usuario
        System.out.println("Digite el primer numero:");
        int n1 = sc.nextInt();
        
        System.out.println("Digite el segundo numero:");
        int n2 = sc.nextInt();
        
        System.out.println("Digite el tercer numero:");
        int n3 = sc.nextInt();
        
        // Condicional
        if ((n1 > n2 && n1 < n3) || (n1 < n2 && n1 > n3)){
            System.out.println("El numero central es: " + n1);
        }else if ((n2 > n1 && n2 < n3) || (n2 < n1 && n2 > n3)){
            System.out.println("El numero central es: " + n2);
        }else if ((n3 > n1 && n3 < n2) || (n3 < n1 && n3 > n2)){
            System.out.println("El numero central es: " + n3);
        }else if (n1 == n2 && n2 == n3){
            System.out.println("Los tres numeros son iguales");
        }else{
            System.out.println("No existe un numero central unico");
        }
        
        sc.close();
    }
}
