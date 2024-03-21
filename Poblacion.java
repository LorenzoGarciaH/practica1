import java.util.*;

public class Poblacion extends Experimento{
    // Atributos de la clase Poblacion
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private int cantidad;
    private Luminosidad luminosidad;
    private Dosis dosisComida;

    // Constructor de la clase Poblacion
    public Poblacion(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaInicio = new Date();
        this.fechaFin = new Date();
    }

    // Métodos getter y setter para los atributos
    public String getNombre() {
        return nombre;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Luminosidad getLuminosidad() {
        return luminosidad;
    }

    public void setLuminosidad(Luminosidad luminosidad) {
        this.luminosidad = luminosidad;
    }

    public Dosis getDosis() {
        return dosisComida;
    }

    public void setDosis(Dosis dosis) {
        this.dosisComida = dosis;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método toString para representar la clase como una cadena de texto
    @Override
    public String toString() {
        return "Poblacion{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad + 
                '}';
    }
}
