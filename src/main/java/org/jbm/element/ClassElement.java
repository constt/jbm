package org.jbm.element;

import org.jbm.graph.Branch;
import org.jbm.ui.Manager;
import org.jbm.ui.presenter.ClassTreePresenter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : const_
 */
public class ClassElement {

    private ClassNode node;
    private List<MethodElement> methods = new LinkedList<>();
    private List<FieldElement> fields = new LinkedList<>();
    private Branch branch;

    public ClassElement(ClassNode node) {
        this.node = node;
        for (MethodNode mn : node.methods) {
            methods.add(new MethodElement(this, mn));
        }
        for (FieldNode fn : node.fields) {
            fields.add(new FieldElement(this, fn));
        }
    }

    public Branch branch() {
        if (branch == null) {
            branch = Manager.get(ClassTreePresenter.class).model().tree().find(this);
        }
        return branch;
    }

    public List<FieldElement> fields() {
        return fields;
    }

    public boolean hasSuper() {
        return !node().superName.equals("java/lang/Object");
    }

    public ClassNode node() {
        return node;
    }

    public String name() {
        return node.name;
    }

    public List<MethodElement> methods() {
        return methods;
    }

    public String format() {
        return Modifier.toString(node().access) + " class " + (hasSuper() ? node().superName : "") + " {";
    }

    @Override
    public String toString() {
        return name();
    }
}
