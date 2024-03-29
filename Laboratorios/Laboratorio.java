package Laboratorios;

import java.util.*;
import Manejo.*;
import IN_OUT.IN_OUT;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;


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
                    try {
                        IN_OUT.salidaPorPantalla("Ingrese el nombre del archivo: ");
                        String nombreArchivo = IN_OUT.entradaString("Ingrese el nombre del archivo: ");
                        File archivo = new File(nombreArchivo);
                        try {
                            Scanner scanner = new Scanner(archivo);
                            while (scanner.hasNextLine()) {
                                String linea = scanner.nextLine();
                                System.out.println(linea);
                            }
                            scanner.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("No se encontró el archivo.");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
                        IN_OUT.salidaPorPantalla("Ingrese primero los atributos de la población: ");//Atributos de la población

                        poblacionNombre = IN_OUT.entradaString("Ingrese el nombre de la población: ");
                        poblacionCantidad = IN_OUT.entradaInteger("Ingrese la cantidad de bacterias: ");
                        poblacionFechaInicio = new Date();
                        poblacionFechaFin = new Date();
                        try {
                            poblacionLuminosidad = Luminosidad.valueOf(IN_OUT.entradaString("ALTO MEDIO BAJO").toUpperCase());
                        } catch (IllegalArgumentException exception) {
                            System.out.println("Valor inválido para Luminosidad. Por favor, ingrese ALTO, MEDIO o BAJO.");
                        }
                        IN_OUT.salidaPorPantalla("Ingrese ahora los atributos del experimento: ");//Atributos del experimento

                        poblacionDosisComida = IN_OUT.entradaInteger("Ingrese la dosis de comida: ");
                        nombre = IN_OUT.entradaString("Ingrese el nombre del experimento: ");
                        cantidad = IN_OUT.entradaInteger("Ingrese la cantidad de bacterias: ");
                        dosisComida = IN_OUT.entradaInteger("Ingrese la dosis de comida: ");
                        fechaInicio = new Date();
                        fechaFin = new Date();
                        try {
                            luminosidad = Luminosidad.valueOf(IN_OUT.entradaString("ALTO MEDIO BAJO").toUpperCase());
                        } catch (IllegalArgumentException exception) {
                            System.out.println("Valor inválido para Luminosidad. Por favor, ingrese ALTO, MEDIO o BAJO.");
                        }
                    } catch (IOException | IllegalArgumentException exception) {
                        exception.printStackTrace();
                    }
                    ArrayList<Poblacion> poblaciones = new ArrayList<>();
                    Poblacion poblacion = new Poblacion(poblacionNombre, poblacionCantidad, poblacionFechaInicio, poblacionFechaFin, poblacionLuminosidad, poblacionDosisComida);
                    experimentoActual = new Experimento(nombre, cantidad, fechaInicio, fechaFin, luminosidad, dosisComida, poblaciones);
                    experimentoActual.agregarPoblacion(poblacion);
                    experimentos.add(experimentoActual);
                    break;
                case 3:
                    if (experimentoActual == null) {
                        System.out.println("No hay experimento actual. Crea un nuevo experimento primero.");
                        return;
                    }   
                    IN_OUT.salidaPorPantalla("Ingrese los atributos de la población: ");
                    String nombrePoblacion = null;
                    try {
                        nombrePoblacion = IN_OUT.entradaString("Ingrese el nombre de la población: ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    int cantidadPoblacion = 0;
                    try {
                        cantidadPoblacion = IN_OUT.entradaInteger("Ingrese la cantidad de bacterias: ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Date fechaInicioPoblacion = new Date();
                    Date fechaFinPoblacion = new Date();
                    Luminosidad luminosidadPoblacion = null;
                    try {
                        luminosidadPoblacion = Luminosidad.valueOf(IN_OUT.entradaString("ALTO MEDIO BAJO").toUpperCase());
                    } catch (IllegalArgumentException exception) {
                        System.out.println("Valor inválido para Luminosidad. Por favor, ingrese ALTO, MEDIO o BAJO.");
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                    Poblacion nuevaPoblacion = new Poblacion(nombrePoblacion, cantidadPoblacion, fechaInicioPoblacion, fechaFinPoblacion, luminosidadPoblacion, 0);
                    experimentoActual.agregarPoblacion(nuevaPoblacion); 
                    break;
                case 4:
                    if (experimentoActual == null) {
                        System.out.println("No hay experimento actual. Crea un nuevo experimento primero.");
                        return;
                    }
                    for (Poblacion poblacionActual : experimentoActual.getPoblaciones()) {
                        System.out.println(poblacionActual.getNombre());
                    }
                    break;
                case 5:
                    if (experimentoActual == null) {
                        System.out.println("No hay experimento actual. Crea un nuevo experimento primero.");
                        return;
                    }
                    String nombrePoblacionEliminar = null;
                    try {
                        nombrePoblacionEliminar = IN_OUT.entradaString("Ingrese el nombre de la población a eliminar: ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for (Poblacion poblacionActual : experimentoActual.getPoblaciones()) {
                        if (poblacionActual.getNombre().equals(nombrePoblacionEliminar)) {
                            experimentoActual.eliminarPoblacion(poblacionActual);
                            break;
                        }
                    }
                    break;
                case 6:
                    if (experimentoActual == null) {
                        System.out.println("No hay experimento actual. Crea un nuevo experimento primero.");
                        return;
                    }
                    String nombrePoblacionDetallada = null;
                    try {
                        nombrePoblacionDetallada = IN_OUT.entradaString("Ingrese el nombre de la población a visualizar: ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for (Poblacion poblacionActual : experimentoActual.getPoblaciones()) {
                        if (poblacionActual.getNombre().equals(nombrePoblacionDetallada)) {
                            System.out.println("Nombre: " + poblacionActual.getNombre());
                            System.out.println("Cantidad: " + poblacionActual.getCantidad());
                            System.out.println("Fecha de inicio: " + poblacionActual.getFechaInicio());
                            System.out.println("Fecha de fin: " + poblacionActual.getFechaFin());
                            System.out.println("Luminosidad: " + poblacionActual.getLuminosidad());
                            System.out.println("Dosis de comida: " + poblacionActual.getDosis());
                            break;
                        }
                    }
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