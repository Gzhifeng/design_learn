package com.zhifeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 外观、状态启动类
 *
 * @Author ganzhifeng
 * @Description
 * @Date 2019/10/21 0021
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.zhifeng.common", "com.zhifeng"})
@MapperScan(basePackages = {"com.zhifeng"})
public class FacadeAndStateApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacadeAndStateApplication.class, args);
    }

}
