package Configurations;

import org.openqa.selenium.InvalidElementStateException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public Properties getPropertiesFromFile(String fileName) {
        InputStream inputStream = null;
        Properties properties = new Properties();

        try {
            inputStream = getClass()
                    .getClassLoader()
                    .getResourceAsStream(fileName);
            if (inputStream != null) {
                properties.load(inputStream);

            } else {
                throw new FileNotFoundException("Nie znaleziono pliku " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new InvalidElementStateException("Nie udało się załadować pliku");

        } finally {
                try {
                    inputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
        }
        return properties;
    }
}
