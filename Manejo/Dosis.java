package Manejo;
public class Dosis {
    private int cantidadInicial;
    private int cantidadIncrementoMax;
    private int cantidadFinal;
    private int diasIncremento;
    
    public Dosis(int cantidadInicial, int cantidadIncrementoMax, int cantidadFinal, int diasIncremento) {
        this.cantidadInicial = cantidadInicial;
        this.cantidadIncrementoMax = cantidadIncrementoMax;
        this.cantidadFinal = cantidadFinal;
        this.diasIncremento = diasIncremento;
    }
    // Getters
    public int getCantidadInicial() {
        return cantidadInicial;
    }

    public int getCantidadIncrementoMax() {
        return cantidadIncrementoMax;
    }

    public int getCantidadFinal() {
        return cantidadFinal;
    }

    public int getDiasIncremento() {
        return diasIncremento;
    }

    // Setters
    public void setCantidadInicial(int cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public void setCantidadIncrementoMax(int cantidadIncrementoMax) {
        this.cantidadIncrementoMax = cantidadIncrementoMax;
    }

    public void setCantidadFinal(int cantidadFinal) {
        this.cantidadFinal = cantidadFinal;
    }

    public void setDiasIncremento(int diasIncremento) {
        this.diasIncremento = diasIncremento;
    }


    public void calcularDosisDiaria(Dosis newdosis) {
        int comida = 0;
        int pendienteIncremento = (cantidadIncrementoMax - cantidadInicial) / diasIncremento;
        int pendienteDecremento = (cantidadIncrementoMax - cantidadFinal) / (30-diasIncremento);
        for(int dias = 0; dias < 30; dias++){
            if(dias<=diasIncremento){
                comida = cantidadInicial + pendienteIncremento * dias;
            }else{
                comida = cantidadIncrementoMax + pendienteDecremento * (dias-diasIncremento);
            }
        }
    }
}
