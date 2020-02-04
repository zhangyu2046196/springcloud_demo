package com.youyuan.grayrelease;

import java.io.Serializable;

/**
 * @author zhangy
 * @version 1.0
 * @description  灰度发布实体类
 * @date 2020/1/20 21:07
 */
public class GrayReleaseBean implements Serializable {
    private static final long serialVersionUID = -5172683046238351108L;
    /**
     * 主键
     */
    private int id;
    /**
     * 服务提供者服务名
     */
    private String serviceId;
    /**
     * 服务提供者的访问路径
     */
    private String path;
    /**
     * 灰度发布的开关 1开 0关
     */
    private int enableGrayRelease;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getEnableGrayRelease() {
        return enableGrayRelease;
    }

    public void setEnableGrayRelease(int enableGrayRelease) {
        this.enableGrayRelease = enableGrayRelease;
    }

    @Override
    public String toString() {
        return "GrayReleaseBean{" +
                "id=" + id +
                ", serviceId='" + serviceId + '\'' +
                ", path='" + path + '\'' +
                ", enableGrayRelease=" + enableGrayRelease +
                '}';
    }
}
