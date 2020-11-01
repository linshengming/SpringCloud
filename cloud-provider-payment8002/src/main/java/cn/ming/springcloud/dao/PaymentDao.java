package cn.ming.springcloud.dao;


import cn.ming.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ming
 */
@Mapper
public interface PaymentDao {
    /**
     * 保存
     * @param payment
     * @return
     */
    public int create(Payment payment);

    /**
     * 根據獲取payment
     * @param id
     * @return
     */
    public Payment getPaymentById(@Param("id") Long id);
}
