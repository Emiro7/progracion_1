package Proyecto;

import java.util.Scanner;

public class Fase3_Menu {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n+------------------------------+");
            System.out.println("| SISTEMA MIO CALI            |");
            System.out.println("+------------------------------+");
            System.out.println("| 1. Cobrar tarifa            |");
            System.out.println("| 2. Iniciar control de ruta  |");
            System.out.println("| 3. Reporte del dia          |");
            System.out.println("| 0. Salir                    |");
            System.out.println("+------------------------------+");

            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {

                //COMPLETEN:que debe ejecutar esta opcion?
                case 1:

                    System.out.print("Ingrese la hora actual (0-23): ");
                    int hora = sc.nextInt();

                    System.out.println("Tipo de pasajero:");
                    System.out.println("1. Normal");
                    System.out.println("2. Estudiante");
                    System.out.println("3. Adulto mayor");
                    System.out.println("4. Discapacitado");
                    System.out.print("Seleccione: ");
                    int tipo = sc.nextInt();

                    double tarifaBase = 0;
                    double descuento = 0;
                    double totalPagar = 0;
                    String nombreTipo = "";

                    boolean esHoraValle = (hora >= 9 && hora <= 16);

                    switch (tipo) {
                        case 1:
                            nombreTipo = "Normal";
                            tarifaBase = 3000;
                            break;

                        case 2:
                            nombreTipo = "Estudiante";
                            tarifaBase = 1500;
                            if (esHoraValle) {
                                descuento = tarifaBase * 0.10;
                            }
                            break;

                        case 3:
                            nombreTipo = "Adulto mayor";
                            tarifaBase = 0;
                            break;

                        case 4:
                            nombreTipo = "Discapacitado";
                            tarifaBase = 0;
                            break;

                        default:
                            System.out.println("Tipo invalido");
                    }

                    totalPagar = tarifaBase - descuento;

                    System.out.println("\n--- TIQUETE ---");
                    System.out.println("Tipo: " + nombreTipo);
                    System.out.println("Tarifa base: " + tarifaBase);
                    System.out.println("Descuento: " + descuento);
                    System.out.println("TOTAL A PAGAR: " + totalPagar);
                    break;

                 //COMPLETEN:quedebeejecutarestaopcion
                case 2:

                    int capacidadMaxima = 80;
                    int pasajerosActuales = 0;
                    int totalSubieron = 0;
                    int totalBajaron = 0;
                    int paradasRecorridas = 0;
                    int paradasConAforo = 0;
                    int parada = 1;
                    boolean rutaActiva = true;

                    while (parada <= 25 && rutaActiva) {

                        System.out.println("\n=== PARADA " + parada + " de 25 ===");
                        System.out.println("Pasajeros en el bus: " + pasajerosActuales);
                        System.out.print("Cuantos SUBEN? (-1 para terminar): ");

                        int suben = sc.nextInt();

                        if (suben == -1) {
                            rutaActiva = false;
                        } else {
                            System.out.print("Cuantos BAJAN? ");
                            int bajan = sc.nextInt();

                            if (bajan > pasajerosActuales) {
                                System.out.println("Error: no pueden bajar mas de los que hay");
                                bajan = pasajerosActuales;
                            }

                            if ((pasajerosActuales + suben - bajan) > capacidadMaxima) {
                                System.out.println("Capacidad superada, se ajustan los pasajeros");
                                suben = capacidadMaxima - (pasajerosActuales - bajan);
                            }

                            pasajerosActuales = pasajerosActuales + suben - bajan;
                            totalSubieron += suben;
                            totalBajaron += bajan;

                            if (pasajerosActuales == capacidadMaxima) {
                                paradasConAforo++;
                            }

                            double porcentaje = (pasajerosActuales * 100.0) / capacidadMaxima;
                            String estado;

                            if (pasajerosActuales == capacidadMaxima) {
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

                    System.out.println("\n--- RESUMEN ---");
                    System.out.println("Paradas: " + paradasRecorridas);
                    System.out.println("Subieron: " + totalSubieron);
                    System.out.println("Bajaron: " + totalBajaron);
                    System.out.println("Aforo maximo: " + paradasConAforo);
                    System.out.println("Pasajeros finales: " + pasajerosActuales);
                    break;

                //COMPLETEN:quedebeejecutarestaopcion?
                case 3:
                    System.out.println("Disponible en la Fase 4.");
                    break;

                case 0:
                    System.out.println("CerrandosistemaMIO...");
                    break;

                default:
                     //COMPLETEN:quepasasilaopcionnoexiste?
                    System.out.println("Opcion no valida.");
            }
        }

        sc.close();
    }
}
