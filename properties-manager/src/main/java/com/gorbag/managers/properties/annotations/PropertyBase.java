package com.gorbag.managers.properties.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation to define the base of properties in the configuration file.
 *
 * @author Ivo Correia (idvcorreia@gmail.com)
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PropertyBase {

    /**
     * The prefix defining the property base.
     *
     * @return The prefix defining the property base.
     */
    String prefix() default "";
}