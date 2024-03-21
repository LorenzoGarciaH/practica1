import java.util.*;
public class Experimento extends Poblacion {

    private Poblacion[] polaciones;

    public Experimento(String nombre, int cantidad, Date fechaInicio, Date fechaFin, Luminosidad luminosidad, Dosis dosisComida, Poblacion[] polaciones) {
        super(nombre, cantidad, fechaInicio, fechaFin, luminosidad, dosisComida);
       
        this.polaciones = new Poblacion[0];
    }
    
    // Define the missing constructor in the Poblacion class
    public Experimento(String nombre, Date fechaInicio, Date fechaFin, double temperatura, Luminosidad luminosidad, int numBacterias, Dosis dosisComida) {
        super(nombre, numBacterias, fechaInicio, fechaFin, luminosidad, dosisComida);
        // Constructor implementation
    }
}
