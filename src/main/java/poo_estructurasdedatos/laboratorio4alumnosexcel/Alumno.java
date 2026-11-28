/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package poo_estructurasdedatos.laboratorio4alumnosexcel;

/**
 *
 * @author jaime
 */
public class Alumno {

    private String carnet;
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    private double promedio;
    private int anioIngreso;

    // Constructor vacío
    public Alumno() {
    }

    // Constructor con parámetros
    public Alumno(String carnet, String nombre, String apellido, int edad,
                  String carrera, double promedio, int anioIngreso) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carrera = carrera;
        this.promedio = promedio;
        this.anioIngreso = anioIngreso;
    }

    // Setters
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    // Getters
    public String getCarnet() {
        return carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public double getPromedio() {
        return promedio;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    // Método toString
    @Override
    public String toString() {
        return "Carnet: " + carnet +
                ", Nombre: " + nombre +
                ", Apellido: " + apellido +
                ", Edad: " + edad +
                ", Carrera: " + carrera +
                ", Promedio: " + promedio +
                ", Año de ingreso: " + anioIngreso;
    }
}

