package cn.cttic.roadtransapi.commadapter.imp;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.RoadWayAdapter;
import cn.cttic.roadtransapi.common.JsonBinder;
import cn.cttic.roadtransapi.mgr.ObjectMapperMgr;
import cn.cttic.roadtransapi.ws_rest.Batchgnss;
import cn.cttic.roadtransapi.ws_rest.BatchgnssList;
import cn.cttic.roadtransapi.ws_rest.Gnss;
import cn.cttic.roadtransapi.ws_rest.GnssList;

import com.google.common.base.Strings;

public class BatchRedisRoadWayAdapterImp extends RedisRoadWayAdapterImp{

	public BatchRedisRoadWayAdapterImp(){
		Init();
	}
	
	private void Init(){
		// 初始化数据库的适配器
	}

	private static Logger log = Logger.getLogger(BatchRedisRoadWayAdapterImp.class);
	
	private JsonBinder json = JsonBinder.buildNormalBinder();
	@Override
	public InterStatusCode ProcessRespAdapter(String reqcontext,StringBuffer context){
		InterStatusCode ret = InterStatusCode.SUCCESS;
		String xmcontext = context.toString();
		if(!Strings.isNullOrEmpty(context.toString())){
			GnssList gnsslist  = json.fromJson(xmcontext, GnssList.class);
			if(gnsslist!=null){
				log.debug(String.format("gnss的数据是[%d]", gnsslist.getGatherGnsses().size()));
				
				BatchgnssList list = new BatchgnssList();
				list.setCode(gnsslist.getCode());
				for (Gnss gnss : gnsslist.getGatherGnsses()) {
					
					Batchgnss batchgnss = new Batchgnss();
					batchgnss.setContext(gnss.getGatherGnsse().toString());
					
					list.getBatchgnssList().add(batchgnss);
				}
				
				String batchcontext = null;
				try {
					 batchcontext  = ObjectMapperMgr.getInstance().fromBeanToJson(list);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				
				context.delete(0, context.length());
				if(!Strings.isNullOrEmpty(batchcontext)){
					context.append(batchcontext);
				}else {
					ret = InterStatusCode.REST_REDIS_BATCH_TEXT_ERROR;
				}
			}
		}
		
		return ret;
	} 
	
	@Override
	public RoadWayAdapter NewRoadWayAdapter() {
		// TODO Auto-generated method stub
		return new BatchRedisRoadWayAdapterImp();
	}
	
	
}
