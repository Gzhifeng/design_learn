package com.zhifeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 装饰者模式启动类
 *
 * @author ganzhifeng
 * @className DecoratorApplication
 * @date 2019/9/18 0018
 */
@SpringBootApplication
@ComponentScan(basePackages ={"com.zhifeng.common", "com.zhifeng"})
@MapperScan(basePackages ={"com.zhifeng"})
public class DecoratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecoratorApplication.class, args);
    }

}
