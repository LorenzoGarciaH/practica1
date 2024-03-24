package Laboratorios;

import java.util.*;
import Manejo.*;
import IN_OUT.IN_OUT;


public class Laboratorio {
    private static Experimento experimentoActual;
    private static ArrayList<Experimento> experimentos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            IN_OUT.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (opcion) {
                case 1:
                    //abrirArchivo();
                    break;
                case 2:
                    //crearNuevoExperimento();
                    break;
                case 3:
                     if (experimentoActual == null) {
                        System.out.println("No hay experimento actual. Crea un nuevo experimento primero.");
                        return;
                     }   
                    //crearPoblacionBacterias();
                    break;
                case 4:
                    //visualizarPoblaciones();
                    break;
                case 5:
                    //EliminarPoblacion();
                    break;
                case 6:
                    //verInformacionPoblaciones();
                    break;
                case 7:
                    //guardarArchivo();
                    break;
                case 8:
                    //guardarComoArchivo();
                    break;
                case 9:
                    System.out.println("Saliendo ...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
                    break;
            }
        } while (opcion != 9);
    }

   
}