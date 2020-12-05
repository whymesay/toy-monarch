package com.github.whymesay.toy.monarch.common.exception;

/**
 * @author whymesay
 * @date 2020/10/3 16:18
 */
public class MonarchException extends RuntimeException {
    public MonarchException() {
    }

    public MonarchException(String message) {
        super(message);
    }

    public MonarchException(String message, Throwable cause) {
        super(message, cause);
    }

    public MonarchException(Throwable cause) {
        super(cause);
    }

    protected MonarchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
