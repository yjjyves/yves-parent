package com.yves.model.common.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 岗位类型
 * @author yinyuqiao
 * @since 2013-5-13-下午02:20:38
 */
public enum PositionTypeEnum {
	OWNER("业主",0),
	SALESMAN("经纪人",1),
	SECRETARY("店长助理",2),
	SECRETDIRECT("店秘",3),
	STOREMANAGER("店长",4),
	DIRECTOR("片区董事",5), 
	VICEPRISIDENT("董事副总经理",6),
	GENERALMANAGER("城市总经理",7);

	private PositionTypeEnum(String name, int value) {
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List toList(){
		PositionTypeEnum[] ary = PositionTypeEnum.values();
		List bizType = new ArrayList();
		for(int i=0;i<ary.length;i++){
			Map<String,String> map = new HashMap<String,String>();
			map.put("value", ary[i].toString());
			map.put("name", ary[i].getName());
			bizType.add(map);
		}
		return bizType;
	}
	public static List<PositionTypeEnum> toEnumList(){
		PositionTypeEnum[] ary = PositionTypeEnum.values();
		List<PositionTypeEnum> enumList = new ArrayList<PositionTypeEnum>();
		for(int i=0;i<ary.length;i++){
			enumList.add(ary[i]);
		}
		return enumList;
	}
	public static PositionTypeEnum getEnumByName(String name) {
		PositionTypeEnum[] enums = PositionTypeEnum.values();
		for (PositionTypeEnum tempEnum : enums) {
			if (tempEnum.getName().equals(name)) {
				return tempEnum;
			}
		}
		return null;
	}
	
	public static PositionTypeEnum valuesOf(String value) {
		
		return null;
	}

	public static PositionTypeEnum getPositionTypeByValue(int value){
		PositionTypeEnum[] values = PositionTypeEnum.values();
		for(PositionTypeEnum e : values){
			if(value == e.getValue())
				return e;
		}
		return null;
	}
	
	public String getDesc() {
		return name;
	}
	
}
