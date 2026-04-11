package Proyecto;

import java.util.Scanner;

public class Fase4_Reporte {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalPasajerosDia = 0;
        int totalVueltas = 0;

        double totalRecaudoDia = 0;
        double maxRecaudo = 0;
        double recaudo;
        double promedio;

        int maxPasajeros = 0;
        int minPasajeros = Integer.MAX_VALUE;

        String rutaMasConcurrida = "";
        String rutaMenosConcurrida = "";
        String rutaMayorRecaudo = "";
        String nombreRuta;

        int pasajeros, vueltas, pctNormal, pctEstudiante;

        for (int ruta = 1; ruta <= 3; ruta++) {

            // Determinar nombre de la ruta
            if (ruta == 1) {
                nombreRuta = "T31";
            } else if (ruta == 2) {
                nombreRuta = "A10";
            } else {
                nombreRuta = "P22A";
            }

            System.out.println("\n----- Datos de la ruta " + nombreRuta + " -----");

            System.out.print("Ingrese pasajeros: ");
            pasajeros = sc.nextInt();

            System.out.print("Ingrese vueltas: ");
            vueltas = sc.nextInt();

            System.out.print("Ingrese porcentaje normal: ");
            pctNormal = sc.nextInt();

             //TODO:calcular pctEstudiante y recaudo 
            pctEstudiante = 100 - pctNormal;

            recaudo = pasajeros * ((pctNormal * 3000 + pctEstudiante * 1500) / 100.0);

            //TODO:actualizar acumuladores globales
            totalPasajerosDia += pasajeros;
            totalRecaudoDia += recaudo;
            totalVueltas += vueltas;

            //TODO:actualizar maximos y minimos

            if (pasajeros > maxPasajeros) {
                maxPasajeros = pasajeros;
                rutaMasConcurrida = nombreRuta;
            }

            if (pasajeros < minPasajeros) {
                minPasajeros = pasajeros;
                rutaMenosConcurrida = nombreRuta;
            }

            //TODO:mostrar recaudo de esta ruta
            
            if (recaudo > maxRecaudo) {
                maxRecaudo = recaudo;
                rutaMayorRecaudo = nombreRuta;
            }

            System.out.println("Recaudo de la ruta: $" + recaudo);
        }

        //TODO:calcular promedio

        promedio = totalPasajerosDia / 3.0;

         //TODO:imprimir reporte final

        System.out.println("\n============================");
        System.out.println("TOTAL PASAJEROS: " + totalPasajerosDia);
        System.out.println("TOTAL RECAUDO: $" + totalRecaudoDia);
        System.out.println("Ruta mas concurrida: " + rutaMasConcurrida + " (" + maxPasajeros + ")");
        System.out.println("Ruta menos concurrida: " + rutaMenosConcurrida + " (" + minPasajeros + ")");
        System.out.println("Ruta mayor recaudo: " + rutaMayorRecaudo + " ($" + maxRecaudo + ")");
        System.out.println("Promedio pasajeros: " + promedio);

        sc.close();
    }
}