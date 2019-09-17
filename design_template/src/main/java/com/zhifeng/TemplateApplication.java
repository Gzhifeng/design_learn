package com.zhifeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ganzhifeng
 * @className TemplateApplicatition
 * @date 2019/9/17 0017
 */
@SpringBootApplication
@ComponentScan(basePackages ={"com.zhifeng.common", "com.zhifeng"})
@MapperScan(basePackages ={"com.zhifeng"})
public class TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }

}
