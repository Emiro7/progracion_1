package Clase7;

import java.util.Scanner;

public class Ejercicio6tablero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int suma = 0;

        System.out.println("Ingrese un numero (0 para terminar)");
        numero = sc.nextInt();

        while (numero != 0) {
            suma = suma + numero;

            System.out.println("Ingrese un numero (0 para terminar)");
            numero = sc.nextInt();
        }

        System.out.println("La suma total es " + suma);
        sc.close();
    }
}