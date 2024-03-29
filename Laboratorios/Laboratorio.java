package Laboratorios;

import java.util.*;
import Manejo.*;
import IN_OUT.IN_OUT;
import java.io.IOException;


public class Laboratorio {
    private static Experimento experimentoActual;
    private static ArrayList<Experimento> experimentos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion=0;
        do {
            IN_OUT.mostrarMenu();
            try {
                opcion = IN_OUT.entradaInteger("Ingrese una opción: ");
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Handle IllegalArgumentException for Luminosidad enum
            catch (IllegalArgumentException exception) {
                System.out.println("Valor inválido para Luminosidad. Por favor, ingrese ALTO, MEDIO o BAJO.");
            }
            
            switch (opcion) {
                case 1:
                    //abrirArchivo();
                    break;
                case 2:
                    String nombre = null;
                    int poblacionCantidad = 0;
                    Date poblacionFechaInicio = null;
                    Date poblacionFechaFin = null;
                    Luminosidad poblacionLuminosidad = null;
                    int poblacionDosisComida = 0;
                    int cantidad = 0;
                    int dosisComida = 0;
                    Date fechaInicio = null;
                    Date fechaFin = null;
                    Luminosidad luminosidad = null;
                    String poblacionNombre = null;
                    try {
                        IN_OUT.salidaPorPantalla("Ingrese primero los atributos de la población: ");

                        poblacionNombre = IN_OUT.entradaString("Ingrese el nombre de la población: ");
                        poblacionCantidad = IN_OUT.entradaInteger("Ingrese la cantidad de bacterias: ");
                        poblacionFechaInicio = new Date();
                        poblacionFechaFin = new Date();
                        poblacionLuminosidad = Luminosidad.valueOf(IN_OUT.entradaString("ALTO MEDIO BAJO"));
                        IN_OUT.salidaPorPantalla("Ingrese   ahora los atributos del experimento: ");

                        poblacionDosisComida = IN_OUT.entradaInteger("Ingrese la dosis de comida: ");
                        nombre = IN_OUT.entradaString("Ingrese el nombre del experimento: ");
                        cantidad = IN_OUT.entradaInteger("Ingrese la cantidad de bacterias: ");
                        dosisComida = IN_OUT.entradaInteger("Ingrese la dosis de comida: ");
                        fechaInicio = new Date();
                        fechaFin = new Date();
                        luminosidad = Luminosidad.valueOf(IN_OUT.entradaString("ALTO MEDIO BAJO"));
                    } catch (IOException | IllegalArgumentException exception) {
                        exception.printStackTrace();
                    }
                    ArrayList<Poblacion> poblaciones = new ArrayList<>();
                    Poblacion poblacion = new Poblacion(poblacionNombre, poblacionCantidad, poblacionFechaInicio, poblacionFechaFin, poblacionLuminosidad, poblacionDosisComida);
                    Experimento NuevoExperimento = new Experimento(nombre, cantidad, fechaInicio, fechaFin, luminosidad, dosisComida, poblaciones);
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