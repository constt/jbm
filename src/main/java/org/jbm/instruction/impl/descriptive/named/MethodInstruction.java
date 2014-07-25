package org.jbm.instruction.impl.descriptive.named;

import org.jbm.element.MethodElement;
import org.jbm.instruction.impl.NamedInstruction;
import org.jbm.util.ASMUtil;
import org.jbm.util.HTML;
import org.jbm.util.StringUtil;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.MethodInsnNode;

import java.awt.*;
import java.util.List;

/**
 * @author : const_
 */
public class MethodInstruction extends NamedInstruction<MethodInsnNode> {

    public MethodInstruction(MethodElement method, MethodInsnNode node) {
        super(method, node);
    }

    @Override
    public String simpleDescription() {
        String desc = description();
        List<String> parameters = ASMUtil.parameters(desc);
        StringBuilder builder = new StringBuilder("(");
        for (int i = 0; i < parameters.size(); i++) {
            String param = parameters.get(i);
            int count = StringUtil.count(param, "\\[");
            builder.append(param.replaceAll("L", "").replaceAll(";", "").replaceAll("\\[", ""));
            for (int x = 0; x < count; x++) {
                builder.append("[]");
            }
            if (i + 1 < parameters.size()) {
                builder.append(", ");
            }
        }
        builder.append(")").append(" ");
        return builder.toString();
    }

    public String returnDescription() {
        String desc = description();
        StringBuilder builder = new StringBuilder();
        String return_ = desc.substring(desc.lastIndexOf(')') + 1);
        if (!return_.contains("L")) {
            return_ = ASMUtil.primitiveName(return_);
        }
        builder.append(return_.replaceAll("\\[", "").replaceAll("L", "").replaceAll(";", ""));
        int count = StringUtil.count(return_, "\\[");
        for (int x = 0; x < count; x++) {
            builder.append("[]");
        }
        return builder.toString();
    }

    @Override
    public String format() {
        return "<html>" + HTML.color(Color.GRAY, opcodeName()) + " " + HTML.color(Color.BLUE, returnDescription())
                + " " + ownerName() + "." + name() + " " + HTML.color(Color.MAGENTA, simpleDescription()) + "</html>";
    }

    @Override
    public String definition() {
        switch (opcode()) {
            case Opcodes.INVOKEINTERFACE:
                return "Invokes the method " + ownerName() + "." + name() + simpleDescription() + "from an interface";
            case Opcodes.INVOKEVIRTUAL:
                return "Invokes the method " + ownerName() + "." + name() + simpleDescription() + " from an instance";
            case Opcodes.INVOKESTATIC:
                return "Invokes the static method " + ownerName() + "." + name() + simpleDescription();
            case Opcodes.INVOKESPECIAL:
                return "Invokes the method " + ownerName() + "." + name() + simpleDescription();
            case Opcodes.INVOKEDYNAMIC:
                return "Invokes the method " + ownerName() + "." + name() + simpleDescription();
        }
        return "null";
    }
}
