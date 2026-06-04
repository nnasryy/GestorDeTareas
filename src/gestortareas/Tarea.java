/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestortareas;

/**
 *
 * @author nasry
 */
public class Tarea {

    private String nombre;
    private boolean completada;

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.completada = false;
    }

    public Tarea(String nombre, boolean completada) {
        this.nombre = nombre;
        this.completada = completada;
    }

    public void completar() {
        this.completada = true;
    }

    public boolean estaCompletada() {
        return completada;
    }

    public String getNombre() {
        return nombre;
    }

    public String mostrar() {
        if (completada) {
            return "[✓] " + nombre;
        } else {
            return "[ ] " + nombre;
        }
    }

    public String aTexto() {
        if (completada) {
            return "COMPLETADA";
        } else {
            return "PENDIENTE";
        }
    }
}