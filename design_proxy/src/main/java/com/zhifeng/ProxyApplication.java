package com.zhifeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ganzhifeng
 * @className ProxyApplication
 * @date 2019/9/29 0029
 */
@SpringBootApplication
@ComponentScan(basePackages ={"com.zhifeng.common", "com.zhifeng"})
@MapperScan(basePackages ={"com.zhifeng"})
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

}
