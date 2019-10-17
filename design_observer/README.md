### 观察者模式笔记
#### 什么是观察者模式
在对象之间定义了一对多的依赖，这样一来，当一个对象改变状态，依赖它的对象会收到通知并自动更新。   
其实就是发布订阅模式，发布者发布信息，订阅者获取信息，订阅了就能收到信息，没订阅就收不到信息。

#### 观察者模式应用场景
Zookeeper事件通知节点、消息订阅通知、安卓开发事件注册、分布式配置中心

#### 观察者模式角色
- 抽象被观察者角色：也就是一个抽象主题，它把所有对观察者对象的引用保存在一个集合中，每个主题都可以有任意数量的观察者。抽象主题提供一个接口，可以增加和删除观察者角色。一般用一个抽象类和接口来实现。
- 抽象观察者角色：为所有的具体观察者定义一个接口，在得到主题通知时更新自己。
- 具体被观察者角色：也就是一个具体的主题，在主题的内部状态改变时，向所有登记过的观察者发出通知。
- 具体观察者角色：实现抽象观察者角色所需要的更新接口，使本身的状态与主题的状态相协调。
