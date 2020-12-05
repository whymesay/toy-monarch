package com.github.whymesay.toy.monarch;

import com.github.whymesay.toy.monarch.config.GlobalConfig;
import com.github.whymesay.toy.monarch.config.SerializeConfig;

/**
 * @author whymesay
 * @date 2020/10/6 1:00
 */
public class BaseTest {
    protected GlobalConfig globalConfig = new GlobalConfig();
    {
        globalConfig.serializeConfig = new SerializeConfig();
    }

}
