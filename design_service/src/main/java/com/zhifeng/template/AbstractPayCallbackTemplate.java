package com.zhifeng.template;

import com.zhifeng.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 模板抽象类
 * 模拟场景：聚合支付平台中系统回调代码重构
 *
 * @author ganzhifeng
 * @className AbstractPayCallbackTemplate
 * @date 2019/9/16 0016
 */
@Component
public abstract class AbstractPayCallbackTemplate {

    private static Logger logger = LoggerFactory.getLogger(AbstractPayCallbackTemplate.class);

    /**
     * 异步回调业务
     *
     * @author ganzhifeng
     * @date 2019/09/17 0017
     * @return
     */
    public Result asyncCallBack() {

        //1.支付回调验证参数
        Map<String, Object> verifySignTrue = verifySignTrue();

        //2.验证成功，写入日志
        payLog(verifySignTrue);

        Result result = new Result();
        Integer analysisCode = (Integer) verifySignTrue.get("analysisCode");
        if (analysisCode.intValue() != 0) {
            String fail = resultFail();
            result.setCode(analysisCode);
            result.setMsg("解析失败");
            result.setData(fail);
            return result;
        }

        //3.执行回调相关逻辑
        String res = asyncService(verifySignTrue);

        result.setMsg("解析成功");
        result.setData(res);
        return result;
    }

    /**
     * 支付回调参数验证
     *
     * @author ganzhifeng
     * @date 2019/09/17 0017
     * @return
     */
    protected abstract Map<String, Object> verifySignTrue();

    /**
     * 日志收集
     *
     * @author ganzhifeng
     * @date 2019/09/17 0017
     * @param verifySignTrueMap
     */
    @Async
    protected void payLog(Map<String, Object> verifySignTrueMap) {
        logger.info("日志收集");
    }

    /**
     * 业务解析操作
     *
     * @author ganzhifeng
     * @date 2019/09/17 0017
     * @param verifySignatureMap
     * @return
     */
    protected abstract String asyncService(Map<String, Object> verifySignatureMap);

    /**
     * 返回成功
     *
     * @author ganzhifeng
     * @date 2019/09/17 0017
     * @return
     */
    protected abstract String resultSuccess();

    /**
     * 返回失败
     *
     * @author ganzhifeng
     * @date 2019/09/17 0017
     * @return
     */
    protected abstract String resultFail();

}
