package com.zhifeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ganzhifeng
 * @className FactoryApplication
 * @date 2019/9/16 0016
 */
@SpringBootApplication
@ComponentScan(basePackages ={"com.zhifeng.common", "com.zhifeng"})
@MapperScan(basePackages ={"com.zhifeng"})
public class FactoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactoryApplication.class);
    }

}
