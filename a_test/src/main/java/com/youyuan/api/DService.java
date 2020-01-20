package com.youyuan.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description D项目feign调用
 * @date 2020/1/18 16:39
 */
@FeignClient("D-SERVER")
public interface DService extends DApi {
}
