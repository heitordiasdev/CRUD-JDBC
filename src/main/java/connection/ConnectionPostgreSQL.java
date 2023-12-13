package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgreSQL {
    public static final String URL =  "jdbc:postgresql://localhost:5432/crud_jdbc";
    public static final String USER =  "postgres";
    public static final String PASSWORD =  "db123";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("CONEXAO REALIZADA COM SUCESSO!");
        } catch (SQLException ex) {
            System.out.println("ERRO AO CONECTAR NO BANCO DE DADOS" + ex.getMessage());
        }

        return connection;

    }

}
