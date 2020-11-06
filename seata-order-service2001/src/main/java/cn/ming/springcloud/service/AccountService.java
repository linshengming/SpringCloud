package cn.ming.springcloud.service;

import cn.ming.springcloud.pojo.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author: ming
 * @create: 2020/11/5 22:46
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 更改賬戶餘額
     * @param userId
     * @param money
     * @return
     */
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);
}
