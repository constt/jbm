package org.jbm.instruction.impl.jump;

import org.jbm.element.MethodElement;
import org.jbm.instruction.impl.JumpInstruction;
import org.objectweb.asm.tree.JumpInsnNode;

/**
 * @author : const_
 */
public class GotoInstruction extends JumpInstruction {

    public GotoInstruction(MethodElement method, JumpInsnNode node) {
        super(method, node);
    }



    @Override
    public String definition() {
        return "Branches to label: " + target();
    }
}
