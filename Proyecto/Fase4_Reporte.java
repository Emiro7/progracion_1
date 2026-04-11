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

        String[] rutas = {"T31", "A10", "P22A"};

        int pasajeros, vueltas, pctNormal, pctEstudiante;

        for (int i = 0; i < 3; i++) {

            String nombreRuta = rutas[i];

            System.out.println("\n----- Datos de la ruta " + nombreRuta + " -----");

            System.out.print("Ingrese pasajeros: ");
            pasajeros = sc.nextInt();

            System.out.print("Ingrese vueltas: ");
            vueltas = sc.nextInt();

            System.out.print("Ingrese porcentaje normal: ");
            pctNormal = sc.nextInt();

            if (pctNormal < 0 || pctNormal > 100) {
                System.out.println("Porcentaje invalido. Se asumira 50%");
                pctNormal = 50;
            }

            pctEstudiante = 100 - pctNormal;

            double valorPromedioPasaje = (pctNormal * 3000 + pctEstudiante * 1500) / 100.0;
            recaudo = pasajeros * valorPromedioPasaje;

            totalPasajerosDia += pasajeros;
            totalRecaudoDia += recaudo;
            totalVueltas += vueltas;

            if (pasajeros > maxPasajeros) {
                maxPasajeros = pasajeros;
                rutaMasConcurrida = nombreRuta;
            }

            if (pasajeros < minPasajeros) {
                minPasajeros = pasajeros;
                rutaMenosConcurrida = nombreRuta;
            }

            if (recaudo > maxRecaudo) {
                maxRecaudo = recaudo;
                rutaMayorRecaudo = nombreRuta;
            }

            System.out.println("Recaudo de la ruta: $" + recaudo);
        }

        promedio = totalPasajerosDia / 3.0;

        System.out.println("\n============================");
        System.out.println("Total pasajeros: " + totalPasajerosDia);
        System.out.println("Total recaudo: $" + totalRecaudoDia);
        System.out.println("Ruta mas concurrida: " + rutaMasConcurrida + " (" + maxPasajeros + ")");
        System.out.println("Ruta menos concurrida: " + rutaMenosConcurrida + " (" + minPasajeros + ")");
        System.out.println("Ruta mayor recaudo: " + rutaMayorRecaudo + " ($" + maxRecaudo + ")");
        System.out.println("Promedio pasajeros: " + promedio);

        sc.close();
    }
}