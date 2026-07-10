import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {
    private String uname;
    private String email;
    private String password;

    // Getters and Setters
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Register method
    public int register() {
        int result = 0;
        Connection connect = JDBCutil.getConnection();
        String sql = "INSERT INTO personalinfo(uname, email, password) VALUES (?, ?, ?)";

        try (PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, uname);
            ps.setString(2, email);
            ps.setString(3, password);

            result = ps.executeUpdate(); // returns number of rows affected
        } catch (SQLException e) {
            e.printStackTrace();
        }
    

        return result;
    }
}
