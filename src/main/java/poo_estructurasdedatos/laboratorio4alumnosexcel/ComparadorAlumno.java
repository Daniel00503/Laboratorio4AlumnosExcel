/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package poo_estructurasdedatos.laboratorio4alumnosexcel;

import java.util.Comparator;

public class ComparadorAlumno {

    // Ordenar por carnet de menor a mayor
    public static Comparator<Alumno> porCarnet() {
        return (a1, a2) -> a1.getCarnet().compareTo(a2.getCarnet());
    }

    // Ordenar por apellido de A a Z
    public static Comparator<Alumno> porApellido() {
        return (a1, a2) -> a1.getApellido().compareTo(a2.getApellido());
    }

    // Ordenar por promedio de mayor a menor
    public static Comparator<Alumno> porPromedio() {
        return (a1, a2) -> Double.compare(a2.getPromedio(), a1.getPromedio());
    }
}


    

