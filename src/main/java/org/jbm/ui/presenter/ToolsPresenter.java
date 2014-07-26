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

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
