package Manejo;
import java.util.*;

public class Poblacion{
    // Atributos de la clase Poblacion
    private String nombre;
    private int cantidad;
    private Date fechaInicio;
    private Date fechaFin;
    private Luminosidad luminosidad;
    private int dosisComida;
    
    // Constructor de la clase Poblacion
    public Poblacion(String nombre, int cantidad, Date fechaInicio, Date fechaFin, Luminosidad luminosidad, int dosisComida) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.luminosidad = luminosidad;
        this.dosisComida = dosisComida;
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

    public int getDosis() {
        return dosisComida;
    }

    public void setDosis(int dosis) {
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
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", cantidad=" + cantidad +
                ", luminosidad=" + luminosidad +
                ", dosisComida=" + dosisComida +
                '}';
    }
}
