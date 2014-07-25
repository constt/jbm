package org.jbm.element;

import org.jbm.util.ASMUtil;
import org.objectweb.asm.tree.FieldNode;

import java.lang.reflect.Modifier;

/**
 * @author : const_
 */
public class FieldElement {

    private ClassElement parent;
    private FieldNode node;

    public FieldElement(ClassElement parent, FieldNode node) {
        this.parent = parent;
        this.node = node;
    }

    public FieldNode node() {
        return node;
    }

    public ClassElement parent() {
        return parent;
    }

    public String desc() {
        return node().desc;
    }

    public int access() {
        return node().access;
    }

    public String name() {
        return node().name;
    }

    public String type() {
        return ASMUtil.primitiveName(ASMUtil.strip(desc()));
    }

    public String format() {
        return "\t" + Modifier.toString(access()).trim() + " " + type() + " " + name() + ";";
    }

    @Override
    public String toString() {
        return format();
    }
}
