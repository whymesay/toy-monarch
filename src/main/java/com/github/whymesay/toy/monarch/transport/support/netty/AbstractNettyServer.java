package com.github.whymesay.toy.monarch.transport.support.netty;

import com.github.whymesay.toy.monarch.transport.AbstractServer;
import com.github.whymesay.toy.monarch.common.domain.RpcRequest;
import com.github.whymesay.toy.monarch.common.exception.MonarchException;
import com.github.whymesay.toy.monarch.config.GlobalConfig;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * The type Abstract netty server.
 *
 * @author whymesay
 * @date 2020 /10/3 16:29
 */
@Slf4j
public abstract class AbstractNettyServer extends AbstractServer {
    private EventLoopGroup boosLoopGroup;
    private EventLoopGroup workerLoopGroup;
    private ChannelFuture channelFuture;

    /**
     * Instantiates a new Abstract netty server.
     *
     * @param globalConfig the global config
     */
    public AbstractNettyServer(GlobalConfig globalConfig) {
        super(globalConfig);
    }

    @Override
    public void start() {
        try {
            doStart(1086);
        } catch (Exception e) {
            throw new MonarchException("start monarch failed", e);
        }
    }

    private void doStart(int port) throws InterruptedException {
        this.boosLoopGroup = new NioEventLoopGroup();
        this.workerLoopGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boosLoopGroup, workerLoopGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        initChannelHandler(ch);
                    }
                });
        this.channelFuture = serverBootstrap.bind(port).sync();
    }


    /**
     * Init channel handler.
     *
     * @param socketChannel the socket channel
     * @throws Exception the exception
     */
    protected abstract void initChannelHandler(SocketChannel socketChannel) throws Exception;

    @Override
    public void close() {
        if (boosLoopGroup != null) {
            boosLoopGroup.shutdownGracefully();
        }
        if (workerLoopGroup != null) {
            workerLoopGroup.shutdownGracefully();
        }
        try {
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            log.warn("fail to close channel", e);
        }

    }

    @Override
    public void handleRpcRequest(RpcRequest request, ChannelHandlerContext ctx) {
        ctx.writeAndFlush(null);
    }
}
