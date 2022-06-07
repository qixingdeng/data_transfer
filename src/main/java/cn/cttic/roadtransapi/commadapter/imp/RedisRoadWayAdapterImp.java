package cn.cttic.roadtransapi.commadapter.imp;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.RoadWayAdapter;
import cn.cttic.roadtransapi.commadapter.RoadWayBaseAdapter;
import cn.cttic.roadtransapi.mgr.DBMgr;
import cn.cttic.roadtransapi.mgr.RedisMgr;

import com.google.common.base.Strings;

public class RedisRoadWayAdapterImp extends RoadWayBaseAdapter{

	public RedisRoadWayAdapterImp(){
		Init();
	}
	
	private void Init(){
		// 初始化数据库的适配器
	}

	private static Logger log = Logger.getLogger(RedisRoadWayAdapterImp.class);
	
	
	@Override
	public InterStatusCode ProcessAdapter(String reqcontext,StringBuffer context){
		InterStatusCode code = InterStatusCode.SUCCESS;
		if(!RedisMgr.getInstance().isConnSign()){
			code = InterStatusCode.REST_REDIS_CLIENT_ERROR;
			code.setTempString(String.format(code.getDescription(), DBMgr.getInstance().getCache_ip(),DBMgr.getInstance().getCache_port()));
			log.debug(code.getTempString());
		}else {
			if(!Strings.isNullOrEmpty(reqcontext)){
				log.debug(String.format("请求的key:[%s]", reqcontext));
				try{
					if(!Strings.isNullOrEmpty(reqcontext)){
						String source = RedisMgr.getInstance().GetCurMap(reqcontext);
						if(Strings.isNullOrEmpty(source)){
							context.append("");
							code = InterStatusCode.REST_REQ_CONTEXT_ERROR;
						}else {
							context.append(source);
							code = InterStatusCode.SUCCESS;
						}
					}
				}catch(Exception e){
					e.printStackTrace();
					context.delete(0,context.length());
					code = InterStatusCode.REST_REDIS_NULL;
					log.debug(e.getMessage());
					log.debug(code.getDescription());
				}
				
			}else {
				code = InterStatusCode.REST_REDIS_NULL;
				log.debug(code.getDescription());
			}
			
		}
			
		return  code;
	}
	
	@Override
	public RoadWayAdapter NewRoadWayAdapter() {
		// TODO Auto-generated method stub
		return new RedisRoadWayAdapterImp();
	}
	
	
}
