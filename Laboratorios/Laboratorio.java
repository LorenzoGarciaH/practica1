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
                opcion = IN_OUT.entradaInteger("Ingrese una opción: ");

            switch (opcion) {
                case 1:
                    try {
                        caracteres tontos;
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
                    //inicializar variables
                    String nombre = null;
                    int cantidad = 0;
                    int dosisComida = 0;
                    Date fechaInicio = null;
                    Date fechaFin = null;
                    Luminosidad luminosidad = null;
                    String poblacionNombre = null;
                    
                    try {
                    
                        IN_OUT.salidaPorPantalla("Ingrese los atributos del experimento:(la poblacion inicial tendra los mismos nombres que el experimento) ");//Atributos del experimento

                        nombre = IN_OUT.entradaString("Ingrese el nombre del experimento: ");
                        cantidad = IN_OUT.entradaInteger("Ingrese la cantidad de bacterias: ");
                        dosisComida = IN_OUT.entradaInteger("Ingrese la dosis de comida: ");
                        fechaInicio = new Date();
                        fechaFin = new Date();
                        try {
                            luminosidad = Luminosidad.valueOf(IN_OUT.entradaString("ALTO MEDIO BAJO"));
                        } catch (IllegalArgumentException exception) {
                            System.out.println("Valor inválido para Luminosidad. Por favor, ingrese ALTO, MEDIO o BAJO.");
                        }
                    } catch (IOException | IllegalArgumentException exception) {
                        exception.printStackTrace();
                    }
                    ArrayList<Poblacion> poblaciones = new ArrayList<>();
                    Poblacion poblacion = new Poblacion(nombre, cantidad, fechaInicio, fechaFin, luminosidad, poblacionDççççosisComida);
                    experimentoActual = new Experimento(nombre, cantidad, fechaInicio, fechaFin, luminosidad, dosisComida, poblaciones);
                    experimentoActual.agregarPoblacion(poblacion);
                    experimentos.add(experimentoActual);
                    break;
                case 3:
                    if (experimentoActual == null) {//comprobar si hay un experimento actual
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
                    for (Poblacion poblacionActual : experimentoActual.getPoblaciones()) {//ver todos los nombres de las poblaciones en el experimento actual
                        System.out.println(poblacionActual.getNombre());
                    }
                    break;
                case 5:
                    if (experimentoActual == null) {
                        System.out.println("No hay experimento actual. Crea un nuevo experimento primero.");
                        return;
                    }
                    String PoblacionAEliminar = null;
                    try {
                        PoblacionAEliminar = IN_OUT.entradaString("Ingrese el nombre de la población a eliminar: ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for (Poblacion poblacionActual : experimentoActual.getPoblaciones()) {
                        if (poblacionActual.getNombre().equals(PoblacionAEliminar)) {
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
                    String infoPoblacion = null;
                    try {
                        infoPoblacion = IN_OUT.entradaString("Ingrese el nombre de la población a visualizar: ");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for (Poblacion poblacionActual : experimentoActual.getPoblaciones()) {
                        if (poblacionActual.getNombre().equals(infoPoblacion)) {
                            infoPoblacion.toString();//ver la informacion de la poblacion
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("Has elegido guardar.");
                    if(experimentoActual != null) {
                        //CSV.GuardarCSV(experimentoActual); //No se como sacar el CSV, el metodo que utliziaba antes no me funciona
                    }
                    break;
                case 8:
                    System.out.println("Has elegido guardar como: ");
                    if(experimentoActual != null) {
                       // CSV.CrearCSV(poblacion);
                    }
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