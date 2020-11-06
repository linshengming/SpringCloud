package cn.ming.springcloud.service.impl;

import cn.ming.springcloud.dao.OrderDao;
import cn.ming.springcloud.pojo.Order;
import cn.ming.springcloud.service.AccountService;
import cn.ming.springcloud.service.OrderService;
import cn.ming.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: ming
 * @create: 2020/11/5 22:42
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说:
     * 下订单->减库存->减余额->改状态
     * GlobalTransactional seata开启分布式事务,异常时回滚,name保证唯一即可
     * @param order 订单对象
     */
    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("----------->開始創建訂單");
        orderDao.create(order);

        log.info("---------->訂單微服務開始調用庫存，做扣減");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("---------->訂單微服務開始調用庫存，做扣減end");

        log.info("---------->訂單微服務開始調用賬戶，做扣減");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("---------->訂單微服務開始調用賬戶，做扣減end");

        //修改訂單狀態    從0到1
        log.info("修改訂單狀態開始");
        orderDao.update(order.getUserId(),0);
        log.info("修改訂單狀態結束");

        log.info("------>下單結束！！！");
    }
}
