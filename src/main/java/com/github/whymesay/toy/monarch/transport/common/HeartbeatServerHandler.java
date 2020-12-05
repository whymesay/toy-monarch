package com.github.whymesay.toy.monarch.transport.common;

import com.github.whymesay.toy.monarch.common.domain.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 心跳处理 每个客户端连接的channel 都有一个handler实例
 *
 * @author whymesay
 * @date 2020/10/3 17:50
 */
@Slf4j
public class HeartbeatServerHandler extends SimpleChannelInboundHandler<Message> {

    /**
     * timeout count
     */
    private AtomicInteger timeoutCount = new AtomicInteger(0);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        timeoutCount.set(0);
        if (msg.getType() == Message.PING) {
            log.info("receive client heartbeat");
            ctx.writeAndFlush(Message.PONG_MSG);
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            // 如果是心跳消息 超过时间客户端没有连接 下线
            handlerHeartbeatTimeout(ctx);
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    /**
     * handler heartbeat timeout
     *
     * @param ctx ctx
     */
    private void handlerHeartbeatTimeout(ChannelHandlerContext ctx) {
        // todo 处理
        if (timeoutCount.getAndIncrement() >= 5) {
            ctx.close();
            log.warn("monarch timeout count more than 5,close!");
        } else {
            log.warn("monarch timeout, count: {}", timeoutCount.get());
        }
    }
}
