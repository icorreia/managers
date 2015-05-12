package com.gorbag.managers.properties;

import com.gorbag.managers.properties.annotated.PropertyBaseAnnotated;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Ivo Correia (idvcorreia@gmail.com)
 * @since 1.0
 */
public class TestAnnotations {

    private static PropertiesManager propertiesManager;

    @BeforeClass
    public static void setUp() throws IOException {
        propertiesManager = new PropertiesManager("src/test/resources/test.properties");
    }


    @Test
    public void testPropertyBase() throws Exception {
        PropertyBaseAnnotated config = propertiesManager.getConfiguration(PropertyBaseAnnotated.class);

        assertEquals("Private field should be changed.", config.getPrivateField(), "yes");
        assertEquals("Protected field should be changed.", config.getProtectedField(), "yes");
        assertEquals("Public field should be changed.", config.getPublicField(), "yes");
    }
}
