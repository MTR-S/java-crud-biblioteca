package bibliotecaV3.dao;

import bibliotecaV3.model.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {
    private Connection connection;

    public LivroDao(Connection connection ) {
        this.connection = connection;
    }

    public void insere(Livro livro) {
        String sql = """
                    INSERT INTO LIVRO
                        (CODIGO, TITULO, AUTOR, PRECO, VALORMULTA, QUANTIDADEEXEMPLARES)
                     VALUES
                     (?, ?, ?, ?, ?, ?)
                """;

        try (PreparedStatement comandoPreparado = this.connection.prepareStatement(sql)) {
            comandoPreparado.setString(1, livro.getCodigo());
            comandoPreparado.setString(2, livro.getTitulo());
            comandoPreparado.setString(3, livro.getAutor());
            comandoPreparado.setDouble(4, livro.getPreco());
            comandoPreparado.setDouble(5, livro.getValorMulta());
            comandoPreparado.setInt(6, livro.getQuantidadeExemplares());

            comandoPreparado.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> listaTodos() {
        String sqlSelect = "select * from livro";

        try (PreparedStatement comandoPreparado = this.connection.prepareStatement(sqlSelect);
             ResultSet resultSet = comandoPreparado.executeQuery()) {
            List<Livro> livros = new ArrayList<>();
            while(resultSet.next()) {
                livros.add(criaLivro(resultSet));
            }

            return livros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int calculaTotalDeLivrosDisponiveis() {
        String sqlSelect = "select sum(quantidadeExemplares) as total from livro";

        try (PreparedStatement comandoPreparado = this.connection.prepareStatement(sqlSelect);
             ResultSet resultSet = comandoPreparado.executeQuery()) {
            resultSet.next();

            return resultSet.getInt("total");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Livro pesquisaPorCodigo(String codigo) {
        String sql = "select * from livro where codigo = ?";

        try (PreparedStatement comandoSelect = this.connection.prepareStatement(sql)) {
            comandoSelect.setString(1, codigo);

            try (ResultSet resultSet = comandoSelect.executeQuery()) {
                Livro livro = null;
                if (resultSet.next()) {
                    livro = criaLivro(resultSet);
                }

                return livro;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Livro criaLivro(ResultSet rs) throws SQLException {
        return new Livro(
                rs.getString("codigo"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getDouble("preco"),
                rs.getDouble("valorMulta"),
                rs.getInt("quantidadeExemplares")
        );
    }

    public void atualiza(Livro livro) {
        String sql = """
                     update livro
                        set titulo = ?, 
                            autor = ?, 
                            preco = ?, 
                            valorMulta = ?, 
                            quantidadeExemplares = ?
                      where codigo = ?""";

        try (PreparedStatement comandoPreparado = this.connection.prepareStatement(sql)) {
            comandoPreparado.setString(1, livro.getTitulo());
            comandoPreparado.setString(2, livro.getAutor());
            comandoPreparado.setDouble(3, livro.getPreco());
            comandoPreparado.setDouble(4, livro.getValorMulta());
            comandoPreparado.setInt(5, livro.getQuantidadeExemplares());
            comandoPreparado.setString(6, livro.getCodigo());

            comandoPreparado.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
