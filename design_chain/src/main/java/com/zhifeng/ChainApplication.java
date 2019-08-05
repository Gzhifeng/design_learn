package com.zhifeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 责任链模式项目启动类
 * @Author ganzhifeng
 * @Description
 * @Date 2019/7/30 0030
 */
@SpringBootApplication
@ComponentScan(basePackages ={"com.zhifeng.common", "com.zhifeng"})
@MapperScan(basePackages ={"com.zhifeng"})
public class ChainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChainApplication.class, args);
    }

}
