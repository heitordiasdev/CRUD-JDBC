import dao.ProdutoDAO;
import domain.Produto;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException {
        var produtoDAO = new ProdutoDAO();

        var produto1 = new Produto("Coca-Cola", 30.00, "Bebida", "2024-12-28");
        produtoDAO.inserirProduto(produto1);

        var produto2 = new Produto("Bolacha", 30.00, "Cereais", "2023-12-28");
        produtoDAO.inserirProduto(produto2);

        var produto3 = new Produto("Soda", 19.00, "Bebida", "2024-12-28");
        produtoDAO.inserirProduto(produto3);

        var produto4 = new Produto("Arroz", 3.00, "Cereais", "2024-09-28");
        produtoDAO.inserirProduto(produto4);

        var produto5 = new Produto("Feijao", 3.00, "Cereais", "2024-10-28");
        produtoDAO.inserirProduto(produto5);

        System.out.println("Todos os produtos:");
        produtoDAO.listarProdutos().forEach(p -> System.out.println(p));

        String categoria = "Cereais";
        List<Produto> produtosPorCategoria = produtoDAO.listarPorCategoria(categoria);

        System.out.println("\nProdutos da categoria '" + categoria + "':");
        produtosPorCategoria.forEach(p -> System.out.println(p));

        Produto produtoMaiorPreco = produtoDAO.listarProdutoMaiorPreco();
        System.out.println("\n" + produtoMaiorPreco);

        Produto produtoProxDeVencer = produtoDAO.listarProdutoProxDeVencer();
        System.out.println(produtoProxDeVencer);

        Produto produtoAtualizado = new Produto();
        produtoAtualizado.setId(1L);
        produtoAtualizado.setPreco(25.00);

        produtoDAO.atualizarPrecoProduto(produtoAtualizado);

        // Listar todos os produtos após a atualização
        System.out.println("\nLista de produtos após a atualização:");
        produtoDAO.listarProdutos().forEach(p -> System.out.println(p));

        // Remover um produto pelo nome
        String nomeProdutoParaRemover = "Bolacha"; // Substitua pelo nome correto
        produtoDAO.removerProdutoPeloNome(nomeProdutoParaRemover);

        // Listar todos os produtos após a remoção
        System.out.println("\nLista de produtos após a remoção:");
        produtoDAO.listarProdutos().forEach(p -> System.out.println(p));

    }
}
