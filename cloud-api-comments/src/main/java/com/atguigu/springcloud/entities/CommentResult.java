package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 前端返回实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> {

    /**
     * 返回编码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

    public CommentResult(Integer code, String message) {
        this(code, message, null);
    }
}
