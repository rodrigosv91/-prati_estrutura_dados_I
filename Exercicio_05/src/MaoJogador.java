public class MaoJogador {
    private CartaNodo primeiraCarta;
    private CartaNodo ultimaCarta;

    public MaoJogador() {
        this.primeiraCarta = null;
        this.ultimaCarta = null;
    }

    // Adiciona uma carta à mão do jogador
    public void adicionarCarta(Carta carta) {
        CartaNodo novoNodo = new CartaNodo(carta);
        if (ultimaCarta == null) {
            primeiraCarta = novoNodo;
            ultimaCarta = novoNodo;
        } else {
            ultimaCarta.setProximo(novoNodo);
            novoNodo.setAnterior(ultimaCarta);
            ultimaCarta = novoNodo;
        }
    }

    // Remove uma carta da mão do jogador pela posição
    public void removerCarta(int posicao) {
        CartaNodo nodoAtual = primeiraCarta;
        int posicaoAtual = 1;

        while (nodoAtual != null) {
            if (posicaoAtual == posicao) {
                if (nodoAtual == primeiraCarta) {
                    primeiraCarta = nodoAtual.getProximo();
                    if (primeiraCarta != null) {
                        primeiraCarta.setAnterior(null);
                    } else {
                        ultimaCarta = null; // Lista ficou vazia
                    }
                } else if (nodoAtual == ultimaCarta) {
                    ultimaCarta = nodoAtual.getAnterior();
                    ultimaCarta.setProximo(null);
                } else {
                    nodoAtual.getAnterior().setProximo(nodoAtual.getProximo());
                    nodoAtual.getProximo().setAnterior(nodoAtual.getAnterior());
                }
                System.out.println("Carta removida: " + nodoAtual.getCarta());
                return;
            }
            posicaoAtual++;
            nodoAtual = nodoAtual.getProximo();
        }
        System.out.println("Posição não encontrada.");
    }

    // Move uma carta para uma nova posição (direita, esquerda, início, fim)
    public void moverCarta(int posicao, String direcao) {
        CartaNodo nodoAtual = primeiraCarta;
        int posicaoAtual = 1;

        while (nodoAtual != null) {
            if (posicaoAtual == posicao) {
                if (direcao.equalsIgnoreCase("direita")) {
                    if (nodoAtual.getProximo() != null) {
                        moverParaDireita(nodoAtual);
                    } else {
                        System.out.println("Não é possível mover para a direita, já está na última posição.");
                    }
                } else if (direcao.equalsIgnoreCase("esquerda")) {
                    if (nodoAtual.getAnterior() != null) {
                        if (nodoAtual.getAnterior() == primeiraCarta) {
                            System.out.println("Não é possível mover para a esquerda, já está na primeira posição.");
                        } else {
                            moverParaEsquerda(nodoAtual);
                        }
                    } else {
                        System.out.println("Não é possível mover para a esquerda, já está na primeira posição.");
                    }
                } else if (direcao.equalsIgnoreCase("inicio")) {
                    if (nodoAtual == primeiraCarta) {
                        System.out.println("A carta já está no início.");
                    } else {
                        moverParaInicio(nodoAtual);
                    }
                } else if (direcao.equalsIgnoreCase("fim")) {
                    if (nodoAtual == ultimaCarta) {
                        System.out.println("A carta já está no fim.");
                    } else {
                        moverParaFim(nodoAtual);
                    }
                } else {
                    System.out.println("Direção inválida.");
                }
                return;
            }
            posicaoAtual++;
            nodoAtual = nodoAtual.getProximo();
        }
        System.out.println("Posição não encontrada.");
    }

    private void moverParaDireita(CartaNodo nodoAtual) {
        CartaNodo nodoProximo = nodoAtual.getProximo();
        if (nodoProximo == null) {
            System.out.println("Não há carta para a direita.");
            return;
        }

        // Remove o nodoAtual da posição atual
        if (nodoAtual == primeiraCarta) {
            primeiraCarta = nodoProximo;
        } else {
            nodoAtual.getAnterior().setProximo(nodoProximo);
        }
        nodoProximo.setAnterior(nodoAtual.getAnterior());

        // Adiciona o nodoAtual após o nodoProximo
        nodoAtual.setProximo(nodoProximo.getProximo());
        if (nodoProximo.getProximo() != null) {
            nodoProximo.getProximo().setAnterior(nodoAtual);
        } else {
            ultimaCarta = nodoAtual;
        }
        nodoAtual.setAnterior(nodoProximo);
        nodoProximo.setProximo(nodoAtual);

        System.out.println("Carta movida para a direita: " + nodoAtual.getCarta());
    }

    private void moverParaEsquerda(CartaNodo nodoAtual) {
        CartaNodo nodoAnterior = nodoAtual.getAnterior();
        if (nodoAnterior == null) {
            System.out.println("Não há carta para a esquerda.");
            return;
        }

        // Remove o nodoAtual da posição atual
        if (nodoAtual == ultimaCarta) {
            ultimaCarta = nodoAnterior;
            ultimaCarta.setProximo(null);
        } else {
            nodoAtual.getProximo().setAnterior(nodoAnterior);
        }
        nodoAnterior.setProximo(nodoAtual.getProximo());

        // Adiciona o nodoAtual antes do nodoAnterior
        nodoAtual.setProximo(nodoAnterior);
        nodoAtual.setAnterior(nodoAnterior.getAnterior());
        if (nodoAnterior.getAnterior() != null) {
            nodoAnterior.getAnterior().setProximo(nodoAtual);
        } else {
            primeiraCarta = nodoAtual;
        }
        nodoAnterior.setAnterior(nodoAtual);

        System.out.println("Carta movida para a esquerda: " + nodoAtual.getCarta());
    }

    private void moverParaInicio(CartaNodo nodoAtual) {
        if (nodoAtual == primeiraCarta) {
            System.out.println("A carta já está no início.");
            return;
        }

        // Remove o nodoAtual da posição atual
        if (nodoAtual == ultimaCarta) {
            ultimaCarta = nodoAtual.getAnterior();
            ultimaCarta.setProximo(null);
        } else {
            nodoAtual.getAnterior().setProximo(nodoAtual.getProximo());
            nodoAtual.getProximo().setAnterior(nodoAtual.getAnterior());
        }

        // Adiciona o nodoAtual ao início
        nodoAtual.setProximo(primeiraCarta);
        nodoAtual.setAnterior(null);
        if (primeiraCarta != null) {
            primeiraCarta.setAnterior(nodoAtual);
        }
        primeiraCarta = nodoAtual;

        System.out.println("Carta movida para o início: " + nodoAtual.getCarta());
    }

    private void moverParaFim(CartaNodo nodoAtual) {
        if (nodoAtual == ultimaCarta) {
            System.out.println("A carta já está no fim.");
            return;
        }

        // Remove o nodoAtual da posição atual
        if (nodoAtual == primeiraCarta) {
            primeiraCarta = nodoAtual.getProximo();
            primeiraCarta.setAnterior(null);
        } else {
            nodoAtual.getAnterior().setProximo(nodoAtual.getProximo());
            nodoAtual.getProximo().setAnterior(nodoAtual.getAnterior());
        }

        // Adiciona o nodoAtual ao fim
        nodoAtual.setProximo(null);
        nodoAtual.setAnterior(ultimaCarta);
        if (ultimaCarta != null) {
            ultimaCarta.setProximo(nodoAtual);
        }
        ultimaCarta = nodoAtual;

        System.out.println("Carta movida para o fim: " + nodoAtual.getCarta());
    }

    // Exibe todas as cartas na mão do jogador
    public void exibirMao() {
        CartaNodo nodoAtual = primeiraCarta;
        int posicaoAtual = 1;
        System.out.println("Mão do jogador:");

        while (nodoAtual != null) {
            System.out.println("Posição " + posicaoAtual + ": " + nodoAtual.getCarta());
            posicaoAtual++;
            nodoAtual = nodoAtual.getProximo();
        }
    }
}
