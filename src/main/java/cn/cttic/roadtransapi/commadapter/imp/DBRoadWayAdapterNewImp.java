package cn.cttic.roadtransapi.commadapter.imp;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.RoadWayAdapter;
import cn.cttic.roadtransapi.commadapter.RoadWayBaseAdapter;
import cn.cttic.roadtransapi.mgr.DBMgr;

public class DBRoadWayAdapterNewImp extends RoadWayBaseAdapter{

	public DBRoadWayAdapterNewImp(){
		Init();
	}
	
	private void Init(){
		// 初始化数据库的适配器
	}

	private static Logger log = Logger.getLogger(DBRoadWayAdapterNewImp.class);
	
	
	@Override
	public InterStatusCode ProcessAdapter(String reqcontext,StringBuffer context){
			try {			
				return  DBMgr.getInstance().ProcessServiceInsertOrUpdate(this.key+"_"+"0",reqcontext, context);
			} catch (Exception e) {
				log.error(e,e);
				return InterStatusCode.NUKONW_ERROR;
			}
	}
	
	@Override
	public RoadWayAdapter NewRoadWayAdapter() {
		// TODO Auto-generated method stub
		return new DBRoadWayAdapterNewImp();
	}
	
	
}
