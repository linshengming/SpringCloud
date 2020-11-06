package cn.ming.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ming
 * @create: 2020/11/5 23:35
 */
@Configuration
@MapperScan("cn.ming.springcloud.dao")
public class MyBatisConfig {
}
