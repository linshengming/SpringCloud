package cn.ming.springcloud.controller;

import cn.ming.springcloud.pojo.CommonResult;
import cn.ming.springcloud.pojo.Order;
import cn.ming.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: ming
 * @create: 2020/11/5 23:22
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"訂單創建成功");
    }
}
