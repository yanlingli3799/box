adapter 适配器

适配器模式简单分为3种：类适配器、对象适配器、接口适配器。
（类适配器就是继承Source类，对象适配器就是持有Source类，接口适配器就是实现Source接口。）

参考：https://blog.csdn.net/u012359453/article/details/79165080

# 需求

手机充电需要将 220V 的交流电转化为手机锂电池需要的 5V 直流电，需要一个电源适配器：将 AC220v ——> DC5V。

# round1
round1 是类适配器的实现。
由于 java 类不能继承多个类，所以 Destination 只能定义为接口，接口实现由 Adapter 来完成。
但这样的话，Adapter 类里直接使用了 Source 的方法，可读性变差、维护成本增加。

# round2
round2 里是对象适配器的实现。
和类适配器类似，但扩展性会更好一些，比如可以支持多个 Source ？

# round3
round3 里是接口适配器的实现。

接口适配器 相当于是在对象适配器上多抽象了一层：
- Destination 需要的方法由单独的 Interface 接口定义，比如：DCOutput；
- 然后定义一个抽象 Adapter 类，内部持有 Source 实例；
- 具体抽象类继承 抽象 Adapter 类，实现自己需要的方法。


### 意图
### 核心角色
### 适用场景
