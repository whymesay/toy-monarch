package com.github.whymesay.toy.monarch.protocol;

/**
 * @author whymesay
 * @date 2020/10/3 15:47
 */
public interface InvokeParam {

    String getInterfaceName();

    String getMethodName();

    Class<?>[] getParameterTypes();

    Object[] getParameters();

    String getRequestId();
}
