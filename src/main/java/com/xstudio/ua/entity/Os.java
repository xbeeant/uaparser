package com.xstudio.ua.entity;


/**
 * @author xiaobiao
 * @version 1.0.0
 * @date 2021/02/01
 */
public class Os extends BaseObject {

    /**
     * 类型
     */
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{type:'" + type + '\'' +
                ", family:'" + super.getFamily() + '\'' +
                ", version:'" + super.getVersion() + '\'' +
                '}';
    }
}
