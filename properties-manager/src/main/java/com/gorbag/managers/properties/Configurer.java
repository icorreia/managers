package com.gorbag.managers.properties;

import com.gorbag.managers.properties.annotations.PropertyBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Class for managining configuration. It reads all the properties from a properties file and fills
 * all its members if it finds a property accordingly.
 *
 * @author Ivo Correia (idvcorreia@gmail.com)
 * @since 1.0
 */
public class Configurer {

    /**
     * A Logger for this class.
     */
    private static final Logger logger = LoggerFactory.getLogger(Configurer.class);

    /**
     * Retrieves the properties associated with this class.
     *
     * @param properties The file where to look for the properties.
     */
    public void build(Properties properties) {

        String propertyBase = "";
        if (this.getClass().isAnnotationPresent(PropertyBase.class)) {
            propertyBase = this.getClass().getAnnotation(PropertyBase.class).prefix() + ".";
        }

        /* Looks for all the properties starting with the given property base. */
        for (Object propKey : properties.keySet()) {
            String key = (String) propKey;

            if (key.startsWith(propertyBase)) {
                String shorterKey = key.replaceFirst("^(" + propertyBase + ")", "");

                try {
                    Field field = this.getClass().getDeclaredField(shorterKey);
                    field.setAccessible(true); // Used for protected and private fields.
                    field.set(this, properties.getProperty(key));
                } catch (Exception e) {
                    logger.warn("Field '{}' could not be set in class '{}'.", shorterKey, this.getClass().getSimpleName(), e);
                }
            }
        }
    }
}
