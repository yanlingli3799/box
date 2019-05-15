## 定时器

### 用法
jdk 提供的定时器工具：`Timer` ：指定时间做指定的事儿。

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

首先，TimerTask 抽象类：
- 实现 Runnable 接口，具有 run()、cancel()、scheduledExecutionTime() 等能力，其中 run() 方法需要由子类自定义。
- 内部定义了一系列状态枚举值，TimerTask 持有一个状态变量，标记任务所处阶段。
- 一个 nextExecutionTime 变量，记录该任务下次执行时间。
- 一个 period 变量，标记任务类型：0是非循环任务，正数表示 fixed-rate 任务（scheduleAtFixedRate），负数表示 fixed-delay 任务（schedule）。
