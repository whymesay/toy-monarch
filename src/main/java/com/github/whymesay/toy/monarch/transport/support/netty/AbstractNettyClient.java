package com.github.whymesay.toy.monarch.transport.support.netty;

import com.github.whymesay.toy.monarch.common.domain.Message;
import com.github.whymesay.toy.monarch.common.domain.RpcRequest;
import com.github.whymesay.toy.monarch.common.domain.RpcResponse;
import com.github.whymesay.toy.monarch.config.GlobalConfig;
import com.github.whymesay.toy.monarch.transport.AbstractClient;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author whymesay
 * @date 2020/10/3 16:29
 */
@Slf4j
public abstract class AbstractNettyClient extends AbstractClient {
    protected Bootstrap bootstrap;
    protected ChannelFuture channelFuture;

    public AbstractNettyClient(GlobalConfig globalConfig) {
        super(globalConfig);
        init();
    }

    protected void init() {
        this.bootstrap = new Bootstrap();
        EventLoopGroup epollEventLoopGroup = new NioEventLoopGroup();
        bootstrap.group(epollEventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        initChannelHandler(ch);
                    }
                });

    }

    /**
     * Init channel handler.
     *
     * @param socketChannel the socket channel
     * @throws Exception the exception
     */
    protected abstract void initChannelHandler(SocketChannel socketChannel) throws Exception;

    @Override
    public Future<RpcResponse> send(RpcRequest request) {
        CompletableFuture<RpcResponse> responseFuture = new CompletableFuture<>();
        //todo 注册到缓存 提取结果
        this.channelFuture.channel().writeAndFlush(Message.buildRequest(request));
        return responseFuture;
    }

    @Override
    public void connect(String host, Integer port) {
        try {
            bootstrap.remoteAddress(new InetSocketAddress(host, port));
            this.channelFuture = bootstrap.connect().sync();
        } catch (InterruptedException e) {
            log.error("connect server fail", e);
        }
    }
}
