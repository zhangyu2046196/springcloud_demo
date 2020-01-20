package com.youyuan.controller;

import com.youyuan.api.AApi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/1/18 16:24
 */
@RestController
public class AController implements AApi{
    @Override
    public void test(@PathVariable("name") String name) {
        System.out.println("调用A项目test方法");
    }
}
