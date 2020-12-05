package com.github.whymesay.toy.monarch.transport.monarch;

import com.github.whymesay.toy.monarch.transport.monarch.codc.MonarchEncoder;
import com.github.whymesay.toy.monarch.transport.monarch.constant.MonarchConstant;
import com.github.whymesay.toy.monarch.transport.support.netty.AbstractNettyServer;
import com.github.whymesay.toy.monarch.config.GlobalConfig;
import com.github.whymesay.toy.monarch.transport.common.HeartbeatServerHandler;
import com.github.whymesay.toy.monarch.transport.monarch.codc.MonarchDecoder;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author whymesay
 * @date 2020/10/3 17:24
 */
public class MonarchServer extends AbstractNettyServer {

    public MonarchServer(GlobalConfig globalConfig) {
        super(globalConfig);
    }

    @Override
    protected void initChannelHandler(SocketChannel socketChannel) throws Exception {
        initPipeline(socketChannel);
    }

    private void initPipeline(SocketChannel socketChannel) {
        socketChannel.pipeline()
                // when idle , send  heartbeat
                .addLast("IdleStateHandler", new IdleStateHandler(MonarchConstant.HEART_BEAT_TIME_OUT * MonarchConstant.HEART_BEAT_TIME_OUT_MAX_TIME, 0, 0, TimeUnit.SECONDS))
                // byte to message
                .addLast("MonarchDecoder", new MonarchDecoder(globalConfig.getSerializeConfig()))
                // message to byte
                .addLast("MonarchEncoder", new MonarchEncoder(globalConfig.getSerializeConfig()))
                // heartbeat
                .addLast("HeartbeatServerHandler", new HeartbeatServerHandler())
                .addLast("MonarchServerHandler", new MonarchServerHandler(this));
    }
}
