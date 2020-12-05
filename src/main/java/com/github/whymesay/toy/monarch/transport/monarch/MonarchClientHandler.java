package com.github.whymesay.toy.monarch.transport.monarch;

import com.github.whymesay.toy.monarch.common.domain.Message;
import com.github.whymesay.toy.monarch.transport.Client;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author whymesay
 * @date 2020/10/3 17:27
 */
@Slf4j
public class MonarchClientHandler extends SimpleChannelInboundHandler<Message> {

    private Client client;

    public MonarchClientHandler(Client client) {
        this.client = client;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        if (msg.getType() == Message.RESPONSE) {
            if (log.isDebugEnabled()) {
                log.debug("receiver rpc response:{}", msg.getResponse());
            }
        }
    }
}
