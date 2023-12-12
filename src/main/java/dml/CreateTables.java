package dml;

import connection.ConnectionPostgreSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class CreateTables {
    private Connection connection;

    public CreateTables() {
        this.connection = ConnectionPostgreSQL.getConnection();
    }

    public void createTableProduto(){
        String sql;
        try {
            sql = "CREATE TABLE IF NOT EXISTS PRODUTO (" +
                    "id SERIAL PRIMARY KEY, " +
                    "nome VARCHAR(255) NOT NULL, " +
                    "preco DECIMAL(10,2) NOT NULL, " +
                    "categoria VARCHAR(50) NOT NULL, " +
                    "datavencimento DATE NOT NULL " +
                    ")";
            var stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            System.out.println("Table PRODUTO foi criada com sucesso!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}