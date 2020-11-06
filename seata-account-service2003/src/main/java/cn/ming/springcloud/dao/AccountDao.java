package cn.ming.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author: ming
 * @create: 2020/11/6 0:38
 */
@Mapper
public interface AccountDao {
    /**
     * 根據用戶id 和 使用金額進行扣減
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
