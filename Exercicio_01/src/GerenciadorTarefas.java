public class GerenciadorTarefas {
    private Tarefa primeira;

    public GerenciadorTarefas() {
        this.primeira = null;
    }

    // Adiciona uma nova tarefa à lista
    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        if (primeira == null) {
            primeira = novaTarefa;
        } else {
            Tarefa atual = primeira;
            while (atual.getProxima() != null) {
                atual = atual.getProxima();
            }
            atual.setProxima(novaTarefa);
        }
    }

    // Remove uma tarefa pelo ID
    public void removerTarefa(int id) {
        if (primeira == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        if (primeira.getId() == id) {
            primeira = primeira.getProxima();
            return;
        }

        Tarefa anterior = null;
        Tarefa atual = primeira;

        while (atual != null && atual.getId() != id) {
            anterior = atual;
            atual = atual.getProxima();
        }

        if (atual != null) {
            anterior.setProxima(atual.getProxima());
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    // Marca uma tarefa como concluída pelo ID
    public void marcarConcluida(int id) {
        Tarefa atual = primeira;
        while (atual != null) {
            if (atual.getId() == id) {
                atual.marcarConcluida();
                return;
            }
            atual = atual.getProxima();
        }
        System.out.println("Tarefa não encontrada.");
    }

    // Exibe todas as tarefas
    public void listarTarefas() {
        if (primeira == null) {
            System.out.println("A lista de tarefas está vazia.");
            return;
        }

        Tarefa atual = primeira;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.getProxima();
        }
    }
}
