package dao;

import connection.ConnectionPostgreSQL;
import domain.Produto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO() {
        this.connection = ConnectionPostgreSQL.getConnection();
    }

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




}
