package com.yves.model.common.enums;


/**
 * 业务类型
 * @author yves
 * @time 2012-2-2 下午04:09:13
 */
//加盟区域、加盟片区、直营区域、直营片区、加盟店铺、直营店铺）
public enum OrgBizTypeEnum {

	DIRECTLY_INTERMEDIARY("营业部","营业部","",1),
	DIRECTLY_BIGPLATE("大区","大区","INTERMEDIARY",1),
	JOIN_REGIONAL("加盟区域","区域","_REGIONAL",2),
	JOIN_AREA("加盟片区","片区","_AREA",3),
	JOIN_STORE("加盟店铺","店铺","_STORE",4);
	//新房事业部组织类型

	private OrgBizTypeEnum(String name, String showName, String searchKey, Integer seq) {
		this.name = name;
		this.showName = showName;
	}

	private String name;
	private String showName;
	public String getName() {
		return name;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}

}
