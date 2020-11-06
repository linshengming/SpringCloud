package cn.ming.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: ming
 * @create: 2020/11/6 0:06
 */
@Mapper
public interface StorageDao {
    /**
     * 庫存更改
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
