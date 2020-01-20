package com.youyuan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.RoutesRefreshedEvent;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhangy
 * @version 1.0
 * @description  定时刷新读取路由配置表的类
 * @date 2020/1/20 17:46
 */
@Component
@EnableScheduling
@Configuration
public class RefreshRouteService {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private RouteLocator routeLocator;

    /**
     * 定时刷新路由表的方法
     *
     * 每隔5秒刷下一下路由配置表中的内容到zuul内存的数据格式
     *
     */
    @Scheduled(fixedRate = 5000)
    public void refreshRoute() {
        System.out.println("定时刷新路由表");
        RoutesRefreshedEvent routesRefreshedEvent = new RoutesRefreshedEvent(routeLocator);
        publisher.publishEvent(routesRefreshedEvent);
    }
}
