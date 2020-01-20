package com.youyuan;

import java.io.Serializable;

/**
 * @author zhangy
 * @version 1.0
 * @description  数据库配置表对应的实体
 * @date 2020/1/20 17:08
 */
public class ZuulRoutBean implements Serializable {
    private static final long serialVersionUID = -8328219839518425243L;
    /**
     * 服务名
     */
    private String id;
    /**
     * 访问路径
     */
    private String path;
    /**
     * 服务名
     */
    private String serviceId;
    /**
     * 访问地址
     */
    private String url;

    /**
     * 是否重试
     */
    private Boolean retryable;
    /**
     * 是否开启
     */
    private Boolean enabled;

    private boolean stripPrefix=true;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getRetryable() {
        return retryable;
    }

    public void setRetryable(Boolean retryable) {
        this.retryable = retryable;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isStripPrefix() {
        return stripPrefix;
    }

    public void setStripPrefix(boolean stripPrefix) {
        this.stripPrefix = stripPrefix;
    }

    @Override
    public String toString() {
        return "ZuulRoutBean{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", url='" + url + '\'' +
                ", retryable=" + retryable +
                ", enabled=" + enabled +
                ", stripPrefix=" + stripPrefix +
                '}';
    }
}
