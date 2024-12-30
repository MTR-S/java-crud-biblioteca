package bibliotecaV2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BibliotecaV2 {
    private static HashMap<String, LivroV2> acervo = new HashMap<>();
    private static List<EmprestimoV2> emprestimos = new ArrayList<>();
    private static List<EmprestimoV2> historicoDeEmprestimos = new ArrayList<>();
    private static int totalDeLivros = 0;

    public static int getTotalDeLivros() {
        return totalDeLivros;
    }

    public static int addLivro(String codigoDoLivro, LivroV2 novoLivro) {
        LivroV2 livro = acervo.get(codigoDoLivro);

        if(livro!= null) {
            return 1;
        }

        acervo.put(codigoDoLivro, novoLivro);

        BibliotecaV2.totalDeLivros += novoLivro.getQuantidadeExemplares();

        return 0;
    }

    public static LivroV2 buscaLivroPorCodigo(String codigoDoLivro) {
        if (acervo.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");

            return null;
        }

        LivroV2 livro = acervo.get(codigoDoLivro);

        if(livro == null) {
            return null;
        }

        return livro;
    }

    public static void removeLivro(String codigoDoLivro) {
        if (acervo.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");

            return;
        }

        LivroV2 novoLivro = acervo.get(codigoDoLivro);
        BibliotecaV2.totalDeLivros -= novoLivro.getQuantidadeExemplares();

        acervo.remove(codigoDoLivro);

    }

    public static void exibirLivros() {
        if (acervo.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");

            return;
        }

        System.out.println("Livros disponíveis na biblioteca:");
        for (Map.Entry<String, LivroV2> entrada : acervo.entrySet()) {
            System.out.println("Código: " + entrada.getKey() + " - " + entrada.getValue());
        }
    }

    public static EmprestimoV2 registrarNovoEmprestimo(String codigoDoLivro) {
        if (acervo.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");

            return null;
        }

        LivroV2 livro = acervo.get(codigoDoLivro);

        if(livro == null) {
            System.out.println("Não existe livro com esse código no acervo!");

            return null;
        }

        if(livro.getQuantidadeExemplares() == 0 ) {
            System.out.println("Infelizmente não estamos com esse título no acervo nesse momento, tente novamente mais tarde!");

            return null;
        }

        BibliotecaV2.totalDeLivros -= 1;

        String codigoDoEmprestimo = gerarStringAleatoria();
        System.out.println("O código do seu emprestimo é: " + codigoDoEmprestimo);

        livro.setQuantidadeExemplares(livro.getQuantidadeExemplares() - 1);
        EmprestimoV2 novoEmprestimo = new EmprestimoV2(livro, LocalDateTime.now(), codigoDoEmprestimo);

        BibliotecaV2.emprestimos.add(novoEmprestimo);
        BibliotecaV2.historicoDeEmprestimos.add(new EmprestimoV2(livro, novoEmprestimo.getDataEmprestimo(), codigoDoEmprestimo));

        return novoEmprestimo;
    }


    public static int devolverEmprestimo(String codigoDoLivro, String codigoDoEmprestimo) {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum livro emprestado.");

            return 1;
        }

        LivroV2 livro = acervo.get(codigoDoLivro);

        if(livro == null) {
            System.out.println("Não existe livro com esse código no acervo!");

            return 1;
        }


        for(EmprestimoV2 emprestimo : emprestimos) {
            if(emprestimo.getCodigoDoEmprestimo().equals(codigoDoEmprestimo)) {
                emprestimos.remove(emprestimo);

                BibliotecaV2.totalDeLivros += 1;

                livro.setQuantidadeExemplares(livro.getQuantidadeExemplares() + 1);

                return 0;
            }
        }

        return 1;
    }

    public static void exibeEmprestimosAtivos() {
        for (EmprestimoV2 emprestimo:
                emprestimos) {
            System.out.println(emprestimo);
        }
    }

    public static void exibirHistoricoDeEmprestimos() {
        for (EmprestimoV2 emprestimo:
                historicoDeEmprestimos) {
            System.out.print(emprestimo + " Data e Hora: " + emprestimo.getDataEmprestimo());
        }
    }

    public static String gerarStringAleatoria() {
        return UUID.randomUUID().toString().replaceAll("[^A-Z0-9]", "").substring(0, 4);
    }

    public static void exibeEmprestimosPorLivro(String codigoDoLivro) {
        LivroV2 livro = acervo.get(codigoDoLivro);

        if(livro == null) {
            System.out.println("Não existe livro com esse código no acervo!");

            return;
        }

        for (EmprestimoV2 emprestimo:
                emprestimos) {
            if(emprestimo.getLivro().equals(livro)) {
                System.out.println(emprestimo);
            }
        }
    }

}
