package org.jbm.worker;

import org.jbm.element.ClassElement;
import org.jbm.ui.Manager;
import org.jbm.ui.presenter.ClassTreePresenter;
import org.jbm.ui.presenter.MainPresenter;
import org.jbm.util.ASMUtil;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.List;

/**
 * @author : const_
 */
public class ClassTreeLoader extends Worker<List<ClassElement>> {

    @Override
    public List<ClassElement> get() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Archive/Class Files", "class", "jar", "zip"));
        int choice = chooser.showOpenDialog(Manager.get(MainPresenter.class).view().frame());
        if (choice == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            if (selectedFile != null) {
                return ASMUtil.load(selectedFile);
            }
        }
        return null;
    }

    @Override
    public void run() {
        List<ClassElement> elements = get();
        if (elements != null) {
            Manager.get(ClassTreePresenter.class).model().update(elements);
            Manager.get(ClassTreePresenter.class).model().constructTree();
            return;
        }
        JOptionPane.showMessageDialog(Manager.get(MainPresenter.class).view().frame(), "Error loading file.");
    }
}
