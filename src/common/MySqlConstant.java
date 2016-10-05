package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConstant {
    public static String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static String MYSQL_PATH = "jdbc:mysql://localhost:3306/";
    public static String DATABASE_NAME = "SMARTBOOK";
    public static String USERNAME =System.getProperty("mysql.username");
    public static String PASSWORD =System.getProperty("mysql.password");

    public static MySqlConstant getInstance() {
        return new MySqlConstant();
    }

    public Statement getCreatedStatement() throws ClassNotFoundException, SQLException {
        Class.forName(MySqlConstant.MYSQL_DRIVER);
        Connection connection = DriverManager.getConnection(MySqlConstant.MYSQL_PATH + MySqlConstant.DATABASE_NAME,
                MySqlConstant.USERNAME, MySqlConstant.PASSWORD);
        Statement statement = connection.createStatement();
        return statement;
    }
}
