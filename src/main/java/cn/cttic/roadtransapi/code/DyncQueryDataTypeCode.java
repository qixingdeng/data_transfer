package cn.cttic.roadtransapi.code;

import java.util.EnumSet;


public enum DyncQueryDataTypeCode {
	SUCCESS(0,"0000", "成功"),
	LOGIN_MODE(1,"verify", "登录验证接口，url地址为http://10.1.88.5:8081/verify；"),
	QUERY_BICYCLE_CURINFO(2,"queryveh", "单车当前动态信息查询接口，url地址为http://10.1.88.5:8081/queryveh；"),
	QUERY_HIGHWAYROUTE_CURINFO(3,"queryvehbyline", "按高速路线查询当前车辆信息接口，url地址为http://10.1.88.5:8081/queryvehbyline"),
	QUERY_HISTORY_CURINFO(4,"queryvehlog","单车历史轨迹查询接口，url地址为http://10.1.88.5:8081/queryvehlog"),
	QUERY_STATISTICAL_CURINFO(5,"querystat","统计信息查询，trl地址为http://10.1.88.5:8081/querystat"),
	QUERY_VEHICLEAREA_CURINFO(6,"queryvehbyprovince","按车辆行驶区域省查询车辆当前信息接口，http://10.1.88.5:8081/queryvehbyprovince");
	
	
	private String code;

	public String getCode() {
		return code;
	}

	private int id;

	private String description;

	public void setDescription(String description) {
		this.description = description;
	}


	private DyncQueryDataTypeCode(int id , String code, String description) {
		this.code = code;
		this.id=id;
		this.description=description;
	}

	
	public static DyncQueryDataTypeCode getOperType(String code) {
		EnumSet<DyncQueryDataTypeCode> operTypes = EnumSet.allOf(DyncQueryDataTypeCode.class);
		for (DyncQueryDataTypeCode operType : operTypes) {
			if (operType.code.equals(code)) {
				return operType;
			}
		}
		return null ;
	}


	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

}
