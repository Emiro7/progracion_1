package Proyecto;

import java.util.Scanner;

public class Fase1_Tarifa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la hora actual (0-23): ");
        int hora = sc.nextInt();
        System.out.println("Tipo de pasajero:");
        System.out.println(" 1. Normal");
        System.out.println(" 2. Estudiante");
        System.out.println(" 3. Adulto mayor");
        System.out.println(" 4. Discapacitado");
        System.out.print("Seleccione: ");
        int tipo = sc.nextInt();

        double tarifaBase = 0;
        double descuento = 0;
        double totalPagar = 0;
        String nombreTipo = "";

        // Esta expresion ya la escribo yo -- analicenla
        boolean esHoraValle = (hora >= 9 && hora <= 16);

        switch (tipo) {
            case 1:
                nombreTipo = "Normal";
                tarifaBase = 3000;
                break;
            case 2:
                nombreTipo = "Estudiante";
                tarifaBase = 1500;
                // TODO: aplicar descuento si es hora valle
                if (esHoraValle){
				descuento = tarifaBase * 0.1;
                }
                break;
            case 3:
                // TODO: completar
                nombreTipo = "adulto_mayor";
			    tarifaBase = 0;
                break;
            case 4:
                // TODO: completar
                nombreTipo = "discapacitado";
			    tarifaBase = 0;
                break;
            default:
                System.out.println("Tipo de pasajero invalido.");
        }

        // TODO: calcular totalPagar
        totalPagar = tarifaBase - descuento;

        // TODO: imprimir el tiquete con el formato de abajo
        System.out.println("------TIQUETE MIO - CALI------");
        System.out.println("Hora de abordaje:" + hora);
        System.out.println("Tipo de pasajero: " + nombreTipo);
        System.out.println("tarifaBase: " + tarifaBase );
        System.out.println("descuento: " + descuento);
        System.out.println("totalPagar: " + totalPagar);
        System.out.println(" ----------------------------");
        
        sc.close();
    }
}
