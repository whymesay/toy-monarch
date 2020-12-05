package com.github.whymesay.toy.monarch.invocation;

import com.github.whymesay.toy.monarch.invoker.Invoker;
import jdk.internal.dynalink.support.TypeUtilities;

/**
 * @author whymesay
 * @date 2020/10/25 21:14
 */
public abstract class AbstractInvocation implements Invocation {

    private String methodName;
    private String[] parameterTypes;
    private Object[] parameters;
    private Invoker<?> invoker;

    @Override
    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public Class<?>[] getParameterTypes() {
        Class<?>[] parameterTypeClazzs = new Class[this.parameterTypes.length];
        for (int i = 0; i < this.parameterTypes.length; i++) {
            parameterTypeClazzs[i] = TypeUtilities.getPrimitiveTypeByName(this.parameterTypes[i]);
        }
        return parameterTypeClazzs;
    }


    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = new String[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            this.parameterTypes[i] = parameterType.getName();
        }
    }

    public void setParameterTypes(String[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    @Override
    public Object[] getParameters() {
        return this.parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    @Override
    public Invoker<?> getInvoker() {
        return this.invoker;
    }

    public void setInvoker(Invoker<?> invoker) {
        this.invoker = invoker;
    }


}
