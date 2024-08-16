public class TextoNodo {
    private String texto;
    private TextoNodo anterior;
    private TextoNodo proximo;
    private boolean isFinal;

    public TextoNodo(String texto) {
        this.texto = texto;
        this.anterior = null;
        this.proximo = null;
        this.isFinal = false;
    }

    public String getTexto() {
        return texto;
    }

    public TextoNodo getAnterior() {
        return anterior;
    }

    public void setAnterior(TextoNodo anterior) {
        this.anterior = anterior;
    }

    public TextoNodo getProximo() {
        return proximo;
    }

    public void setProximo(TextoNodo proximo) {
        this.proximo = proximo;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }
}
