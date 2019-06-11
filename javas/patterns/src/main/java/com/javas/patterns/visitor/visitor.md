visitor 访问者模式

# 需求
淘宝商家营销。商家为了做精准营销，会对消费人群做分析，不同商家对不同群体关注重点不一样。
比如：
- 化妆品店，关注适龄女性顾客、非单身男士顾客。
- 游戏产品店，关注男性顾客、有过游戏类产品购买/收藏记录的女性顾客。
- 美发产品店，关注顾客是否有相关从业经验。

# 分析
通常来说，商家能看到的消费群体中的"人"的数据是相对稳定的，包括：性别、年龄、行业、地区、购买记录、收藏记录等。
而不同商家对"人"的关注点是不一样的，他们会基于自己的喜好或者一些分析对人群进行分类，然后做一些相关的营销推广活动。
这个场景，满足了使用 **访问者** 的两大基本条件：
- 数据结构（`Element`）：即"人" Person。是一个相对稳定的对象结构。
- 访问者（`Visitor`）：即"商家" Merchant。经常需要在"人"这个对象结构上做一些不同的操作。


# 基础`round1` 
现在我们来分析一下哈：
- 然后是"商家"的定义，也很容易写出 `round1` 包下的 `MerchantConsmetic.java`（化妆品店） 和 `MerchantGame.java`（游戏店） 实现。
- 那如果再新增 "人" 或 "商家" 呢？要如何扩展？

# 进阶 `round2`
- 新增两个接口定义：
    - `IPerson.java`，对应的是"数据结构"——"人"。
    - `IMerchant.java`，对应的是"访问者"——"商店""。
- 然后 "人" 和 "商家" 分别继承新接口，也就是：
    - `PersonMale + PersonFemale implements IPerson`。
    - `MerchantCosmetic + MerchantGame implements IMerchant`。
- 接口方法：
    - `IMerchant.java` 有一个 visit 方法，用于主动访问 `IPerson` 信息：`visit(PersonMale element){...}` 和 `visit(PersonFemale element){...}`。
    - `IPerson.java` 提供一个 accept 方法，接受 `IMerchant` 参数，然后把"我自己（this）"作为 IMerchant visit 方法的参数：`accept(IMerchant visitor){visitor.visit(this)}`。
- 子类实现，略。
- 好处：
    - 数据和操作严格分离。
    - 规则定好了，也不用担心后续的扩展会跑偏。
    - 访问是双向的，主动 visit 和被动 accept 都没问题。

# 思考
上述实现是一个最经典版的结构，但实际运用中可灵活拆解，比如：
- IPerson 只有一个类实例 Person。
- IPerson 不提供 accept 方法，只 Merchant 提供 visit 方法。

### 意图
### 核心角色
### 适用场景
