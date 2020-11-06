package cn.ming.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: ming
 * @create: 2020/11/6 0:20
 */
public interface StorageService {
    /**
     * 庫存變化
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
