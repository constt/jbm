package org.jbm.worker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : const_
 */
public class Executor {

    private static ExecutorService service;

    public static void init(int threads) {
        service = Executors.newFixedThreadPool(threads);
    }

    public static void execute(Runnable r) {
        service.submit(r);
    }
}
