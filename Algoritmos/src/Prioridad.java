import java.util.Arrays;

public class Prioridad extends Planificador {

    public void ejecutar(Proceso[] procesos) {
        System.out.println("\nPrioridad:");
        Arrays.sort(procesos, (a, b) -> {
            if (a.llegada == b.llegada) {
                return Integer.compare(b.prioridad, a.prioridad);
            }
            return Integer.compare(a.llegada, b.llegada);
        });

        imprimirResultados(procesos, true);
    }
}
