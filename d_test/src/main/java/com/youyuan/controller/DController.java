package com.youyuan.controller;

import com.youyuan.api.DApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/1/18 16:36
 */
@RestController
public class DController implements DApi {
    @Override
    public void test(String name) {
        System.out.println("调用D项目的test方法");
    }
}
