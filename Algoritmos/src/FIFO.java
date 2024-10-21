public class FIFO extends Planificador {

    public void ejecutar(Proceso[] procesos) {
        System.out.println("FIFO:");
        imprimirResultados(procesos, false);
    }
}
