package com.cmile.controller;

import com.cmile.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
@EnableAutoConfiguration
public class TestController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/HelloWorld")
    public String HelloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/Exception")
    public String ShowError() {
        int num = 6 / 0;
        return "Show Error Function";
    }

    @RequestMapping("/Async")
    public String AsyncTest() throws Exception {

        long start = System.currentTimeMillis();

        Future<String> task1 = asyncService.doTask1();
        Future<String> task2 = asyncService.doTask2();
        Future<String> task3 = asyncService.doTask3();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                break;
            }

            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        return "全部执行完成，总耗时: " + (end - start) + "毫秒";
    }
}