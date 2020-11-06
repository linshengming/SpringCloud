package cn.ming.springcloud.service.impl;

import cn.ming.springcloud.dao.AccountDao;
import cn.ming.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author: ming
 * @create: 2020/11/6 0:54
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money){
        log.info("------->扣減賬戶餘額開始");
        accountDao.decrease(userId, money);
        log.info("------->扣減賬戶餘額結束");
    }



}
