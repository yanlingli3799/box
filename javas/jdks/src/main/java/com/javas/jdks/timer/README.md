## 定时器

jdk 提供的定时器工具：`Timer` ：指定时间做指定的事儿。

**底层是一个是基于数组用堆实现的优先级队列。**


### 用法


步骤：
- 定义 `TimerTask` 子类，重写 run 方法，指定任务内容。
- new 一个 `Timer` 实例，使用 schedule 执行定时任务，指定 TimerTask 子类实例和间隔时间。

特性：
- Timer 的 schedule 有4种执行方式：
    1. 指定间隔后执行一次
    2. 指定时间点执行一次
    3. 指定间隔后第一次执行，然后指定间隔重复执行
    4. 指定时间点第一次执行，然后指定间隔重复执行
- Timer 的 scheduleAtFixedRate 有 2 种执行方式：
    1. 指定间隔后第一次执行，然后指定间隔重复执行
    2. 指定时间点第一次执行，然后指定间隔重复执行
- `schedule` VS `scheduleAtFixedRate`
    - schedule 是以当前任务的 **实际执行时间** 计算下一个任务的执行时间
    - scheduleAtFixedRate 是以当前任务的 **理论执行时间** 计算下一个任务的执行时间


### 源码

模型：
- `TimerTask`：定义了一个任务的基本属性（run、cancel 等），其中 run() 方法由子类自定义（implements Runnable ）。
- `TaskQueue`：基于 TimerTask 数组实现了个最小堆，可以动态扩容。
- `TimerThread`：和 Timer 共享一个 TaskQueue 队列，mainLoop 每次取堆顶元素，看是否到其执行时间，到则取出并执行。
- `Timer`：持有一个 TaskQueue 和一个 TimerThread 线程，与 Thread 共享 queue，对外暴露接口，允许加入新的任务，并指定执行策略。


细节：
- TimerTask
    - implements Runnable
    - 内部定义了一系列状态枚举值，TimerTask 持有一个状态变量，标记任务所处阶段。
    - 一个 nextExecutionTime 变量，记录该任务下次执行时间。
    - 一个 period 变量，标记任务类型：0是非循环任务，正数表示 fixed-rate 任务（scheduleAtFixedRate），负数表示 fixed-delay 任务（schedule）。
- TimerThread
    - extends Thread
    - 一个 newTasksMayBeScheduled 变量，标记线程是否状态（是否被杀死）。
- Timer
    - 是线程安全的