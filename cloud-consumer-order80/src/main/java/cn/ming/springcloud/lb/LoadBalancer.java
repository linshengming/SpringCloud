package cn.ming.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author: ming
 * @create: 2020/10/29 19:14
 */
public interface LoadBalancer {
    /**
     * 獲取服務List
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
