package com.zhifeng.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟阿里支付
 *
 * @author ganzhifeng
 * @className AliPayCallbackTemplate
 * @date 2019/9/17 0017
 */
@Component
public class AliPayCallbackTemplate extends AbstractPayCallbackTemplate {

    private static final Logger logger = LoggerFactory.getLogger(AliPayCallbackTemplate.class);

    /**
     * 假设为支付宝报文
     *
     * @return
     */
    @Override
    protected Map<String, Object> verifySignTrue() {

        logger.info("解析支付宝报文");
        Map<String, Object> verifySignature = new HashMap<>();
        verifySignature.put("price", 1399);
        verifySignature.put("orderDes", "购买成功");
        // 支付状态为1表示为成功
        verifySignature.put("aliPaymentStatus", 1);
        verifySignature.put("aliPayOrderNumber", 201909170017L);
        // 解析报文是否成功 0 为成功
        verifySignature.put("analysisCode", 0);

        return verifySignature;
    }

    @Override
    protected String asyncService(Map<String, Object> verifySignatureMap) {

        logger.info("业务处理");
        Integer aliPaymentStatus = (Integer) verifySignatureMap.get("aliPaymentStatus");
        if (aliPaymentStatus.intValue() == 1) {
            Long aliPayOrderNumber = (Long) verifySignatureMap.get("aliPayOrderNumber");
            logger.info("订单【" + aliPayOrderNumber + "】,已经支付成功 修改订单状态为已经支付...");
            return resultSuccess();
        }
        return resultFail();
    }

    @Override
    protected String resultSuccess() {
        return String.valueOf(Boolean.TRUE);
    }

    @Override
    protected String resultFail() {
        return String.valueOf(Boolean.FALSE);
    }
}
