import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaoJogador mao = new MaoJogador();
        boolean rodando = true;

        while (rodando) {
            System.out.println("\nDigite um comando (adicionar (1), remover (2), mover (3), exibir (4), sair (5)):");
            String comando = scanner.nextLine().trim().toLowerCase();

            switch (comando) {
                case "adicionar", "add", "1":
                    System.out.println("Digite o valor da carta:");
                    String valor = scanner.nextLine().trim();
                    System.out.println("Digite o naipe da carta:");
                    String naipe = scanner.nextLine().trim();
                    mao.adicionarCarta(new Carta(valor, naipe));
                    System.out.println("Carta adicionada.");
                    break;

                case "remover", "2":
                    mao.exibirMao();
                    System.out.println("Digite a posição da carta a ser removida:");
                    int posicaoRemover = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha
                    mao.removerCarta(posicaoRemover);
                    break;

                case "mover", "3":
                    mao.exibirMao();
                    System.out.println("Digite a posição da carta a ser movida:");
                    int posicaoMover = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha
                    System.out.println("Digite a direção para mover (direita, esquerda, inicio, fim):");
                    String direcao = scanner.nextLine().trim().toLowerCase();
                    mao.moverCarta(posicaoMover, direcao);
                    break;

                case "exibir", "e","4":
                    mao.exibirMao();
                    break;

                case "sair", "5":
                    rodando = false;
                    System.out.println("Saindo do jogo.");
                    break;

                default:
                    System.out.println("Comando inválido.");
                    break;
            }
        }

        scanner.close();
    }
}
