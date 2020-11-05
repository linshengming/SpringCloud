package cn.ming.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: ming
 * @create: 2020/11/5 13:16
 */
@Configuration
public class ApplicationContextConfig {

        @Bean
        @LoadBalanced
        public RestTemplate getRestTemplate() {
            return new RestTemplate();
        }

}
