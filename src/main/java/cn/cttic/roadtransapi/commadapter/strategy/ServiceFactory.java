package cn.cttic.roadtransapi.commadapter.strategy;

import cn.cttic.roadtransapi.commadapter.strategy.imp.A0104ServiceImpl;

public class ServiceFactory {
	public static ServiceStrategy Create(String key){
		ServiceStrategy strategy = null;
		if("1001QA0104".equals(key)){
			strategy = new A0104ServiceImpl();
		}else{
			strategy = null ;
		}
		return strategy ;
	}
}
