package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * 支付服务类
 *
 * @author liuyuqi39
 * @since 2020-3-11
 */
public interface PaymentService {

    /**
     * 添加数据
     *
     * @param payment payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据Id查找
     *
     * @param id id
     * @return
     */
    Payment getPaymentById(Long id);
}
