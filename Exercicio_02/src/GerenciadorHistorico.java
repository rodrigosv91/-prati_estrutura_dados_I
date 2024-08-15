public class GerenciadorHistorico {
    private HistoricoNavegacao primeira;
    private int tamanhoMaximo;
    private int tamanhoAtual;

    public GerenciadorHistorico(int tamanhoMaximo) {
        this.primeira = null;
        this.tamanhoMaximo = tamanhoMaximo;
        this.tamanhoAtual = 0;
    }

    // Adiciona uma nova URL ao histórico
    public void adicionarUrl(String url) {
        HistoricoNavegacao novaUrl = new HistoricoNavegacao(url);
        if (primeira == null) {
            primeira = novaUrl;
        } else {
            HistoricoNavegacao atual = primeira;
            while (atual.getProxima() != null) {
                atual = atual.getProxima();
            }
            atual.setProxima(novaUrl);
        }
        tamanhoAtual++;

        // Remove a URL mais antiga se o tamanho máximo for excedido
        if (tamanhoAtual > tamanhoMaximo) {
            removerPrimeiraUrl();
        }
    }

    // Remove a primeira URL (mais antiga) do histórico
    private void removerPrimeiraUrl() {
        if (primeira != null) {
            primeira = primeira.getProxima();
            tamanhoAtual--;
        }
    }

    // Exibe todas as URLs do histórico
    public void listarHistorico() {
        if (primeira == null) {
            System.out.println("O histórico está vazio.");
            return;
        }

        HistoricoNavegacao atual = primeira;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.getProxima();
        }
    }
}
