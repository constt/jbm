package org.jbm.ui.presenter;

import org.jbm.ui.model.MainModel;
import org.jbm.ui.view.MainView;
import org.jbm.worker.ClassTreeLoader;

import java.awt.event.ActionEvent;

/**
 * @author : const_
 */
public class MainPresenter extends Presenter<MainView, MainModel> {

    @Override
    public void link() {
        MainView view = new MainView(this);
        MainModel model = new MainModel(this);
        set(view, model);
    }

    @Override
    public void show() {
        view().frame().setVisible(true);
    }

    @Override
    public void hide() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "file:load":
                ClassTreeLoader loader = new ClassTreeLoader();
                loader.execute();
                break;
        }
    }
}
