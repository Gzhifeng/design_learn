package com.zhifeng.controller;

import com.zhifeng.common.result.Result;
import com.zhifeng.template.AbstractPayCallbackTemplate;
import com.zhifeng.template.TemplateFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ganzhifeng
 * @className TemplateController
 * @date 2019/9/17 0017
 */
@RestController
@RequestMapping("/api/v1")
public class TemplateController {

    @Autowired
    private TemplateFactory templateFactory;

    private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

    /**
     * 方法测试
     *
     * @author ganzhifeng
     * @date 2019/09/17 0017
     * @param templateId
     * @return
     */
    @GetMapping("/template")
    public Result template(String templateId) {

        logger.info("模板方法测试");

        AbstractPayCallbackTemplate payCallbackTemplate = templateFactory.getPayCallbackTemplate(templateId);
        Result result = payCallbackTemplate.asyncCallBack();
        return result;
    }

}
