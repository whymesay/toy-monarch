package com.github.whymesay.toy.monarch.transport.monarch.codc;

import com.github.whymesay.toy.monarch.serialize.Serializer;
import com.github.whymesay.toy.monarch.common.domain.Message;
import com.github.whymesay.toy.monarch.config.SerializeConfig;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author whymesay
 * @date 2020/10/3 17:42
 */
public class MonarchEncoder extends MessageToByteEncoder<Message> {
    private SerializeConfig serializeConfig;

    public MonarchEncoder(SerializeConfig serializeConfig) {
        this.serializeConfig = serializeConfig;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
        Serializer serializer = serializeConfig.getSerializer();
        // 第一个字节为请求类型,后面根据请求内容选择需要序列化的部分
        out.writeByte(msg.getType());
        if (msg.getType() == Message.REQUEST) {
            byte[] request = serializer.serialize(msg.getRequest());
            out.writeBytes(request);
        } else if (msg.getType() == Message.RESPONSE) {
            byte[] response = serializer.serialize(msg.getResponse());
            out.writeBytes(response);
        }
    }
}
