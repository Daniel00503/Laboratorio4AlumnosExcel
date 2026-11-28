/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo_estructurasdedatos.laboratorio4alumnosexcel;

import java.util.ArrayList;
import java.util.Comparator;

public class Ordenamiento {

    public static void selectionSort(ArrayList<Alumno> lista, Comparator<Alumno> comparador) {
        int n = lista.size();

        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < n; j++) {
                if (comparador.compare(lista.get(j), lista.get(indiceMenor)) < 0) {
                    indiceMenor = j;
                }
            }

            if (indiceMenor != i) {
                Alumno temp = lista.get(i);
                lista.set(i, lista.get(indiceMenor));
                lista.set(indiceMenor, temp);
            }
        }
    }
}