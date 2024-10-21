import java.util.Arrays;

public class SJF extends Planificador {

    public void ejecutar(Proceso[] procesos) {
        System.out.println("\nSJF:");
        Arrays.sort(procesos, (a, b) -> Integer.compare(a.rafaga, b.rafaga));
        imprimirResultados(procesos, false);
    }
}

