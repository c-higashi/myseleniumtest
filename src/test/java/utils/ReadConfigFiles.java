package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Properties;

/**
 * Utility for reading in a configuration properties file
 */
public class ReadConfigFiles {
    public Properties readConfigProperties(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            Properties properties = new Properties();
            properties.load(fis);
            return properties;
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read the configuration properties file: " + fileName, e);
        }
    }
}
