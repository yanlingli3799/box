package com.javas.jdks.concurrents.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

  public static void main(String[] args) throws InterruptedException, ExecutionException {

    // TODO：BlockingQueue 阻塞队列的实现
    ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 12, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>(3));

    System.out.println("---1. execute 执行 Runnable,无返回值,不等线程执行完");
    test1(executor);
    Thread.sleep(1000);
    System.out.println();

    System.out.println("---2. execute 执行 Runnable,无返回值,利用 CountDownLatch 阻塞等待线程全部执行完");
    test2(executor);
    Thread.sleep(1000);
    System.out.println();

    System.out.println("---3. submit 执行 Callable,有返回值,Future.get() 阻塞读返回值等待线程执行完");
    test3(executor);
    Thread.sleep(1000);
    System.out.println();

    System.out.println("---4. invokeAll 执行 Callable 列表,有返回值,invokeAll 内部 Future.get() 阻塞执行");
    test4(executor);

    Thread.sleep(1000);
    executor.shutdown();
  }




  private static void test1(ThreadPoolExecutor executor) throws InterruptedException {
    executor.execute(new Runnable() {
      @Override
      public void run() {
        System.out.println("   123");
      }
    });
    System.out.println("   这一行可能打印在123前面");
  }


  private static void test2(ThreadPoolExecutor executor) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(1);
    executor.execute(new Runnable() {
      @Override
      public void run() {
        System.out.println("   456");
        latch.countDown();
      }
    });
    latch.await(10,TimeUnit.MILLISECONDS);
    System.out.println("   这一行一定打印在456后面");
  }


  private static void test3(ThreadPoolExecutor executor) throws ExecutionException, InterruptedException {
    Callable<String> callable = new Callable<String>() {
      public String call() throws Exception {
        System.out.println("   789");
        return "ok";
      }
    };

    Future<?> future = executor.submit(callable);
    System.out.println("   这一行可能打印在789前面");
    System.out.println("   阻塞读返回值"+future.get());
  }

  private static void test4(ThreadPoolExecutor executor) throws InterruptedException {
    List<Callable<Object>> list = new ArrayList<Callable<Object>>(3);
    list.add(new Callable<Object>() {
      @Override
      public Object call() throws Exception {
        System.out.println("   aaa");
        return "ok";
      }
    });
    List<Future<Object>> futures = executor.invokeAll(list);
    for (Future<Object> future : futures) {
      try {
        System.out.println("   返回值："+future.get());
      } catch (Exception e) {
        future.cancel(true);
      }
    }
    System.out.println("   这一行一定在aaa和返回值之后");
  }

}
