package org.jbm.ui.presenter;

import org.jbm.element.ClassElement;
import org.jbm.ui.component.ToolsTab;
import org.jbm.ui.model.ToolsModel;
import org.jbm.ui.view.ToolsView;

import java.awt.event.ActionEvent;

/**
 * @author : const_
 */
public class ToolsPresenter extends Presenter<ToolsView, ToolsModel> {


    @Override
    public void link() {
        ToolsView view = new ToolsView(this);
        ToolsModel model = new ToolsModel(this);
        set(view, model);
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    public void open(ClassElement element) {
        boolean exists = false;
        if (model().openClasses().contains(element)) {
            for (ToolsTab tab : model().tabs()) {
                if (tab.element().equals(element)) {
                    exists = true;
                }
            }
        }
        if (!exists) {
            model().add(new ToolsTab(element));
        }
        view().tabbedPane().setSelectedIndex(model().openClasses().indexOf(element));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
