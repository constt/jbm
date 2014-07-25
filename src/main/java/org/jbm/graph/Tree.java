package org.jbm.graph;

import org.jbm.element.ClassElement;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author : const_
 */
public class Tree {

    private List<Branch> branches = new LinkedList<>();
    private List<ClassElement> elements;
    private List<ClassElement> all;

    public Tree(List<ClassElement> elements) {
        this.elements = new LinkedList<>(elements);
        this.all = new LinkedList<>(elements);
    }

    public Branch find(ClassElement element) {
        for(Branch branch : branches) {
            if(branch.elements().contains(element)) {
                return branch;
            }
        }
        return null;
    }

    public void build() {
        initBranches();
        buildBranches();
    }

    private void buildBranches() {
        for (Branch branch : branches) {
            ClassElement next;
            while ((next = next(branch.last())) != null) {
                branch.add(next);
            }
        }
    }

    private ClassElement next(ClassElement element) {
        for (ClassElement _element : all) {
            if (element.node().superName.equals(_element.node().name)) {
                return _element;
            }
        }
        return null;
    }

    private void initBranches() {
        ListIterator<ClassElement> iterator = elements.listIterator();
        iterator:
        while (iterator.hasNext()) {
            ClassElement next = iterator.next();
            for (ClassElement element : all) {
                if (element.node().superName.equals(next.node().name)) {
                    continue iterator;
                }
            }
            branches.add(new Branch(next));
            iterator.remove();
        }
    }

    @Override
    public String toString() {
        String content = branches.get(0).toString();
        for(int i = 1; i < branches.size(); i++) {
            content += "\n" + branches.get(i).toString();
        }
        return content;
    }

    public List<Branch> branches() {
        return branches;
    }

    public List<ClassElement> elements() {
        return elements;
    }

    public List<ClassElement> all() {
        return all;
    }
}
