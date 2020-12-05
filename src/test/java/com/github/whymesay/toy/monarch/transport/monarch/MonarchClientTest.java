package com.github.whymesay.toy.monarch.transport.monarch;


import com.github.whymesay.toy.monarch.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author whymesay
 * @date 2020/10/6 0:59
 */

class MonarchClientTest extends BaseTest {

    @Test
    public void testMonarchClient() {
        MonarchClient monarchClient = new MonarchClient(globalConfig);
        monarchClient.connect("127.0.0.1", 1086);
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
    }
}
