package com.xstudio.ua.entity;


/**
 * @author xiaobiao
 * @version 1.0.0
 * @date 2021/02/01
 */
public class Browser extends BaseObject {

    @Override
    public String toString() {
        return "{family:'" + super.getFamily() + '\'' +
                ", version:'" + super.getVersion() + '\'' +
                '}';
    }
}
