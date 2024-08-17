public class Processo {
    private String nome;
    private int pid;

    public Processo(String nome, int pid) {
        this.nome = nome;
        this.pid = pid;
    }

    public String getNome() {
        return nome;
    }

    public int getPid() {
        return pid;
    }

    @Override
    public String toString() {
        return "Processo: " + nome + " | PID: " + pid;
    }
}
