package Clase5parcial;

import java.util.Scanner;

public class Parcial1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int clave = 1234;
        int saldoInical = 800000;
        int claveUsuario,retiro,nuevoSaldo;
        

    System.out.println("leer claveUsuario");

     if (clave == claveUsuario); {
    System.out.println("bienvenido al cajero de uniajc");
    System.out.println("digite la cangtida a retirar");
     retiro = sc.nextInt();
     }
     if (retiro > 200000); {
     retiro = retiro + 2000;
     }
     
     if (retiro <= saldoInical); {
        nuevoSaldo = saldoInical - retiro;
        System.out.println("su saldo actual es nuevo saldo");
     }else{
        System.out.println("el valor solicitado + el costo de la transaccion es mayor al saldo");
     }else{
        System.out.println("su clave no es correta... intenta nuevamente");
     }
     sc.close();
    }
}
