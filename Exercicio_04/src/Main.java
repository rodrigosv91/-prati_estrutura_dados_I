import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        Scanner scanner = new Scanner(System.in);
        String comando;

        do {
            System.out.println("Digite um comando (adicionar (1), desfazer (2), refazer (3), exibir (4), sair (5)):");
            comando = scanner.nextLine();

            switch (comando.toLowerCase()) {
                case "adicionar", "add", "1":
                    System.out.println("Digite o texto a ser adicionado:");
                    String textoAdicionar = scanner.nextLine();
                    editor.adicionarTexto(textoAdicionar);
                    break;
                case "desfazer", "undo", "2":
                    editor.desfazer();
                    break;
                case "refazer", "redo", "3":
                    editor.refazer();
                    break;
                case "exibir", "show","e", "4":
                    editor.exibirTexto();
                    break;
                case "sair", "exit", "5":
                    System.out.println("Encerrando o editor de texto.");
                    break;
                default:
                    System.out.println("Comando não reconhecido.");
            }
        } while (!comando.equalsIgnoreCase("sair") && !comando.equals("5"));

        scanner.close();
    }
}
