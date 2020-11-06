package cn.ming.springcloud.service;

import java.math.BigDecimal;

/**
 * @author: ming
 * @create: 2020/11/6 0:51
 */
public interface AccountService {
    /**
     * 根據userId 來扣減賬戶餘額
     * @param userId
     * @param money
     */
    void decrease(Long userId, BigDecimal money);
}
