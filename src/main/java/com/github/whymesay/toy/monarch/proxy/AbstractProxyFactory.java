package com.github.whymesay.toy.monarch.proxy;

import com.github.whymesay.toy.monarch.common.domain.RpcRequest;
import com.github.whymesay.toy.monarch.common.domain.RpcResponse;
import com.github.whymesay.toy.monarch.invoker.Invoker;

import java.lang.reflect.Method;

/**
 * @author whymesay
 * @date 2020/10/24 22:32
 */
public abstract class AbstractProxyFactory implements MonarchProxyFactory {

    @Override
    public <T> T createProxy(Invoker<T> invoker) {
        return doCreateProxy(invoker);
    }

    /**
     * 创建代理
     *
     * @param invoker
     * @param <T>
     * @return
     */
    protected abstract <T> T doCreateProxy(Invoker<T> invoker);

    /**
     * 调用代理方法
     *
     * @param invoker
     * @param method
     * @param args
     * @return
     */
    protected Object invokeProxyMethod(Invoker<?> invoker, Method method, Object[] args) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        String[] parameters = new String[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            parameters[i] = parameterTypes[i].getName();
        }
        return invokeProxyMethod(invoker, invoker.getInterface().getName(), method.getName(), parameters, args);
    }

    private Object invokeProxyMethod(Invoker<?> invoker, String interfaceName, String methodName, String[] parameterTypes, Object[] args) {
        RpcRequest rpcRequest = new RpcRequest();

        RpcResponse response = invoker.invoke(rpcRequest);
        Object result = null;
        if (response != null) {
            result = response.getResult();
        }
        return result;
    }
}
