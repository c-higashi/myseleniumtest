package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFiles {

    protected static final Logger logger = LogManager.getLogger();

    public Properties readConfigProperties(String fileName) {
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            properties.load(fis);
        } catch (IOException e) {
            logger.error( "Failed to read the properties file!" );
        }
        return properties;
    }
}
