package org.jbm;

import org.jbm.element.ClassElement;
import org.jbm.element.MethodElement;
import org.jbm.instruction.AbstractInstruction;
import org.jbm.ui.Manager;
import org.jbm.ui.presenter.MainPresenter;
import org.jbm.util.ASMUtil;

import java.io.File;
import java.util.List;

/**
 * @author : const_
 */
public class Application {

    private static List<ClassElement> classes;

    public static void main(String[] args) {
        List<String> st = ASMUtil.parameters("(IILah;[Lab;IS)V");
      /*  classes = ASMUtil.load(new File("./gamepack.jar"));
        for (ClassElement element : classes) {
            for (MethodElement ele : element.methods()) {
                for (AbstractInstruction ain : ele.instructions()) {
                    System.out.println(ain.format());
                }
            }
        }*/
        Manager.get(MainPresenter.class).show();
    }


    public static ClassElement get(String name) {
        for (ClassElement element : classes) {
            if (element.name().equals(name)) {
                return element;
            }
        }
        return null;
    }
}
