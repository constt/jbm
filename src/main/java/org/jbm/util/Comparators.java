package org.jbm.util;

import org.jbm.element.ClassElement;

import java.util.Comparator;

/**
 * @author : const_
 */
public class Comparators {

    public static final Comparator<ClassElement> CLASS_ALPHABETIC = new Comparator<ClassElement>() {
        @Override
        public int compare(ClassElement o1, ClassElement o2) {
            return o1.name().compareTo(o2.name());
        }
    };
}
