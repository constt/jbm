package org.jbm.util;

import org.jbm.element.ClassElement;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author : const_
 */
public class ASMUtil {

    private static final Map<Integer, String> OPCODE_MAP = new HashMap<>();

    static {
        for (Field f : Opcodes.class.getFields()) {
            f.setAccessible(true);
            try {
                if (f.getName().contains("TOP") ||
                        f.getName().contains("INTEGER") ||
                        f.getName().contains("FLOAT") ||
                        f.getName().contains("DOUBLE") ||
                        f.getName().contains("LONG") ||
                        f.getName().contains("NULL") ||
                        f.getName().contains("THIS")) {
                    OPCODE_MAP.put(ReflectionUtil.<Integer>get("owner", Opcodes.class), f.getName());
                    continue;
                }
                OPCODE_MAP.put(f.getInt(null), f.getName());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static String opcode(int opcode) {
        if (OPCODE_MAP.containsKey(opcode)) {
            return OPCODE_MAP.get(opcode);
        }
        return "null";
    }

    public static boolean isStandard(String desc) {
        return desc.contains("java") || desc.contains("[") &&
                desc.substring(desc.lastIndexOf('[') + 2).length() == 0 ||
                desc.length() == 1 && Character.isUpperCase(desc.charAt(0));
    }

    public static String primitiveName(String desc) {
        switch (desc) {
            case "B":
                return "byte";
            case "I":
                return "int";
            case "S":
                return "short";
            case "J":
                return "long";
            case "Z":
                return "boolean";
            case "F":
                return "float";
            case "D":
                return "double";
            case "C":
                return "char";
            case "V":
                return "void";
        }
        return desc;
    }

    public static List<ClassElement> load(File file) {
        try {
            List<ClassElement> list = new LinkedList<>();
            if (file.getName().endsWith(".class")) {
                ClassReader reader = new ClassReader(new FileInputStream(file));
                ClassNode node = new ClassNode();
                reader.accept(node, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
                list.add(new ClassElement(node));
            } else {
                ZipFile zip = new ZipFile(file);
                Enumeration<? extends ZipEntry> enumeration = zip.entries();
                while (enumeration.hasMoreElements()) {
                    ZipEntry next = enumeration.nextElement();
                    if (next.getName().endsWith(".class")) {
                        ClassReader reader = new ClassReader(zip.getInputStream(next));
                        ClassNode node = new ClassNode();
                        reader.accept(node, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
                        list.add(new ClassElement(node));
                    }
                }
            }
            Collections.sort(list, Comparators.CLASS_ALPHABETIC);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> parameters(String desc) {
        String parameters = desc.substring(desc.indexOf('(') + 1, desc.indexOf(')'));
        List<String> params = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        boolean standard = false;
        for (char c : parameters.toCharArray()) {
            if (c == 'L') {
                standard = true;
            }
            if (!standard) {
                switch (c) {
                    case 'B':
                    case 'I':
                    case 'S':
                    case 'J':
                    case 'Z':
                    case 'F':
                    case 'D':
                    case 'C':
                        builder.append(primitiveName(String.valueOf(c)));
                        params.add(builder.toString());
                        builder = new StringBuilder();
                        continue;
                }
            }
            builder.append(c);
            if (c == ';') {
                standard = false;
                params.add(builder.toString());
                builder = new StringBuilder();
            }
        }
        return params;
    }

    public static String strip(String desc) {
        return desc.replaceAll("L", "").replaceAll("\\[", "").replaceAll(";", "");
    }
}
