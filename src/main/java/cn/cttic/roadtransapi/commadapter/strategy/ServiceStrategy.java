package cn.cttic.roadtransapi.commadapter.strategy;

import cn.cttic.roadtransapi.code.InterStatusCode;

public interface ServiceStrategy {
	public InterStatusCode ProcessBusi(String key,String reqcontext,StringBuffer context);
	public String GetName();
	public String GetErrorMsg();
}
