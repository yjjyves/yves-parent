package com.yves.model.common;


import com.yves.model.common.enums.OrgBizTypeEnum;

/**
 * @author Administrator
 * @date Created in 10:57 2018/5/15
 */
public class Org extends Entity<String>{
    /**
     * 名称
     */
    private String name;

    /**
     * 长编码
     */
    private String longNumber;

    /**
     * 上级组织
     */
    private Org parent;

    /**
     * 业务类型-FBIZTYPE
     */
    private OrgBizTypeEnum orgBizType;

    public Org(){}

    public Org(String id){
        super.setId(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongNumber() {
        return longNumber;
    }

    public void setLongNumber(String longNumber) {
        this.longNumber = longNumber;
    }

    public Org getParent() {
        return parent;
    }

    public void setParent(Org parent) {
        this.parent = parent;
    }

    public OrgBizTypeEnum getOrgBizType() {
        return orgBizType;
    }

    public void setOrgBizType(OrgBizTypeEnum orgBizType) {
        this.orgBizType = orgBizType;
    }

}
