package org.jbm.instruction.impl.descriptive;

import org.jbm.element.MethodElement;
import org.jbm.instruction.impl.DescriptiveInstruction;
import org.jbm.util.ASMUtil;
import org.jbm.util.HTML;
import org.jbm.util.StringUtil;
import org.objectweb.asm.tree.MultiANewArrayInsnNode;

import java.awt.*;

/**
 * @author : const_
 */
public class MultiNewArrayInstruction extends DescriptiveInstruction<MultiANewArrayInsnNode> {
    public MultiNewArrayInstruction(MethodElement method, MultiANewArrayInsnNode node) {
        super(method, node);
    }

    public int dimensions() {
        return node().dims;
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
        return "<html>" + HTML.color(Color.GRAY, opcodeName())  + HTML.color(Color.MAGENTA, simpleDescription()) + "</html>";
    }

    @Override
    public String definition() {
        return "Create a " +dimensions() + " dimensional array of " + ASMUtil.primitiveName(
                simpleDescription().replaceAll("\\[\\]", ""));
    }
}
