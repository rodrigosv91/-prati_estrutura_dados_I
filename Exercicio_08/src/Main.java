import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilaDeProcessos filaDeProcessos = new FilaDeProcessos();
        Scanner scanner = new Scanner(System.in);
        String comando;

        System.out.println("Simulador de Fila de Processos");
        System.out.println("Adicionar processo (adicionar, add, 1)");
        System.out.println("Executar próximo processo (executar, exec, 2)");
        System.out.println("Exibir fila de processos (exibir, show, 3)");
        System.out.println("Sair (sair, exit, 4)");

        do {
            System.out.print("Digite um comando: ");
            comando = scanner.nextLine().trim().toLowerCase();

            switch (comando) {
                case "adicionar", "add", "1":
                    System.out.print("Digite o nome do processo: ");
                    String nomeProcesso = scanner.nextLine();
                    filaDeProcessos.adicionarProcesso(nomeProcesso);
                    break;
                case "executar", "exec", "2":
                    filaDeProcessos.executarProximoProcesso();
                    break;
                case "exibir", "show", "3":
                    filaDeProcessos.exibirFila();
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
