package org.jbm.ui.view;

import org.jbm.ui.component.ToolsTab;
import org.jbm.ui.model.ToolsModel;
import org.jbm.ui.presenter.ToolsPresenter;

import javax.swing.*;

/**
 * @author : const_
 */
public class ToolsView extends View<ToolsPresenter, ToolsModel> {

    private JTabbedPane tabbedPane;

    public ToolsView(ToolsPresenter presenter) {
        super(presenter);
    }

    @Override
    public void create() {
        tabbedPane = new JTabbedPane();
    }

    public JTabbedPane tabbedPane() {
        return tabbedPane;
    }

    public ToolsTab current() {
        return (ToolsTab) tabbedPane.getComponentAt(tabbedPane.getSelectedIndex());
    }

    @Override
    public void refresh() {
        int size = tabbedPane.getTabCount();
        if (model().tabs().size() > size) {
            tabs:
            for (ToolsTab tab : model().tabs()) {
                for (int i = 0; i < size; i++) {
                    if (tabbedPane.getComponentAt(i) instanceof ToolsTab
                            && ((ToolsTab) tabbedPane.getComponentAt(i)).element().equals(tab.element())) {
                        continue tabs;
                    }
                }
                tabbedPane.add(tab);
            }
        }
    }
}
