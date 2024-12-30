package bibliotecaV2;

import java.util.Objects;

public class LivroV2 {
    private String titulo;
    private String autor;
    private double preco;
    private double valorMulta;
    private int quantidadeExemplares;

    public LivroV2(String titulo, String autor, double preco, double valorMulta, int quantidadeExemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.valorMulta = valorMulta;
        this.quantidadeExemplares = quantidadeExemplares;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public int getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    public void setQuantidadeExemplares(int quantidadeExemplares) {
        this.quantidadeExemplares = quantidadeExemplares;
    }

    public void alteraQuantidadeDeExemplares(int emprestimoOuDevolucao) {
        this.quantidadeExemplares -=  -(emprestimoOuDevolucao);
    }

    public void exibeInfoLivro() {
        System.out.println("\n=====================================");
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Preço: " + this.preco);
        System.out.println("Quantidade disponível: " + this.quantidadeExemplares);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LivroV2 livro = (LivroV2) obj;  // Faz cast
        return Objects.equals(titulo, livro.titulo) &&
                Objects.equals(autor, livro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor);
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Quantidade de Exemplares: " + quantidadeExemplares;
    }
}
