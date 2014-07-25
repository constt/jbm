package org.jbm.ui.component;

import org.jbm.element.ClassElement;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : const_
 */
public class ToolsTab extends JPanel {

    private JTabbedPane tabbedPane;
    private ClassElement element;

    public ToolsTab(ClassElement element) {
        this.element = element;
        setName(element.name());
        init();
    }

    public void init() {
        tabbedPane = new JTabbedPane();
        tabbedPane.add(new EditorTab(this));
        setLayout(new GridLayout(1, 1));
        add(tabbedPane);
    }

    public ClassElement element() {
        return element;
    }
}
