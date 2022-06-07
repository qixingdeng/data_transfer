package cn.cttic.roadtransapi.timertask;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.mgr.MapInfoMgr;


public class TimerTask {
	private Object lockForBaseInfo = new Object();
	
	private static Logger logger = Logger.getLogger(TimerTask.class);
	
	public TimerTask(){
		
	}
	
	public void runBusi(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		runLoadBaseInfo();
	}
	
	private static boolean runLoadBaseInfoSign = true;
	
	private void runLoadBaseInfo(){
		if(runLoadBaseInfoSign){
			try {
				runLoadBaseInfoSign = false;
				synchronized (lockForBaseInfo) {
					logger.debug(String.format("come in runLoadBaseInfo"));
					MapInfoMgr.getInstance();
					logger.debug(String.format("come out runLoadBaseInfo"));
				}
				runLoadBaseInfoSign = true;
			} catch (Exception e) {
				e.printStackTrace();
				runLoadBaseInfoSign = false ;
			}
			
		}
		
	}
	
	
	
	
	
}