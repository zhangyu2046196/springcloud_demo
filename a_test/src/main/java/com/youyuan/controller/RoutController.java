package com.youyuan.controller;

import com.youyuan.api.BService;
import com.youyuan.api.CService;
import com.youyuan.api.DService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/1/18 16:40
 */
@RestController
@RequestMapping("/rout")
public class RoutController {

    @Autowired
    private BService bService;
    @Autowired
    private CService cService;
    @Autowired
    private DService dService;

    @RequestMapping("/{name}")
    public void rController(@PathVariable("name") String name) {
        System.out.println("调用A项目的controller方法");
        bService.test(name);
        cService.test(name);
        dService.test(name);
    }
}
