package org.jbm.instruction.impl.simple;

import org.jbm.element.MethodElement;
import org.jbm.instruction.AbstractInstruction;
import org.jbm.util.HTML;
import org.objectweb.asm.tree.LabelNode;

import java.awt.*;

/**
 * @author : const_
 */
public class LabelInstruction extends AbstractInstruction<LabelNode> {

    public LabelInstruction(MethodElement method, LabelNode node) {
        super(method, node);
    }

    public int index() {
        return method().node().instructions.indexOf(node());
    }

    @Override
    public String format() {
        return "<html>label: " + HTML.color(Color.RED, index()) + "</html>";
    }

    @Override
    public String definition() {
        return "Label for index: " + index();
    }
}
