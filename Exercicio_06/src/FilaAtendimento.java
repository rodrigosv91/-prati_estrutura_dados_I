import java.util.ArrayList;

public class FilaAtendimento {
    private ArrayList<Cliente> fila;
    private int proximaSenha;

    public FilaAtendimento() {
        this.fila = new ArrayList<>();
        this.proximaSenha = 1;
    }

    // Adiciona um cliente à fila
    public void adicionarCliente(String nome) {
        Cliente cliente = new Cliente(nome, proximaSenha++);
        fila.add(cliente);
        System.out.println(cliente + " adicionado à fila.");
    }

    // Chama o próximo cliente na fila
    public void chamarProximoCliente() {
        if (fila.isEmpty()) {
            System.out.println("Nenhum cliente na fila.");
        } else {
            Cliente proximoCliente = fila.remove(0); // Remove o primeiro cliente
            System.out.println("Chamando " + proximoCliente + " para atendimento.");
        }
    }

    // Exibe todos os clientes na fila
    public void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Clientes na fila:");
            for (Cliente cliente : fila) {
                System.out.println(cliente);
            }
        }
    }
}
