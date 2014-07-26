package org.jbm.ui.handler;

import org.jbm.ui.evt.EventBus;

import java.awt.*;
import java.awt.event.*;

/**
 * @author : const_
 */
public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {
    @Override
    public void keyTyped(KeyEvent e) {
        EventBus.handle(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        EventBus.handle(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        EventBus.handle(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        EventBus.handle(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        EventBus.handle(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        EventBus.handle(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        EventBus.handle(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        EventBus.handle(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        EventBus.handle(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        EventBus.handle(e);
    }
}
