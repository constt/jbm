package org.jbm.ui.presenter;

import org.jbm.element.ClassElement;
import org.jbm.ui.Manager;
import org.jbm.ui.component.util.ClassTreeNode;
import org.jbm.ui.model.ClassTreeModel;
import org.jbm.ui.model.Model;
import org.jbm.ui.model.ToolsModel;
import org.jbm.ui.view.ClassTreeView;
import org.jbm.ui.view.View;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.awt.event.ActionEvent;

/**
 * @author : const_
 */
public class ClassTreePresenter extends Presenter<ClassTreeView, ClassTreeModel> implements TreeSelectionListener {

    @Override
    public void link() {
        ClassTreeModel model = new ClassTreeModel(this);
        ClassTreeView view = new ClassTreeView(this);
        set(view, model);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getNewLeadSelectionPath();
        if(path == null) {
            return;
        }
        Object o = path.getLastPathComponent();
        if(o == null) {
            return;
        }
        if(o instanceof ClassTreeNode) {
            ClassTreeNode node = (ClassTreeNode) o;
            ClassElement element = node.element();
            Manager.get(ToolsPresenter.class).open(element);
        }
    }
}
