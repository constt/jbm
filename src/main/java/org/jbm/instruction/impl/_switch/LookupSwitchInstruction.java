package org.jbm.instruction.impl._switch;

import org.jbm.element.MethodElement;
import org.jbm.instruction.impl.SwitchInstruction;
import org.jbm.util.HTML;
import org.objectweb.asm.tree.LookupSwitchInsnNode;

import java.awt.*;

/**
 * @author : const_
 */
public class LookupSwitchInstruction extends SwitchInstruction<LookupSwitchInsnNode> {
    public LookupSwitchInstruction(MethodElement method, LookupSwitchInsnNode node) {
        super(method, node);
    }

    @Override
    public String format() {
        return "<html>" + HTML.color(Color.GRAY, opcodeName()) + "</html>";
    }

    @Override
    public String definition() {
        return "Performs a lookupswitch on a set of keys starting at index ";
    }
}
