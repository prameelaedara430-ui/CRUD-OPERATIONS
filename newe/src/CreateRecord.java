import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateRecord {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/login_schema";
        String user = "root";
        String password = "12345";

        String sql = "INSERT INTO users (username, pasword) VALUES (?, ?)";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "ujjwal");
            ps.setString(2, "12345");

            ps.executeUpdate();

            System.out.println("Record inserted successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}