package com.gorbag.managers.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Ivo Correia (idvcorreia@gmail.com)
 * @since 1.0
 */
public class PropertiesManager {

    /**
     * The properties read from the file.
     */
    private Properties properties = new Properties();

    /**
     * Loads the properties into memory from the provided file name.
     *
     * @param propertiesFile The file name of the properties file.
     * @throws IOException If anything goes wrong while loading the properties file.
     */
    public PropertiesManager(String propertiesFile) throws IOException {
        InputStream input = new FileInputStream(propertiesFile);
        properties.load(input);
        input.close();
    }

    public <T extends Configurer> T getConfiguration(Class<T> configuratorClass) throws Exception {
        T config = configuratorClass.newInstance();
        config.build(properties);
        return config;
    }
}
