package org.jbm.ui.view;

import org.jbm.ui.model.Model;
import org.jbm.ui.presenter.Presenter;

import javax.swing.*;

/**
 * @author : const_
 */
public abstract class View<P extends Presenter, M extends Model> {

    protected P presenter;
    protected M model;

    public View(P presenter) {
        this.presenter = presenter;
    }

    public void link() {
        model = (M) presenter.model();
    }

    public abstract void create();

    public abstract void refresh();

    public P presenter() {
        return presenter;
    }

    public M model() {
        return model;
    }

    protected void setModel(Model model) {
        this.model = (M) model;
    }
}
