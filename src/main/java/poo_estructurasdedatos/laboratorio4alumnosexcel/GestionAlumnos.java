package poo_estructurasdedatos.laboratorio4alumnosexcel;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class GestionAlumnos {

    // La colección de alumnos (RF03)
    private ArrayList<Alumno> alumnos = new ArrayList<>();

    // GestionAlumnos usa el ExcelReader de Néstor para importar
    private final ExcelReader lector = new ExcelReader();

    // Importa los alumnos desde el Excel y devuelve cuántos se leyeron
    public int importarDesdeExcel(String rutaArchivo) {
        try (FileInputStream archivo = new FileInputStream(rutaArchivo)) {
            // ExcelReader devuelve un List; lo convertimos a ArrayList
            alumnos = new ArrayList<>(lector.leerAlumnos(archivo));
            return alumnos.size();
        } catch (Exception e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
            return 0;
        }
    }

    // Indica si todavía no hay alumnos cargados
    public boolean estaVacia() {
        return alumnos.isEmpty();
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    // Ordena la lista con el Selection Sort de Harry usando el criterio recibido
    public void ordenar(Comparator<Alumno> criterio) {
        Ordenamiento.selectionSort(alumnos, criterio);
    }

    // Muestra todos los alumnos en forma de tabla (RF04)
    public void mostrarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos cargados. Primero importa el Excel.");
            return;
        }
        imprimirEncabezado();
        for (Alumno a : alumnos) {
            System.out.println(formatearFila(a));
        }
        System.out.println("-".repeat(90));
        System.out.println("Total de alumnos: " + alumnos.size());
    }

    // Títulos de las columnas
    private void imprimirEncabezado() {
        System.out.println("-".repeat(90));
        System.out.println(String.format("%-9s %-10s %-11s %4s   %-27s %6s   %s",
                "CARNET", "NOMBRE", "APELLIDO", "EDAD", "CARRERA", "PROM.", "INGRESO"));
        System.out.println("-".repeat(90));
    }

    // Una fila de la tabla, armada con los getters de Alumno
    private String formatearFila(Alumno a) {
        return String.format("%-9s %-10s %-11s %4d   %-27s %6.2f   %d",
                a.getCarnet(), a.getNombre(), a.getApellido(), a.getEdad(),
                a.getCarrera(), a.getPromedio(), a.getAnioIngreso());
    }
}