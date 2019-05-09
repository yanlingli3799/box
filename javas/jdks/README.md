

## 定时器

jdk 提供的定时器工具：`Timer` 和 `TimerTask`：指定时间做指定的事儿。

步骤：
- 定义 `TimerTask` 子类，重写 run 方法，指定任务内容。
- new 一个 `Timer` 实例，指定 TimerTask 子类实例和间隔时间。

特性：
- Timer 的 schedule 有4种执行方式：
    1. 指定间隔后执行一次
    2. 指定时间点执行一次
    3. 指定间隔后第一次执行，然后指定间隔重复执行
    4. 指定时间点第一次执行，然后指定间隔重复执行
- Timer 的 scheduleAtFixedRate 有 2 种执行方式：
    1. 指定间隔后第一次执行，然后指定间隔重复执行
    2. 指定时间点第一次执行，然后指定间隔重复执行
- schedule VS scheduleAtFixedRate
    - schedule 是以当前任务的 **实际执行时间** 计算下一个任务的执行时间
    - scheduleAtFixedRate 是以当前任务的 **理论执行时间** 计算下一个任务的执行时间

