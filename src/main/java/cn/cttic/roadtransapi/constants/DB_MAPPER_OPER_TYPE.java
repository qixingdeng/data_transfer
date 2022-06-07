package cn.cttic.roadtransapi.constants;

import java.util.EnumSet;

public enum DB_MAPPER_OPER_TYPE{
	
	countByExample(0,"countByExample", "example"),
	deleteByExample(1,"deleteByExample", "example"),
	insert(2,"insert", "record"),
	insertSelective(3,"insertSelective", "record"),
	selectByExample(4,"selectByExample","example"),
	updateByExampleSelective(5,"updateByExampleSelective","example"),
	updateByExample(6,"updateByExample","example"),
	selectByExampleForPage(7,"selectByExample","example"),
	selectByExampleWithBLOBs(8,"selectByExampleWithBLOBs","example"),
	updateByExampleWithBLOBs(9,"updateByExampleWithBLOBs","example"),
	countByExampleByname(10,"countByExampleByname","example"),
	createTableByname(11,"createTableByname","example"),
	insertSelectiveByname(12,"insertSelectiveByname","example");
	
	public String getCode() {
		return code;
	}

	private int id;

	private String description;

	private  String code;
	
	private DB_MAPPER_OPER_TYPE(int id , String code, String description) {
		this.code = code;
		this.id=id;
		this.description=description;
	}

	public static DB_MAPPER_OPER_TYPE getOperType(String code) {
		EnumSet<DB_MAPPER_OPER_TYPE> operTypes = EnumSet.allOf(DB_MAPPER_OPER_TYPE.class);
		for (DB_MAPPER_OPER_TYPE operType : operTypes) {
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

