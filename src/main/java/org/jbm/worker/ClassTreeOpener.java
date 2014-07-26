package org.jbm.worker;

import org.jbm.element.ClassElement;
import org.jbm.ui.Manager;
import org.jbm.ui.component.ToolsTab;
import org.jbm.ui.component.util.ClassTreeNode;
import org.jbm.ui.presenter.ToolsPresenter;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.TreePath;

/**
 * @author : const_
 */
public class ClassTreeOpener extends Worker<ClassElement> {

    private TreeSelectionEvent evt;

    public ClassTreeOpener(TreeSelectionEvent evt) {
        this.evt = evt;
    }

    @Override
    public ClassElement get() {
        TreePath path = evt.getNewLeadSelectionPath();
        if (path == null) {
            return null;
        }
        Object o = path.getLastPathComponent();
        if (o == null) {
            return null;
        }
        if (o instanceof ClassTreeNode) {
            ClassTreeNode node = (ClassTreeNode) o;
            ClassElement element = node.element();
            return element;
        }
        return null;
    }

    @Override
    public void run() {
        ClassElement element = get();
        if (element != null) {
            boolean exists = false;
            ToolsPresenter presenter = Manager.get(ToolsPresenter.class);
            if (presenter.model().openClasses().contains(element)) {
                for (ToolsTab tab : presenter.model().tabs()) {
                    if (tab.element().equals(element)) {
                        exists = true;
                    }
                }
            }
            if (!exists) {
                presenter.model().add(new ToolsTab(element));
            }
            presenter.view().tabbedPane().setSelectedIndex(presenter.model().openClasses().indexOf(element));
        }
    }
}
