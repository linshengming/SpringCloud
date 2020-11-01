package cn.ming.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author: ming
 * @create: 2020/10/30 19:49
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "**********------>PaymentFallbackService fall back ----->paymentInfo_OK (*^_^*)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "**********------>PaymentFallbackService fall back ----->paymentInfo_TimeOut (*^_^*)";
    }
}
