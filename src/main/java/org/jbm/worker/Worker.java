package org.jbm.worker;

/**
 * @author : const_
 */
public abstract class Worker<T> implements Runnable {

    public abstract T get();

    public void execute() {
        Executor.execute(this);
    }
}
