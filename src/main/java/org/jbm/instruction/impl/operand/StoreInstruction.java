package org.jbm.instruction.impl.operand;

import org.jbm.element.MethodElement;
import org.jbm.instruction.AbstractInstruction;
import org.objectweb.asm.tree.VarInsnNode;

/**
 * @author : const_
 */
public class StoreInstruction extends AbstractInstruction<VarInsnNode> {

    public StoreInstruction(MethodElement method, VarInsnNode node) {
        super(method, node);
    }

    @Override
    public String format() {
        return opcodeName() + " " + variable();
    }

    public int variable() {
        return node().var;
    }

    @Override
    public String definition() {
        return "Stores the local variable at index : " + variable();
    }
}
