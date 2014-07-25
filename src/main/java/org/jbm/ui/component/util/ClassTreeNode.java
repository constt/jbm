package org.jbm.ui.component.util;

import org.jbm.element.ClassElement;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * @author : const_
 */
public class ClassTreeNode extends DefaultMutableTreeNode {

    private ClassElement element;

    public ClassTreeNode(ClassElement element) {
        super(element);
        this.element = element;
    }

    public ClassElement element() {
        return element;
    }


}
