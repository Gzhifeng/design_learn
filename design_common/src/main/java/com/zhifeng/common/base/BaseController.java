package com.zhifeng.common.base;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Liuk
 * @date 2017-06-27 14:54
 * @TODO
 */
@Controller
public abstract class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // true:允许输入空值，false:不能为空值

        // String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
        binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(text == null ? null : org.apache.commons.lang3.StringEscapeUtils.escapeHtml4(text.trim()));
            }

            @Override
            public String getAsText() {
                Object value = getValue();
                return value != null ? value.toString() : "";
            }
        });

        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                try {
                    setValue(DateUtils.parseDate(text));
                } catch (Exception ex) {
                }
            }
        });

        // Timestamp 类型转换
        binder.registerCustomEditor(Timestamp.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                Date date;
                try {
                    date = DateUtils.parseDate(text);
                    setValue(date == null ? null : new Timestamp(date.getTime()));
                } catch (Exception ex) {
                }
            }
        });
    }

    /**
     * 直接调整到后台路径
     * @param path
     * @return
     */
    public String getRedirectPath(String path){
        StringBuilder stringBuilder = new StringBuilder("redirect:/");
        return stringBuilder.append(path).toString();
    }

}
