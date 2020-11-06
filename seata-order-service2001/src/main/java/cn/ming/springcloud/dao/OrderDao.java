package cn.ming.springcloud.dao;

import cn.ming.springcloud.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: ming
 * @create: 2020/11/5 22:02
 */
@Mapper
public interface OrderDao {
    /**
     * 1 新建訂單
     * @param order
     */
    void create(Order order);

    /**
     * 2 修改訂單狀態，從0改爲1
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
