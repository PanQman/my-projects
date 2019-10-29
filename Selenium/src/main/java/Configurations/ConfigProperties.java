package Configurations;

import java.util.Properties;

public class ConfigProperties {

    private static Properties properties = null;

    public static void setProperties(Properties properties) {
        ConfigProperties.properties = properties;
    }

    public static Properties getProperties() {
        if (properties == null) {
            throw new IllegalStateException("Nie zainicjalizowano pliku Config.Properties");
        }
        return properties;
    }
}
