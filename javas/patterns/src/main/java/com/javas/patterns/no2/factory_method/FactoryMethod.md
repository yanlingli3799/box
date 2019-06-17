
Factory Method 工厂方法（又称：工厂模式、多态工厂模式、虚拟构造器模式）
:通过定义工厂父类负责定义创建对象的公共接口，而子类则负责生成具体的对象。

作用：将类的实例化（具体产品的创建）延迟到工厂类的子类（具体工厂）中完成，即由子类来决定应该实例化（创建）哪一个类。


这个是在简单工厂方法上做的演进，简单工厂是由一个工厂管理所有产品的生产；
工厂方法是每一类产品都有自己的工厂，在此基础上进一步抽象出一个 Factory 接口，所有工厂继承这个接口即可。

参考：
- https://www.jianshu.com/p/d0c444275827


优点：
- 更符合开-闭原则：新增一种产品时，只需要增加相应的具体产品类和相应的工厂子类即可。
- 符合单一职责原则：每个具体工厂类只负责创建对应的产品。
- 不使用静态工厂方法，可以形成基于继承的等级结构。
  

缺点：
- 类太多，一定程度上增加了复杂度，编译和运行过程带来额外开销。

### 意图
### 核心角色
### 适用场景