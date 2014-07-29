package org.jbm.instruction.impl._switch;

import org.jbm.element.MethodElement;
import org.jbm.instruction.impl.SwitchInstruction;
import org.jbm.util.HTML;
import org.objectweb.asm.tree.TableSwitchInsnNode;

import java.awt.*;

/**
 * @author : const_
 */
public class TableSwitchInstruction extends SwitchInstruction<TableSwitchInsnNode> {

    public TableSwitchInstruction(MethodElement method, TableSwitchInsnNode node) {
        super(method, node);
    }

    @Override
    public String format() {
        return "<html>" + HTML.color(Color.GRAY, opcodeName()) + "</html>";
    }

    @Override
    public String definition() {
        return "Continues execution from an address in the table at offset index: " + defaultStart();
    }

    /**
     * Gets the minimum key value
     *
     * @return int
     */
    public int min() {
        return node().min;
    }

    /**
     * Gets the maximum key value
     *
     * @return int
     */
    public int max() {
        return node().max;
    }
}
