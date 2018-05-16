package com.yves.model.common;


import com.yves.model.common.enums.StateEnum;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 实体基类
 * @author Administrator
 * @date Created in 15:07 2018/5/11
 */
public class Entity<T> implements Serializable {
    /**
     * 主键ID
     */
    private T id;

    /**
     * 创建人ID
     */
    private String createPersonId;

    /**
     * 创建人账号平台ID
     */
    private String createAccountId;

    /**
     * 创建人时间
     */
    private Date createTime;

    /**
     * 更新人ID
     */
    private String updatePersonId;

    /**
     * 更新人账号平台ID
     */
    private String updateAccountId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 城市ID
     */
    private String cuId;

    /**
     * 数据状态
     */
    private StateEnum state;

    public  void setUUID(){
        this.setId((T) (UUID.randomUUID().toString()));
    }

    public String getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(String createPersonId) {
        this.createPersonId = createPersonId;
    }

    public String getCreateAccountId() {
        return createAccountId;
    }

    public void setCreateAccountId(String createAccountId) {
        this.createAccountId = createAccountId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdatePersonId() {
        return updatePersonId;
    }

    public void setUpdatePersonId(String updatePersonId) {
        this.updatePersonId = updatePersonId;
    }

    public String getUpdateAccountId() {
        return updateAccountId;
    }

    public void setUpdateAccountId(String updateAccountId) {
        this.updateAccountId = updateAccountId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCuId() {
        return cuId;
    }

    public void setCuId(String cuId) {
        this.cuId = cuId;
    }

    public String getCreateTimeStr() {
        return createTime == null ? "" : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createTime);
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }
}
