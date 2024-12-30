package bibliotecaV2;

import java.util.Scanner;

public class SistemaDaBibliotecaV2 {
    private static String bibliotecario = "Matheus";

    public static void main(String[] args) {

        LivroV2 livro1 = new LivroV2("Harry Potter e a Pedra Filosofal" ,"J.K. Rowling", 88.97, 45.90, 3);
        LivroV2 livro2 = new LivroV2("Percy Jackson e o Ladrão de Raios","Rick Riordan", 56.65, 39.90,  2);
        LivroV2 livro3 = new LivroV2("O Hobbit", "J.R.R. Tolkien", 99.98, 55.90, 2);

        if(BibliotecaV2.addLivro("HP01", livro1) == 1) {
            System.out.println("Livro " + livro1.getTitulo() + " tem código já cadastrado no acervo!");
        }
        if(BibliotecaV2.addLivro("PJ01", livro2) == 1) {
            System.out.println("Livro " + livro2.getTitulo() + " tem código já cadastrado no acervo!");
        }
        if(BibliotecaV2.addLivro("OH01", livro3) == 1) {
            System.out.println("Livro " + livro3.getTitulo() + " tem código já cadastrado no acervo!");
        }

        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            exibeMenu();
            opcao = scanner.next();

            switch (opcao) {
                case "1":
                    System.out.println("🔍 Consultando o acervo...");
                    consultaAcervo();
                    break;
                case "2":
                    System.out.println("📕 Emprestando um livro...");
                    registrarNovoEmprestimo();
                    break;
                case "3":
                    System.out.println("📗 Devolvendo um livro...");
                    devolverLivro();
                    break;
                case "4":
                    System.out.println("💰 Calculando a multa...");
                    //multar();
                    break;
                case "5":
                    System.out.println("🔍 Cadastrando Livro...");
                    cadastrarLivro();
                    break;
                case "6":
                    System.out.println("🔍 Buscando livro...");
                    exibeLivroPorCodigo();
                    break;
                case "7":
                    System.out.println("🔍  Removendo Livro...");
                    removeLivro();
                    break;
                case "8":
                    System.out.println("🔍  Exibindo todos os emprestimos ativos...");
                    exibirEmprestimosAtivos();
                    break;
                case "9":
                    System.out.println("🔍  Exibindo emprestimos por livro...");
                    exibeEmprestimosPorLivro();
                    break;
                case "10":
                    System.out.println("🔍  Exibindo histórico de emprestimos...");
                    BibliotecaV2.exibirHistoricoDeEmprestimos();
                    break;
                case "11":
                    System.out.println("👋 Saindo do sistema. Até mais, " + bibliotecario + " !");
                    break;
                default:
                    System.out.println("❌ Opção inválida. Tente novamente!");
                    break;
            }
            System.out.println();
        } while (!opcao.equals("11"));

        scanner.close();


    }

    public static void exibeMenu() {
        System.out.println("=====================================");
        System.out.println("📚 Bem-vindo ao Sistema da Biblioteca 📚");
        System.out.println("=====================================");
        System.out.println("1  Consultar acervo");
        System.out.println("2  Emprestar livro");
        System.out.println("3  Devolver livro");
        System.out.println("4  Calcular multa");
        System.out.println("5  Cadastrar Livro");
        System.out.println("6  Buscar Livro");
        System.out.println("7  Remover Livro");
        System.out.println("8  Exibir todos os emprestimos");
        System.out.println("9  Busca emprestimos de um livro");
        System.out.println("10 Exibir histórico de emprestimos");
        System.out.println("11 Sair");
        System.out.println("=====================================");
        System.out.print("➡️ Escolha uma opção: ");
    }

    public static void consultaAcervo() {
        System.out.println("\n=====================================");
        System.out.println("📚 Acervo de livros 📚");
        System.out.println("=====================================");

        BibliotecaV2.exibirLivros();

        System.out.println("\n==> Total de livros DISPONÍVEIS no acervo: " + BibliotecaV2.getTotalDeLivros());

    }

    public static void registrarNovoEmprestimo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o código do livro que deseja pegar emprestado:");
        String codigoDoLivro = sc.nextLine();

        if(BibliotecaV2.registrarNovoEmprestimo(codigoDoLivro) == null) {
            return;
        }

        System.out.println("Emprestimo registrado com sucesso, aproveite seu título!");
    }

    public static void devolverLivro() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o código do livro que deseja devolver:");
        String codigoDoLivro = sc.nextLine();

        System.out.println("Digite o código de emprestimo:");
        String codigoDeEmprestimo = sc.nextLine();

        switch (BibliotecaV2.devolverEmprestimo(codigoDoLivro, codigoDeEmprestimo)) {
            case 0:
                System.out.println("Livro devolvido com sucesso, aproveite!");
                break;
            default:
                System.out.println("Tente novamente!");
                break;
        }
    }
/*
    public static void multar() {
        double diasDeAtraso;
        String codigoDoLivro;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Código do Livro: ");
        codigoDoLivro = scanner.nextLine();

        LivroV1 livroMultado = BibliotecaV1.getLivroPorCodigo(codigoDoLivro);

        System.out.println("Dias de atraso: ");
        diasDeAtraso = scanner.nextInt();

        double valorDaMulta = BibliotecaV1.calculaMulta(diasDeAtraso, livroMultado);

        if(valorDaMulta < 0) {
            System.out.println("Desculpe, infelizmente não temos esse livro no nosso acervo, tente novamente.");
            return;
        }

        System.out.printf("Você tem %.2f dias de atraso, logo sua multa ficará = %.2f\n", diasDeAtraso, valorDaMulta);
    }*/

    public static void cadastrarLivro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("📚 Cadastro de Livro 📚");
        System.out.println("=====================================");

        System.out.println("1) Título: ");
        String titulo = scanner.nextLine();

        System.out.println("2) Código: ");
        String codigo = scanner.nextLine();

        System.out.println("3) Autor: ");
        String autor = scanner.nextLine();

        System.out.println("4) Preco: ");
        double ano = scanner.nextDouble();

        System.out.println("5) Valor da Multa: ");
        double valorDaMulta = scanner.nextDouble();

        System.out.println("6) Quantidade de Exemplares: ");
        int quantidadeDeExemplares = scanner.nextInt();

        LivroV2 novoLivro = new LivroV2(titulo, autor, ano, valorDaMulta, quantidadeDeExemplares);

        switch (BibliotecaV2.addLivro(codigo, novoLivro)) {
            case 0:
                System.out.println("Livro cadastrado com sucesso, aproveite!");
                break;
            default:
                System.out.println("Livro com mesmo código já cadastrado em nosso acervo, tente novamente.");
                break;
        }
    }

    public static LivroV2 buscaLivroPorCodigo(String codigoDoLivro) {
        LivroV2 livro = BibliotecaV2.buscaLivroPorCodigo(codigoDoLivro);
        if(livro == null){
            System.out.println("Código: " + codigoDoLivro + " não encontrado, tente novamente!");

            return null;
        }

        return livro;
    }

    public static void exibeLivroPorCodigo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do livro: ");
        String codigoDoLivro = scanner.nextLine();

        LivroV2 livro = buscaLivroPorCodigo(codigoDoLivro);

        if(livro == null) {
            return;
        }

        livro.exibeInfoLivro();
        System.out.println("=====================================");
    }

    public static void removeLivro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do livro: ");
        String codigoDoLivro = scanner.nextLine();

        LivroV2 livro = buscaLivroPorCodigo(codigoDoLivro);

        if(livro == null) {
            return;
        }

        BibliotecaV2.removeLivro(codigoDoLivro);
        System.out.println("Livro removido com sucesso!");
    }

    public static void exibirEmprestimosAtivos() {
        BibliotecaV2.exibeEmprestimosAtivos();
    }

    public static void exibeEmprestimosPorLivro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do livro: ");
        String codigoDoLivro = scanner.nextLine();

        BibliotecaV2.exibeEmprestimosPorLivro(codigoDoLivro);
    }

}
