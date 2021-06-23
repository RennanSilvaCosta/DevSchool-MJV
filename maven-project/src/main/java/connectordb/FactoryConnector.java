package connectordb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnector {

    public static Connection getConnection() {
        String url = "jdbc:postgresql://localhost/vacinacao_db";
        String user = "postgres";
        String password = "rammstein-1";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
