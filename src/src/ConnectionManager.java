import java.sql.*;

/**
 * Created by skinadi on 03.05.18.
 */
public class ConnectionManager {
    static Connection connection;
    static PreparedStatement insert;
    static PreparedStatement exist;
    static void establishconnection()
    {
        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "madzia");
            insert = connection.prepareStatement("INSERT INTO client (email,password,name,surname) VALUES (?,?,?,?)");
            exist = connection.prepareStatement("SELECT 1 WHERE EXISTS(SELECT * from client where email=? and password =?) ");
        }catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
