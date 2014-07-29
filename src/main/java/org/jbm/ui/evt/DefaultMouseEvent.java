package org.jbm.ui.evt;

import java.awt.event.MouseEvent;

/**
 * @author : const_
 */
public class DefaultMouseEvent extends Event<MouseEvent> {

    public DefaultMouseEvent(MouseEvent evt) {
        super(evt);
    }

    @Override
    public void process() {
    }
}
