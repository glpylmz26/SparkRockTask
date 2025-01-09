package org.sparkrock.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static {
        try {
            properties = new Properties();

            String[] propertyFiles = {
                    "src/main/java/org/sparkrock/envProps/config.properties",
                    // Add more file paths as needed
            };

            for (String filePath : propertyFiles) {
                FileInputStream input = new FileInputStream(filePath);
                properties.load(input);
                input.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}
