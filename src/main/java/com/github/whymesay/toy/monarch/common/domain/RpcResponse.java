package com.github.whymesay.toy.monarch.common.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author whymesay
 * @date 2020/10/3 16:26
 */
@Data
public class RpcResponse implements Serializable {

    /**
     * 错误信息
     */
    private String error;
    /**
     * 返回的结果
     */
    private Object result;

}
