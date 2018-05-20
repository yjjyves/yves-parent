package com.yves.model.common.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 城市列表
 *
 * @author Hou Peiqin
 *
 */
public enum CityEnum {

	SHANGHAI("上海","SHANGHAI", "021","SHANGHAI",IDCEnum.HD, "SH"),
	BEIJING("北京","BEIJING","010","BEIJING",IDCEnum.HB, "BJ"),
	SHENZHEN("深圳", "SHENZHEN","0755","SHENZHEN",IDCEnum.HN, "SZ"),
	ZHUHAI("珠海", "ZHUHAI", "0756","ZH",IDCEnum.HN,"ZH");


	CityEnum(String alias, String value, String simplePin,
             String areaCode, IDCEnum idc, String uniqueSimplePin) {
		this.alias = alias;
		this.value = value;
		this.simplePin = simplePin;
		this.areaCode=areaCode;
		this.idc = idc;
		this.uniqueSimplePin = uniqueSimplePin;
	}
	private String alias;
	private String value;
	private String simplePin;
	private String areaCode;//区号
	private IDCEnum idc;
	private String  uniqueSimplePin;//简拼 唯一

	public String getUniqueSimplePin() {
		return uniqueSimplePin;
	}

	public void setUniqueSimplePin(String uniqueSimplePin) {
		this.uniqueSimplePin = uniqueSimplePin;
	}

	public IDCEnum getIdc() {
		return idc;
	}

	public void setIdc(IDCEnum idc) {
		this.idc = idc;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSimplePin() {
		return simplePin;
	}

	public void setSimplePin(String simplePin) {
		this.simplePin = simplePin;
	}

	public static CityEnum getEnumByName(String name){

		for(CityEnum cityEnum:CityEnum.values()){
			if(cityEnum.getAlias().equals(name)){
				return cityEnum;
			}
		}
		return null;
	}


}
