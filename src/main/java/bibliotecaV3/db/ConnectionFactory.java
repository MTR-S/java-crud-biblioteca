package bibliotecaV3.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection getConexao() {
        String user = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/bibliotecav3";

        try {
            return DriverManager.getConnection(url, user, password);

        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}

