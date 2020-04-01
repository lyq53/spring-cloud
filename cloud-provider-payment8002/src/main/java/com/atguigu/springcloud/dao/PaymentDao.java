package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 支付dao
 *
 * @author liuyuqi39
 * @since
 */
@Mapper
public interface PaymentDao {

    /**
     * 添加数据
     * @param payment payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据Id查找
     * @param id  id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
