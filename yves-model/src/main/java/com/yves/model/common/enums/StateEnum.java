package com.yves.model.common.enums;

/**
 * @author Administrator
 * @date Created in 15:13 2018/5/11
 */
public enum StateEnum {
    EFFECTIVE("启用",0),
    DISABLED("禁用",0);

    private StateEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }
    private String name;
    private int value;

    public String getName() {
        return name;
    }
    public int getValue() {
        return value;
    }
}
