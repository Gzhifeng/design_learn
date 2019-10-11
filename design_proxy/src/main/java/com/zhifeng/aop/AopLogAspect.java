package com.zhifeng.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author ganzhifeng
 * @className AopLogAspect
 * @date 2019/10/11 0011
 */
@Aspect
@Component
public class AopLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(AopLogAspect.class);

    /**
     * 申明一个切点 里面是 execution表达式
     */
    @Pointcut("execution(* com.zhifeng.controller.*.*(..))")
    private void serviceAspect() {
    }

    /**
     * 请求method前打印内容
     * @param joinPoint
     */
    @Before(value = "serviceAspect()")
    public void methodBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        // 打印请求内容
        logger.info("===============请求内容===============");
        logger.info("请求地址:" + request.getRequestURL().toString());
        logger.info("请求方式:" + request.getMethod());
        logger.info("请求类方法:" + joinPoint.getSignature());
        logger.info("请求类方法参数:" + Arrays.toString(joinPoint.getArgs()));
        logger.info("===============请求内容===============");


    }

    /**
     * 在方法执行完结后打印返回内容
     * @param o
     */
    @AfterReturning(returning = "o", pointcut = "serviceAspect()")
    public void methodAfterReturing(Object o) {
        logger.info("--------------返回内容----------------");
        logger.info("Response内容:" + o.toString());
        logger.info("--------------返回内容----------------");
    }

}
