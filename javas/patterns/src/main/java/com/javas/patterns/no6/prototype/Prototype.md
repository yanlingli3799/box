Prototype 原型模式

简单来说，原型模式意在提供对象的克隆方法。

比如：复制简历

对象克隆有两种类型：
- 浅克隆：当原型对象被复制时，只复制它本身和其中包含的值类型的成员变量，而引用类型的成员变量并没有复制。
- 深克隆：除了对象本身被复制外，对象所包含的所有成员变量也将被复制。

关于深克隆与浅克隆的介绍参见：http://www.cnblogs.com/chenssy/p/3308489.html

直接用 jdk 自带的 Cloneable 接口就可以了。

问题是：复杂对象深克隆的实现可能会比较麻烦。

### 意图
### 核心角色
### 适用场景
