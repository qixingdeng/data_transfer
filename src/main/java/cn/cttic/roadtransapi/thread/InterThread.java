package cn.cttic.roadtransapi.thread;


public class InterThread  extends Thread {
	public InterThread(Runnable r,String poolname){
		super(r) ;
		poolName=poolname;
	}
	
	public String getPoolName() {
		return poolName;
	}

	private  String poolName; 
}
