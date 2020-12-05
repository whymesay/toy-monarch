package com.github.whymesay.toy.monarch.transport;

import com.github.whymesay.toy.monarch.common.exception.MonarchException;
import com.github.whymesay.toy.monarch.config.GlobalConfig;
import lombok.extern.slf4j.Slf4j;

/**
 * @author whymesay
 * @date 2020/10/3 15:58
 */
@Slf4j
public abstract class AbstractClient implements Client {


    protected GlobalConfig globalConfig;

    public AbstractClient(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
    }

    @Override
    public void close() {
        throw new MonarchException("cant close monarch client");
    }

    /**
     * connect server
     *
     * @param host server host
     * @param port server port
     */
    public abstract void connect(String host, Integer port);

}

