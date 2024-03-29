package Manejo;
import java.util.*;
public class Experimento extends Poblacion {
    private ArrayList<Poblacion> polaciones;
        
    public Experimento(String nombre, int cantidad, Date fechaInicio, Date fechaFin, Luminosidad luminosidad, int dosisComida, ArrayList<Poblacion> polaciones) {
        super(nombre, cantidad, fechaInicio, fechaFin, luminosidad, dosisComida);
        this.polaciones = new ArrayList<>();
    }
    public ArrayList<Poblacion> getPoblaciones() {
        return polaciones;
    }

    public void setPoblaciones(ArrayList<Poblacion> poblaciones) {
        this.polaciones = poblaciones;
    }

    public void agregarPoblacion(Poblacion poblacion) {
        polaciones.add(poblacion);
    }
    public void eliminarPoblacion(Poblacion poblacion) {
        polaciones.remove(poblacion);
    }
}
