package cn.cttic.roadtransapi.commadapter.imp;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.RoadWayAdapter;
import cn.cttic.roadtransapi.commadapter.RoadWayBaseAdapter;
import cn.cttic.roadtransapi.mgr.DBMgr;

public class ProcessChoseAdapterImp extends RoadWayBaseAdapter{

	public ProcessChoseAdapterImp(){

	}
	
	private static Logger log = Logger.getLogger(ProcessChoseAdapterImp.class);
	
	
	@Override
	public InterStatusCode ProcessAdapter(String reqcontext,StringBuffer context){
			return  DBMgr.getInstance().ProcessBusiForChose(this.key+"_"+"0",reqcontext, context);
	}
	
	
	
	@Override
	public RoadWayAdapter NewRoadWayAdapter() {
		// TODO Auto-generated method stub
		return new ProcessChoseAdapterImp();
	}
	
	
}
