package com.github.whymesay.toy.monarch.transport.monarch;

import com.github.whymesay.toy.monarch.common.domain.Message;
import com.github.whymesay.toy.monarch.transport.Server;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author whymesay
 * @date 2020/10/3 17:27
 */
@Slf4j
public class MonarchServerHandler extends SimpleChannelInboundHandler<Message> {
    private Server server;

    public MonarchServerHandler(Server server) {
        this.server = server;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        if (msg.getType() == Message.REQUEST) {
            if (log.isDebugEnabled()) {
                log.debug("receiver rpc request:{}", msg.getRequest());
            }
            server.handleRpcRequest(msg.getRequest(), ctx);
        }
    }
}
