package org.jbm.instruction.impl;

import org.jbm.element.MethodElement;
import org.jbm.instruction.AbstractInstruction;
import org.jbm.util.ReflectionUtil;
import org.objectweb.asm.tree.AbstractInsnNode;

import java.lang.reflect.Field;

/**
 * @author : const_
 */
public abstract class DescriptiveInstruction<T extends AbstractInsnNode> extends AbstractInstruction<T> {

    public DescriptiveInstruction(MethodElement method, T node) {
        super(method, node);
    }

    public String description() {
        return ReflectionUtil.<String>get("desc", node());
    }

    public abstract String simpleDescription();

}
