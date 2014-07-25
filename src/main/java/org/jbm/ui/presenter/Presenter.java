package org.jbm.ui.presenter;

import org.jbm.ui.handler.InputHandler;
import org.jbm.ui.model.Model;
import org.jbm.ui.view.View;

import java.awt.event.ActionListener;

/**
 * @author : const_
 */
public abstract class Presenter<V extends View, M extends Model> extends InputHandler implements ActionListener {

    private V view;
    private M model;

    protected Presenter() {
        link();
    }

    public abstract void link();

    public abstract void show();

    public abstract void hide();

    public V view() {
        return view;
    }

    public M model() {
        return model;
    }

    protected void set(V view, M model) {
        this.view = view;
        this.model = model;
        model.link();
        view.link();
    }
}
