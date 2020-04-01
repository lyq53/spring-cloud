package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 支付实体类
 *
 * @author liuyuqi39
 * @since 2019-3-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 支付流水号
     */
    private String serial;

}
