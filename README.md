# Laboratorio 4 – Gestión de Alumnos desde Excel

Aplicación de consola en Java que lee la información de estudiantes desde un archivo de Excel (`Alumnos.xlsx`) usando **Apache POI**, convierte cada fila en un objeto `Alumno`, los almacena en un `ArrayList<Alumno>` y permite ordenarlos con el algoritmo **Selection Sort** implementado manualmente, usando distintos criterios definidos con la interfaz **Comparator**.

**Materia:** Programación Orientada a Objetos y Estructuras de Datos – Universidad Francisco Gavidia
**Docente:** Ing. René Iraheta
**Grupo:** 4

---

## Integrantes y roles

El equipo está formado por 4 integrantes, por lo que los 5 roles sugeridos en la guía se redistribuyeron así:

- **Daniel Alvarenga (Daniel00503) – Líder del proyecto**
  Repositorio, GitHub Projects, colaboradores, revisión de Pull Requests, clases `GestionAlumnos` y `Main`, README.
- **Jaime Hernández (JaimeH100) – Programación orientada a objetos y comparadores**
  Clases `Alumno` y `ComparadorAlumno`.
- **Néstor Chinchilla (NestorGH-0) – Importación de Excel**
  Configuración de Apache POI en el `pom.xml` y clase `ExcelReader`.
- **Harry Herrera(211hqxx) – Algoritmo de ordenamiento y pruebas**
  Clase `Ordenamiento` (Selection Sort), pruebas y capturas de ejecución.

---

## Requisitos

- **JDK 26**
- **Apache NetBeans** (probado con NetBeans 30)
- **Maven** (incluido en NetBeans)
- Conexión a internet la primera vez, para que Maven descargue Apache POI

> Si se usa otra versión del JDK (por ejemplo, 21), cambiar en el `pom.xml` el valor de `<maven.compiler.release>` por esa versión.

---

## Cómo configurar y ejecutar

1. Clonar el repositorio:
   - En NetBeans: **Team → Git → Clone…**
   - URL: `https://github.com/Daniel00503/Laboratorio4AlumnosExcel.git`
   - Rama: `master`
   - O descargar el ZIP desde GitHub y abrirlo con **File → Open Project**.
2. Clic derecho sobre el proyecto → **Build with Dependencies** (descarga Apache POI).
3. Verificar que el archivo `Alumnos.xlsx` esté en la **raíz del proyecto**, al lado del `pom.xml`.
4. Presionar **Run** (clase principal: `Main`).
5. Usar el menú escribiendo el número de la opción en la pestaña **Output** y presionando Enter.

---

## Menú de opciones

1. Importar estudiantes desde Excel
2. Mostrar estudiantes importados
3. Ordenar por carnet (ascendente)
4. Ordenar por apellido (ascendente)
5. Ordenar por promedio (descendente)
6. Salir

**Orden de prueba recomendado:** 1 → 2 → 5 → 3 → 4 → 6
(Primero se ordena por promedio para que el ordenamiento por carnet muestre un cambio visible, ya que el Excel viene ordenado por carnet).

---

## Formato del archivo Excel

- La **primera fila** contiene los encabezados y no se interpreta como registro.
- Cada fila siguiente representa un alumno, con estas columnas en orden:
  1. Carnet
  2. Nombre
  3. Apellido
  4. Edad
  5. Carrera
  6. Promedio
  7. AnioIngreso

---

## Estructura del proyecto

Paquete: `poo_estructurasdedatos.laboratorio4alumnosexcel`

- **Alumno:** representa la información de cada estudiante (atributos privados, constructores, getters, setters y `toString()`).
- **ExcelReader:** lee el archivo Excel con Apache POI y convierte cada fila en un objeto `Alumno`.
- **ComparadorAlumno:** contiene los criterios de comparación con `Comparator<Alumno>` (carnet, apellido y promedio).
- **Ordenamiento:** implementación manual del algoritmo Selection Sort, que recibe la lista y un `Comparator<Alumno>`.
- **GestionAlumnos:** administra el `ArrayList<Alumno>` y las operaciones de importar, mostrar y ordenar.
- **Main:** contiene el menú principal y coordina las operaciones de la aplicación.

---

## Dependencias (pom.xml)

- `org.apache.poi:poi-ooxml:5.5.1` – lectura de archivos `.xlsx`
- `org.apache.logging.log4j:log4j-to-slf4j:2.24.3` y `org.slf4j:slf4j-nop:2.0.17` – evitan el aviso de Log4j en consola

---

## Trabajo colaborativo

- Cada integrante trabajó en su propia rama y subió su aporte mediante **Pull Requests**, revisados y aprobados por el líder antes de unirlos a `master`.
- Las tareas, responsables, estados y horas estimadas se administraron en **GitHub Projects**, con las columnas Pendiente, En progreso, En revisión y Finalizado.
- Tiempo estimado: mínimo 6 horas por integrante (24.5 horas en total).