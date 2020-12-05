package com.github.whymesay.toy.monarch.invoker;

import com.github.whymesay.toy.monarch.common.domain.RpcRequest;
import com.github.whymesay.toy.monarch.common.domain.RpcResponse;
import com.github.whymesay.toy.monarch.common.exception.MonarchException;

/**
 * @author whymesay
 * @date 2020/10/12 21:38
 */
public interface Invoker<T> {
    /**
     * get service interface.
     *
     * @return service interface.
     */
    Class<T> getInterface();

    /**
     * invoke rpc
     *
     * @param request
     * @return result
     */
    RpcResponse invoke(RpcRequest request) throws MonarchException;

}
