package com.github.whymesay.toy.monarch.serialize;

import com.github.whymesay.toy.monarch.common.exception.MonarchSerializeException;

/**
 * The interface Serializer.
 *
 * @author whymesay
 * @date 2020 /10/3 17:43
 */
public interface Serializer {
    /**
     * serialize object
     *
     * @param <T> the type parameter
     * @param obj the obj
     * @return byte [ ]
     * @throws MonarchSerializeException the monarch serialize exception
     */
    <T> byte[] serialize(T obj) throws MonarchSerializeException;

    /**
     * deserialize object
     *
     * @param <T>  the type parameter
     * @param data data
     * @param cls  the cls
     * @return t
     * @throws MonarchSerializeException the monarch serialize exception
     */
    <T> T deserialize(byte[] data, Class<T> cls) throws MonarchSerializeException;
}
