package org.jbm.ui;

import org.jbm.ui.presenter.ClassTreePresenter;
import org.jbm.ui.presenter.MainPresenter;
import org.jbm.ui.presenter.Presenter;
import org.jbm.ui.presenter.ToolsPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : const_
 */
public class Manager {

    private static final List<Presenter> presenters = new ArrayList<>();

    static {
        presenters.add(new ClassTreePresenter());
        presenters.add(new ToolsPresenter());
        presenters.add(new MainPresenter());
        for (Presenter presenter : presenters) {
            presenter.view().create();
        }
    }

    public static <T extends Presenter> T get(Class<T> clazz) {
        for (Presenter presenter : presenters) {
            if (presenter.getClass().equals(clazz)) {
                return (T) presenter;
            }
        }
        return null;
    }
}
