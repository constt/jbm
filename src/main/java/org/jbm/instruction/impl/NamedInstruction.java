package org.jbm.instruction.impl;

import org.jbm.Application;
import org.jbm.element.ClassElement;
import org.jbm.element.MethodElement;
import org.jbm.util.ReflectionUtil;
import org.objectweb.asm.tree.AbstractInsnNode;

/**
 * @author : const_
 */
public abstract class NamedInstruction<T extends AbstractInsnNode> extends DescriptiveInstruction<T> {

    public NamedInstruction(MethodElement method, T node) {
        super(method, node);
    }

    public String ownerName() {
        return ReflectionUtil.<String>get("owner", node());
    }

    /**
     * Gets a short representation of the owner e.g org/jbm/Application would return Application
     *
     * @return owner name
     */
    public String ownerSimpleName() {
        String owner = ownerName();
        return owner.contains("/") ? owner.substring(owner.lastIndexOf('/') + 1) : owner;
    }

    /**
     * Fetches the name of the instruction, field name, method name etc
     *
     * @return name
     */
    public String name() {
        return ReflectionUtil.<String>get("name", node());
    }

    /**
     * Returns the owner class element object
     *
     * @return owner
     */
    public ClassElement owner() {
        return Application.get(ownerName());
    }
}
