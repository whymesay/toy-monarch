package com.github.whymesay.toy.monarch.invoker;

import com.github.whymesay.toy.monarch.common.domain.RpcRequest;
import com.github.whymesay.toy.monarch.common.domain.RpcResponse;

import java.util.concurrent.ExecutionException;

/**
 * @author whymesay
 * @date 2020/10/12 21:40
 */
public class MonarchInvoker<T> extends AbstractInvoker<T> {

    @Override
    protected RpcResponse doInvoke(RpcRequest request) {
        try {
            return client.send(request).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
