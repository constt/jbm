package org.jbm.util;

/**
 * @author : const_
 */
public class StringUtil {

    public static int count(String str, String search) {
        int len = str.length();
        int nLen = str.replaceAll(search, "").length();
        return len - nLen;
    }
}
