package Proyecto;

import java.util.Scanner;

public class Fase6_SistemaMIOCompleto {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n=== SISTEMA MIO CALI ===");
            System.out.println("1. Cobrar tarifa");
            System.out.println("2. Iniciar control de ruta");
            System.out.println("3. Reporte del dia");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {


                case 1:
                    // Toda la logica de Fase 1

                    System.out.print("Ingrese la hora (0-23): ");
                    int hora = sc.nextInt();

                    System.out.println("Tipo de pasajero:");
                    System.out.println("1. Normal");
                    System.out.println("2. Estudiante");
                    System.out.println("3. Adulto mayor");
                    System.out.println("4. Discapacitado");
                    int tipo = sc.nextInt();

                    boolean esHoraValle = (hora >= 9 && hora <= 16);
                    double tarifaBase = 0, descuento = 0;

                    switch (tipo) {
                        case 1:
                            tarifaBase = 3000;
                            break;
                        case 2:
                            tarifaBase = 1500;
                            if (esHoraValle) {
                                descuento = tarifaBase * 0.10;
                            }
                            break;
                        case 3:
                        case 4:
                            tarifaBase = 0;
                            break;
                        default:
                            System.out.println("Tipo invalido");
                    }

                    double totalPagar = tarifaBase - descuento;
                    System.out.println("TOTAL A PAGAR: " + totalPagar);
                    break;


                case 2:
                    // Toda la logica de Fase 2

                    int capacidadMaxima = 80;
                    int pasajerosActuales = 0;
                    int totalSubieron = 0, totalBajaron = 0;
                    int paradasRecorridas = 0, paradasConAforo = 0;
                    int parada = 1;
                    boolean rutaActiva = true;

                    while (parada <= 25 && rutaActiva) {

                        System.out.println("\nPARADA " + parada);
                        System.out.println("Pasajeros: " + pasajerosActuales);

                        System.out.print("Cuantos suben (-1 para terminar): ");
                        int suben = sc.nextInt();

                        if (suben == -1) {
                            rutaActiva = false;
                        } else {

                            System.out.print("Cuantos bajan: ");
                            int bajan = sc.nextInt();

                            if (bajan > pasajerosActuales) {
                                bajan = pasajerosActuales;
                            }

                            if (pasajerosActuales + suben - bajan > capacidadMaxima) {
                                suben = capacidadMaxima - pasajerosActuales + bajan;
                            }

                            pasajerosActuales += suben - bajan;
                            totalSubieron += suben;
                            totalBajaron += bajan;

                            if (pasajerosActuales == capacidadMaxima) {
                                paradasConAforo++;
                            }

                            double porcentaje = (pasajerosActuales * 100.0) / capacidadMaxima;

                            String estado;
                            if (pasajerosActuales == 80) {
                                estado = "AFORO MAXIMO";
                            } else if (porcentaje >= 60) {
                                estado = "BUS LLENO";
                            } else {
                                estado = "NORMAL";
                            }

                            System.out.println("Estado: " + estado);

                            parada++;
                            paradasRecorridas++;
                        }
                    }

                    System.out.println("\nResumen:");
                    System.out.println("Paradas: " + paradasRecorridas);
                    System.out.println("Subieron: " + totalSubieron);
                    System.out.println("Bajaron: " + totalBajaron);
                    System.out.println("Pasajeros finales: " + pasajerosActuales);
                    break;


                
                case 3:
                    // Toda la logica de Fase 4
                    // Inmediante despues, toda la de la fase 5

                    int totalPasajerosDia = 0, totalVueltas = 0;
                    double totalRecaudoDia = 0, maxRecaudo = 0;
                    int maxPasajeros = 0, minPasajeros = Integer.MAX_VALUE;

                    String rutaMas = "", rutaMenos = "", rutaMayorRecaudo = "";

                    int rutasConAlerta = 0;

                    for (int ruta = 1; ruta <= 3; ruta++) {

                        String nombreRuta;
                        if (ruta == 1) nombreRuta = "T31";
                        else if (ruta == 2) nombreRuta = "A10";
                        else nombreRuta = "P22A";

                        System.out.println("\n--- Ruta " + nombreRuta + " ---");

                        System.out.print("Pasajeros: ");
                        int pasajeros = sc.nextInt();

                        System.out.print("Vueltas: ");
                        int vueltas = sc.nextInt();

                        System.out.print("Porcentaje normal: ");
                        int pctNormal = sc.nextInt();

                        int pctEstudiante = 100 - pctNormal;

                        double recaudo = pasajeros * ((pctNormal * 3000 + pctEstudiante * 1500) / 100.0);

                        totalPasajerosDia += pasajeros;
                        totalRecaudoDia += recaudo;
                        totalVueltas += vueltas;

                        if (pasajeros > maxPasajeros) {
                            maxPasajeros = pasajeros;
                            rutaMas = nombreRuta;
                        }

                        if (pasajeros < minPasajeros) {
                            minPasajeros = pasajeros;
                            rutaMenos = nombreRuta;
                        }

                        if (recaudo > maxRecaudo) {
                            maxRecaudo = recaudo;
                            rutaMayorRecaudo = nombreRuta;
                        }

                        
                        System.out.print("Retraso (min): ");
                        int retraso = sc.nextInt();

                        boolean alertaDemanda = pasajeros < 500;
                        boolean alertaVueltas = vueltas > 20;
                        boolean alertaRetraso = retraso > 90;
                        boolean alertaRecaudo = recaudo < (pasajeros * 1500 * 0.70);

                        if (alertaDemanda || alertaVueltas || alertaRetraso || alertaRecaudo) {
                            rutasConAlerta++;
                            System.out.println("ALERTA DETECTADA");
                        } else {
                            System.out.println("OK");
                        }
                    }

                    double promedio = totalPasajerosDia / 3.0;

                    System.out.println("\n=== REPORTE FINAL ===");
                    System.out.println("Total pasajeros: " + totalPasajerosDia);
                    System.out.println("Total recaudo: " + totalRecaudoDia);
                    System.out.println("Ruta mas concurrida: " + rutaMas);
                    System.out.println("Ruta menos concurrida: " + rutaMenos);
                    System.out.println("Ruta mayor recaudo: " + rutaMayorRecaudo);
                    System.out.println("Promedio pasajeros: " + promedio);

                    System.out.println("Rutas con alerta: " + rutasConAlerta);
                    break;


                case 0:
                    System.out.println("Cerrando sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }
        }

        sc.close();
    }
}