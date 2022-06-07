package cn.cttic.roadtransapi.commadapter;

import cn.cttic.roadtransapi.code.InterStatusCode;

public interface RoadWayAdapter {
	public InterStatusCode ProcessBusi(String key,String reqcontext,StringBuffer context);
	public RoadWayAdapter  NewRoadWayAdapter();
}
