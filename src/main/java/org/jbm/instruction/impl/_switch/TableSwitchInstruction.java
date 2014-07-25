package org.jbm.instruction.impl._switch;

import org.jbm.element.MethodElement;
import org.jbm.instruction.impl.SwitchInstruction;
import org.objectweb.asm.tree.TableSwitchInsnNode;

/**
 * @author : const_
 */
public class TableSwitchInstruction extends SwitchInstruction<TableSwitchInsnNode> {

    public TableSwitchInstruction(MethodElement method, TableSwitchInsnNode node) {
        super(method, node);
    }

    /**
     * Gets the minimum key value
     * @return int
     */
    public int min() {
        return node().min;
    }

    /**
     * Gets the maximum key value
     * @return int
     */
    public int max() {
        return node().max;
    }
}
