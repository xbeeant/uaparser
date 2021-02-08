package com.xstudio.ua.entity;

public class Engine extends BaseObject {

    @Override
    public String toString() {
        return "{family:'" + super.getFamily() + '\'' +
                ", version:'" + super.getVersion() + '\'' +
                '}';
    }
}
