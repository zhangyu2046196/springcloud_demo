package com.youyuan.grayrelease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhangy
 * @version 1.0
 * @description 灰度发布表的管理类，有定时任务拉取灰度发布表的内容到内存
 * @date 2020/1/20 21:13
 */
@Component
@Configuration
@EnableScheduling
public class GrayReleaseConfigManager {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 用来保存灰度发布表内容的map  key:存储服务请求path  value存储服务配置实体
     */
    private Map<String, GrayReleaseBean> grayReleaseBeanMap = new ConcurrentHashMap<String, GrayReleaseBean>();

    /**
     * 定时任务每隔1秒从数据库拉取一次数据
     */
    @Scheduled(fixedRate = 1000)
    public void refreshRout() {
        System.out.println("加载灰度发布的配置信息");
        List<GrayReleaseBean> releaseBeanList = jdbcTemplate.query("select * from gray_release_config", new BeanPropertyRowMapper<>(GrayReleaseBean.class));
        for (GrayReleaseBean grayReleaseBean : releaseBeanList) {
            grayReleaseBeanMap.put(grayReleaseBean.getPath(), grayReleaseBean);
        }
    }

    /**
     * 获取所有灰度发布开关
     * @return
     */
    public Map<String,GrayReleaseBean> getGrayReleaseBeanMap(){
        return grayReleaseBeanMap;
    }
}
