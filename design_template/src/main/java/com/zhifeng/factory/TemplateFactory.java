package com.zhifeng.factory;

import com.zhifeng.common.util.SpringUtils;
import com.zhifeng.template.AbstractPayCallbackTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 对象工厂
 *
 * @author ganzhifeng
 * @className TemplateFactory
 * @date 2019/9/17 0017
 */
@Component
public class TemplateFactory {

    @Autowired
    private SpringUtils springUtils;

    public AbstractPayCallbackTemplate getPayCallbackTemplate(String templateId) {

        AbstractPayCallbackTemplate bean = (AbstractPayCallbackTemplate) springUtils.getBean(templateId);
        return bean;
    }

}
