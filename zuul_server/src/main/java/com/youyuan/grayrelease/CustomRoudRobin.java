package com.youyuan.grayrelease;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangy
 * @version 1.0
 * @description  自定义负载均衡策略
 * @date 2020/1/20 22:25
 */
@Configuration
@EnableScheduling
public class CustomRoudRobin {
    /**
     * 自定义灰度发布的负载均衡权重值  key存储发布的版本  value权重值
     */
    private static Map<String,Integer> hashMap=new HashMap<String,Integer>();

    private static Map<String,Weight> weightMap=new HashMap<String,Weight>();

    public int totalWeight=0;

    static {
        hashMap.put("1",8);
        hashMap.put("2",2);
    }

    /**
     * 定时刷新总的权重值
     */
    @Scheduled(fixedRate = 2000)
    public void refreshWeight(){
        System.out.println("重新计算灰度发布的指定服务列表总权重值");
        for (Map.Entry<String,Integer> entry:hashMap.entrySet()){
            totalWeight+=entry.getValue();
            weightMap.put(entry.getKey(),new Weight(entry.getKey(),entry.getValue(),entry.getValue()));
        }
    }

    /**
     * 获取加权平滑轮询负载均衡的灰度发布调用的版本号
     * @param totalWeight 总权重值
     * @return 返回灰度发布的版本号
     */
    public String getVersionByCurrentWeight(int totalWeight) {
        //计算当前weightMap列表中currentWeight最大的值
        Weight maxCurrentWeight=null;
        for (Map.Entry<String,Weight> entry:weightMap.entrySet()){
            if (maxCurrentWeight==null || maxCurrentWeight.getCurrentWeight()<entry.getValue().getCurrentWeight()){
                maxCurrentWeight=entry.getValue();
            }
        }

//        System.out.println("weightMap:"+weightMap);
//        System.out.println("maxCurrentWeight:"+maxCurrentWeight+" version:"+maxCurrentWeight.getVersion());

        //将最大的权重值减去总权重值
        weightMap.get(maxCurrentWeight.getVersion()).setCurrentWeight(maxCurrentWeight.getCurrentWeight()-totalWeight);


        //循环遍历权重服务 列表 ，将动态权重值加上固定权重值


        for (Map.Entry<String,Weight> entry:weightMap.entrySet()){
            weightMap.get(entry.getKey()).setCurrentWeight(entry.getValue().getCurrentWeight()+entry.getValue().getWeight());
        }


        return maxCurrentWeight.getVersion();
    }

}
