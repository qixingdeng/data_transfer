package cn.cttic.roadtransapi.thread;

import cn.cttic.roadtransapi.thread.command.TaskCommandBase;





public class InterRunnable implements Runnable {
	public InterRunnable(TaskCommandBase  command ) {
		taskcommand=command;
	}
	
	@Override
	public void run() {
		if(taskcommand!=null){
			taskcommand.Execute();
		}
		
	}
	
	private TaskCommandBase taskcommand;

}
