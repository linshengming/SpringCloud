package cn.ming.springcloud.controller;


import cn.ming.springcloud.entity.CommonResult;
import cn.ming.springcloud.entity.Payment;
import cn.ming.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ming
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*******插入結果："+result);

        if(result>0){
            return new CommonResult<>(200, "插入數據庫成功", result);
        }else{
            return new CommonResult<>(444,"插入數據庫失敗", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******查詢結果："+payment);

        if(payment != null){
            return new CommonResult<>(200,"查詢成功, serverPort" + serverPort, payment);
        }else{
            return new CommonResult<>(444, "沒有對應記錄，查詢ID：" + id, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();

        for (String element: services){
            log.info("***********element: " + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        for (ServiceInstance instance: instances){
            log.info(instance.getServiceId() + "\t" +instance.getHost() + "\t" +instance.getPort() + "\t" +instance.getUri());
        }

        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            return serverPort;
        }
    }

}
