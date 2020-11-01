package cn.ming.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ming
 * @create: 2020/10/29 21:36
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLever(){
        return Logger.Level.FULL;
    }
}
