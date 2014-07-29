package org.jbm.instruction.impl;

import org.jbm.element.MethodElement;
import org.jbm.instruction.AbstractInstruction;
import org.jbm.util.ReflectionUtil;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.LabelNode;

import java.sql.Ref;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : const_
 */
public abstract class SwitchInstruction<T extends AbstractInsnNode> extends AbstractInstruction<T> {

    public SwitchInstruction(MethodElement method, T node) {
        super(method, node);
    }

    /**
     * Gets the index of the default: block start
     * @return int
     */
    public int defaultStart() {
        return method().node().instructions.indexOf(ReflectionUtil.<LabelNode>get("dflt", node()));
    }

    /**
     * Gets the starts of each handler block
     * @return list of integers
     */
    public List<Integer> blockStarts() {
        List<Integer> idxs = new LinkedList<>();
        for(LabelNode labeLNode : ReflectionUtil.<List<LabelNode>>get("blocks", node())) {
            idxs.add(method().node().instructions.indexOf(labeLNode));
        }
        return idxs;
    }
}
