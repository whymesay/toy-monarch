package com.github.whymesay.toy.monarch.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by SinjinSong on 2017/7/31.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {
    public static final byte PING = 1;
    public static final byte PONG = 1 << 1;
    public static final byte REQUEST = 1 << 2;
    public static final byte RESPONSE = 1 << 3;
    /**
     * heartbeat request
     */
    public static final Message PING_MSG = new Message(PING);
    /**
     * heartbeat response
     */
    public static final Message PONG_MSG = new Message(PONG);
    private byte type;
    private RpcRequest request;
    private RpcResponse response;

    public Message(byte type) {
        this.type = type;
    }

    public static Message buildRequest(RpcRequest request) {
        return new Message(REQUEST, request, null);
    }

    public static Message buildResponse(RpcResponse response) {
        return new Message(RESPONSE, null, response);
    }
}
