package org.jbm.graph;


import org.jbm.element.ClassElement;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : const_
 */
public class Branch {

    private ClassElement root;
    private List<ClassElement> elements = new LinkedList<>();

    public Branch(ClassElement root) {
        this.root = root;
        elements.add(root);
    }

    public void add(ClassElement element) {
        elements.add(element);
    }

    public List<ClassElement> elements() {
        return elements;
    }

    public ClassElement last() {
        return elements.get(elements.size() - 1);
    }

    public ClassElement get(int index) {
        return elements.get(index);
    }

    public ClassElement first() {
        return root;
    }

    public int size() {
        return elements.size();
    }

    @Override
    public String toString() {
        String content = elements.get(0).node().name;
        for(int i = 1; i < size(); i++) {
            content += " --> " + elements.get(i).node().name;
        }
        return content;
    }
}
