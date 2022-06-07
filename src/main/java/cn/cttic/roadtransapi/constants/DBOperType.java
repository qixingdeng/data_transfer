package cn.cttic.roadtransapi.constants;

import java.util.EnumSet;

public enum DBOperType{
	
	DB_DONE(0,"0000", "NULL"),
	DB_INSERT(1,"0001", "插入"),
	DB_UPDATE(2,"0002", "修改"),
	DB_DELETE(3,"0003", "删除"),
	DB_SELECT(4,"0004","查询"),
	DB_INSERT_LOG(5,"0005","查询");
	
	public String getCode() {
		return code;
	}

	private int id;

	private String description;

	private  String code;
	
	private DBOperType(int id , String code, String description) {
		this.code = code;
		this.id=id;
		this.description=description;
	}

	public static DBOperType getOperType(String code) {
		EnumSet<DBOperType> operTypes = EnumSet.allOf(DBOperType.class);
		for (DBOperType operType : operTypes) {
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