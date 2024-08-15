import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        Scanner scanner = new Scanner(System.in);
        String comando;

        do {
            System.out.println("Digite um comando (adicionar, remover, concluir, listar, sair):");
            comando = scanner.nextLine();

            switch (comando.toLowerCase()) {
                case "adicionar", "add":
                    System.out.println("Digite a descrição da tarefa:");
                    String descricao = scanner.nextLine();
                    gerenciador.adicionarTarefa(descricao);
                    break;
                case "remover":
                    System.out.println("Digite o ID da tarefa a ser removida:");
                    int idRemover = scanner.nextInt();
                    gerenciador.removerTarefa(idRemover);
                    scanner.nextLine(); // Consumir a nova linha
                    break;
                case "concluir":
                    System.out.println("Digite o ID da tarefa a ser concluída:");
                    int idConcluir = scanner.nextInt();
                    gerenciador.marcarConcluida(idConcluir);
                    scanner.nextLine(); // Consumir a nova linha
                    break;
                case "listar":
                    gerenciador.listarTarefas();
                    break;
                case "sair":
                    System.out.println("Encerrando o gerenciador de tarefas.");
                    break;
                default:
                    System.out.println("Comando não reconhecido.");
            }
        } while (!comando.equalsIgnoreCase("sair"));

        scanner.close();
    }
}
