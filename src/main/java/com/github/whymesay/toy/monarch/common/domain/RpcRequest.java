package com.github.whymesay.toy.monarch.common.domain;

import jdk.internal.dynalink.support.TypeUtilities;

import java.io.Serializable;

/**
 * @author whymesay
 * @date 2020/10/3 16:26
 */
public class RpcRequest implements Serializable {
    private String requestId;
    private String interfaceName;
    private String methodName;
    private String[] parameterTypes;
    private Object[] parameters;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParameterTypes() {
        Class[] parameterTypeClazzs = new Class[this.parameterTypes.length];
        for (int i = 0; i < this.parameterTypes.length; i++) {
            parameterTypeClazzs[i] = TypeUtilities.getPrimitiveTypeByName(this.parameterTypes[i]);
        }
        return parameterTypeClazzs;
    }

    public void setParameterTypes(Class[] parameterTypes) {
        this.parameterTypes = new String[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Class parameterType = parameterTypes[i];
            this.parameterTypes[i] = parameterType.getName();
        }
    }

    public void setParameterTypes(String[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
