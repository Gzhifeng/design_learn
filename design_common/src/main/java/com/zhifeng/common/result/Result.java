package com.zhifeng.common.result;

import com.zhifeng.common.constants.CodeConstants;
import net.sf.json.JSONObject;

import java.io.Serializable;

/**
 * 服务器端返回的通用对象（所有控制器都返回此对象）
 * @author ganzhifeng
 * @ClassName Result
 * @Date 2019/7/27 0027
 */
public class Result implements Serializable {

    /**
     * 请求状态码
     */
    private Integer code;

    /**
     * 请求状态描述
     */
    private String msg;

    /**
     * 请求状态时间
     */
    private Long serverTimestamp;

    /**
     * 请求获取的数据
     */
    private Object data;

    public Result() {
        this.code = CodeConstants.SUCCESS_CODE;
        this.msg = CodeConstants.SUCCESS_MSG;
        this.serverTimestamp = System.currentTimeMillis();
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.serverTimestamp = System.currentTimeMillis();
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.serverTimestamp = System.currentTimeMillis();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getServerTimestamp() {
        return serverTimestamp;
    }

    public void setServerTimestamp(Long serverTimestamp) {
        this.serverTimestamp = serverTimestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        JSONObject result = new JSONObject();
        result.put("code", code);
        result.put("msg", msg);
        result.put("serverTimestamp", serverTimestamp);
        result.put("data", data);
        return result.toString();
    }
}
