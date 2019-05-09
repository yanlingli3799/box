package com.javas.jdks.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by liyanling on 2019/5/9.
 */
public class TimerSample {

  public static void main(String[] args){

    System.out.println("主线程id："+Thread.currentThread().getId());
    System.out.println("主线程name："+Thread.currentThread().getName());


    Reminder reminder = new Reminder();

    System.out.println("方法1：延迟指定时间间隔后执行任务");
    reminder.run1(2);

    System.out.println("方法2：指定时间点执行任务");
    reminder.run2(new Date());

    System.out.println("方法3：指定时间间隔后首次执行，接下来再指定时间间隔重复执行");
    reminder.run3(2,3);

    System.out.println("方法4：指定时间首次执行，接下来再指定时间间隔重复执行");
    reminder.run4(new Date(),3);



    // scheduleAtFixedRate 也有上述3、4两种方式，不写例子了，看不出啥差别。
    // - schedule 是以上一个任务的实际执行时间计算下一个任务的执行时间的。
    // - scheduleAtFixedRate 是计算的理论执行时间，任何一个任务的执行时间都不受上一个任务实际执行时间的影响。

  }




  public static class Reminder{

    Reminder(){
    }


    void run1(int sec){
      System.out.println("延迟指定时间后执行任务，sec="+sec);
      Timer timer = new Timer();

      timer.schedule(new TimerTask() {
        @Override
        public void run() {
          System.out.println("run1子线程id："+Thread.currentThread().getId());
          System.out.println("run1子线程name："+Thread.currentThread().getName());
          timer.cancel();// 这里要 cancel 一下，否则 timer 不会关闭
        }
      },sec*1000);

    }


    void run2(Date time){
      System.out.println("指定时间点执行任务，time="+time);
      Timer timer = new Timer();
      timer.schedule(new TimerTask() {
        @Override
        public void run() {
          System.out.println("run2子线程id："+Thread.currentThread().getId());
          System.out.println("run2子线程name："+Thread.currentThread().getName());
          timer.cancel();
        }
      },time);
    }

    void run3(int sec,int interval){
      System.out.println("延迟指定时间后执行任务，sec="+sec+" 间隔 "+interval+" 循环执行");
      Timer timer = new Timer();
      timer.schedule(new TimerTask() {
        @Override
        public void run() {
          System.out.println("run3子线程id："+Thread.currentThread().getId());
          System.out.println("run3子线程name："+Thread.currentThread().getName());
        }
      },sec*1000,interval*1000);
    }

    public void run4(Date date, int interval) {
      System.out.println("指定时间执行任务，date="+date+" 间隔 "+interval+" 循环执行");
      Timer timer = new Timer();
      timer.schedule(new TimerTask() {
        @Override
        public void run() {
          System.out.println("run4子线程id："+Thread.currentThread().getId());
          System.out.println("run4子线程name："+Thread.currentThread().getName());
        }
      },date,interval*1000);

    }
  }




}
