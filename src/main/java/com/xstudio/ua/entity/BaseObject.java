package com.xstudio.ua.entity;

import com.xstudio.ua.StringUtils;

public class BaseObject {

    /**
     * 版本
     */
    private String version;

    /**
     * 系列
     */
    private String family;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        if (!StringUtils.isEmpty(version)) {
            this.version = version.replace("_",".");
        } else {
            this.version = version;
        }

    }
}
