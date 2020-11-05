package cn.ming.springcloud.service;

import cn.ming.springcloud.entity.CommonResult;
import cn.ming.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author: ming
 * @create: 2020/11/5 14:12
 */
@Component
public class PaymentFallbackService implements PaymentService{

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回，---PaymentFallbackService",new Payment(id,"ErrorSerial"));
    }
}
