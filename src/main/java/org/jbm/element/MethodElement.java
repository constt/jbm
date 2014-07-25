package org.jbm.element;

import org.jbm.instruction.AbstractInstruction;
import org.jbm.instruction.impl._switch.LookupSwitchInstruction;
import org.jbm.instruction.impl._switch.TableSwitchInstruction;
import org.jbm.instruction.impl.descriptive.MultiNewArrayInstruction;
import org.jbm.instruction.impl.descriptive.TypeInstruction;
import org.jbm.instruction.impl.descriptive.named.FieldInstruction;
import org.jbm.instruction.impl.descriptive.named.MethodInstruction;
import org.jbm.instruction.impl.jump.GotoInstruction;
import org.jbm.instruction.impl.jump.IfInstruction;
import org.jbm.instruction.impl.operand.LdcInstruction;
import org.jbm.instruction.impl.operand.LoadInstruction;
import org.jbm.instruction.impl.operand.PushInstruction;
import org.jbm.instruction.impl.simple.BasicInstruction;
import org.jbm.instruction.impl.simple.IncrementalInstruction;
import org.jbm.instruction.impl.simple.LabelInstruction;
import org.jbm.util.ASMUtil;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : const_
 */
public class MethodElement {

    private ClassElement owner;
    private MethodNode node;
    private List<AbstractInstruction> instructions = new LinkedList<>();

    public MethodElement(ClassElement owner, MethodNode node) {
        this.owner = owner;
        this.node = node;
        loadInstructions();
    }

    public String format() {
        return Modifier.toString(node.access).trim() + " " +
                ASMUtil.primitiveName(ASMUtil.strip(node.desc.substring(node.desc.lastIndexOf(')') + 1)))
                + " " + node.name + node.desc.substring(0, node.desc.lastIndexOf(')') + 1) + " {";
    }

    private void loadInstructions() {
        for (AbstractInsnNode ain : node.instructions.toArray()) {
            switch (ain.getType()) {
                case AbstractInsnNode.FIELD_INSN:
                    instructions.add(new FieldInstruction(this, (FieldInsnNode) ain));
                    break;
                case AbstractInsnNode.METHOD_INSN:
                    instructions.add(new MethodInstruction(this, (MethodInsnNode) ain));
                    break;
                case AbstractInsnNode.VAR_INSN:
                    instructions.add(new LoadInstruction(this, (VarInsnNode) ain));
                    break;
                case AbstractInsnNode.INT_INSN:
                    instructions.add(new PushInstruction(this, (IntInsnNode) ain));
                    break;
                case AbstractInsnNode.JUMP_INSN:
                    if (ain.getOpcode() == Opcodes.GOTO) {
                        instructions.add(new GotoInstruction(this, (JumpInsnNode) ain));
                    } else {
                        instructions.add(new IfInstruction(this, (JumpInsnNode) ain));
                    }
                    break;
                case AbstractInsnNode.LDC_INSN:
                    instructions.add(new LdcInstruction(this, (LdcInsnNode) ain));
                    break;
                case AbstractInsnNode.INSN:
                    instructions.add(new BasicInstruction(this, (InsnNode) ain));
                    break;
                case AbstractInsnNode.IINC_INSN:
                    instructions.add(new IncrementalInstruction(this, (IincInsnNode) ain));
                    break;
                case AbstractInsnNode.LABEL:
                    instructions.add(new LabelInstruction(this, (LabelNode) ain));
                    break;
                case AbstractInsnNode.LOOKUPSWITCH_INSN:
                    instructions.add(new LookupSwitchInstruction(this, (LookupSwitchInsnNode) ain));
                    break;
                case AbstractInsnNode.TABLESWITCH_INSN:
                    instructions.add(new TableSwitchInstruction(this, (TableSwitchInsnNode) ain));
                    break;
                case AbstractInsnNode.MULTIANEWARRAY_INSN:
                    instructions.add(new MultiNewArrayInstruction(this, (MultiANewArrayInsnNode) ain));
                    break;
                case AbstractInsnNode.TYPE_INSN:
                    instructions.add(new TypeInstruction(this, (TypeInsnNode) ain));
            }
        }
    }

    public ClassElement owner() {
        return owner;
    }

    public MethodNode node() {
        return node;
    }

    public List<AbstractInstruction> instructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return format();
    }
}
