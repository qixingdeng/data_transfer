package cn.cttic.roadtransapi.mgr;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.strategy.ServiceFactory;
import cn.cttic.roadtransapi.commadapter.strategy.ServiceStrategy;


public class ServiceStrategyMgr  {
	
	private ServiceStrategyMgr(){
	
	}
	
	private static ServiceStrategyMgr uniqueInstance = null;
	
	public static ServiceStrategyMgr getInstance() {
	    if (uniqueInstance == null) {
	           uniqueInstance = new ServiceStrategyMgr();
	       }
	       return uniqueInstance;   
	}
	  
	public InterStatusCode ProcessBusi(String key , String reqcontext ,StringBuffer context){
		InterStatusCode code = InterStatusCode.SUCCESS ; 
		ServiceStrategy strategy = ServiceFactory.Create(key);
		
		if(strategy!=null){
			code = strategy.ProcessBusi(key,reqcontext, context);
		}else{
			code = InterStatusCode.SERVICE_INSERTMETHOD_ERROR;
		}
		
		return code ; 
		
	}
		
	
}
