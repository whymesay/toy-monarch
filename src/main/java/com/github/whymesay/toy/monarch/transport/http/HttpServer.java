package com.github.whymesay.toy.monarch.transport.http;

import com.github.whymesay.toy.monarch.config.GlobalConfig;
import com.github.whymesay.toy.monarch.transport.common.HeartbeatServerHandler;
import com.github.whymesay.toy.monarch.transport.support.netty.AbstractNettyServer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * @author whymesay
 * @date 2020/10/6 0:21
 */
public class HttpServer extends AbstractNettyServer {

    public HttpServer(GlobalConfig globalConfig) {
        super(globalConfig);
    }

    @Override
    protected void initChannelHandler(SocketChannel socketChannel) throws Exception {
        initPipeline(socketChannel);
    }

    private void initPipeline(SocketChannel socketChannel) {
        socketChannel.pipeline()
                // heartbeat
                .addLast("HeartbeatServerHandler", new HeartbeatServerHandler())
                .addLast("HttpResponseEncoder", new HttpResponseEncoder())
                .addLast("HttpRequestDecoder", new HttpRequestDecoder())
                .addLast("HttpObjectAggregator", new HttpObjectAggregator(10 * 1024 * 1024))
                .addLast("HttpServerHandler", new HttpServerHandler());
    }
}
