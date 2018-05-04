import java.sql.*;

/**
 * Created by skinadi on 03.05.18.
 */
public class ConnectionManager {
    static Connection connection;
    static PreparedStatement insert;
    static PreparedStatement exist;
    static PreparedStatement getfriends;
    static void establishconnection()
    {
        try{
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "madzia");
            insert = connection.prepareStatement("INSERT INTO client (email,password,name,surname) VALUES (?,?,?,?)");
            exist = connection.prepareStatement("SELECT * from client where email=? and password=?");
            getfriends = connection.prepareStatement("select * from client where email = (select email2 from friends where email1 = ?)");
        }catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
