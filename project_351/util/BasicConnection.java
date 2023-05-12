import java.sql.*;

public class BasicConnection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_app";
        String username = "my_app";
        String password = "<2057>";

        String sql = "SELECT * FROM formulario.users_tbl";
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                System.out.print(rs.getString("user_first_name"));
                System.out.print(" | ");
                System.out.println(rs.getString("user_lastname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stm != null) stm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
