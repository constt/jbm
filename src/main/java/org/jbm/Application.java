package org.jbm;

import org.jbm.element.ClassElement;
import org.jbm.element.MethodElement;
import org.jbm.instruction.AbstractInstruction;
import org.jbm.ui.Manager;
import org.jbm.ui.presenter.MainPresenter;
import org.jbm.util.ASMUtil;
import org.jbm.worker.Executor;

import java.io.File;
import java.util.List;

/**
 * @author : const_
 */
public class Application {

    public static void main(String[] args) {
        Executor.init(10);
        Manager.get(MainPresenter.class).show();
    }

}
