import java.util.ArrayList;

public class FilaDeProcessos {
    private ArrayList<Processo> fila;
    private int proximoPid;

    public FilaDeProcessos() {
        this.fila = new ArrayList<>();
        this.proximoPid = 1;
    }

    // Adiciona um processo à fila
    public void adicionarProcesso(String nome) {
        Processo processo = new Processo(nome, proximoPid++);
        fila.add(processo);
        System.out.println(processo + " adicionado à fila de processos.");
    }

    // Remove o processo mais antigo da fila para execução
    public void executarProximoProcesso() {
        if (fila.isEmpty()) {
            System.out.println("Nenhum processo na fila.");
        } else {
            Processo proximoProcesso = fila.remove(0); // Remove o primeiro processo da fila
            System.out.println("Executando " + proximoProcesso + "...");
        }
    }

    // Exibe todos os processos na fila
    public void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("A fila de processos está vazia.");
        } else {
            System.out.println("Processos na fila:");
            for (Processo processo : fila) {
                System.out.println(processo);
            }
        }
    }
}
