package com.github.whymesay.toy.monarch.transport.monarch.codc;

import com.github.whymesay.toy.monarch.common.domain.Message;
import com.github.whymesay.toy.monarch.common.domain.RpcRequest;
import com.github.whymesay.toy.monarch.common.domain.RpcResponse;
import com.github.whymesay.toy.monarch.config.SerializeConfig;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 解码数据为指定格式
 *
 * @author whymesay
 * @date 2020/10/3 18:48
 */
public class MonarchDecoder extends ByteToMessageDecoder {

    private SerializeConfig serializeConfig;

    public MonarchDecoder(SerializeConfig serializeConfig) {
        this.serializeConfig = serializeConfig;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        byte type = in.readByte();
        if (type == Message.PING) {
            out.add(Message.PING_MSG);
        } else if (type == Message.PONG) {
            out.add(Message.PONG_MSG);
        } else {
            byte[] data = new byte[in.readableBytes()];
            if (type == Message.REQUEST) {
                RpcRequest request = serializeConfig.getSerializer().deserialize(data, RpcRequest.class);
                out.add(Message.buildRequest(request));
            } else if (type == Message.RESPONSE) {
                RpcResponse response = serializeConfig.getSerializer().deserialize(data, RpcResponse.class);
                out.add(Message.buildResponse(response));
            }
        }
    }
}
