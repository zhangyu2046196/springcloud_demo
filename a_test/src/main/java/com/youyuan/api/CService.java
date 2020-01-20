package com.youyuan.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description C项目feign调用
 * @date 2020/1/18 16:38
 */
@FeignClient("C-SERVER")
public interface CService extends CApi {
}
