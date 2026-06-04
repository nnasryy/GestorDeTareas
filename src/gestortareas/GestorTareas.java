/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestortareas;

/**
 *
 * @author nasry
 */
public class GestorTareas {

    private static final int MAX_TAREAS = 100;
    private Tarea[] tareas;
    private int cantidad;
    private ArchivoTareas archivo;

    public GestorTareas() {
        tareas = new Tarea[MAX_TAREAS];
        cantidad = 0;
        archivo = new ArchivoTareas("tareas.txt");
        cargarDesdeArchivo();
    }

    private void cargarDesdeArchivo() {
        Tarea[] cargadas = archivo.cargar();
        for (int i = 0; i < cargadas.length; i++) {
            if (cargadas[i] != null) {
                tareas[cantidad] = cargadas[i];
                cantidad++;
            }
        }
    }

    public void agregarTarea(String nombre) {
        if (cantidad >= MAX_TAREAS) {
            System.out.println("Llegaste al limite de tareas");
            return;
        }

        tareas[cantidad] = new Tarea(nombre);
        cantidad++;
        archivo.guardar(tareas, cantidad);
        System.out.println("✓ Tarea agregada: " + nombre);
    }

    public void mostrarTareas() {
        System.out.println();
        System.out.println("LISTA DE TAREAS");
        System.out.println("====================");

        if (cantidad == 0) {
            System.out.println("No hay tareas.");
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            System.out.println((i + 1) + ". " + tareas[i].mostrar());
        }
    }

    public void completarTarea(int numero) {
        if (numero < 1 || numero > cantidad) {
            System.out.println("Numero invalido.");
            return;
        }

        int indice = numero - 1;

        if (tareas[indice].estaCompletada()) {
            System.out.println("Esa tarea ya estaba completada.");
            return;
        }

        tareas[indice].completar();
        archivo.guardar(tareas, cantidad);
        System.out.println("✓ Tarea #" + numero + " completada: " + tareas[indice].getNombre());
    }

    public int getCantidad() {
        return cantidad;
    }
}