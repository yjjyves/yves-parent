package com.yves.model.bill;


import com.yves.model.common.Entity;

import java.util.Date;

/**
 * @author Administrator
 * @date Created in 15:06 2018/5/11
 */
public class VirtualBillDO extends Entity<String> {
    /**
     * 运营商-通话唯一标识id
     */
    private String recorderId;

    /**
     * 经纪人短号池ID
     */
    private String agentNumberId;

    /**
     * 冗余经纪人短号
     */
    private String agentNumber;

    /**
     * 经纪人城市渠道与短号ID
     */
    private String channelPersonId;

    /**
     * 分配记录ID
     */
    private String matchRecordId;

    /**
     * 经纪人ID
     */
    private String personId;

    /**
     * 帐号平台ID
     */
    private String accountId;

    /**
     * 经纪人手机号
     */
    private String personPhone;

    /**
     * 主叫真实号码
     */
    private String caller;

    /**
     * 主叫显示号码
     */
    private String callerShow;

    /**
     * 被叫真实号码
     */
    private String called;

    /**
     * 被叫分配号码，即主叫所拨打的虚拟号
     */
    private String calledShow;

    /**
     * 主叫拨打时间
     */
    private Date beginTime;

    /**
     * 被叫挂机时间,通话结束时刻
     */
    private Date releaseTime;

    /**
     * 主被叫之间的通话时长，单位为秒
     */
    private Integer callDuration;

    /**
     * 计费时长，单位为秒
     */
    private Integer billDuration;


    /**
     * 通话录音源地址url
     */
    private String soundUrl;

    /**
     * 该次通话费用，单位为元
     */
    private Double callCost;

    /**
     * 主叫城市名称，例如“北京”
     */
    private String callerArea;

    /**
     * 被叫城市名称，例如“上海”
     */
    private String calledArea;

    /**
     * 接通时间
     */
    private Date connectTime;

    /**
     * 被叫振铃时间
     */
    private Date alertingTime;

    /**
     * 通话录音保存地址url
     */
    private String soundPersistentUrl;

    /**
     * 流水屏蔽人
     */
    private String shieldPid;

    /**
     * 屏蔽状态
     */
    private Integer isShield;

    /**
     * 屏蔽时间
     */
    private Date shieldTime;

    /**
     * 私客ID
     */
    private String privateId;

    /**
     * 私客ID
     */
    private String privatePersonId;

    /**
     * 所属分店id
     */
    private String storeId;

    /**
     * 所属片区id
     */
    private String areaId;

    /**
     * 所属大区id
     */
    private String regionId;

    /**
     * 业主ID
     */
    private String ownerId;

    /**
     * 房源编码
     */
    private String roomId;


    public String getRecorderId() {
        return recorderId;
    }

    public void setRecorderId(String recorderId) {
        this.recorderId = recorderId;
    }

    public String getAgentNumberId() {
        return agentNumberId;
    }

    public void setAgentNumberId(String agentNumberId) {
        this.agentNumberId = agentNumberId;
    }

    public String getAgentNumber() {
        return agentNumber;
    }

    public void setAgentNumber(String agentNumber) {
        this.agentNumber = agentNumber;
    }

    public String getChannelPersonId() {
        return channelPersonId;
    }

    public void setChannelPersonId(String channelPersonId) {
        this.channelPersonId = channelPersonId;
    }

    public String getMatchRecordId() {
        return matchRecordId;
    }

    public void setMatchRecordId(String matchRecordId) {
        this.matchRecordId = matchRecordId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller;
    }

    public String getCallerShow() {
        return callerShow;
    }

    public void setCallerShow(String callerShow) {
        this.callerShow = callerShow;
    }

    public String getCalled() {
        return called;
    }

    public void setCalled(String called) {
        this.called = called;
    }

    public String getCalledShow() {
        return calledShow;
    }

    public void setCalledShow(String calledShow) {
        this.calledShow = calledShow;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(Integer callDuration) {
        this.callDuration = callDuration;
    }

    public Integer getBillDuration() {
        return billDuration;
    }

    public void setBillDuration(Integer billDuration) {
        this.billDuration = billDuration;
    }

    public String getSoundUrl() {
        return soundUrl;
    }

    public void setSoundUrl(String soundUrl) {
        this.soundUrl = soundUrl;
    }

    public Double getCallCost() {
        return callCost;
    }

    public void setCallCost(Double callCost) {
        this.callCost = callCost;
    }

    public String getCallerArea() {
        return callerArea;
    }

    public void setCallerArea(String callerArea) {
        this.callerArea = callerArea;
    }

    public String getCalledArea() {
        return calledArea;
    }

    public void setCalledArea(String calledArea) {
        this.calledArea = calledArea;
    }

    public Date getConnectTime() {
        return connectTime;
    }

    public void setConnectTime(Date connectTime) {
        this.connectTime = connectTime;
    }

    public Date getAlertingTime() {
        return alertingTime;
    }

    public void setAlertingTime(Date alertingTime) {
        this.alertingTime = alertingTime;
    }

    public String getSoundPersistentUrl() {
        return soundPersistentUrl;
    }

    public void setSoundPersistentUrl(String soundPersistentUrl) {
        this.soundPersistentUrl = soundPersistentUrl;
    }

    public String getShieldPid() {
        return shieldPid;
    }

    public void setShieldPid(String shieldPid) {
        this.shieldPid = shieldPid;
    }

    public Integer getIsShield() {
        return isShield;
    }

    public void setIsShield(Integer isShield) {
        this.isShield = isShield;
    }

    public Date getShieldTime() {
        return shieldTime;
    }

    public void setShieldTime(Date shieldTime) {
        this.shieldTime = shieldTime;
    }

    public String getPrivateId() {
        return privateId;
    }

    public void setPrivateId(String privateId) {
        this.privateId = privateId;
    }

    public String getPrivatePersonId() {
        return privatePersonId;
    }

    public void setPrivatePersonId(String privatePersonId) {
        this.privatePersonId = privatePersonId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "VirtualBillDO{" +
                "recorderId='" + recorderId + '\'' +
                ", agentNumberId='" + agentNumberId + '\'' +
                ", agentNumber='" + agentNumber + '\'' +
                ", channelPersonId='" + channelPersonId + '\'' +
                ", matchRecordId='" + matchRecordId + '\'' +
                ", personId='" + personId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", personPhone='" + personPhone + '\'' +
                ", caller='" + caller + '\'' +
                ", callerShow='" + callerShow + '\'' +
                ", called='" + called + '\'' +
                ", calledShow='" + calledShow + '\'' +
                ", beginTime=" + beginTime +
                ", releaseTime=" + releaseTime +
                ", callDuration=" + callDuration +
                ", billDuration=" + billDuration +
                ", soundUrl='" + soundUrl + '\'' +
                ", callCost=" + callCost +
                ", callerArea='" + callerArea + '\'' +
                ", calledArea='" + calledArea + '\'' +
                ", connectTime=" + connectTime +
                ", alertingTime=" + alertingTime +
                ", soundPersistentUrl='" + soundPersistentUrl + '\'' +
                ", shieldPid='" + shieldPid + '\'' +
                ", isShield=" + isShield +
                ", shieldTime=" + shieldTime +
                ", privateId='" + privateId + '\'' +
                ", privatePersonId='" + privatePersonId + '\'' +
                ", storeId='" + storeId + '\'' +
                ", areaId='" + areaId + '\'' +
                ", regionId='" + regionId + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", roomId='" + roomId + '\'' +
                '}';
    }
}
