package Clase7;

import java.util.Scanner;

public class Ejercio54libro {
        public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            int numero;
            int suma =0;
            int contador =0;
            double media;

            System.out.println("ingrese un numero");
            numero = sc.nextInt();

            while(numero>0){
                suma = suma + numero;
                contador++;

                System.out.println("ingrese otro numero");
                numero = sc.nextInt();
            }

            media = (double)suma/contador;

            System.out.println("la media es: " + media);
            sc.close();
        }
    }
    