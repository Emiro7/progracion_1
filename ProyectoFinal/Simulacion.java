import java.util.ArrayList;
import java.util.Scanner;

class Estudiante {
    private int id;
    private String nombre;
    private double promedio;
    private int horasTotales;
    private int horasDeporte;
    private int horasCultura;
    private int horasSalud;
    // Historial para el Bono de Rendimiento (Contador por categoría aprobada/asistida)
    private int actividadesDeporteAprobadas = 0;
    private int actividadesCulturaAprobadas = 0;
    private int actividadesSaludAprobadas = 0;

    public Estudiante(int id, String nombre, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.promedio = promedio;
        this.horasTotales = 0;
        this.horasDeporte = 0;
        this.horasCultura = 0;
        this.horasSalud = 0;
    }

    public void agregarHoras(String tipoActividad, int horasGanadas) {
        this.horasTotales += horasGanadas;
        switch (tipoActividad) {
            case "Deporte":
                this.horasDeporte += horasGanadas;
                this.actividadesDeporteAprobadas++;
                verificarBono("Deporte");
                break;
            case "Cultura":
                this.horasCultura += horasGanadas;
                this.actividadesCulturaAprobadas++;
                verificarBono("Cultura");
                break;
            case "Salud":
                this.horasSalud += horasGanadas;
                this.actividadesSaludAprobadas++;
                verificarBono("Salud");
                break;
            default:
                System.out.println("Categoría no válida.");
        }
    }

    private void verificarBono(String categoria) {
        if (categoria.equals("Deporte") && this.actividadesDeporteAprobadas % 3 == 0) {
            this.horasTotales += 5;
            this.horasDeporte += 5;
            System.out.println("¡Bono UNIAJC otorgado! +5 horas en Deporte.");
        } else if (categoria.equals("Cultura") && this.actividadesCulturaAprobadas % 3 == 0) {
            this.horasTotales += 5;
            this.horasCultura += 5;
            System.out.println("¡Bono UNIAJC otorgado! +5 horas en Cultura.");
        } else if (categoria.equals("Salud") && this.actividadesSaludAprobadas % 3 == 0) {
            this.horasTotales += 5;
            this.horasSalud += 5;
            System.out.println("¡Bono UNIAJC otorgado! +5 horas en Salud.");
        }
    }

    public void restarHoras(int horasPerdidas) {
        this.horasTotales -= horasPerdidas;
        if (this.horasTotales < 0) this.horasTotales = 0;
    }

    public boolean esAptoParaGrado() {
        return this.horasDeporte >= 10 && this.horasCultura >= 10 && this.horasSalud >= 10;
    }

    public void mostrarDatos() {
        System.out.println("ID: " + id + " | Nombre: " + nombre + " | Promedio: " + promedio);
        System.out.println("Horas -> Totales: " + horasTotales + " [Deporte: " + horasDeporte + " | Cultura: " + horasCultura + " | Salud: " + horasSalud + "]");
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPromedio() { return promedio; }
}

class Actividad {
    private int id;
    private String nombreActividad;
    private String categoria;
    private int cuposMaximos;
    private int cuposDisponibles;
    private int horasActividad;
    private String horario; // Ej: "Lunes", "Martes"
    private boolean esAltoImpacto; // Para restricción de promedio

    // Listas de gestión interna
    private ArrayList<Estudiante> listaEspera;
    private ArrayList<Integer> calificaciones;

    public Actividad(int id, String nombreActividad, String categoria, int cuposMaximos, int horasActividad, String horario, boolean esAltoImpacto) {
        this.id = id;
        this.nombreActividad = nombreActividad;
        this.categoria = categoria;
        this.cuposMaximos = cuposMaximos;
        this.cuposDisponibles = cuposMaximos;
        this.horasActividad = horasActividad;
        this.horario = horario;
        this.esAltoImpacto = esAltoImpacto;
        this.listaEspera = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
    }

    public boolean tieneCupo() {
        return cuposDisponibles > 0;
    }

    public void ocuparCupo() {
        if (cuposDisponibles > 0) {
            cuposDisponibles--;
        }
    }

    public void liberarCupo() {
        if (cuposDisponibles < cuposMaximos) {
            cuposDisponibles++;
        }
    }

    public void agregarAListaEspera(Estudiante e) {
        listaEspera.add(e);
        System.out.println("Cupos llenos. Estudiante '" + e.getNombre() + "' agregado a la lista de espera.");
    }

    public Estudiante extraerSiguienteListaEspera() {
        if (!listaEspera.isEmpty()) {
            return listaEspera.remove(0); // FIFO (Primero en entrar, primero en salir)
        }
        return null;
    }

    public void registrarCalificacion(int nota) {
        if (nota >= 1 && nota <= 5) {
            calificaciones.add(nota);
        }
    }

    public double getPromedioSatisfaccion() {
        if (calificaciones.isEmpty()) return 0.0;
        double suma = 0;
        for (int nota : calificaciones) {
            suma += nota;
        }
        return suma / calificaciones.size();
    }

    public void mostrarActividad() {
        System.out.println("ID: " + id + " | Actividad: " + nombreActividad + " (" + categoria + ")");
        System.out.println("Horario: " + horario + " | Horas otorgadas: " + horasActividad + " | Alto Impacto: " + (esAltoImpacto ? "SÍ" : "NO"));
        System.out.println("Cupos Disponibles: " + cuposDisponibles + "/" + cuposMaximos + " | En Espera: " + listaEspera.size());
        System.out.println("Satisfacción Promedio: " + String.format("%.2f", getPromedioSatisfaccion()) + "");
    }

    // Getters
    public int getId() { return id; }
    public String getNombreActividad() { return nombreActividad; }
    public String getCategoria() { return categoria; }
    public int getHorasActividad() { return horasActividad; }
    public String getHorario() { return horario; }
    public boolean isEsAltoImpacto() { return esAltoImpacto; }
}

class Inscripcion {
    private Estudiante estudiante;
    private Actividad actividad;
    private boolean asistenciaConfirmada;
    private String estadoInscripcion; // "Activa", "Cancelada", "Lista de Espera"

    public Inscripcion(Estudiante estudiante, Actividad actividad, String estadoInscripcion) {
        this.estudiante = estudiante;
        this.actividad = actividad;
        this.asistenciaConfirmada = false;
        this.estadoInscripcion = estadoInscripcion;
    }

    public void confirmarAsistencia() {
        if (this.estadoInscripcion.equals("Activa")) {
            this.asistenciaConfirmada = true;
            this.estudiante.agregarHoras(actividad.getCategoria(), actividad.getHorasActividad());
            System.out.println
            ("Asistencia confirmada. Se cargaron " + actividad.getHorasActividad() + " horas a " + estudiante.getNombre());
        } else {
            System.out.println
            ("No se puede confirmar asistencia. El estado actual es: " + estadoInscripcion);
        }
    }

    public void cancelarInscripcion(boolean conAntelacion) {
        if (this.estadoInscripcion.equals("Activa")) {
            this.estadoInscripcion = "Cancelada";
            actividad.liberarCupo();
            
            if (!conAntelacion) {
                estudiante.restarHoras(2);
                System.out.println
                ("Cancelación tardía. Penalización aplicada: -2 horas a " + estudiante.getNombre());
            } else {
                System.out.println("Cancelación exitosa sin penalización.");
            }
        }
    }

    public void activarDesdeEspera() {
        this.estadoInscripcion = "Activa";
    }

    public void mostrarInscripcion() {
        System.out.println
        ("Estudiante: " + estudiante.getNombre() + " | Actividad: " + actividad.getNombreActividad() + " | Horario: " + actividad.getHorario());
        System.out.println
        ("Estado: " + estadoInscripcion + " | Asistió: " + (asistenciaConfirmada ? "SÍ" : "NO"));
    }

    // Getters
    public Estudiante getEstudiante() { return estudiante; }
    public Actividad getActividad() { return actividad; }
    public String getEstadoInscripcion() { return estadoInscripcion; }
}

public class Simulacion {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        ArrayList<Actividad> actividades = new ArrayList<>();
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        // Datos Iniciales de Prueba
        estudiantes.add(new Estudiante(101, "Juan Carlos", 4.2));
        estudiantes.add(new Estudiante(102, "Camila Torres", 3.8)); // Promedio menor a 4.0
        estudiantes.add(new Estudiante(103, "Andres Felipe", 4.5));

        // Actividades (ID, Nombre, Categoría, Cupos, Horas, Día, EsAltoImpacto)
        actividades.add(new Actividad(1, "Torneo de Microfútbol", 
        "Deporte", 2, 5, "Lunes", false));
        actividades.add(new Actividad(2, "Salida Cultural Museo",
         "Cultura", 10, 4, "Martes", true)); // Alto impacto
        actividades.add(new Actividad(3, "Taller de Manejo del Estrés",
         "Salud", 5, 6, "Lunes", false)); // Mismo horario que fútbol

        int opcion = 0;

        while (opcion != 7) {
            System.out.println("\n=======================================");
            System.out.println("    SISTEMA DE GESTIÓN: BIENESTAR UNIAJC ");
            System.out.println("=======================================");
            System.out.println("1. Ver Estudiantes");
            System.out.println("2. Ver Oferta de Actividades");
            System.out.println("3. Inscribir Estudiante a Actividad");
            System.out.println("4. Confirmar Asistencia (Aprobar Actividad)");
            System.out.println("5. Cancelar Inscripción (Con/Sin Antelación)");
            System.out.println("6. Calificar Actividad e Informe General");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = entrada.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada no válida.");
                entrada.next();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n--- LISTADO DE ESTUDIANTES ---");
                    for (Estudiante e : estudiantes) {
                        e.mostrarDatos();
                        System.out.println("---------------------------------------");
                    }
                    break;

                case 2:
                    System.out.println("\n--- OFERTA DE ACTIVIDADES BIENESTAR ---");
                    for (Actividad a : actividades) {
                        a.mostrarActividad();
                        System.out.println("---------------------------------------");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el ID del Estudiante: ");
                    int idEst = entrada.nextInt();
                    System.out.print("Ingrese el ID de la Actividad: ");
                    int idAct = entrada.nextInt();

                    Estudiante estSel = null;
                    for (Estudiante e : estudiantes) {
                        if (e.getId() == idEst) estSel = e;
                    }

                    Actividad actSel = null;
                    for (Actividad a : actividades) {
                        if (a.getId() == idAct) actSel = a;
                    }

                    if (estSel == null || actSel == null) {
                        System.out.println("❌ Estudiante o Actividad no encontrados.");
                        break;
                    }

                    // REGLA 8: Restricción por Promedio Académico
                    if (actSel.isEsAltoImpacto() && estSel.getPromedio() < 4.0) {
                        System.out.println
                        (" Inscripción Rechazada: Esta actividad es de alto impacto/viaje y el promedio del estudiante es menor a 4.0.");
                        break;
                    }

                    // REGLA 5: Validación de Horarios (Cruces)
                    boolean tieneCruce = false;
                    for (Inscripcion ins : inscripciones) {
                        if (ins.getEstudiante().getId() == estSel.getId() && 
                            ins.getEstadoInscripcion().equals("Activa") &&
                            ins.getActividad().getHorario().equalsIgnoreCase(actSel.getHorario())) {
                            tieneCruce = true;
                            break;
                        }
                    }
                    if (tieneCruce) {
                        System.out.println
                        ("Inscripción Rechazada: El estudiante ya se encuentra registrado en otra actividad el día " + actSel.getHorario());
                        break;
                    }

                    // REGLA 3 y 4: Gestión de Cupos y Lista de Espera Dinámica
                    if (actSel.tieneCupo()) {
                        actSel.ocuparCupo();
                        Inscripcion nuevaInscripcion = new Inscripcion(estSel, actSel, "Activa");
                        inscripciones.add(nuevaInscripcion);
                        System.out.println("✔ Inscripción exitosa en estado: ACTIVA.");
                    } else {
                        actSel.agregarAListaEspera(estSel);
                        Inscripcion enEspera = new Inscripcion(estSel, actSel, "Lista de Espera");
                        inscripciones.add(enEspera);
                    }
                    break;

                case 4:
                    System.out.println("\n--- CONFIRMAR ASISTENCIA (APROBACIÓN) ---");
                    System.out.print("Ingrese ID del Estudiante: ");
                    int idE = entrada.nextInt();
                    
                    boolean encontro = false;
                    for (Inscripcion ins : inscripciones) {
                        if (ins.getEstudiante().getId() == idE && ins.getEstadoInscripcion().equals("Activa")) {
                            System.out.print("¿Confirmar asistencia para '" + ins.getActividad().getNombreActividad() + "'? (s/n): ");
                            char conf = entrada.next().toLowerCase().charAt(0);
                            if (conf == 's') {
                                ins.confirmarAsistencia();
                                encontro = true;
                            }
                        }
                    }
                    if (!encontro) System.out.println
                    ("No se encontraron inscripciones activas por confirmar para ese estudiante.");
                    break;

                case 5:
                    System.out.println("\n--- CANCELAR INSCRIPCIÓN ---");
                    System.out.print("Ingrese ID del Estudiante: ");
                    int idCancel = entrada.nextInt();
                    
                    Inscripcion aCancelar = null;
                    for (Inscripcion ins : inscripciones) {
                        if (ins.getEstudiante().getId() == idCancel && 
                        ins.getEstadoInscripcion().equals("Activa")) {
                            aCancelar = ins;
                            break;
                        }
                    }

                    if (aCancelar == null) {
                        System.out.println("No se encontró una inscripción activa para cancelar.");
                        break;
                    }

                    // REGLA 6: Sistema de Penalizaciones
                    System.out.print("¿Cancela con suficiente anticipación? (s/n): ");
                    char ant = entrada.next().toLowerCase().charAt(0);
                    boolean conAntelacion = (ant == 's');

                    Actividad actLiberada = aCancelar.getActividad();
                    aCancelar.cancelarInscripcion(conAntelacion);

                    // REGLA 4: Asignación automática desde Lista de Espera
                    Estudiante proximo = actLiberada.extraerSiguienteListaEspera();
                    if (proximo != null) {
                        actLiberada.ocuparCupo();
                        for (Inscripcion ins : inscripciones) {
                            if (ins.getEstudiante().getId() == proximo.getId() && 
                                ins.getActividad().getId() == actLiberada.getId() &&
                                ins.getEstadoInscripcion().equals("Lista de Espera")) {
                                ins.activarDesdeEspera();
                                System.out.println(" [Lista de Espera]: El estudiante " + proximo.getNombre() +
                                 " ha sido promovido automáticamente a cupo ACTIVO.");
                                break;
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("\n--- MÉTRICAS DE SATISFACCIÓN Y REPORTE DE GRADO ---");
                    System.out.print("¿Desea calificar una actividad primero? (s/n): ");
                    char calif = entrada.next().toLowerCase().charAt(0);
                    if (calif == 's') {
                        System.out.print("Ingrese ID de la Actividad a calificar: ");
                        int idA = entrada.nextInt();
                        System.out.print("Ingrese calificación de satisfacción (1 al 5): ");
                        int nota = entrada.nextInt();
                        for (Actividad a : actividades) {
                            if (a.getId() == idA) a.registrarCalificacion(nota);
                        }
                    }

                    // REGLA 2 y 10: Certificación de Grado General
                    System.out.println("\n====== REPORTE DE CERTIFICACIÓN DE GRADO ======");
                    for (Estudiante e : estudiantes) {
                        e.mostrarDatos();
                        // Validación de mínimos por categoría (10 horas c/u)
                        if (e.esAptoParaGrado()) {
                            System.out.println("ESTADO FINAL:  [APTO PARA GRADO]");
                        } else {
                            System.out.println("ESTADO FINAL:  [NO APTO] - Debe cumplir mínimo 10 horas en Deporte, Cultura y Salud de manera independiente.");
                        }
                        System.out.println("------------------------------------------------");
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del software de Gestión Bienestar UNIAJC. ¡Mucho éxito en la sustentación!");
                    break;

                default:
                    System.out.println("Opción errónea.");
            }
        }
        entrada.close();
    }
}
