public class HistoricoNavegacao {
    private String url;
    private HistoricoNavegacao proxima;

    public HistoricoNavegacao(String url) {
        this.url = url;
        this.proxima = null;
    }

    public String getUrl() {
        return url;
    }

    public HistoricoNavegacao getProxima() {
        return proxima;
    }

    public void setProxima(HistoricoNavegacao proxima) {
        this.proxima = proxima;
    }

    @Override
    public String toString() {
        return url;
    }
}
