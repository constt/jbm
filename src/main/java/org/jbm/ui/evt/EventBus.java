package org.jbm.ui.evt;

import org.jbm.ui.Manager;
import org.jbm.ui.presenter.ToolsPresenter;
import org.jbm.util.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : const_
 */
public class EventBus {


    private static final List<Method> EVENT_PROCESSORS = new LinkedList<>();

    static {
        EVENT_PROCESSORS.addAll(ReflectionUtil.annotated(EventProcessor.class));
    }

    public static <T extends Event> void handle(T evt) {
        if (evt instanceof ListMouseMoveEvent) {
            for (Method m : EVENT_PROCESSORS) {
                for (Class<?> type : m.getParameterTypes()) {
                    if (type.equals(evt.getClass())) {
                        try {
                            m.invoke(Manager.get(ToolsPresenter.class).view().current().current(), evt);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
