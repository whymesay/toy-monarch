package com.github.whymesay.toy.monarch.transport;

import com.github.whymesay.toy.monarch.common.domain.RpcRequest;
import com.github.whymesay.toy.monarch.common.domain.RpcResponse;

import java.util.concurrent.Future;

/**
 * The interface Client.
 *
 * @author whymesay
 * @date 2020 /10/3 15:57
 */
public interface Client {
    /**
     * Request rpc future.
     *
     * @param request the request
     * @return the future
     */
    Future<RpcResponse> send(RpcRequest request);

    /**
     * Close.
     */
    void close();
}
