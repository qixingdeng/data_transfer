package cn.cttic.roadtransapi.thread.command;

import java.util.EnumSet;


public enum TaskCommandCode {
	TASK_COMMAND(0),
	TASK_COMMAND_NOKNOW(9999);
	
	private int code;

	private TaskCommandCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static TaskCommandCode getOperType(int code) {
		EnumSet<TaskCommandCode> operTypes = EnumSet.allOf(TaskCommandCode.class);
		for (TaskCommandCode operType : operTypes) {
			if (operType.code==code) {
				return operType;
			}
		}
		return null ;
	}
	
}