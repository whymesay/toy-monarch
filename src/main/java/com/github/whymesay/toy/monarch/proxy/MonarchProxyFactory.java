package com.github.whymesay.toy.monarch.proxy;

import com.github.whymesay.toy.monarch.invoker.Invoker;

/**
 * @author whymesay
 * @date 2020/10/24 22:26
 */
public interface MonarchProxyFactory {
    /**
     * 创建代理
     *
     * @param invoker
     * @return
     */
   <T> T createProxy(Invoker<T> invoker);
}
