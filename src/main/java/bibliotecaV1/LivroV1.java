package bibliotecaV1;

public class LivroV1 {
    private String codigo;
    private String titulo;
    private String autor;
    private double preco;
    private double valorMulta;
    private int quantidadeExemplares;

    public LivroV1(String titulo, String codigo, String autor, double preco, double valorMulta, int quantidadeExemplares) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.autor = autor;
        this.preco = preco;
        this.valorMulta = valorMulta;
        this.quantidadeExemplares = quantidadeExemplares;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public int getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    public void exibeInfoLivro() {
        System.out.println("\n=====================================");
        System.out.println("Título: " + this.titulo);
        System.out.println("Código: " + this.codigo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Preço: " + this.preco);
        System.out.println("Quantidade disponível: " + this.quantidadeExemplares);
    }

    public void alteraQuantidadeDeExemplares(int emprestimoOuDevolucao) {
        this.quantidadeExemplares -=  -(emprestimoOuDevolucao);
    }
}
