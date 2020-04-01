package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义负载策略
 */

public interface LoadBalanced {

    /**
     * 初始化服务
     * @param
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
