package cn.cttic.roadtransapi.constants;

import java.util.EnumSet;

public enum DB_EXAMPLE_OPER_TYPE{
	
	andIsNull(0,"and%sIsNull", "andIsNull"),
	andEqualTo(1,"and%sEqualTo", "andEqualTo"),
	andNotEqualTo(2,"and%sNotEqualTo", "andNotEqualTo"),
	andGreaterThan(3,"and%sGreaterThan", "andGreaterThan"),
	andGreaterThanOrEqualTo(4,"and%sGreaterThanOrEqualTo","andGreaterThanOrEqualTo"),
	andLessThan(5,"and%sLessThan","andLessThan"),
	andLessThanOrEqualTo(6,"and%sLessThanOrEqualTo","andLessThanOrEqualTo"),
	andLike(7,"and%sLike","andLike"),
	andNotLike(8,"and%sNotLike","andNotLike"),
	andIn(9,"and%sIn","andIn"),
	andNotIn(10,"and%sNotIn","andNotIn"),
	andBetween(11,"and%sBetween","andBetween"),
	andNotBetween(12,"and%sNotBetween","andNotBetween");
	
	public String getCode() {
		return code;
	}

	private int id;

	private String description;

	private  String code;
	
	private DB_EXAMPLE_OPER_TYPE(int id , String code, String description) {
		this.code = code;
		this.id=id;
		this.description=description;
	}

	public static DB_EXAMPLE_OPER_TYPE getOperType(String code) {
		EnumSet<DB_EXAMPLE_OPER_TYPE> operTypes = EnumSet.allOf(DB_EXAMPLE_OPER_TYPE.class);
		for (DB_EXAMPLE_OPER_TYPE operType : operTypes) {
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
