package com.zhifeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ganzhifeng
 * @className ObserverApplication
 * @date 2019/10/14 0014
 */
@SpringBootApplication
@ComponentScan(basePackages ={"com.zhifeng.common", "com.zhifeng"})
@MapperScan(basePackages ={"com.zhifeng"})
public class ObserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObserverApplication.class, args);
    }
}
