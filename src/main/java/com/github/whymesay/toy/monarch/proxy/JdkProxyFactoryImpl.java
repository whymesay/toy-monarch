package com.github.whymesay.toy.monarch.proxy;

import com.github.whymesay.toy.monarch.invoker.Invoker;

import java.lang.reflect.Proxy;

/**
 * @author whymesay
 * @date 2020/10/24 22:34
 */
public class JdkProxyFactoryImpl extends AbstractProxyFactory {

    @Override
    @SuppressWarnings("unchecked")
    protected <T> T doCreateProxy(Invoker<T> invoker) {
        return (T) Proxy.newProxyInstance(invoker.getInterface().getClassLoader(), new Class[]{invoker.getInterface()},
                (proxy, method, args) -> (T) JdkProxyFactoryImpl.this.invokeProxyMethod(invoker, method, args));
    }
}
