package org.jbm.util;

import org.jbm.ui.evt.EventProcessor;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author : const_
 */
public class ReflectionUtil {

    private static final Reflections reflections = new Reflections(ClasspathHelper.forPackage("org.jbm"),
            new SubTypesScanner(), new MethodAnnotationsScanner(), new TypeAnnotationsScanner());

    public static Set<Method> annotated(Class<? extends Annotation> annotation) {
        return reflections.getMethodsAnnotatedWith(annotation);
    }

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