Abstract Factory 抽象工厂

简单工厂和工厂方法看完之后，我们来看抽象工厂。


假设我们把塑料制品分为两类：民用（civil）、医用（medical）。

那么：
- 杯、桶、瓶，算是 "产品类型"。
- 民用、医用，算是 "产品用途"。


抽象工厂模式下：
- 根据 "产品用途"，分别定义了 PlasticCivil（民用产品） 和 PlasticMedical（商用产品） 两个抽象类。然后每个抽象类下都有各自产品的实现。
- 工厂是按 "产品类型" 划分的，分别有 PlasticBottleFactory（塑料瓶工厂）、PlasticBucketFactory（塑料桶工厂）、PlasticCupFactory（塑料杯工厂）。
- 然后每个产品类型的工厂，都生产 Civil 和 Medical 两种用途的产品，也就是有 2*3 种产品被生产出来。

emmmmmm 其实就是从多个维度进行产品的管理，和工厂方法比的话：
- 工厂方法模式针对的是一个产品等级结构，而抽象工厂模式针对的是多个产品等级结构。
- 工厂模式：1个工厂对应1个具体的产品类；抽象工厂：1个工厂对应n个具体的产品类。

也可以理解为：抽象工厂=简单工厂+工厂模式。

### 意图
### 核心角色
### 适用场景