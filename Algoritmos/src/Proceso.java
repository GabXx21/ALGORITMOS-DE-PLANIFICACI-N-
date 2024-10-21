public class Proceso {
    String nombre;
    int rafaga;
    int llegada;
    int prioridad;

    public Proceso(String nombre, int rafaga, int llegada, int prioridad) {
        this.nombre = nombre;
        this.rafaga = rafaga;
        this.llegada = llegada;
        this.prioridad = prioridad;
    }

    public String toString(boolean mostrarPrioridad) {
        if (mostrarPrioridad) {
            return String.format("%-8s %-8d %-8d %-8d", nombre, rafaga, llegada, prioridad);
        } else {
            return String.format("%-8s %-8d %-8d", nombre, rafaga, llegada);
        }
    }
}
