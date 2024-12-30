package bibliotecaV1;

import java.util.*;

public class SistemaDaBibliotecaV1 {

    private static String bibliotecario = "Matheus";

    public static void main(String[] args) {

        LivroV1 livro1 = new LivroV1("Harry Potter e a Pedra Filosofal", "HP01" ,"J.K. Rowling", 88.97, 45.90, 3);
        LivroV1 livro2 = new LivroV1("Percy Jackson e o Ladrão de Raios", "PJ01","Rick Riordan", 56.65, 39.90,  2);
        LivroV1 livro3 = new LivroV1("O Hobbit", "OH01", "J.R.R. Tolkien", 99.98, 55.90, 2);

        BibliotecaV1.addLivro(livro1);
        BibliotecaV1.addLivro(livro2);
        BibliotecaV1.addLivro(livro3);

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
                    emprestarLivro();
                    break;
                case "3":
                    System.out.println("📗 Devolvendo um livro...");
                    devolverLivro();
                    break;
                case "4":
                    System.out.println("💰 Calculando a multa...");
                    multar();
                    break;
                case "5":
                    System.out.println("🔍 Cadastrando Livro...");
                    cadastrarLivro();
                    break;
                case "6":
                    System.out.println("👋 Saindo do sistema. Até mais, " + bibliotecario + " !");
                    break;
                default:
                    System.out.println("❌ Opção inválida. Tente novamente!");
                    break;
            }
            System.out.println();
        } while (!opcao.equals("6"));

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
        System.out.println("6  Sair");
        System.out.println("=====================================");
        System.out.print("➡️ Escolha uma opção: ");
    }

    public static void consultaAcervo() {
        System.out.println("\n=====================================");
        System.out.println("📚 Acervo de livros 📚");
        System.out.println("=====================================");

        BibliotecaV1.getAcervoDeLivros();

        System.out.println("\n==> Total de livros DISPONÍVEIS no acervo: " + BibliotecaV1.getLivrosDisponiveis());

    }

    public static void emprestarLivro() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o código do livro que deseja pegar emprestado:");
        String codigoDoLivro = sc.nextLine();

        switch (BibliotecaV1.emprestaLivro(codigoDoLivro)) {
            case 0:
                System.out.println("Livro emprestado com sucesso, aproveite!");
                break;
            case 1:
                System.out.println("Desculpe, infelizmente atualmente estamos sem esse livro no nosso acervo");
                break;
            default:
                System.out.println("Código não encontrado, tente novamente!");
                break;
        }
    }

    public static void devolverLivro() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o código do livro que deseja devolver:");
        String codigoDoLivro = sc.nextLine();

        switch (BibliotecaV1.devolveLivro(codigoDoLivro)) {
            case 0:
                System.out.println("Livro devolvido com sucesso, aproveite!");
                break;
            default:
                System.out.println("Código não encontrado, tente novamente!");
                break;
        }
    }

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
    }

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

        LivroV1 novoLivro = new LivroV1(titulo, codigo, autor, ano, valorDaMulta, quantidadeDeExemplares);

        switch (BibliotecaV1.cadastraLivro(novoLivro)) {
            case 0:
                System.out.println("Livro cadastrado com sucesso, aproveite!");
                break;
            case 1:
                System.out.println("Livro com mesmo código já cadastrado em nosso acervo, tente novamente.");
                break;
            default:
                System.out.println("Acervo aumentado! Livro cadastrado com sucesso, aproveite!");
                break;
        }
    }
}
