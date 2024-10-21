import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int numeroDeProcesos = 5;
        Proceso[] procesos = new Proceso[numeroDeProcesos];

        for (int i = 0; i < numeroDeProcesos; i++) {
            String nombre = "P" + (i + 1);
            int rafaga = random.nextInt(10) + 1;
            int llegada = random.nextInt(10);
            int prioridad = random.nextInt(5) + 1;
            procesos[i] = new Proceso(nombre, rafaga, llegada, prioridad);
        }

        FIFO fifo = new FIFO();
        SJF sjf = new SJF();
        Prioridad prioridad = new Prioridad();
        RoundRobin rr = new RoundRobin();

        System.out.println("=== FIFO ===");
        fifo.ejecutar(procesos);
        double fifoEspera = fifo.calcularTiempoEsperaMedio(procesos);
        double fifoRetorno = fifo.calcularTiempoRetornoMedio(procesos);

        System.out.println("\n=== SJF ===");
        sjf.ejecutar(procesos);
        double sjfEspera = sjf.calcularTiempoEsperaMedio(procesos);
        double sjfRetorno = sjf.calcularTiempoRetornoMedio(procesos);

        System.out.println("\n=== Prioridad ===");
        prioridad.ejecutar(procesos);
        double prioridadEspera = prioridad.calcularTiempoEsperaMedio(procesos);
        double prioridadRetorno = prioridad.calcularTiempoRetornoMedio(procesos);

        System.out.println("\n=== Round Robin ===");
        rr.ejecutar(procesos, 2); // Quantum de 2
        double rrEspera = rr.calcularTiempoEsperaMedio(procesos);
        double rrRetorno = rr.calcularTiempoRetornoMedio(procesos);

        double mejorEspera = Math.min(Math.min(fifoEspera, sjfEspera), Math.min(prioridadEspera, rrEspera));
        double mejorRetorno = Math.min(Math.min(fifoRetorno, sjfRetorno), Math.min(prioridadRetorno, rrRetorno));

        System.out.println("\n=== Análisis de eficiencia ===");
        if (fifoEspera == mejorEspera) {
            System.out.println("FIFO tiene el menor tiempo medio de espera.");
        } else if (sjfEspera == mejorEspera) {
            System.out.println("SJF tiene el menor tiempo medio de espera.");
        } else if (prioridadEspera == mejorEspera) {
            System.out.println("Prioridad tiene el menor tiempo medio de espera.");
        } else {
            System.out.println("Round Robin tiene el menor tiempo medio de espera.");
        }

        if (fifoRetorno == mejorRetorno) {
            System.out.println("FIFO tiene el menor tiempo medio de retorno.");
        } else if (sjfRetorno == mejorRetorno) {
            System.out.println("SJF tiene el menor tiempo medio de retorno.");
        } else if (prioridadRetorno == mejorRetorno) {
            System.out.println("Prioridad tiene el menor tiempo medio de retorno.");
        } else {
            System.out.println("Round Robin tiene el menor tiempo medio de retorno.");
        }
    }
}