package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlconstants {
    public static String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static String MYSQL_PATH = "jdbc:mysql://localhost:3306/";
    public static String DATABASE_NAME = "SMARTBOOK";
    public static String USERNAME = "root";
    public static String PASSWORD = "root";

    public static MySqlconstants getInstance() {
        return new MySqlconstants();
    }

    public Statement getCreatedStatement() throws ClassNotFoundException, SQLException {
        Class.forName(MySqlconstants.MYSQL_DRIVER);
        Connection connection = DriverManager.getConnection(MySqlconstants.MYSQL_PATH + MySqlconstants.DATABASE_NAME,
                MySqlconstants.USERNAME, MySqlconstants.PASSWORD);
        Statement statement = connection.createStatement();
        return statement;
    }
}
