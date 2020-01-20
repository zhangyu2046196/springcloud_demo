package com.youyuan.controller;

import com.youyuan.api.BApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/1/18 16:29
 */
@RestController
public class BController implements BApi {
    @Override
    public void test(String name) {
        System.out.println("调用B项目的test方法");
    }
}
