package com.javas.jdks.management;

import org.apache.logging.log4j.core.util.datetime.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.RuntimeMXBean;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * package java.lang.management 提供管理接口，用于监视和管理 Java 虚拟机以及 Java 虚拟机在其上运行的操作系统。
 * package java.lang.management 英文文档：https://docs.oracle.com/javase/7/docs/api/java/lang/management/package-summary.html
 * package java.lang.management 中文文档：http://tool.oschina.net/uploads/apidocs/jdk-zh/java/lang/management/package-summary.html
 * <p>
 * ManagementFactory 类是一种工厂类，用于获取 Java 平台的管理 Bean。此类由静态方法组成，每种静态方法都会返回一个或多个表示 Java 虚拟机组件的管理接口的平台 MXBean。
 * ManagementFactory 英文文档：https://docs.oracle.com/javase/7/docs/api/java/lang/management/ManagementFactory.html
 * ManagementFactory 中文文档：http://tool.oschina.net/uploads/apidocs/jdk-zh/java/lang/management/ManagementFactory.html
 * <p>
 * mxbean 总结（博客）：https://blog.csdn.net/winggyn/article/details/52709984
 */

public class ManagementUtil {

  private static Logger logger = LoggerFactory.getLogger(ManagementUtil.class);

  private static final FastDateFormat FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");


  /**
   * java.lang.management.RuntimeMXBean 运行时系统
   *
   * @return
   */
  public static Map<String, String> getRuntimeInfo() {
    RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
    Map<String, String> map = new LinkedHashMap<>();
    map.put("name", runtimeMXBean.getName());
    map.put("specName", runtimeMXBean.getSpecName());
    map.put("specVendor", runtimeMXBean.getSpecVendor());
    map.put("specVersion", runtimeMXBean.getSpecVersion());
    map.put("managementSpecVersion", runtimeMXBean.getManagementSpecVersion());
    map.put("vmName", runtimeMXBean.getVmName());
    map.put("vmVender", runtimeMXBean.getVmVendor());
    map.put("vmVersion", runtimeMXBean.getVmVersion());
    map.put("startTime", FORMAT.format(runtimeMXBean.getStartTime()));
    map.put("upTime", FORMAT.format(runtimeMXBean.getUptime()));
    map.put("systemProperties", runtimeMXBean.getSystemProperties().toString());
    map.put("classPath", runtimeMXBean.getClassPath());
    map.put("bootClassPath", runtimeMXBean.getBootClassPath());
    map.put("libraryPath", runtimeMXBean.getLibraryPath());
    map.put("inputArguments", runtimeMXBean.getInputArguments().toString());
    return map;
  }


  /**
   * java.lang.management.CompilationMXBean 编译系统
   *
   * @return
   */
  public static Map<String, String> getCompilationInfo() {
    CompilationMXBean compilationMXBean = ManagementFactory.getCompilationMXBean();
    Map<String, String> map = new LinkedHashMap<>();

    // 即时（JIT）编译器的名称
    map.put("name", compilationMXBean.getName());

    // 编译耗时近似值（单位：毫秒）
    map.put("totalCompilationTime",
            String.valueOf(compilationMXBean.getTotalCompilationTime()) + "ms");

    // 检测 Java 虚拟机是否支持监视编译时间
    map.put("isCompilationTimeMonitoringSupported",
            String.valueOf(compilationMXBean.isCompilationTimeMonitoringSupported()));
    return map;
  }


  /**
   * java.lang.management.GarbageCollectorMXBean 垃圾回收
   *
   * @return
   */
  public static Map<String, String> getGarbageCollectorInfo() {
    List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
    Map<String, String> map = new LinkedHashMap<>();
    for (int index = 0; index < list.size(); index++) {
      GarbageCollectorMXBean garbageCollectorMXBean = list.get(index);

      // 已发生的回收的总次数
      map.put(index + ":collectionCount",
              String.valueOf(garbageCollectorMXBean.getCollectionCount()));

      // 近似的累积回收时间（单位：毫秒）
      map.put(index + ":collectionTime",
              String.valueOf(garbageCollectorMXBean.getCollectionTime()) + "ms");
    }
    return map;
  }


  /**
   * java.lang.management.ClassLoadingMXBean 类加载系统
   *
   * @return
   */
  public static Map<String, String> getClassLoadingInfo() {
    ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
    Map<String, String> map = new LinkedHashMap<>();

    // 当前加载到 Java 虚拟机中的类的数量。
    map.put("loadedClassCount", String.valueOf(classLoadingMXBean.getLoadedClassCount()));

    // 自 Java 虚拟机开始执行到目前已经加载的类的总数。
    map.put("totalLoadedClassCount", String.valueOf(classLoadingMXBean.getTotalLoadedClassCount()));

    // 自 Java 虚拟机开始执行到目前已经卸载的类的总数。
    map.put("unloadedClassCount", String.valueOf(classLoadingMXBean.getUnloadedClassCount()));

    // 测试是否已为类加载系统启用了 verbose 输出。
    // verbose 的含义：https://blog.csdn.net/yxpjx/article/details/6187207
    map.put("isVerbose", String.valueOf(classLoadingMXBean.isVerbose()));

    return map;
  }


  /**
   * java.lang.management.MemoryManagerMXBean 内存管理器
   *
   * @return
   */
  public static Map<String, String> getMemoryManagerInfo() {
    List<MemoryManagerMXBean> list = ManagementFactory.getMemoryManagerMXBeans();
    Map<String, String> map = new LinkedHashMap<>();

    for (int index = 0; index < list.size(); index++) {
      MemoryManagerMXBean memoryManagerMXBean = list.get(index);

      // 表示此内存管理器的名称。
      map.put(index + ":name", memoryManagerMXBean.getName());

      // 此内存管理器管理的内存池名称。
      map.put(index + ":memoryPoolNames",
              Arrays.toString(memoryManagerMXBean.getMemoryPoolNames()));

      // 测试此内存管理器在 Java 虚拟机中是否【有效】。
      map.put(index + ":isValid", String.valueOf(memoryManagerMXBean.isValid()));
    }
    return map;
  }

  /**
   * java.lang.management.MemoryMXBean 内存系统
   * java.lang.management.MemoryUsage 表示内存使用量快照的 Memory 对象
   *
   * @return
   */
  public static Map<String, String> getMemoryInfo() {
    MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    Map<String, String> map = new LinkedHashMap<>();

    // 用于对象分配的堆的当前内存使用量。
    map.put("heapMemoryUsage", memoryMXBean.getHeapMemoryUsage().toString());

    // 非堆内存的当前内存使用量。
    map.put("nonHeapMemoryUsage", memoryMXBean.getNonHeapMemoryUsage().toString());

    // 其终止被挂起的对象的近似数目。【没看太懂】
    map.put("objectPendingFinalizationCount",
            String.valueOf(memoryMXBean.getObjectPendingFinalizationCount()));

    // 测试内存系统的 verbose 输出是否已启用。
    map.put("isVerbose", String.valueOf(memoryMXBean.isVerbose()));
    return map;
  }

  /**
   * 剩下的不再列了。用到再说。
   */
}
