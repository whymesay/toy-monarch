package com.github.whymesay.toy.monarch.transport.monarch;


import com.github.whymesay.toy.monarch.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author whymesay
 * @date 2020/10/6 0:59
 */

class MonarchServerTest extends BaseTest {

    @Test
    public void testMonarchServer() {
        MonarchServer monarchServer = new MonarchServer(globalConfig);
        monarchServer.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
    }
}
