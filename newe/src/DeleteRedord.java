import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteRedord {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/login_schema",
                    "root",
                    "12345"
            );

            Statement stmt = con.createStatement();

            String sql = "DELETE FROM users WHERE idusers=1";

            int rows = stmt.executeUpdate(sql);

            if (rows > 0) {
                System.out.println("Record Deleted Successfully");
            } else {
                System.out.println("Record Not Found");
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}