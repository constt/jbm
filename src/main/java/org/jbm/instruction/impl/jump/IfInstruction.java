package org.jbm.instruction.impl.jump;

import org.jbm.element.MethodElement;
import org.jbm.instruction.impl.JumpInstruction;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.JumpInsnNode;

/**
 * @author : const_
 */
public class IfInstruction extends JumpInstruction {

    public IfInstruction(MethodElement method, JumpInsnNode node) {
        super(method, node);
    }


    @Override
    public String definition() {
        switch (opcode()) {
            case Opcodes.IF_ACMPEQ:
                return "If the two values are equal(==) branches to label: " + target();
            case Opcodes.IF_ACMPNE:
                return "If the two values are NOT equal(!=) branches to label: " + target();
            case Opcodes.IF_ICMPEQ:
                return "If two int values are equal (==) branches to label: " + target();
            case Opcodes.IF_ICMPGE:
                return "If first value is greater than or equal to (>=) second value branches to label: " + target();
            case Opcodes.IF_ICMPGT:
                return "If first value is greater than (>) second value branches to label: " + target();
            case Opcodes.IF_ICMPLE:
                return "If first value is less than or equal to(<=) second value branches to label: " + target();
            case Opcodes.IF_ICMPLT:
                return "If first value is less than (<) second value branches to label: " + target();
            case Opcodes.IF_ICMPNE:
                return "If the two values are not equal (!=) branches to label: " + target();
            case Opcodes.IFEQ:
                return "If the value is equal to 0 (==) branches to label: " + target();
            case Opcodes.IFGE:
                return "If the value is greater than or equal to 0 (>=) branches to label: " + target();
            case Opcodes.IFGT:
                return "If the value is greater than 0 (>) branches to label: " + target();
            case Opcodes.IFLE:
                return "If the value is less than or equal to 0 (<=) branches to label: " + target();
            case Opcodes.IFLT:
                return "If the value is less than 0 (<) branches to label: " + target();
            case Opcodes.IFNE:
                return "If the value is NOT equal to 0 (!=) branches to label: " + target();
            case Opcodes.IFNONNULL:
                return "If the value is not null (!=) branches to label: " + target();
            case Opcodes.IFNULL:
                return "If the value is null (==) branches to label: " + target();
        }
        return "null";
    }
}
