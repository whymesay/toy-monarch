package com.github.whymesay.toy.monarch.common.exception;

/**
 * @author whymesay
 * @date 2020/10/3 16:18
 */
public class MonarchSerializeException extends RuntimeException {
    public MonarchSerializeException() {
    }

    public MonarchSerializeException(String message) {
        super(message);
    }

    public MonarchSerializeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MonarchSerializeException(Throwable cause) {
        super(cause);
    }

    protected MonarchSerializeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
