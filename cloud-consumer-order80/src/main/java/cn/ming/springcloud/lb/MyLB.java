package cn.ming.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: ming
 * @create: 2020/10/29 19:18
 */
@Component
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement(){
        int current;
        int next;

        do{
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0: current+1;
        }while(!this.atomicInteger.compareAndSet(current,next));

        System.out.println("************第幾次訪問，次數next" + next);
        return next;
    }

    /**
     * 负载均衡轮询算法，rest接口第几次请求数 % 服务器集群总数 = 实际调用服务器位置下标
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
