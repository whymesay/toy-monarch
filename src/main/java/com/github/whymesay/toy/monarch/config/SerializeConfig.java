package com.github.whymesay.toy.monarch.config;

import com.github.whymesay.toy.monarch.common.enums.SerializeTypeEnum;
import com.github.whymesay.toy.monarch.serialize.Serializer;
import com.github.whymesay.toy.monarch.serialize.json.JacksonSerializer;

/**
 * @author whymesay
 * @date 2020/10/3 17:56
 */
public class SerializeConfig {
    public Serializer getSerializer() {
        if (SerializeTypeEnum.JSON.equals(getSerializeType())) {
            return new JacksonSerializer();
        }
        return null;
    }

    private SerializeTypeEnum getSerializeType() {
        return SerializeTypeEnum.JSON;
    }

}
