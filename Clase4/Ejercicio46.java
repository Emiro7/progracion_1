package Clase4;

import java.util.Scanner;

public class Ejercicio46 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // Pedir la fecha
        System.out.println("Digite el dia:");
        int dia = sc.nextInt();
        
        System.out.println("Digite el mes:");
        int mes = sc.nextInt();
        
        System.out.println("Digite el anio:");
        int año = sc.nextInt();
        
        boolean bisiesto;
        
        // Verificar si es año bisiesto
        if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)){
            bisiesto = true;
        }else{
            bisiesto = false;
        }
        
        int diasMes = 0;
        
        // Determinar dias del mes
        switch (mes){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                diasMes = 31;
                break;
            case 4: case 6: case 9: case 11:
                diasMes = 30;
                break;
            case 2:
                if (bisiesto){
                    diasMes = 29;
                }else{
                    diasMes = 28;
                }
                break;
        }
        
        // Calcular dia siguiente
        dia = dia + 1;
        
        if (dia > diasMes){
            dia = 1;
            mes = mes + 1;
            
            if (mes > 12){
                mes = 1;
                año = año + 1;
            }
        }
        
        System.out.println("La fecha del dia siguiente es: " + dia + "/" + mes + "/" + año);
        
        sc.close();
    }
}
