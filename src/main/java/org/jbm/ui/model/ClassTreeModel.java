package org.jbm.ui.model;

import org.jbm.element.ClassElement;
import org.jbm.graph.Tree;
import org.jbm.ui.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : const_
 */
public class ClassTreeModel extends Model {

    private List<ClassElement> classes;
    private Tree tree;

    public ClassTreeModel(Presenter presenter) {
        super(presenter);
        classes = new ArrayList<>();
    }

    public List<ClassElement> classes() {
        return classes;
    }

    public void update(List<ClassElement> classes) {
        this.classes = new ArrayList<>(classes);
        view().refresh();
    }

    public void add(ClassElement element) {
        classes.add(element);
        view().refresh();
    }

    public void remove(ClassElement element) {
        classes.remove(element);
        view().refresh();
    }

    public void constructTree() {
        tree = new Tree(classes);
        tree.build();
    }

    public Tree tree() {
        return tree;
    }
}
