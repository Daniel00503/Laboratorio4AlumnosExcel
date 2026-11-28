package poo_estructurasdedatos.laboratorio4alumnosexcel;

import java.util.Comparator;
import java.util.Scanner;

public class Main {

    // Nombre del archivo Excel (en la raíz del proyecto)
    private static final String ARCHIVO_EXCEL = "Alumnos.xlsx";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionAlumnos gestion = new GestionAlumnos();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion(sc);

            switch (opcion) {
                case 1 -> {
                    int cantidad = gestion.importarDesdeExcel(ARCHIVO_EXCEL);
                    System.out.println("Se importaron " + cantidad + " alumnos desde " + ARCHIVO_EXCEL);
                }
                case 2 -> gestion.mostrarAlumnos();
                case 3 -> ordenarYMostrar(gestion, ComparadorAlumno.porCarnet(),
                                          "CARNET (ASCENDENTE)");
                case 4 -> ordenarYMostrar(gestion, ComparadorAlumno.porApellido(),
                                          "APELLIDO (ASCENDENTE)");
                case 5 -> ordenarYMostrar(gestion, ComparadorAlumno.porPromedio(),
                                          "PROMEDIO (DESCENDENTE)");
                case 6 -> System.out.println("Saliendo del programa. ¡Hasta luego!");
                default -> System.out.println("Opción inválida. Escribe un número del 1 al 6.");
            }

        } while (opcion != 6);

        sc.close();
    }

    // Imprime las opciones del menú (RF09)
    private static void mostrarMenu() {
        System.out.println("\n========== GESTIÓN DE ALUMNOS ==========");
        System.out.println("1. Importar estudiantes desde Excel");
        System.out.println("2. Mostrar estudiantes importados");
        System.out.println("3. Ordenar por carnet (ascendente)");
        System.out.println("4. Ordenar por apellido (ascendente)");
        System.out.println("5. Ordenar por promedio (descendente)");
        System.out.println("6. Salir");
        System.out.println("========================================");
    }

    // Lee la opción; si el usuario escribe letras, devuelve -1 en vez de fallar
    private static int leerOpcion(Scanner sc) {
        System.out.print("Elige una opción: ");
        String texto = sc.nextLine().trim();
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Ordena con el criterio recibido y muestra el resultado
    private static void ordenarYMostrar(GestionAlumnos gestion,
                                        Comparator<Alumno> criterio, String titulo) {
        if (gestion.estaVacia()) {
            System.out.println("No hay alumnos cargados. Primero usa la opción 1.");
            return;
        }
        gestion.ordenar(criterio);
        System.out.println("\n=== ALUMNOS ORDENADOS POR " + titulo + " ===");
        gestion.mostrarAlumnos();
    }
}