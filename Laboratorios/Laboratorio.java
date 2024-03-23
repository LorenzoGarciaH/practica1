import java.util.ArrayList;
import java.util.Scanner;
import package IN_OUT;
import package Manejo;
package Laboratorios;


public class Laboratorio {
    private static Experimento experimentoActual;
    private static ArrayList<Experimento> experimentos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (opcion) {
                case 1:
                    abrirArchivo();
                    break;
                case 2:
                    crearNuevoExperimento();
                    break;
                case 3:
                     if (experimentoActual == null) {
                        System.out.println("No hay experimento actual. Crea un nuevo experimento primero.");
                        return;
                     }   
                    crearPoblacionBacterias();
                    break;
                case 4:
                    visualizarPoblacionesBacterias();
                    break;
                case 5:
                    borrarPoblacionBacterias();
                    break;
                case 6:
                    verInformacionPoblacionBacterias();
                    break;
                case 7:
                    guardarArchivo();
                    break;
                case 8:
                    guardarComoArchivo();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intenta nuevamente.");
                    break;
            }
        } while (opcion != 9);
    }

   
}