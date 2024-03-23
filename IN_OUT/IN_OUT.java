package IN_OUT;

public class IN_OUT {
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

    public static void crearNuevoExperimento() {
        System.out.print("Ingrese el nombre del nuevo experimento: ");
        String nombreExperimento = scanner.nextLine();
        experimentoActual = new Experimento(nombreExperimento);
        experimentos.add(experimentoActual);
        System.out.println("Nuevo experimento creado exitosamente.");
    }
}
