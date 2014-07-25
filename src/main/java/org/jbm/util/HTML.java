package org.jbm.util;

import java.awt.*;

/**
 * @author : const_
 */
public class HTML {

    public static <T> String color(Color color, T str) {
        return "<font color=" + toHex(color) + ">" + str + "</font>";
    }

    private static String toHex(Color color) {
        return String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
    }
}
