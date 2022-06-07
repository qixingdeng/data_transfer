package cn.cttic.roadtransapi.mgr;



import cn.cttic.roadtransapi.common.JsonBinder;

/**
 * 
 * 提供单例模式调用工单<br>
 * 
 * @author guoshouzhong@cttic.cn
 * @date 2014年12月3日 上午11:49:50 <br>
 *       Copyright: Copyright (c) 2014 CTTIC
 */
public class ObjectMapperMgr {

	// 声明一个ObjectMapperMgr类的引用
	private static ObjectMapperMgr instance = null;

	private static JsonBinder binder = null;

	private ObjectMapperMgr() {

	}

	public static synchronized ObjectMapperMgr getInstance() {
		if (instance == null) {
			instance = new ObjectMapperMgr();
		}
		return instance;
	}

	

	public String fromBeanToJson(Object object) throws Exception {
		binder = JsonBinder.buildNonDefaultBinder();
		return binder.toJson(object);
	}

	
	public <T> T fromJsonToObject(String reqJson, Class<T> clazz) {
		binder = JsonBinder.buildNonDefaultBinder();
		return binder.fromJson(reqJson, clazz);
	}

}
