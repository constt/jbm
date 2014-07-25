package org.jbm.instruction.impl.operand;

import org.jbm.element.MethodElement;
import org.jbm.instruction.AbstractInstruction;
import org.objectweb.asm.tree.IntInsnNode;

/**
 * @author : const_
 */
public class PushInstruction extends AbstractInstruction<IntInsnNode> {

    public PushInstruction(MethodElement method, IntInsnNode node) {
        super(method, node);
    }

    @Override
    public String format() {
        return opcodeName() + " " + operand();
    }

    public int operand() {
        return node().operand;
    }

    @Override
    public String definition() {
        return "Pushes a value of " + node().operand + " onto the stack";
    }
}
