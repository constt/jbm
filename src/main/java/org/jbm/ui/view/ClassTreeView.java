package org.jbm.ui.view;

import org.jbm.element.ClassElement;
import org.jbm.ui.component.util.ClassTreeNode;
import org.jbm.ui.model.ClassTreeModel;
import org.jbm.ui.presenter.ClassTreePresenter;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.List;

/**
 * @author : const_
 */
public class ClassTreeView extends View<ClassTreePresenter, ClassTreeModel> {

    private JTree classTree;

    public ClassTreeView(ClassTreePresenter presenter) {
        super(presenter);
    }

    @Override
    public void create() {
        classTree = new JTree(new Object[]{"Empty"});
        classTree.addTreeSelectionListener(presenter);
    }

    @Override
    public void refresh() {
        List<ClassElement> classes = model().classes();
        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        for (ClassElement element : classes) {
            node.add(new ClassTreeNode(element));
        }
        DefaultTreeModel model = new DefaultTreeModel(node);
        classTree.setModel(model);
    }

    public JTree tree() {
        return classTree;
    }

}
