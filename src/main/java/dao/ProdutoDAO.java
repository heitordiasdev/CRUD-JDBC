package dao;

import connection.ConnectionPostgreSQL;
import domain.Produto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO() {
        this.connection = ConnectionPostgreSQL.getConnection();
    }

    // 1 QUESTAO
    public void inserirProduto(Produto produto){
        String sql = "INSERT INTO PRODUTO (nome,preco,categoria,datavencimento) values (?,?,?,?)";
        try {
            var stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getCategoria());
            stmt.setDate(4, Date.valueOf(produto.getDataVencimento()));
            stmt.execute();
            stmt.close();
            System.out.println("INSERT REALIZADO COM SUCESSO!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // 2 QUESTAO
    public List<Produto> listarProdutos() throws SQLException{
        var produtos = new ArrayList<Produto>();
        String sql = "SELECT * FROM PRODUTO";

        var stmt = connection.prepareStatement(sql);
        var rs = stmt.executeQuery();
        while(rs.next()){
            var produto = new Produto(rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getDouble("preco"),
                    rs.getString("categoria"),
                    rs.getString("datavencimento"));
            produtos.add(produto);
        }
        rs.close();
        stmt.close();
        return produtos;
    }

    // 3 QUESTAO
    public List<Produto> listarPorCategoria(String categoria) throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM PRODUTO WHERE CATEGORIA = ?";
        var stmt = connection.prepareStatement(sql);
        stmt.setString(1, categoria);
        var rs = stmt.executeQuery();

        while (rs.next()) {
            var produto = new Produto();
            produto.setId(rs.getLong("id"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getDouble("preco"));
            produto.setCategoria(rs.getString("categoria"));
            produto.setDataVencimento(LocalDate.parse(rs.getString("datavencimento")));
            produtos.add(produto);
        }

        rs.close();
        stmt.close();
        return produtos;
    }
}
