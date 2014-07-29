package org.jbm.ui.evt;

import org.jbm.instruction.AbstractInstruction;

import javax.swing.*;
import java.awt.event.MouseEvent;

/**
 * @author : const_
 */
public class ListMouseMoveEvent extends Event<MouseEvent> {

    private MouseEvent evt;

    public ListMouseMoveEvent(MouseEvent evt) {
        super(evt);
        this.evt = evt;
    }

    @Override
    public void process() {
    }
}
