package Clase4;

import java.util.Scanner;

public class Ejercicio41b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Pedir el angulo por parte del usuario
        System.out.println("Digite el angulo:");
        int angulo = sc.nextInt();
        // Condicional
        if (angulo == 90) {
            System.out.println("El angulo es un angulo recto");
        } else {
            System.out.println("El angulo no es un angulo recto");
        }
        sc.close();
    }
}
