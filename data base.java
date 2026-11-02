import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 * Demonstrates connecting to a MySQL database using JDBC,
 * executing a SELECT query, and displaying the results.
 */
public class JdbcSelectDemo {
 
    // Step 2: JDBC connection constants (change to match your setup)
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "your_password";
 
    public static void main(String[] args) {
        // Step 5: SQL query
        String sqlQuery = "SELECT * FROM users";
 
        // Step 3, 4, 6: try-with-resources for Connection, Statement, ResultSet
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlQuery)) {
 
            System.out.println("Connected to the database successfully.\n");
 
            // Step 7: Loop through the ResultSet
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
 
                System.out.println("User ID: " + id
                        + ", Username: " + username
                        + ", Email: " + email);
            }
 
        } catch (SQLException e) {
            // Step 8: Handle SQLException
            System.err.println("Database error occurred!");
            System.err.println("Message   : " + e.getMessage());
            System.err.println("SQLState  : " + e.getSQLState());
            System.err.println("ErrorCode : " + e.getErrorCode());
        }
        // Step 9: Resources are closed automatically
    }
}
 