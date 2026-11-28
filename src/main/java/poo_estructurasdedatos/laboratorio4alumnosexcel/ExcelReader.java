/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_estructurasdedatos.laboratorio4alumnosexcel;

import org.apache.poi.ss.usermodel.*;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nesto
 */
public class ExcelReader {

    //Metodo que permite leer el archivo 
    public List<Alumno> leerAlumnos(InputStream inputStream) throws Exception {

        //Creación de lista donde se almacenaran los Alumnos en el archivo
        List<Alumno> listaAlumnos = new ArrayList();

        //Variable que permite  obtener el contenido de las celdas como texto
        DataFormatter formatter = new DataFormatter();

        //Apertura y lectura del archivo
        try (Workbook workbook = WorkbookFactory.create(inputStream)) {
            Sheet hoja = workbook.getSheetAt(0);

            for (Row fila : hoja) {

                //Condicional para omitir encabezado
                if (fila.getRowNum() == 0) {
                    continue;
                }

                Alumno alumno = new Alumno();

                String carnet = formatter.formatCellValue(fila.getCell(0));
                String nombre = formatter.formatCellValue(fila.getCell(1));
                String apellido = formatter.formatCellValue(fila.getCell(2));
                String edad = formatter.formatCellValue(fila.getCell(3));
                String carrera = formatter.formatCellValue(fila.getCell(4));
                String promedio = formatter.formatCellValue(fila.getCell(5));
                String anioIngreso = formatter.formatCellValue(fila.getCell(6));

                alumno.setCarnet(carnet);
                alumno.setNombre(nombre);
                alumno.setApellido(apellido);
                alumno.setEdad(Integer.parseInt(edad));
                alumno.setCarrera(carrera);
                alumno.setPromedio(Double.parseDouble(promedio));
                alumno.setAnioIngreso(Integer.parseInt(anioIngreso));

                listaAlumnos.add(alumno);

            }

        }

        return listaAlumnos;

    }

}
