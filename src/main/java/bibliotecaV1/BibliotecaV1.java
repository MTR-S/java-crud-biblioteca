package bibliotecaV1;

public class BibliotecaV1 {

    private static LivroV1[] acervoDeLivros = new LivroV1[5];
    private static int acervoIndex = 0;
    private static int livrosDisponiveis = 0;

    public static int getLivrosDisponiveis() {
        return livrosDisponiveis;
    }

    public static void addLivro(LivroV1 acervoDeLivros) {
        BibliotecaV1.acervoDeLivros[BibliotecaV1.acervoIndex] = acervoDeLivros;

        BibliotecaV1.acervoIndex++;
    }

    public static void getAcervoDeLivros() {
        BibliotecaV1.livrosDisponiveis = 0;

        for(int i = 0; i < acervoDeLivros.length && acervoDeLivros[i] != null; i++) {
            acervoDeLivros[i].exibeInfoLivro();

            BibliotecaV1.livrosDisponiveis += acervoDeLivros[i].getQuantidadeExemplares();
        }
    }

    public static int emprestaLivro(String codigoDoLivro) {
        for(int i = 0; i < BibliotecaV1.acervoDeLivros.length && BibliotecaV1.acervoDeLivros[i] != null; i++) {
            if(acervoDeLivros[i].getCodigo().equals(codigoDoLivro)) {

                if(acervoDeLivros[i].getQuantidadeExemplares() == 0) {
                    return 1;
                }

                acervoDeLivros[i].alteraQuantidadeDeExemplares(-1);

                return 0;
            }
        }
        return 2;
    }

    public static int devolveLivro(String codigoDoLivro) {
        for(int i = 0; i < acervoDeLivros.length && acervoDeLivros[i] != null; i++) {
            if(acervoDeLivros[i].getCodigo().equals(codigoDoLivro)) {

                acervoDeLivros[i].alteraQuantidadeDeExemplares(1);

                return 0;
            }
        }
        return 1;
    }

    public static double calculaMulta(double qntdDiasDeAtraso, LivroV1 livroMultado) {
        if(livroMultado == null) {
            return -1.0;
        }

        return qntdDiasDeAtraso * livroMultado.getValorMulta();

    }

    public static int cadastraLivro(LivroV1 novoLivro) {
        int proxIndiceDisponivel = 0;

        for(int i = 0; i < BibliotecaV1.acervoDeLivros.length; i++) {
            if(BibliotecaV1.acervoDeLivros[i] == null) {
                BibliotecaV1.acervoDeLivros[i] = novoLivro;
                return 0;
            }

            if(acervoDeLivros[i].getCodigo().equals(novoLivro.getCodigo())) {
                return 1;
            }

            proxIndiceDisponivel++;
        }

        BibliotecaV1.aumentaEspacoNoAcervo();
        BibliotecaV1.acervoDeLivros[proxIndiceDisponivel] = novoLivro;

        return 2;
    }

    public static void aumentaEspacoNoAcervo() {
        int tamanhoDoAntigoAcervo = acervoDeLivros.length;

        LivroV1[] novoAcervoDeLivros = new LivroV1[tamanhoDoAntigoAcervo * 2];

        for(int i = 0; i < tamanhoDoAntigoAcervo; i++) {
            novoAcervoDeLivros[i] = BibliotecaV1.acervoDeLivros[i];
        }

        acervoDeLivros = novoAcervoDeLivros;
    }

    public static LivroV1 getLivroPorCodigo(String codigoDoLivro) {
        for(int i = 0; i < acervoDeLivros.length && acervoDeLivros[i] != null; i++) {
            if(BibliotecaV1.acervoDeLivros[i].getCodigo().equals(codigoDoLivro)) {
                return BibliotecaV1.acervoDeLivros[i];
            }

        }
        return null;
    }
}
