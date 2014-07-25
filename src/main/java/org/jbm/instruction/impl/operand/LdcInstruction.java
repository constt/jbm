package org.jbm.instruction.impl.operand;

import org.jbm.element.MethodElement;
import org.jbm.instruction.AbstractInstruction;
import org.jbm.util.HTML;
import org.objectweb.asm.tree.LdcInsnNode;

import java.awt.*;

/**
 * @author : const_
 */
public class LdcInstruction extends AbstractInstruction<LdcInsnNode> {

    public LdcInstruction(MethodElement method, LdcInsnNode node) {
        super(method, node);
    }

    public Object value() {
        return node().cst;
    }

    public String valueType() {
        switch (node().cst.getClass().getSimpleName()) {
            case "Integer":
                return "int";
            case "Float":
                return "float";
            case "Boolean":
                return "boolean";
            case "Double":
                return "double";
            case "Long":
                return "long";
            case "Character":
                return "char";
            case "Short":
                return "short";
            case "Byte":
                return "byte";
        }
        return node().cst.getClass().getSimpleName();
    }

    @Override
    public String format() {
        if (valueType().equals("String")) {
            return "<html>" + HTML.color(Color.GRAY, opcodeName()) + " (" + HTML.color(Color.MAGENTA, valueType()) + ") "
                    + "\"" + HTML.color(Color.GREEN, value()) + "\"</html>";
        }
        return "<html>" + HTML.color(Color.GRAY, opcodeName()) + " (" + HTML.color(Color.MAGENTA, valueType()) + ") "
                + HTML.color(Color.GREEN, value()) + "</html>";
    }

    @Override
    public String definition() {
        return null;
    }
}
