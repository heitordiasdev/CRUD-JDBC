import dao.ProdutoDAO;
import domain.Produto;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        var produtoDAO = new ProdutoDAO();

        var produto1 = new Produto("Bolacha",20.00,"Comidas", "2023-11-02");

        produtoDAO.inserirProduto(produto1);

        produtoDAO.listarProdutos().forEach(p -> System.out.println(p));
    }
}
