#### 工厂模式笔记

<font color="blue">工厂模式类型</font>
<ul>
    <li>简单工厂</li>
    <li>工厂方法</li>
    <li>抽象工厂</li>
    <li>静态工厂</li>
</ul>

<font color="blue">工厂模式优点</font>
<ol>
    <li>解耦：<font color="red">把对象的创建和使用过程分开。</font>Class A 调用 Class B.method(), 直接调用B,method(), Class B 的实例化交给工厂类</li>
    <li>降低代码重复：new Object B的过程很复杂，而且很多地方都可以用到。可以把 new Object B 的代码放到工厂里统一管理，既减少冗余代码，又方便维护。</li>
    <li>减少错误：使用工厂管理对象创建逻辑，使用者不需要知道创建过程，也不需要使用者 new Object，因而减少了创建逻辑导致的错误</li>
    <li>满足开闭原则：对拓展开放，修改关闭</li>
</ol>

<font color="blue">工厂模式缺点</font>  
拓展比较繁琐，需要同时修改抽象工厂和工厂实现类。


