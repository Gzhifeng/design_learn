package com.zhifeng.ext.jdk.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author ganzhifeng
 * @className MyProxy
 * @date 2019/10/11 0011
 */
public class MyProxy {
    static String rt = "\r\t";

    /**
     * @param classInfo 被代理实现的接口信息 <br>
     * @param h
     * @return
     */
    public static Object newProxyInstance(JavaClassLoader javaClassLoader, Class classInfo, MyExtInvocationHandler h) {
        try {
            // 1.创建代理类java源码文件,写入到硬盘中..
            Method[] methods = classInfo.getMethods();
            String proxyClass = "package com.zhifeng.ext.jdk.proxy;" + rt
                    + "import java.lang.reflect.Method;" + rt
                    + "import com.zhifeng.ext.jdk.proxy.MyExtInvocationHandler;" + rt
                    + "public class $Proxy0 implements " + classInfo.getName() + "{" + rt
                    + "MyExtInvocationHandler h;" + rt
                    + "public $Proxy0(MyExtInvocationHandler h)" + "{" + rt
                    + "this.h= h;" + rt + "}"
                    + getMethodString(methods, classInfo) + rt + "}";

            // 2. 将代理类源码文件写入硬盘中
            String filename = "H:\\JustForMe\\design_learn\\design_proxy\\$Proxy0.java";
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            fw.write(proxyClass);
            fw.flush();
            fw.close();

            // 3.使用JavaJavaCompiler 编译该$Proxy0源代码 获取class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileMgr.getJavaFileObjects(filename);
            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
            t.call();
            fileMgr.close();

            //4.使用classClassLoader 将$Proxy0.class读取到内存中...
            Class proxy0Class = javaClassLoader.findClass("$Proxy0");
            //5.使用java反射机制给函数中赋值
            Constructor m = proxy0Class.getConstructor(MyExtInvocationHandler.class);
            Object o = m.newInstance(h);
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getMethodString(Method[] methods, Class intf) {
        String proxyMe = "";
        for (Method method : methods) {
            proxyMe += "public void " + method.getName() + "() throws Throwable {" + rt
                    + "Method md= " + intf.getName() + ".class.getMethod(\"" + method.getName()
                    + "\",new Class[]{});" + rt
                    + "this.h.invoke(this,md,null);" + rt + "}" + rt;

        }
        return proxyMe;
    }

}
