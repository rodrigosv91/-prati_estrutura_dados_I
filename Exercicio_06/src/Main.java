import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilaAtendimento filaAtendimento = new FilaAtendimento();
        Scanner scanner = new Scanner(System.in);
        String comando;

        System.out.println("Simulador de Fila de Atendimento - Banco");
        System.out.println("Adicionar cliente (adicionar, add, 1)");
        System.out.println("Chamar próximo cliente (chamar, call, 2)");
        System.out.println("Exibir fila (exibir, show, 3)");
        System.out.println("Sair (sair, exit, 4)");

        do {
            System.out.print("Digite um comando: ");
            comando = scanner.nextLine().trim().toLowerCase();

            switch (comando) {
                case "adicionar", "add", "1":
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    filaAtendimento.adicionarCliente(nome);
                    break;
                case "chamar", "call", "2":
                    filaAtendimento.chamarProximoCliente();
                    break;
                case "exibir", "show", "3":
                    filaAtendimento.exibirFila();
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
