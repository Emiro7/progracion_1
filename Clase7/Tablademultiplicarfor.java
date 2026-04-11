package Clase7;

import java.util.Scanner;

public class Tablademultiplicarfor {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Digite el numero de la tabla");
      int n = sc.nextInt();
      for(int i= 1; i <= 10; i++){
        System.out.println(n + "x" + i +" =" + (n*i));
      }  
      sc.close();

    }
}
