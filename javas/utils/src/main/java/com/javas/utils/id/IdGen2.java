package com.javas.utils.id;


/**
 * id生成规则：{时间} + {数据中心} + {应用} + {随机值}
 * - 时间，决定了从 TWEPOCH 开始多久内不会生成重复id。30年大约946080000秒，二进制占 30 bit。
 * - 数据中心，bit数可配置，决定最多可以有多少个数据中心。
 * - 应用，bit数可配置，决定每个数据中心可以有多少个应用。
 * - 随机值，bit数可配置，决定一个数据中心一个应用同一秒最多能生成多少个id。
 */
public class IdGen2 {

  private final static long TWEPOCH = 1448928000L; // 2015/12/01 00:00:00 UTC
  private final        long dataCenterId;// 数据中心编号
  private final        long workerId;// 应用编号

  private final int workerLShift; // {应用} 应该左移多少 bit
  private final int dataCenterLShift;// {数据中心} 应该左移多少 bit
  private final int timeLShift;// {时间} 应该左移多少 bit

  private       long sequence = 0;
  private final long sequenceMask;// 这是统一毫秒内可生成id数上限

  private long lastTimeMillis = -1L;// 上次获取 id 的毫秒

  /**
   * 构造方法
   * 指定 dataCenterId 和 workerID
   * 指定 dataCenter、worker、sequence 各自占比（bit数）
   *
   * @param dataCenterId
   * @param dataCenterBits
   * @param workerId
   * @param workerBits
   * @param sequenceBits
   */
  public IdGen2(long dataCenterId, int dataCenterBits, long workerId, int workerBits, int sequenceBits) {
    this.dataCenterId = dataCenterId;
    this.workerId = workerId;

    // 限制 {数据中心}+{应用}+{随机值} 最多占 24 bit
    if (dataCenterBits + workerBits + sequenceBits > 24) {
      throw new IllegalArgumentException("sum bits of center+worker+sequence should be <= 24");
    }

    // 检查 {数据中心} 有没有越界
    if (dataCenterId < 0 || dataCenterId >= (1 << dataCenterBits)) {
      throw new IllegalArgumentException(String.format("dataCenterId should be between 0 and %d", 1 << dataCenterBits));
    }

    // 检查 {应用} 有没有越界
    if (workerId < 0 || workerId >= (1 << workerBits)) {
      throw new IllegalArgumentException(String.format("workerId should be between 0 and %d", 1 << workerBits));
    }

    sequenceMask = ~(-1L << sequenceBits);
    workerLShift = sequenceBits;
    dataCenterLShift = sequenceBits + workerBits;
    timeLShift = sequenceBits + workerBits + dataCenterBits;
  }


  /**
   * 生成 id
   *
   * @return
   */
  public synchronized long nextId() {
    long currentTimeMillis = System.currentTimeMillis();

    // 异常处理，当前时间在 lastTimeMillis 之后。可能是时钟重置。
    if (currentTimeMillis < lastTimeMillis) {
      throw new RuntimeException(
          String.format("clock is moving backwards.Rejecting requests until %d.", lastTimeMillis));
    }

    // 如果当前时间等于 lastTimeMillis，则需要在原来的 sequence 基础上生成新的 sequence（实际就是个AtomicInteger的逻辑），避免生成相同 id。
    // 否则 sequence 从 0 开始计。
    // 注意，如果 `sequence = (sequence + 1) & sequenceMask` 后，sequence 为 0 则表示当前毫秒内分配的id数已经到达上线，需要等到下一个毫秒才能继续生成新id
    if (currentTimeMillis == lastTimeMillis) {
      sequence = (sequence + 1) & sequenceMask;
      if (sequence == 0) {
        for (; currentTimeMillis <= lastTimeMillis; ) {
          currentTimeMillis = System.currentTimeMillis();
        }
      }
    } else {
      sequence = 0;
    }

    // 更新 lastTimeMillis
    lastTimeMillis = currentTimeMillis;

    // 按规则拼接 id
    return ((currentTimeMillis - TWEPOCH) << timeLShift)
           | (dataCenterId << dataCenterLShift)
           | (workerId << workerLShift)
           | sequence;
  }



  // -------------------------------------

  public static void main(String[] args) {
    long dataCenterId = 123;
    IdGen2 idGen = new IdGen2(dataCenterId, 12, 0, 0, 9);
    for (int i = 0; i < 100; i++) {
      long id = idGen.nextId();
      System.out.println("测试，id=" + id);
      System.out.println("测试，id=" + Long.toBinaryString(id));
    }
  }


}
