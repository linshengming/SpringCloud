package cn.ming.springcloud.service.impl;

import cn.ming.springcloud.dao.StorageDao;
import cn.ming.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: ming
 * @create: 2020/11/6 0:22
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------>庫存更改");
        storageDao.decrease(productId,count);
        log.info("------>庫存更改結束");
    }
}
