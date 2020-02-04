package com.youyuan.grayrelease;

import java.io.Serializable;

/**
 * @author zhangyu
 * @description  权重值对象
 * @date 2020/1/20 22:29
 */
public class Weight implements Serializable {

    private static final long serialVersionUID = 4130468385030027572L;

    //ip信息
    private String version;
    //固定权重值
    private Integer weight;
    //动态权重值
    private Integer currentWeight;

    public Weight(String version, Integer weight, Integer currentWeight) {
        this.version = version;
        this.weight = weight;
        this.currentWeight = currentWeight;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "version='" + version + '\'' +
                ", weight=" + weight +
                ", currentWeight=" + currentWeight +
                '}';
    }
}
