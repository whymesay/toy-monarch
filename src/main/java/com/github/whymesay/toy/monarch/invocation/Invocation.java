package com.github.whymesay.toy.monarch.invocation;

import com.github.whymesay.toy.monarch.invoker.Invoker;

/**
 * @author whymesay
 * @date 2020/10/25 21:08
 */
public interface Invocation {

    /**
     * get method name.
     *
     * @return method name.
     * @serial
     */
    String getMethodName();

    /**
     * get parameter types.
     *
     * @return parameter types.
     * @serial
     */
    Class<?>[] getParameterTypes();

    /**
     * get arguments.
     *
     * @return arguments.
     * @serial
     */
    Object[] getParameters();

    /**
     * get the invoker in current context.
     *
     * @return invoker.
     */
    Invoker<?> getInvoker();

}
