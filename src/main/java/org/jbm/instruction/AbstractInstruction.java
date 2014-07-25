package org.jbm.instruction;

import org.jbm.element.MethodElement;
import org.jbm.util.ASMUtil;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;

/**
 * @author : const_
 */
public abstract class AbstractInstruction<T extends AbstractInsnNode> {

    private MethodElement method;
    private T node;

    public AbstractInstruction(MethodElement method, T node) {
        this.method = method;
        this.node = node;
    }

    public abstract String format();

    public abstract String definition();

    public String opcodeName() {
        return ASMUtil.opcode(opcode());
    }

    public int opcode() {
        return node.getOpcode();
    }

    public int type() {
        return node.getType();
    }

    public T node() {
        return node;
    }

    public MethodElement method() {
        return method;
    }

    @Override
    public String toString() {
        return format();
    }
}
