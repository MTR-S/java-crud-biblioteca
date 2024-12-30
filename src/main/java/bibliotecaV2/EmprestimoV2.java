package bibliotecaV2;

import java.time.LocalDateTime;

public class EmprestimoV2 {
    private LivroV2 livro;
    private LocalDateTime dataEmprestimo;
    private String codigoDoEmprestimo;

    public EmprestimoV2(LivroV2 livro, LocalDateTime dataEmprestimo, String codigoDoEmprestimo) {
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.codigoDoEmprestimo = codigoDoEmprestimo;
    }

    public String getCodigoDoEmprestimo() {
        return codigoDoEmprestimo;
    }

    public LivroV2 getLivro() {
        return livro;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    @Override
    public String toString() {
        return "Livro: " + this.livro.getTitulo() + " - Código do Emprestimo: " + this.codigoDoEmprestimo;
    }
}
