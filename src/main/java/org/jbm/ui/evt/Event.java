package org.jbm.ui.evt;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * @author : const_
 */
public abstract class Event<T extends InputEvent> {

    private T evt;

    public Event(T evt) {
        this.evt = evt;
    }

    public T event() {
        return evt;
    }

    public abstract void process();

    public Object source() {
        return event().getSource();
    }

}
