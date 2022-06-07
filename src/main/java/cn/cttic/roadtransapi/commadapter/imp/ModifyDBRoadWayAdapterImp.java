package cn.cttic.roadtransapi.commadapter.imp;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.RoadWayAdapter;
import cn.cttic.roadtransapi.commadapter.RoadWayBaseAdapter;
import cn.cttic.roadtransapi.mgr.DBMgr;

public class ModifyDBRoadWayAdapterImp extends RoadWayBaseAdapter{

	public ModifyDBRoadWayAdapterImp(){
		Init();
	}
	
	private void Init(){
		// 初始化数据库的适配器
	}

	private static Logger log = Logger.getLogger(ModifyDBRoadWayAdapterImp.class);
	
	
	@Override
	public InterStatusCode ProcessAdapter(String reqcontext,StringBuffer context){
			return  DBMgr.getInstance().ProcessBusiForModify(this.key+"_"+"0",reqcontext, context);
	}
	
	@Override
	public RoadWayAdapter NewRoadWayAdapter() {
		// TODO Auto-generated method stub
		return new ModifyDBRoadWayAdapterImp();
	}
	
	
}
