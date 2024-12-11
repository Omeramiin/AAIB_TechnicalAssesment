package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestDataProvider {

    private Properties properties;

    // Constructor to load properties file
    public TestDataProvider(String filePath) {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve data from properties file by key
    public String getTestData(String key) {
        return properties.getProperty(key);
    }

}
