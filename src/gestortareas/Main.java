/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestortareas;

import java.util.Scanner;

/**
 *
 * @author nasry
 */
public class Main {
 
    public static void main(String[] args) {
 
        Scanner teclado = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();
        int opcion = 0;
 
        while (opcion != 4) {
 
            mostrarMenu();
            System.out.print("Selecciona una opcion: ");
 
            if (teclado.hasNextInt()) {
                opcion = teclado.nextInt();
                teclado.nextLine();
            } else {
                teclado.nextLine();
                System.out.println("Por favor ingresa un numero del 1 al 4.");
                continue;
            }
 
            switch (opcion) {
 
                case 1:
                    System.out.print("Ingresa la nueva tarea: ");
                    String nombreTarea = teclado.nextLine().trim();
                    gestor.agregarTarea(nombreTarea);
                    System.out.println();
                    break;
 
                case 2:
                    gestor.mostrarTareas();
                    System.out.println();
                    break;
 
                case 3:
                    System.out.print("Numero de tarea a completar: ");
                    if (teclado.hasNextInt()) {
                        int numero = teclado.nextInt();
                        teclado.nextLine();
                        gestor.completarTarea(numero);
                    } else {
                        teclado.nextLine();
                        System.out.println("Ingresa un numero valido.");
                    }
                    System.out.println();
                    break;
 
                case 4:
                    break;
 
                default:
                    System.out.println("Opcion invalida. Elige entre 1 y 4.");
                    System.out.println();
                    break;
            }
        }
 
        teclado.close();
    }
 
    static void mostrarMenu() {
        System.out.println("GESTOR DE TAREAS");
        System.out.println("====================");
        System.out.println("1. Agregar tarea");
        System.out.println("2. Mostrar tareas");
        System.out.println("3. Completar tarea");
        System.out.println("4. Salir");
    }
}
