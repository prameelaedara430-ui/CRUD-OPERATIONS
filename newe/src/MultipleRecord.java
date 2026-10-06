import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MultipleRecord {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/login_schema",
                    "root",
                    "12345"
            );

            Statement stmt = con.createStatement();

            String insert1 =
                    "INSERT INTO users (username, pasword) VALUES ('manu', '11111')";

            String insert2 =
                    "INSERT INTO users (username, pasword) VALUES ('manvanth', '22222')";

            String insert3 =
                    "INSERT INTO users (username, pasword) VALUES ('randy', '33333')";

            stmt.addBatch(insert1);
            stmt.addBatch(insert2);
            stmt.addBatch(insert3);

            stmt.executeBatch();

            System.out.println("Multiple Records Inserted Successfully");

            con.close();

        } catch (Exception e) {

            System.out.println(e);

        }
    }
}