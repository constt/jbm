package org.jbm.instruction.impl;

import org.jbm.element.MethodElement;
import org.jbm.instruction.AbstractInstruction;
import org.jbm.util.HTML;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;

import java.awt.*;

/**
 * @author : const_
 */
public abstract class JumpInstruction<T extends JumpInsnNode> extends AbstractInstruction<T> {

    public JumpInstruction(MethodElement method, T node) {
        super(method, node);
    }

    public int target() {
        LabelNode label = node().label;
        return method().node().instructions.indexOf(label);
    }

    @Override
    public String format() {
        return "<html>" + HTML.color(Color.GRAY, opcodeName()) + " --> label: " + HTML.color(Color.RED, target()) + "</html>";
    }
}
