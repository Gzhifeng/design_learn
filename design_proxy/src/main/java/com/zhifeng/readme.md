package ext下简单模拟jdk动态代理  
模拟思路   
1. 创建代理类$Proxy0源代码文件实现被代理的接口   
2. 使用JavaCompiler技术编译该$Proxy0文件获取到$Proxy0.class
3. 使用ClassLoader将该$Proxy0.class加入到当前JVM内存中   
ClassLoader 顾名思义就是类加载器,ClassLoader 作用：  
负责将 Class 加载到 JVM 中  
审查每个类由谁加载（父优先的等级加载机制）  
将 Class 字节码重新解析成 JVM 统一要求的对象格式

