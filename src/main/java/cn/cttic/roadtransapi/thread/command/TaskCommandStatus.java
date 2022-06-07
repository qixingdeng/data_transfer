package cn.cttic.roadtransapi.thread.command;

import java.util.EnumSet;



public enum TaskCommandStatus {
	INIT(0),RUNING(1);
	
	private int code;

	private TaskCommandStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static TaskCommandStatus getOperType(int code) {
		EnumSet<TaskCommandStatus> operTypes = EnumSet.allOf(TaskCommandStatus.class);
		for (TaskCommandStatus operType : operTypes) {
			if (operType.code==code) {
				return operType;
			}
		}
		return null ;
	}
	
}