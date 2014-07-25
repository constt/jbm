package org.jbm.ui.presenter;

import org.jbm.element.ClassElement;
import org.jbm.ui.Manager;
import org.jbm.ui.model.MainModel;
import org.jbm.ui.view.MainView;
import org.jbm.util.ASMUtil;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;

/**
 * @author : const_
 */
public class MainPresenter extends Presenter<MainView, MainModel> {

    @Override
    public void link() {
        MainView view = new MainView(this);
        MainModel model = new MainModel(this);
        set(view, model);
    }

    @Override
    public void show() {
        view().frame().setVisible(true);
    }

    @Override
    public void hide() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "file:load":
                JFileChooser chooser = new JFileChooser();
                chooser.setFileFilter(new FileNameExtensionFilter("Archive/Class Files", "class", "jar", "zip"));
                int choice = chooser.showOpenDialog(view().frame());
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = chooser.getSelectedFile();
                    List<ClassElement> classes = ASMUtil.load(selectedFile);
                    Manager.get(ClassTreePresenter.class).model().update(classes);
                    Manager.get(ClassTreePresenter.class).model().constructTree();
                }
                break;
        }
    }
}
