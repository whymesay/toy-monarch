package com.github.whymesay.toy.monarch.transport.monarch;

import com.github.whymesay.toy.monarch.transport.common.HeartbeatClientHandler;
import com.github.whymesay.toy.monarch.transport.monarch.codc.MonarchEncoder;
import com.github.whymesay.toy.monarch.transport.monarch.constant.MonarchConstant;
import com.github.whymesay.toy.monarch.transport.support.netty.AbstractNettyClient;
import com.github.whymesay.toy.monarch.config.GlobalConfig;
import com.github.whymesay.toy.monarch.transport.monarch.codc.MonarchDecoder;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author whymesay
 * @date 2020/10/6 11:57
 */
@Slf4j
public class MonarchClient extends AbstractNettyClient {


    public MonarchClient(GlobalConfig globalConfig) {
        super(globalConfig);
    }

    @Override
    public void close() {
        super.close();
    }


    @Override
    protected void initChannelHandler(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline()
                .addLast("IdleStateHandler", new IdleStateHandler(0, MonarchConstant.HEART_BEAT_TIME_OUT, 0))
                // byte to message
                .addLast("MonarchDecoder", new MonarchDecoder(globalConfig.getSerializeConfig()))
                // message to byte
                .addLast("MonarchEncoder", new MonarchEncoder(globalConfig.getSerializeConfig()))
                .addLast("HeartbeatClientHandler", new HeartbeatClientHandler())
                .addLast("MonarchClientHandler", new MonarchClientHandler(this));
    }

}
