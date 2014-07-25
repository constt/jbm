package org.jbm.instruction.impl.simple;

import org.jbm.element.MethodElement;
import org.jbm.instruction.AbstractInstruction;
import org.jbm.util.HTML;
import org.objectweb.asm.tree.IincInsnNode;

import java.awt.*;

/**
 * @author : const_
 */
public class IncrementalInstruction extends AbstractInstruction<IincInsnNode> {

    public IncrementalInstruction(MethodElement method, IincInsnNode node) {
        super(method, node);
    }

    public int increment() {
        return node().incr;
    }

    public int index() {
        return node().var;
    }

    @Override
    public String format() {
        return opcodeName() + " increment: " + HTML.color(Color.ORANGE, increment()) + " local var: " +
                HTML.color(Color.RED, index());
    }

    @Override
    public String definition() {
        return "Increments local variable at index " + index() + " by " + increment();
    }
}
