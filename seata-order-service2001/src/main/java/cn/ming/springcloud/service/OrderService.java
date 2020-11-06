package cn.ming.springcloud.service;

import cn.ming.springcloud.pojo.Order;

/**
 * @author: ming
 * @create: 2020/11/5 22:41
 */
public interface OrderService {
    /**
     * 創建訂單
     * @param order
     */
    void create(Order order);

}
