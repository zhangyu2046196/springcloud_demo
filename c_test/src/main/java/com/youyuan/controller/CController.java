package com.youyuan.controller;

import com.youyuan.api.CApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/1/18 16:32
 */
@RestController
public class CController  implements CApi{
    @Override
    public void test(String name) {
        System.out.println("调用C项目test方法");
    }
}
