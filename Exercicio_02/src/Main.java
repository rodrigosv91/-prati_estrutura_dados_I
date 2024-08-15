import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tamanho máximo do histórico:");
        int tamanhoMaximo = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        GerenciadorHistorico gerenciador = new GerenciadorHistorico(tamanhoMaximo);
        String comando;

        do {
            System.out.println("Digite um comando (adicionar, listar, sair):");
            comando = scanner.nextLine();

            switch (comando.toLowerCase()) {
                case "adicionar", "add":
                    System.out.println("Digite a URL a ser adicionada:");
                    String url = scanner.nextLine();
                    gerenciador.adicionarUrl(url);
                    break;
                case "listar":
                    gerenciador.listarHistorico();
                    break;
                case "sair":
                    System.out.println("Encerrando o gerenciador de histórico.");
                    break;
                default:
                    System.out.println("Comando não reconhecido.");
            }
        } while (!comando.equalsIgnoreCase("sair"));

        scanner.close();
    }
}
