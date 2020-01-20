package com.youyuan.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description A项目接口
 * @date 2020/1/18 16:14
 */
@RequestMapping("/a")
public interface AApi {
    @RequestMapping("/test/{name}")
    public void test(@PathVariable("name") String name);
}
