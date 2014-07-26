package org.jbm.ui.presenter;

import org.jbm.ui.model.ClassTreeModel;
import org.jbm.ui.view.ClassTreeView;
import org.jbm.worker.ClassTreeOpener;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
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
        ClassTreeOpener opener = new ClassTreeOpener(e);
        opener.execute();
    }
}
