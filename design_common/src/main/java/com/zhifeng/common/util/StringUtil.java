package com.zhifeng.common.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串相关工具
 * @author ganzhifeng
 * @className StringUtil
 * @date 2019/8/9 0009
 */
public class StringUtil extends StringUtils {

    /**
     * 字符串为空
     * @param src
     * @return
     */
    public static boolean isEmpty(Object src) {
        String isNull = "null";
        if (src == null || "".equals(src.toString().trim()) || isNull.equals(src)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    /**
     * 字符串不为空
     * @param src
     * @return
     */
    public static boolean notEmpty(Object src) {
        boolean empty = isEmpty(src);
        if (empty) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }
}
