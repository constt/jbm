package org.jbm.ui.model;

import org.jbm.ui.presenter.Presenter;
import org.jbm.ui.view.View;

/**
 * @author : const_
 */
public abstract class Model<V extends View, P extends Presenter> {

    protected P presenter;
    protected V view;

    public Model(P presenter) {
        this.presenter = presenter;
    }

    public void link() {
        view = (V) presenter.view();
    }

    public P presenter() {
        return presenter;
    }

    public V view() {
        return view;
    }
}
