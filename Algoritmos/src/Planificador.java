public class Planificador {

    public double calcularTiempoEsperaMedio(Proceso[] procesos) {
        int tiempoEsperaTotal = 0;
        int[] tiemposFinalizacion = calcularTiemposFinalizacion(procesos);

        for (int i = 0; i < procesos.length; i++) {
            int tiempoEspera = tiemposFinalizacion[i] - procesos[i].llegada - procesos[i].rafaga;
            tiempoEsperaTotal += tiempoEspera;
        }

        return (double) tiempoEsperaTotal / procesos.length;
    }

    public double calcularTiempoRetornoMedio(Proceso[] procesos) {
        int tiempoRetornoTotal = 0;
        int[] tiemposFinalizacion = calcularTiemposFinalizacion(procesos);

        for (int i = 0; i < procesos.length; i++) {
            int tiempoRetorno = tiemposFinalizacion[i] - procesos[i].llegada;
            tiempoRetornoTotal += tiempoRetorno;
        }

        return (double) tiempoRetornoTotal / procesos.length;
    }

    private int[] calcularTiemposFinalizacion(Proceso[] procesos) {
        int[] tiemposFinalizacion = new int[procesos.length];
        int tiempo = 0;

        for (int i = 0; i < procesos.length; i++) {
            tiempo += procesos[i].rafaga;
            tiemposFinalizacion[i] = tiempo;
        }

        return tiemposFinalizacion;
    }

    public void imprimirResultados(Proceso[] procesos, boolean mostrarPrioridad) {
        if (mostrarPrioridad) {
            System.out.printf("%-8s %-8s %-8s %-8s\n", "Proceso", "Ráfaga", "Llegada", "Prioridad");
        } else {
            System.out.printf("%-8s %-8s %-8s\n", "Proceso", "Ráfaga", "Llegada");
        }

        for (Proceso proceso : procesos) {
            System.out.println(proceso.toString(mostrarPrioridad));
        }

        double tiempoEsperaMedio = calcularTiempoEsperaMedio(procesos);
        double tiempoRetornoMedio = calcularTiempoRetornoMedio(procesos);

        System.out.printf("\nTiempo medio de espera: %.2f\n", tiempoEsperaMedio);
        System.out.printf("Tiempo medio de retorno: %.2f\n", tiempoRetornoMedio);
    }
}