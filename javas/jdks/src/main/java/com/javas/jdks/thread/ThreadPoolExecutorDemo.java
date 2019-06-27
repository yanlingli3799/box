package com.javas.jdks.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

  public static void main(String[] args) throws InterruptedException {

    int corePoolSize = 30; // 核心线程池大小
    int maximumPoolSize = 30; // 最大线程池大小
    long keepAliveTime = 0; // 线程最大空闲时间
    TimeUnit timeUnit = TimeUnit.MILLISECONDS; // 时间单位
    BlockingQueue<Runnable> queue = new SynchronousQueue<Runnable>(true); // 阻塞队列

    ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit, queue);

    List<Future<Object>> results = executor.invokeAll(buildTaskList());
    System.out.println("结果=" + results);

    for (Future<Object> o : results) {
      o.cancel(true);
    }
    System.out.println("测试");
  }

  private static List<Callable<Object>> buildTaskList() {
    List<Callable<Object>> taskList = new ArrayList<Callable<Object>>(1);
    taskList.add(new Callable<Object>() {
      @Override
      public Object call() throws Exception {
        for (int i = 0; i < 1000; i++) {
          System.out.print(i + "-");
        }
        System.out.println();
        return "ok";
      }
    });
    taskList.add(new Callable<Object>() {
      @Override
      public Object call() throws Exception {
        for (int i = 0; i < 1000; i++) {
          System.out.print(i + ".");
        }
        System.out.println();
        return "ok";
      }
    });

    return taskList;
  }


}
