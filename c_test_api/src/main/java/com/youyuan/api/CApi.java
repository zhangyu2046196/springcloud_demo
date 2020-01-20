package com.youyuan.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangy
 * @version 1.0
 * @description C项目接口
 * @date 2020/1/18 16:17
 */
@RequestMapping("/c")
public interface CApi {

    @RequestMapping("/test/{name}")
    public void test(@PathVariable("name") String name);
}
