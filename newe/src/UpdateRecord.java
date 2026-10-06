import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateRecord {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/login_schema";
        String user = "root";
        String password = "12345";

        String sql = "UPDATE users SET username=?, pasword=? WHERE idusers=?";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "manu");
            ps.setString(2, "98765");
            ps.setInt(3, 8);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record updated successfully!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}