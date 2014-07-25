package org.jbm.ui.view;

import org.jbm.ui.Manager;
import org.jbm.ui.model.MainModel;
import org.jbm.ui.presenter.ClassTreePresenter;
import org.jbm.ui.presenter.MainPresenter;
import org.jbm.ui.presenter.ToolsPresenter;

import javax.swing.*;
import java.awt.*;

/**
 * @author : const_
 */
public class MainView extends View<MainPresenter, MainModel> {

    private JFrame frame;

    public MainView(MainPresenter presenter) {
        super(presenter);
    }

    @Override
    public void create() {
        frame = new JFrame();
        frame.setBounds(100, 100, 631, 418);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu mnFile = new JMenu("File");
        menuBar.add(mnFile);
        JMenuItem load = new JMenuItem("Load");
        load.setActionCommand("file:load");
        load.addActionListener(presenter);
        mnFile.add(load);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        JLabel test = new JLabel("Class(es):");
        frame.getContentPane().add(test, BorderLayout.BEFORE_FIRST_LINE);
        JScrollPane classScroller = new JScrollPane(Manager.get(ClassTreePresenter.class).view().tree(),
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.getContentPane().add(classScroller, BorderLayout.WEST);
        frame.getContentPane().add(Manager.get(ToolsPresenter.class).view().tabbedPane(), BorderLayout.CENTER);
        frame.setVisible(false);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    public JFrame frame() {
        return frame;
    }

    @Override
    public void refresh() {

    }
}
