package org.jbm.ui.handler;

import org.jbm.ui.evt.DefaultKeyEvent;
import org.jbm.ui.evt.DefaultMouseEvent;
import org.jbm.ui.evt.EventBus;
import org.jbm.ui.evt.ListMouseMoveEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author : const_
 */
public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {
    @Override
    public void keyTyped(KeyEvent e) {
        EventBus.handle(new DefaultKeyEvent(e));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        EventBus.handle(new DefaultKeyEvent(e));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        EventBus.handle(new DefaultKeyEvent(e));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        EventBus.handle(new DefaultMouseEvent(e));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        EventBus.handle(new DefaultMouseEvent(e));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        EventBus.handle(new DefaultMouseEvent(e));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        EventBus.handle(new DefaultMouseEvent(e));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        EventBus.handle(new DefaultMouseEvent(e));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        EventBus.handle(new DefaultMouseEvent(e));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (e.getSource() instanceof JList) {
            ListMouseMoveEvent evt = new ListMouseMoveEvent(e);
            EventBus.handle(evt);
        }
    }
}
