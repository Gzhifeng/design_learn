package com.zhifeng.ext.jdk.proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ganzhifeng
 * @className JavaClassLoader
 * @date 2019/10/11 0011
 */
public class JavaClassLoader extends ClassLoader {

    private File classPathFile;

    public JavaClassLoader(){
        String classPath="H:\\JustForMe\\design_learn\\design_proxy";
        this.classPathFile=new File(classPath);
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        String className= JavaClassLoader.class.getPackage().getName()+"."+name;
        if(classPathFile!=null){
            File classFile=new File(classPathFile,name.replaceAll("\\.","/")+".class");
            if(classFile.exists()){
                FileInputStream in=null;
                ByteArrayOutputStream out=null;
                try {
                    in=new FileInputStream(classFile);
                    out=new ByteArrayOutputStream();
                    byte[] buff=new byte[1024];
                    int len;
                    while ((len=in.read(buff))!=-1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(in!=null){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(out!=null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}
