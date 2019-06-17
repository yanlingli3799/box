
## proxy 代理

### 意图
- 为其他对象提供一种代理以控制对这个对象的访问。
- 本质上就是在访问对象时引入一定程度的间接性，因为这种间接性，可以附加多种用途。
- 即，代理是真实对象的代表。


### 核心角色
- `Subject`：定义了 RealSubject 和 Proxy 的共用接口，这样就在任何使用 RealSubject 的地方都可以使用 Proxy。
- `RealSubject`：定义 Proxy 所代表的真实实体。
- `Proxy`：保存一个引用使得代理可以访问实体，并提供一个与 Subject 的接口相同的接口，这样代理就可以用来替代实体。

### 适用场景
- `远程代理`：也就是为一个对象在不同的地址空间提供局部代表，这样可以隐藏一个对象存在于不同地址空间的事实。
- `虚拟代理`：是根据需要创建开销很大的对象。通过它来存放实例化需要很长时间的真实对象。
- `安全代理/保护代理`：用来控制真实对象访问时的权限。一般用于对象应该有不同的访问权限的时候。
- `智能指引`：取代了简单的指针，当调用真实的对象时，代理处理另外一些事。
- `Copy-on-Write代理`：是虚拟代理的一种，把复制操作延迟到只有在客户端真正需要时才执行。

### 举个例子：卖毛巾
1. 毛巾在哪生产出来的？=>工厂。
2. 工厂直接把毛巾卖给顾客吗？=>不，卖给经销商。
=> 这就是非常典型的代理模式：工厂把毛巾卖给经销商，经销商再卖给超市
=> 于是有了 round1 的实现。

这个写法其实只不支持多级代理的，怎么办呢？
=> 于是有了 round2 的实现。

### 参考：
- [设计模式之代理模式（Proxy）](https://www.cnblogs.com/BeyondAnyTime/archive/2012/07/04/2576865.html)

### todo
- 代理模式的多个适用场景分别单独进行了解，并写出demo。