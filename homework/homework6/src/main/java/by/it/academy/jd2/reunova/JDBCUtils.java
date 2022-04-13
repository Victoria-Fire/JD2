package by.it.academy.jd2.reunova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBCResource.getUrl(),
                    JDBCResource.getUser(), JDBCResource.getPassword());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
