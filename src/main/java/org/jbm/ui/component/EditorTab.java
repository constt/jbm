package org.jbm.ui.component;

import org.jbm.element.ClassElement;
import org.jbm.element.FieldElement;
import org.jbm.element.MethodElement;
import org.jbm.instruction.AbstractInstruction;
import org.jbm.ui.Manager;
import org.jbm.ui.presenter.ToolsPresenter;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Modifier;

/**
 * @author : const_
 */
public class EditorTab extends Tab {

    private JList<Object> content;
    private JScrollPane scroller;

    protected EditorTab(ToolsTab toolsTab) {
        super(toolsTab);
        setName("Editor");
    }

    @Override
    public void init() {
        content = new JList<>();
        content.addMouseMotionListener(Manager.get(ToolsPresenter.class));
        DefaultListModel<Object> model = new DefaultListModel<>();
        ClassElement element = toolsTab().element();
        model.addElement(" ");
        model.addElement(element.format());
        model.addElement(" ");
        for(FieldElement field : element.fields()) {
            model.addElement(field);
        }
        model.addElement(" ");
        for (MethodElement method : toolsTab().element().methods()) {
            model.addElement(method);
            for (AbstractInstruction insn : method.instructions()) {
                model.addElement(insn);
            }
            model.addElement("}");
            model.addElement(" ");
        }
        model.addElement("}");
        model.addElement(" ");
        setLayout(new GridLayout(1, 1));
        content.setModel(model);
        scroller = new JScrollPane(content,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scroller);
    }
}
