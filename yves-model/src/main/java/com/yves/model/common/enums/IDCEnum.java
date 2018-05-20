package com.yves.model.common.enums;

public enum IDCEnum {
	
	HD("华东","HUADONG"),
	HB("华北","HUABEI"),
	HN("华南","HUANAN");
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private String desc;
	private String pinyin;

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	private IDCEnum(String desc){
		this.desc = desc;
	}
	
	private IDCEnum(String desc, String pinyin){
		this.desc = desc;
		this.pinyin = pinyin;
	}
}
