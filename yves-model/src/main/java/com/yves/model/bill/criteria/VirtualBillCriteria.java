package com.yves.model.bill.criteria;

/**
 * @author Administrator
 * @date Created in 16:28 2018/5/15
 */
public class VirtualBillCriteria {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 小号
     */
    private String agentNumber;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAgentNumber() {
        return agentNumber;
    }

    public void setAgentNumber(String agentNumber) {
        this.agentNumber = agentNumber;
    }
}
