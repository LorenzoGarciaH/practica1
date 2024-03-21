public class Laboratorio implements {
    public static void main(String[] args) {
        // Crear una población
        Poblacion poblacion = new Poblacion("Población 1", 100);
        poblacion.setLuminosidad(Luminosidad.ALTA);
        poblacion.setDosis(new Dosis());
        
        // Crear un experimento
        Experimento experimento = new Experimento();
        experimento.setNombre("Experimento 1");
        experimento.setLuminosidad(Luminosidad.ALTA);
        experimento.setDosisComida(new Dosis());
        experimento.setPoblaciones(new Poblacion[] {poblacion});
        
        // Mostrar los datos del experimento
        System.out.println("Nombre del experimento: " + experimento.getNombre());
        System.out.println("Luminosidad del experimento: " + experimento.getLuminosidad());
        System.out.println("Dosis de comida del experimento: " + experimento.getDosisComida());
        System.out.println("Número de poblaciones del experimento: " + experimento.getPoblaciones().length);
    }
}
