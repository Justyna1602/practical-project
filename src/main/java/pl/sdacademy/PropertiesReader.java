package pl.sdacademy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    public Properties loadFromFile(String fileName) {
        Properties properties = new Properties();
        InputStream input;

        input = getClass().getClassLoader().getResourceAsStream(fileName);

        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
