package Clase4;

import java.util.Scanner;

public class Ejercicio47 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // Pedir cantidad de alumnos
        System.out.println("Digite la cantidad de alumnos:");
        int n = sc.nextInt();
        
        int menores40 = 0;
        int entre40y50 = 0;
        int entre50y60 = 0;
        int mayorIgual60 = 0;
        
        // Ciclo para leer pesos
        for (int i = 1; i <= n; i++){
            System.out.println("Digite el peso del alumno " + i + ":");
            double peso = sc.nextDouble();
            
            if (peso < 40){
                menores40++;
            }else if (peso >= 40 && peso <= 50){
                entre40y50++;
            }else if (peso > 50 && peso < 60){
                entre50y60++;
            }else{
                mayorIgual60++;
            }
        }
        
        // Mostrar resultados
        System.out.println("Alumnos de menos de 40 kg: " + menores40);
        System.out.println("Alumnos entre 40 y 50 kg: " + entre40y50);
        System.out.println("Alumnos de más de 50 kg y menos de 60 kg: " + entre50y60);
        System.out.println("Alumnos de más o igual a 60 kg: " + mayorIgual60);
        
        sc.close();
    }
}
