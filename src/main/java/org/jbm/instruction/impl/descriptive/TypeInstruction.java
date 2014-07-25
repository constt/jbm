package org.jbm.instruction.impl.descriptive;

import com.google.inject.internal.asm.$Opcodes;
import org.jbm.element.MethodElement;
import org.jbm.instruction.impl.DescriptiveInstruction;
import org.jbm.util.ASMUtil;
import org.jbm.util.HTML;
import org.jbm.util.StringUtil;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.TypeInsnNode;

import java.awt.*;

/**
 * @author : const_
 */
public class TypeInstruction extends DescriptiveInstruction<TypeInsnNode> {

    public TypeInstruction(MethodElement method, TypeInsnNode node) {
        super(method, node);
    }

    @Override
    public String simpleDescription() {
        return description().replaceAll("L", "").replaceAll(";", "");
    }

    @Override
    public String format() {
        return "<html>" + HTML.color(Color.GRAY, opcodeName())  + " " + HTML.color(Color.MAGENTA, simpleDescription()) + "</html>";
    }

    @Override
    public String definition() {
        switch (opcode()) {
            case Opcodes.NEW:
                return "Creates a new instance of the class " + simpleDescription();
            case Opcodes.ANEWARRAY:
                return "Creates a new array instance of the class " + simpleDescription();
            case Opcodes.CHECKCAST:
                return "Casts a variable to " + simpleDescription();
            case Opcodes.INSTANCEOF:
                return "Performs 'instance of' of " + simpleDescription() + " on a variable";
        }
        return "null";
    }
}
