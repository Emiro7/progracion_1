package Proyecto;

import java.util.Scanner;

public class Fase2_Aforo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int     capacidadMaxima = 80;
        int     pasajerosActuales = 0;
        int     totalSubieron   = 0;
        int     totalBajaron    = 0;
        int     paradasRecorridas = 0;
        int     paradasConAforo = 0;
        int     parada          = 1;
        boolean rutaActiva      = true;

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

                // TODO 1: Validar que no bajen mas de los que hay
                if (bajan > pasajerosActuales) {
                    System.out.println("Error: Solo hay " + pasajerosActuales + " pasajeros en el bus. No pueden bajar " + bajan + ".");
                    bajan = pasajerosActuales;
                }
                
                // TODO 2: Validar que no se supere el aforo maximo
                if ((pasajerosActuales + suben - bajan) > 80) {
                    System.out.println("Alerta: Capacidad máxima superada. Solo subirán los que caben.");
                    suben = 80 - (pasajerosActuales - bajan);
                }
                
                // TODO 3: Actualizar pasajerosActuales, totalSubieron, totalBajaron
                pasajerosActuales = pasajerosActuales + suben - bajan;
                totalSubieron = totalSubieron + suben;
                totalBajaron = totalBajaron + bajan;
                
                // TODO 4: Si el bus llego a 80, sumar 1 a paradasConAforo
                if (pasajerosActuales == capacidadMaxima) {
                    paradasConAforo = paradasConAforo + 1;
                }
                
                // TODO 5: Calcular porcentaje y mostrar estado del bus
                double porcentaje = (pasajerosActuales * 100.0) / capacidadMaxima;
                String estado;
                
                if (pasajerosActuales == 80) {
                    estado = "AFORO MAXIMO";
                } else if (porcentaje >= 60) {
                    estado = "BUS LLENO";
                } else {
                    estado = "NORMAL";
                }
                System.out.println("Estado actual: " + estado + " (" + porcentaje + "% de ocupacion)");
                
                // TODO 6: Actualizar parada y paradasRecorridas
                parada = parada + 1;
                paradasRecorridas = paradasRecorridas + 1;
            }
        }
        
        // TODO: mostrar resumen final de la ruta
        System.out.println("\n=== RESUMEN FINAL DE LA RUTA ===");
        System.out.println("Paradas completadas: " + paradasRecorridas);
        System.out.println("Total de pasajeros que subieron: " + totalSubieron);
        System.out.println("Total de pasajeros que bajaron: " + totalBajaron);
        System.out.println("Paradas con el bus completamente lleno (Aforo): " + paradasConAforo);
        System.out.println("Pasajeros que quedaron en el bus al terminar: " + pasajerosActuales);
        
        sc.close();
    }
}
