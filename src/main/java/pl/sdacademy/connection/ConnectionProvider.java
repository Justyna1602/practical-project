package pl.sdacademy.connection;

import pl.sdacademy.propertis.PropertiesReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {
    private static Connection connection;

    public static Connection getConnection() {
        PropertiesReader propertiesReader = new PropertiesReader();
        Properties properties = propertiesReader.loadFromFile("db.properties");
        try {
            connection = DriverManager.getConnection(
                    properties.getProperty("MYSQL_URL"),
                    properties.getProperty("MYSQL_USERNAME"),
                    properties.getProperty("MYSQL_PASSWORD"));
            connection.setAutoCommit(true);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
