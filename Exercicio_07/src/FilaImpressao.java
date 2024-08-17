import java.util.ArrayList;

public class FilaImpressao {
    private ArrayList<TrabalhoDeImpressao> fila;

    public FilaImpressao() {
        this.fila = new ArrayList<>();
    }

    // Adiciona um trabalho de impressão à fila
    public void adicionarTrabalho(String nomeDocumento, int numeroPaginas) {
        TrabalhoDeImpressao trabalho = new TrabalhoDeImpressao(nomeDocumento, numeroPaginas);
        fila.add(trabalho);
        System.out.println(trabalho + " adicionado à fila de impressão.");
    }

    // Processa o próximo trabalho de impressão na fila
    public void processarProximoTrabalho() {
        if (fila.isEmpty()) {
            System.out.println("Nenhum trabalho de impressão na fila.");
        } else {
            TrabalhoDeImpressao proximoTrabalho = fila.remove(0); // Remove o primeiro trabalho da fila
            System.out.println("Processando " + proximoTrabalho + "...");
        }
    }

    // Exibe todos os trabalhos de impressão na fila
    public void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("A fila de impressão está vazia.");
        } else {
            System.out.println("Trabalhos de impressão na fila:");
            for (TrabalhoDeImpressao trabalho : fila) {
                System.out.println(trabalho);
            }
        }
    }
}
