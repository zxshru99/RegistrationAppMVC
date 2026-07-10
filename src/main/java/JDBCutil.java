import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCutil {

    private static final String URL = "jdbc:mysql://localhost:3306/registrationdetails";
    private static final String USER = "root";
    private static final String PASSWORD = "Samridh@50867";

    // Method to get a new connection
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return conn;
    }

    // Method to close resources safely
    public static void closeResources(Connection conn,PreparedStatement pstmnt) {
        try {
            if (conn != null) {
                conn.close();
                pstmnt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
