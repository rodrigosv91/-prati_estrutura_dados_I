public class CartaNodo {
    private Carta carta;
    private CartaNodo anterior;
    private CartaNodo proximo;

    public CartaNodo(Carta carta) {
        this.carta = carta;
        this.anterior = null;
        this.proximo = null;
    }

    public Carta getCarta() {
        return carta;
    }

    public CartaNodo getAnterior() {
        return anterior;
    }

    public void setAnterior(CartaNodo anterior) {
        this.anterior = anterior;
    }

    public CartaNodo getProximo() {
        return proximo;
    }

    public void setProximo(CartaNodo proximo) {
        this.proximo = proximo;
    }
}
