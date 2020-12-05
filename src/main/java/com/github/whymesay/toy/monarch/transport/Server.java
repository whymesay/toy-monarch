package com.github.whymesay.toy.monarch.transport;

import com.github.whymesay.toy.monarch.common.domain.RpcRequest;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author whymesay
 * @date 2020/10/3 15:57
 */
public interface Server {
    void start();

    void handleRpcRequest(RpcRequest request, ChannelHandlerContext ctx);

    void close();
}
