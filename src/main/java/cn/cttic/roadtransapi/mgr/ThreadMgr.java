package cn.cttic.roadtransapi.mgr;

import cn.cttic.roadtransapi.thread.InterRunnable;
import cn.cttic.roadtransapi.thread.InterThreadPool;
import cn.cttic.roadtransapi.thread.command.TaskCommandBase;
import cn.cttic.roadtransapi.thread.command.TaskCommandCode;
import cn.cttic.roadtransapi.thread.command.TaskCommandFactory;



public class ThreadMgr{
	
	private ThreadMgr(){
		
	}
	
	private static ThreadMgr uniqueInstance = null;
	
	public static ThreadMgr getInstance() {
	    if (uniqueInstance == null) {
	           uniqueInstance = new ThreadMgr();
	       }
	       return uniqueInstance;   
	}
	  
	
	
	public int ProcessBusi(TaskCommandCode code,Object source, Object resouce){
		int ret = -1 ;
		TaskCommandBase  command = TaskCommandFactory.getCommandInstance(code);
		if(command!= null){
			command.setSource(source);
			command.setResource(resouce);
			interThreadPool.Execute(new InterRunnable(command));
			ret = 0;		
		}
		return ret ;
	}

	public int ProcessBusi(TaskCommandBase  command){
		int ret = -1 ;
		
		if(command!= null){
			interThreadPool.Execute(new InterRunnable(command));
			ret = 0;		
		}
		return ret ;
	}
	
	private InterThreadPool interThreadPool = new InterThreadPool();
}
