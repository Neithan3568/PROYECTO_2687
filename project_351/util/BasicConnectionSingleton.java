import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasicConnectionSingleton {
    private static String url =
            "jdbc:mysql://localhost:3306/my_app";
    private static String user = "my_app";
    private static String pass ="<2057>";

    private static Connection conn;

    public static Connection getInstance() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(url, user, pass);
        }
        return conn;
    }
}


