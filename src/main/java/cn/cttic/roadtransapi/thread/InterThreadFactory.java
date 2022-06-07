package cn.cttic.roadtransapi.thread;

import java.util.concurrent.ThreadFactory;

public class InterThreadFactory  implements ThreadFactory{

	 private final String poolName; 
	 
	@Override
	public Thread newThread(Runnable r) {
		return new InterThread(r, poolName);  
	}
	
	 public InterThreadFactory(String poolName) {  
	        this.poolName = poolName;  
	    }

	public String getPoolName() {
		return poolName;
	}  

}
