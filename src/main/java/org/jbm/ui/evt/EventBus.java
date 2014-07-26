package org.jbm.ui.evt;

import org.jbm.instruction.AbstractInstruction;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

/**
 * @author : const_
 */
public class EventBus {

    public static <T extends InputEvent> void handle(T evt) {
        if (evt.getSource() instanceof JList && evt instanceof MouseEvent) {
            JList list = (JList) evt.getSource();
            ListModel model = list.getModel();
            int index = list.locationToIndex(((MouseEvent) evt).getPoint());
            if (index > -1) {
                Object insn = model.getElementAt(index);
                if (insn instanceof AbstractInstruction) {
                    list.setToolTipText(((AbstractInstruction) insn).definition());
                }
            }
        }
    }
}
