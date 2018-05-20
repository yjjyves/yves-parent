package com.yves.model.common;


import com.yves.model.common.enums.PositionTypeEnum;

/**
 * @author Administrator
 * @date Created in 10:57 2018/5/15
 */
public class Person extends Entity<String>{
    /**
     * 姓名
     */
    private String name;

    /**
     * 账号平台ID
     */
    private String accountId;

    /**
     * 电话
     */
    private String cell;

    /**
     * 所属组织--冗余字段
     */
    private Org org;

    /**
     * 岗位
     */
    private PositionTypeEnum positionType;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    public PositionTypeEnum getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionTypeEnum positionType) {
        this.positionType = positionType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
