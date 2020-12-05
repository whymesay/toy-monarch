package com.github.whymesay.toy.monarch.invoker;

import com.github.whymesay.toy.monarch.transport.Client;
import com.github.whymesay.toy.monarch.common.domain.RpcRequest;
import com.github.whymesay.toy.monarch.common.domain.RpcResponse;
import com.github.whymesay.toy.monarch.common.exception.MonarchException;

import java.net.URL;

/**
 * The type Abstract invoker.
 *
 * @param <T> the type parameter
 * @author whymesay
 * @date 2020 /10/12 21:41
 */
public abstract class AbstractInvoker<T> implements Invoker<T> {

    /**
     * The Client.
     */
    protected Client client;

    @Override
    public Class<T> getInterface() {
        return null;
    }

    @Override
    public RpcResponse invoke(RpcRequest request) throws MonarchException {
        return doInvoke(request);
    }

    /**
     * do really invoke
     *
     * @param request the request
     * @return result rpc response
     */
    protected abstract RpcResponse doInvoke(RpcRequest request);


    /**
     * get url.
     *
     * @return url. url
     */
    public URL getUrl() {
        return null;
    }

    /**
     * is available.
     *
     * @return available. boolean
     */
    public boolean isAvailable() {
        return false;
    }

    /**
     * destroy.
     */
    public void destroy() {

    }
}
