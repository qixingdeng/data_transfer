package cn.cttic.roadtransapi.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterThreadPool {
	public  InterThreadPool(){
		Init();
	}
	
	private  void Init(){
		executorService =  Executors.newCachedThreadPool( new InterThreadFactory(InterThreadPool.class.getSimpleName()));
		
	}
	
	private ExecutorService executorService ;
	
	public void Execute(InterRunnable command){
		executorService.execute( command);
	}
}
