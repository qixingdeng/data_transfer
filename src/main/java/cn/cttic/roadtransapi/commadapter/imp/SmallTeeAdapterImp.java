package cn.cttic.roadtransapi.commadapter.imp;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.RoadWayAdapter;
import cn.cttic.roadtransapi.commadapter.RoadWayBaseAdapter;
import cn.cttic.roadtransapi.mgr.DBMgr;

/**
 * 小三通接口适配器
 */
public class SmallTeeAdapterImp extends RoadWayBaseAdapter{

	public SmallTeeAdapterImp(){
		Init();
	}
	
	private void Init(){
		// 初始化数据库的适配器
	}

	private static Logger log = Logger.getLogger(SmallTeeAdapterImp.class);
	
	
	@Override
	public InterStatusCode ProcessAdapter(String reqcontext,StringBuffer context){
		try {			
			return  DBMgr.getInstance().ProcessBusiForSmallTee(this.key+"_"+"0",reqcontext, context);
		} catch (Exception e) {
			log.error(e,e);
			return InterStatusCode.NUKONW_ERROR;
		}
	}
	
	@Override
	public RoadWayAdapter NewRoadWayAdapter() {
		return new SmallTeeAdapterImp();
	}
	
	
}
