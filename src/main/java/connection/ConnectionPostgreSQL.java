package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgreSQL {

    public static final String URL = "jdbc:postgresql://localhost:5432/crud_jdbc";
    public static final String user = "postgres";
    public static final String password = "db123";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println("CONEXAO REALIZADA COM SUCESSO!");
        } catch (SQLException ex) {
            System.out.println("ERRO AO CONECTAR NO BANCO DE DADOS" + ex.getMessage());
        }

        return connection;

    }

}
