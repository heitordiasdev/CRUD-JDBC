package domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Produto {
    private Long id;
    private String nome;
    private Double preco;
    private String categoria;
    private LocalDate dataVencimento;

    public Produto(String nome, Double preco, String categoria, String dataVencimento) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.dataVencimento = LocalDate.parse(dataVencimento);
    }

    public Produto(){

    }

    public Produto(Long id, String nome, Double preco, String categoria, String dataVecimento){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.dataVencimento = LocalDate.parse(dataVecimento);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco='" + preco+ '\'' +
                ", categoria='" + categoria + '\'' +
                ", dataVencimento='" + dataVencimento + '\'' +
                '}';
    }


}
