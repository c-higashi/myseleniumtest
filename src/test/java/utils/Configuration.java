package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Properties;

/**
 * Utility for reading in a configuration properties file
 */
public class Configuration {

    private final Properties properties;

    public Configuration(String fileName) {

        try (FileInputStream fis = new FileInputStream(fileName)) {
            this.properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read the configuration properties file: " + fileName, e);
        }
    }

    public String getProperty( String key ) {
        String value = this.properties.getProperty(key);
        if( value == null ) {
            throw new RuntimeException("Unknown property: " + value);
        }
        return value;
    }
}
