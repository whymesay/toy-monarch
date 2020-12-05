package com.github.whymesay.toy.monarch.serialize.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.whymesay.toy.monarch.common.exception.MonarchSerializeException;
import com.github.whymesay.toy.monarch.serialize.Serializer;

import java.io.IOException;

/**
 * @author whymesay
 * @date 2020/10/3 18:28
 */
public class JacksonSerializer implements Serializer {
    @Override
    public <T> byte[] serialize(T obj) throws MonarchSerializeException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            throw new MonarchSerializeException("monarch serialize failed", e);
        }
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> cls) throws MonarchSerializeException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(data, cls);
        } catch (IOException e) {
            throw new MonarchSerializeException("monarch deserialize failed", e);
        }
    }
}
