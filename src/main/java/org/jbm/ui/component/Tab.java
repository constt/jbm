package org.jbm.ui.component;

import org.jbm.element.ClassElement;

import javax.swing.*;

/**
 * @author : const_
 */
public abstract class Tab extends JPanel {

    protected String name;
    protected ClassElement element;
    private ToolsTab toolsTab;

    protected Tab(ToolsTab toolsTab) {
        this.toolsTab = toolsTab;
        this.element = toolsTab.element();
        this.name = getClass().getSimpleName().substring(0, getClass().getSimpleName().indexOf("Tab"));
        init();
    }

    public abstract void init();


    public String name() {
        return name;
    }

    public ClassElement element() {
        return element;
    }

    public ToolsTab toolsTab() {
        return toolsTab;
    }
}
