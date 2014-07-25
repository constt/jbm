package org.jbm.instruction.impl.descriptive.named;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;
import org.jbm.element.MethodElement;
import org.jbm.instruction.impl.NamedInstruction;
import org.jbm.util.HTML;
import org.jbm.util.StringUtil;
import org.objectweb.asm.tree.FieldInsnNode;

import java.awt.*;

/**
 * @author : const_
 */
public class FieldInstruction extends NamedInstruction<FieldInsnNode> {

    public FieldInstruction(MethodElement method, FieldInsnNode node) {
        super(method, node);
    }

    @Override
    public String simpleDescription() {
        StringBuilder builder = new StringBuilder();
        String desc = description();
        builder.append(desc.replaceAll("L", ";").replaceAll(";", "").replaceAll("\\[", ""));
        int count = StringUtil.count(desc, "\\[");
        for(int i =0; i < count; i++) {
            builder.append("[]");
        }
        return builder.toString();
    }

    @Override
    public String format() {
        return "<html>" + HTML.color(Color.GRAY, opcodeName()) + " " + HTML.color(Color.MAGENTA, simpleDescription())
                + " " + ownerName() + "." + name() + "</html>";
    }

    @Override
    public String definition() {
        switch (opcode()) {
            case Opcodes.GETSTATIC:
                return "Gets the static instance(field) of " + ownerName() + "." + name();
           case Opcodes.GETFIELD:
               return "Gets the instance(field) of " + ownerName() + "." + name();
            case Opcodes.PUTFIELD:
                return "Sets the field value of " + ownerName() + "." + name();
            case Opcodes.PUTSTATIC:
                return "Sets the static field value of " + ownerName() + "." + name();
        }
        return "null";
    }
}
