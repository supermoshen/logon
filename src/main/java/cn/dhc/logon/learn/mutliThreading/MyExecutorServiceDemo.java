package cn.dhc.logon.learn.mutliThreading;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-09-22
 */
public class MyExecutorServiceDemo {
    static final int MAX_NUM=100;
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("The cache %s").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        Task task = new Task();
        threadPoolExecutor.execute(task);
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < MAX_NUM; i++) {
                System.out.println("This is my " + i + " thread.");
            }
        }
    }
}
