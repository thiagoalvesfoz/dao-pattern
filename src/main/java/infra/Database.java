package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static final String username = "root";
    private static final String password = "1234";
    private static final String url = "jdbc:mysql://localhost:3306/aula";


    // após as informações devidamente setadas, eu programo a ação de obter uma conexão.
    public static Connection getConnection() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password); // se tivesse dado um erro
            System.out.println("Conexão bem sucedida");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return conn;
    }
}
