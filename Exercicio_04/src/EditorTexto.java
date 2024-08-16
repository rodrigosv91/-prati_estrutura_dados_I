public class EditorTexto {
    private TextoNodo nodoInicio;
    private TextoNodo nodoFinal;

    public EditorTexto() {
        this.nodoInicio = null;
        this.nodoFinal = null;
    }

    // Adiciona um novo trecho de texto no final da lista
    public void adicionarTexto(String texto) {
        TextoNodo novoNodo = new TextoNodo(texto);

        if (nodoFinal == null) {
            nodoInicio = novoNodo;
            nodoFinal = novoNodo;
        } else {
            nodoFinal.setProximo(novoNodo);
            novoNodo.setAnterior(nodoFinal);
            nodoFinal.setFinal(false);
            nodoFinal = novoNodo;
        }

        nodoFinal.setFinal(true);
    }

    // Desfaz a última ação, movendo o nodoFinal para o anterior ou deixando a lista vazia se só há um nodo
    public void desfazer() {
        if (nodoFinal != null) {
            if (nodoFinal.getAnterior() != null) {
                nodoFinal.setFinal(false);
                nodoFinal = nodoFinal.getAnterior();
                nodoFinal.setFinal(true);
            } else {
                nodoFinal.setFinal(false);
                nodoFinal = null;
                nodoInicio = null;
            }
        } else {
            System.out.println("Nenhuma ação para desfazer.");
        }
    }

    // Refaz a próxima ação, movendo o nodoFinal para o próximo
    public void refazer() {
        if (nodoFinal != null && nodoFinal.getProximo() != null) {
            nodoFinal.setFinal(false);
            nodoFinal = nodoFinal.getProximo();
            nodoFinal.setFinal(true);
        } else {
            System.out.println("Nenhuma ação para refazer.");
        }
    }

    // Exibe o texto completo até o nodo final
    public void exibirTexto() {
        if (nodoInicio == null) {
            System.out.println("Texto atual: ");
            return;
        }

        StringBuilder textoCompleto = new StringBuilder();
        TextoNodo nodo = nodoInicio;

        while (nodo != null) {
            textoCompleto.append(nodo.getTexto());
            if (nodo.isFinal()) {
                break; // Para de exibir quando atingir o nodo final
            }
            nodo = nodo.getProximo();
        }

        System.out.println("Texto atual: " + textoCompleto.toString());
    }
}
