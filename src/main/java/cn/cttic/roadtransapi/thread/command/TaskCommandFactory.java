package cn.cttic.roadtransapi.thread.command;


public class TaskCommandFactory {

	public static TaskCommandBase getCommandInstance(TaskCommandCode type) {
		TaskCommandBase c = null;

		switch (type) {
			case TASK_COMMAND:
				break;
			
			default:
				break;
		}

		return c;
	}
}
