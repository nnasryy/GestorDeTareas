/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestortareas;

/**
 *
 * @author nasry
 */
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ArchivoTareas {

    private String nombreArchivo;

    public ArchivoTareas(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void guardar(Tarea[] tareas, int cantidad) {
        try {
            FileWriter escritor = new FileWriter(nombreArchivo, false);

            for (int i = 0; i < cantidad; i++) {
                escritor.write(tareas[i].aTexto() + "\n");
                escritor.write(tareas[i].getNombre() + "\n");
            }

            escritor.close();

        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public Tarea[] cargar() {

        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            return new Tarea[0];
        }

        String[] lineas = new String[200];
        int totalLineas = 0;

        try {
            FileReader lector = new FileReader(nombreArchivo);

            char[] lineaActual = new char[200];
            int posicion = 0;
            int caracter;

            while ((caracter = lector.read()) != -1) {
                char c = (char) caracter;

                if (c == '\n') {
                    String linea = new String(lineaActual, 0, posicion).trim();
                    if (!linea.isEmpty()) {
                        lineas[totalLineas] = linea;
                        totalLineas++;
                    }
                    posicion = 0;
                } else {
                    lineaActual[posicion] = c;
                    posicion++;
                }
            }

            if (posicion > 0) {
                String linea = new String(lineaActual, 0, posicion).trim();
                if (!linea.isEmpty()) {
                    lineas[totalLineas] = linea;
                    totalLineas++;
                }
            }

            lector.close();

        } catch (Exception e) {
            System.out.println("Error al cargar: " + e.getMessage());
            return new Tarea[0];
        }

        int cantidadTareas = totalLineas / 2;
        Tarea[] tareas = new Tarea[cantidadTareas];

        for (int i = 0; i < cantidadTareas; i++) {
            String estado = lineas[i * 2];
            String nombre = lineas[i * 2 + 1];
            boolean estaCompletada = estado.equals("COMPLETADA");
            tareas[i] = new Tarea(nombre, estaCompletada);
        }

        return tareas;
    }
}
