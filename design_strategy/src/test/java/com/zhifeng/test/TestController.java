package com.zhifeng.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName TestController
 * @Authoe ganzhifeng
 * @Date 2019/8/1 0001
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Test
    public void testRun() {
        logger.info("test run...");
    }

}
