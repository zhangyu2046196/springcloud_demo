package com.youyuan.grayrelease;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author zhangy
 * @version 1.0
 * @description 定义filter  每个请求zuul都会调用这个filter
 * @date 2020/1/20 21:35
 */
@Configuration
public class GrayReleaseFilter extends ZuulFilter {

    @Autowired
    private GrayReleaseConfigManager grayReleaseConfigManager;

    @Autowired
    private CustomRoudRobin customRoudRobin;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    /**
     * 读取灰度发布的配置内容来匹配请求地址是否开启灰度发布
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestURI = request.getRequestURI();
        Map<String, GrayReleaseBean> grayReleaseBeanMap = grayReleaseConfigManager.getGrayReleaseBeanMap();
        for (String path : grayReleaseBeanMap.keySet()) {
            if (requestURI.contains(path)) {
                GrayReleaseBean grayReleaseBean = grayReleaseBeanMap.get(path);
                if (grayReleaseBean.getEnableGrayRelease() == 1) {
                    System.out.println("启用灰度发布");
                    return true;
                }
            }
        }
        System.out.println("不启用灰度发布");
        return false;
    }

    /**
     * zuul流量负载均衡逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//
//        Random random = new Random();
//        int seed = random.nextInt(100);
//
//        if (seed % 2 == 0) {  //偶数走新版本  奇数走老版本
//            // 此处的版本是在服务提供者定义的版本号，通过这个版本来路由到不同版本的服务提供者
//            RibbonFilterContextHolder.getCurrentContext().add("version", "2");
//        } else {
//            RibbonFilterContextHolder.getCurrentContext().add("version", "1");
//        }

        //自定义负载均衡策略，按照百分比来进行灰度发布
//        String version = customRoudRobin.getVersionByCurrentWeight(customRoudRobin.totalWeight);
//
//        RibbonFilterContextHolder.getCurrentContext().add("version", version);

        return null;
    }
}
