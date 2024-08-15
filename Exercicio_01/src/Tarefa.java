public class Tarefa {
    private static int contadorId = 0;
    private int id;
    private String descricao;
    private boolean concluida;
    private Tarefa proxima;

    public Tarefa(String descricao) {
        this.id = ++contadorId;
        this.descricao = descricao;
        this.concluida = false;
        this.proxima = null;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarConcluida() {
        this.concluida = true;
    }

    public Tarefa getProxima() {
        return proxima;
    }

    public void setProxima(Tarefa proxima) {
        this.proxima = proxima;
    }

    @Override
    public String toString() {
        return "ID: " + id + " - " + descricao + (concluida ? " (Concluída)" : " (Pendente)");
    }
}
