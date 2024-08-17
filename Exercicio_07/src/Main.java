import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilaImpressao filaImpressao = new FilaImpressao();
        Scanner scanner = new Scanner(System.in);
        String comando;

        System.out.println("Sistema de Gerenciamento de Impressões");
        System.out.println("Adicionar trabalho de impressão (adicionar, add, 1)");
        System.out.println("Processar próximo trabalho (processar, proc, 2)");
        System.out.println("Exibir fila de impressão (exibir, show, 3)");
        System.out.println("Sair (sair, exit, 4)");

        do {
            System.out.print("Digite um comando: ");
            comando = scanner.nextLine().trim().toLowerCase();

            switch (comando) {
                case "adicionar", "add", "1":
                    System.out.print("Digite o nome do documento: ");
                    String nomeDocumento = scanner.nextLine();
                    System.out.print("Digite o número de páginas: ");
                    int numeroPaginas = scanner.nextInt();
                    scanner.nextLine();  // Limpar o buffer
                    filaImpressao.adicionarTrabalho(nomeDocumento, numeroPaginas);
                    break;
                case "processar", "proc", "2":
                    filaImpressao.processarProximoTrabalho();
                    break;
                case "exibir", "show", "3":
                    filaImpressao.exibirFila();
                    break;
                case "sair", "exit", "4":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Comando inválido. Tente novamente.");
            }
        } while (!comando.equals("sair") && !comando.equals("exit") && !comando.equals("4"));

        scanner.close();
    }
}
