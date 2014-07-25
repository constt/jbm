package org.jbm.ui.model;

import org.jbm.element.ClassElement;
import org.jbm.ui.component.Tab;
import org.jbm.ui.component.ToolsTab;
import org.jbm.ui.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : const_
 */
public class ToolsModel extends Model {

    private List<ClassElement> openClasses;
    private List<ToolsTab> tabs;

    public ToolsModel(Presenter presenter) {
        super(presenter);
        openClasses = new ArrayList<>();
        tabs = new ArrayList<>();
    }

    public List<ClassElement> openClasses() {
        return openClasses;
    }

    public boolean isOpen(ClassElement element) {
        return openClasses.contains(element);
    }

    public List<ToolsTab> tabs() {
        return tabs;
    }

    public void add(ToolsTab tab) {
        tabs.add(tab);
        openClasses.add(tab.element());
        view().refresh();
    }

    public void remove(ToolsTab tab) {
        tabs.remove(tab);
        openClasses.remove(tab.element());
        view().refresh();
    }
}
