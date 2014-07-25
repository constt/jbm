package org.jbm.util;

import java.lang.reflect.Field;

/**
 * @author : const_
 */
public class ReflectionUtil {

    public static <T> T get(String name, Object instance) {
        for (Field f : instance.getClass().getFields()) {
            f.setAccessible(true);
            if (f.getName().equals(name)) {
                try {
                    return (T) f.get(instance);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}