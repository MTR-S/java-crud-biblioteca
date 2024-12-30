package bibliotecaV3.commands;

import bibliotecaV3.model.Livro;
import bibliotecaV3.services.LivroService;

import java.util.Scanner;

public class DevolveLivroCommand implements Command {

    @Override
    public void executa() {
        System.out.println("Digite o código do livro a ser devolvido: ");
        Scanner scanner = new Scanner(System.in);

        String codigoDoLivroDevolvido = scanner.nextLine();
        try {
            LivroService livroService = new LivroService();
            Livro livroDevolvido = livroService.efetuaDevolucaoDoLivro(codigoDoLivroDevolvido);

            System.out.println("Livro " + livroDevolvido.getTitulo() + " devolvido!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
