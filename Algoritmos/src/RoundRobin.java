import java.util.Arrays;

public class RoundRobin extends Planificador {

    public void ejecutar(Proceso[] procesos, int quantum) {
        System.out.println("\nRound Robin:");
        int[] remanente = Arrays.stream(procesos).mapToInt(p -> p.rafaga).toArray(); // Ráfagas restantes
        int tiempo = 0;
        boolean completado;

        do {
            completado = true;
            for (int i = 0; i < procesos.length; i++) {
                if (remanente[i] > 0) {
                    completado = false;
                    if (remanente[i] > quantum) {
                        tiempo += quantum;
                        remanente[i] -= quantum;
                    } else {
                        tiempo += remanente[i];
                        remanente[i] = 0;
                    }
                }
            }
        } while (!completado);

        imprimirResultados(procesos, true);
    }
}

