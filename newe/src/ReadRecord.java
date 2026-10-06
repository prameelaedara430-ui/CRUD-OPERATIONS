import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadRecord {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/login_schema";
        String user = "root";
        String password = "12345";

        String sql = "SELECT * FROM users";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("idusers") + " | " +
                                rs.getString("username") + " | " +
                                rs.getString("pasword")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}