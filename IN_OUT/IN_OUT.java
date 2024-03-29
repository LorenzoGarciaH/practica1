package IN_OUT;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;
import Manejo.Experimento;
import Manejo.Luminosidad;
import Manejo.Poblacion;
public class IN_OUT {
    private static Scanner entrada = new Scanner(System.in);
    public static void mostrarMenu() {
        System.out.println("----- Menú -----");
        System.out.println("1. Abrir un archivo que contenga un experimento");
        System.out.println("2. Crear un nuevo experimento");
        System.out.println("3. Crear una población de bacterias y añadirla al experimento actual");
        System.out.println("4. Visualizar los nombres de todas las poblaciones de bacterias del experimento actual");
        System.out.println("5. Borrar una población de bacterias del experimento actual");
        System.out.println("6. Ver información detallada de una población de bacterias del experimento actual");
        System.out.println("7. Guardar");
        System.out.println("8. Guardar como");
        System.out.println("9. Salir");
        System.out.print("Ingrese una opción: ");
    }
    public static void salidaPorPantalla(String informacion){
        System.out.println(informacion);
    }

    public static String entradaString(String informacion)throws NumberFormatException, IOException{
        boolean probar = false;
        String nuevaEntrada = "";
        System.out.println(informacion);
        do{
            try {
               nuevaEntrada = entrada.next();
            } catch (NumberFormatException e){
                System.out.println(informacion);
                probar = true;

            }
        } while(probar);
        return nuevaEntrada;
    }

    public static int entradaInteger(String informacion) throws IOException, NumberFormatException {
        int nuevaEntrada = 0;
        boolean entradaValida = false;
        System.out.println(informacion);
        do {
            try {
                nuevaEntrada = Integer.parseInt(entrada.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero entero.");

            }
        } while (!entradaValida);
        return nuevaEntrada;
    }

    public static float entradaFloat(String informacion)throws IOException, NumberFormatException {
        boolean probar = false;
        float nuevaEntrada = 0;
        System.out.println(informacion);
        do {
            try {
                nuevaEntrada = entrada.nextFloat();
            } catch (NumberFormatException e ) {
                System.out.println(informacion);
                probar = true;

            }
        } while (probar);
        return nuevaEntrada;
    }

}
