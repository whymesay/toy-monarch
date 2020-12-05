package com.github.whymesay.toy.monarch.transport;

import com.github.whymesay.toy.monarch.common.exception.MonarchException;
import com.github.whymesay.toy.monarch.config.GlobalConfig;
import lombok.extern.slf4j.Slf4j;

/**
 * @author whymesay
 * @date 2020/10/3 16:10
 */
@Slf4j
public abstract class AbstractServer implements Server {


    protected GlobalConfig globalConfig;

    public AbstractServer(GlobalConfig globalConfig) {
        this.globalConfig = globalConfig;
    }

    @Override
    public void start() {
        throw new MonarchException("cant start monarch server");
    }

    @Override
    public void close() {
        throw new MonarchException("cant close monarch server");
    }
}
