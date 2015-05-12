package com.gorbag.managers.properties.annotated;

import com.gorbag.managers.properties.Configurer;
import com.gorbag.managers.properties.annotations.PropertyBase;

/**
 *
 * @author Ivo Correia (idvcorreia@gmail.com)
 * @since 1.0
 */
@PropertyBase(prefix="my.property.base")
public class PropertyBaseAnnotated extends Configurer {

    /**
     * A private field to test if it is filled by the properties manager.
     */
    private String privateField = "no";

    /**
     * A protected field to test if it is filled by the properties manager.
     */
    protected String protectedField = "no";

    /**
     * A public field to test if it is filled by the properties manager.
     */
    public String publicField = "no";

    /**
     * Get the value of the private variable.
     * @return The private variable.
     */
    public String getPrivateField() {
        return privateField;
    }

    /**
     * Get the value of the protected variable.
     * @return The protected variable.
     */
    public String getPublicField() {
        return publicField;
    }

    /**
     * Get the value of the public variable.
     * @return The public variable.
     */
    public String getProtectedField() {
        return protectedField;
    }
}
