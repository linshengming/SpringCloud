package cn.ming.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ming
 * @create: 2020/10/29 17:35
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule getRule(){
        //定義爲隨機
        return new RandomRule();
    }
}
