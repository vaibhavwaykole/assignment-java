package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class HsqlConnection {

    public static void main(String[] args) {
        Connection con = HsqlConnection.getConnection();
        System.out.println("done");
    }

    private static Connection con = null;
    public static Connection getConnection() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            if (con != null) {
                System.out.println("Connection created successfully");
            } else {
                System.out.println("Problem with creating connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

