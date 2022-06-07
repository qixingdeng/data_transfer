package cn.cttic.roadtransapi.commadapter.imp;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.RoadWayAdapter;
import cn.cttic.roadtransapi.commadapter.RoadWayBaseAdapter;
import cn.cttic.roadtransapi.common.RoadWayServiceRoot;
import cn.cttic.roadtransapi.common.XmlOper;
import cn.cttic.roadtransapi.mgr.ServiceStrategyMgr;

import com.google.common.base.Strings;

public class DBServiceRoadWayAdapterImp extends RoadWayBaseAdapter{

	public DBServiceRoadWayAdapterImp(){
		Init();
	}
	
	private void Init(){
		// 初始化数据库的适配器
	}

	private static Logger log = Logger.getLogger(DBServiceRoadWayAdapterImp.class);
	
	@Override
	protected String ProcessReqContext(String reqcontext){
		String logString;
		if(Strings.isNullOrEmpty(reqcontext)){
			logString="业务ID是:[%s],取全表数据";
			logString=String.format(logString, config.getServiceId());
			log.debug(logString);
			RoadWayServiceRoot root = new RoadWayServiceRoot();
			String newreqcontext = XmlOper.bean2Xml(root);
			return newreqcontext;
		}else{
			return reqcontext;
		}
	}
	
	@Override
	public InterStatusCode ProcessAdapter(String reqcontext,StringBuffer context){
			return  ServiceStrategyMgr.getInstance().ProcessBusi(this.key,reqcontext, context);
	}
	
	@Override
	public RoadWayAdapter NewRoadWayAdapter() {
		// TODO Auto-generated method stub
		return new DBServiceRoadWayAdapterImp();
	}
	
	
}
