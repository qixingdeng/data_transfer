package cn.cttic.roadtransapi.commadapter.imp;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.RoadWayAdapter;
import cn.cttic.roadtransapi.commadapter.RoadWayBaseAdapter;
import cn.cttic.roadtransapi.constants.RoadWayConstants;
import cn.cttic.roadtransapi.domain.InterSwapPlatformConfigWithBLOBs;
import cn.cttic.roadtransapi.mgr.DBMgr;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

public class RoadWayAdapterImp extends RoadWayBaseAdapter{

	public RoadWayAdapterImp(){
		Init();
	}
	
	private static Logger log = Logger.getLogger(RoadWayAdapterImp.class);
	
	private void Init(){
		// 初始化数据库的适配器
		DBRoadWayAdapterImp dbadapterAdapterImp = new DBRoadWayAdapterImp();
		
		// 初始化url适配器
		HttpRoadWayAdapterImp httpRoadWayAdapterImp = new HttpRoadWayAdapterImp();
		
		SoapRoadWayAdapterImp soapRoadWayAdapterImp = new SoapRoadWayAdapterImp();
		
		ModifyDBRoadWayAdapterImp  modifyDBRoadWayAdapterImp = new ModifyDBRoadWayAdapterImp();
		
		DBRoadWayAdapterNewImp insertOrUpdateDBRoadWayAdapterImp = new DBRoadWayAdapterNewImp();
		
		UserInfoAdapterImp  userInfoAdapterImp = new UserInfoAdapterImp();
		
		SmallTeeAdapterImp smallTeeAdapterImp = new SmallTeeAdapterImp() ;
		
		HignWayJsonDBRoadWayAdapterImp hignWayJsonDBRoadWayAdapterImp = new HignWayJsonDBRoadWayAdapterImp();
		
		JsonDBRoadWayAdapterImp jsonDBRoadWayAdapterImp = new JsonDBRoadWayAdapterImp();
		
		RedisRoadWayAdapterImp redisRoadWayAdapterImp = new RedisRoadWayAdapterImp();
		
		ProcessChoseAdapterImp processChoseAdapterImp = new ProcessChoseAdapterImp();
		
		DBServiceRoadWayAdapterImp dbServiceRoadWayAdapterImp = new DBServiceRoadWayAdapterImp();
		
		BatchRedisRoadWayAdapterImp batchRedisRoadWayAdapterImp = new BatchRedisRoadWayAdapterImp();
		
		List<InterSwapPlatformConfigWithBLOBs> list = DBMgr.getInstance().getConfiglist();
		for(InterSwapPlatformConfigWithBLOBs config : list){
			String key = config.getSystemId()+config.getServiceId();
			String adaptertypeString = config.getAdapterType();
			if(Strings.isNullOrEmpty(adaptertypeString)){
				map.put(key, dbadapterAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB, dbadapterAdapterImp);
			}else if (RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB.equals(adaptertypeString)){
				map.put(key, dbadapterAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB, dbadapterAdapterImp);
			}else if (RoadWayConstants.Adapter_Type.ADAPTER_TYPE_HTTP_SOAP.equals(adaptertypeString)){
				map.put(key, soapRoadWayAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_HTTP_SOAP, soapRoadWayAdapterImp);
			}else if (RoadWayConstants.Adapter_Type.ADAPTER_TYPE_HTTP_XML.equals(adaptertypeString)){
				map.put(key, httpRoadWayAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_HTTP_XML, httpRoadWayAdapterImp);
			}else if (RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_MODIFY.equals(adaptertypeString)){
				map.put(key, modifyDBRoadWayAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_MODIFY, modifyDBRoadWayAdapterImp);
			}else if (RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_INSERT_OR_UPDATE.equals(adaptertypeString)){
				map.put(key, insertOrUpdateDBRoadWayAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_INSERT_OR_UPDATE, insertOrUpdateDBRoadWayAdapterImp);
			}else if (RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_SMALL_TEE.equals(adaptertypeString)){
				map.put(key, smallTeeAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_SMALL_TEE, smallTeeAdapterImp);
			}else if (RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_USERINFO.equals(adaptertypeString)){
				map.put(key, userInfoAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_USERINFO, userInfoAdapterImp);
			}else if (RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_JSON.equals(adaptertypeString)){
				map.put(key, jsonDBRoadWayAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_JSON, jsonDBRoadWayAdapterImp);
			}else if (RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_JSON_HIGN.equals(adaptertypeString)){
				map.put(key, hignWayJsonDBRoadWayAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_JSON_HIGN, hignWayJsonDBRoadWayAdapterImp);
			}else if (RoadWayConstants.Adapter_Type.ADAPTER_TYPE_CACHE_REDIS.equals(adaptertypeString)){
				map.put(key, redisRoadWayAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_CACHE_REDIS, redisRoadWayAdapterImp);
			}else if (RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_CHOOSE.equals(adaptertypeString)){
				map.put(key, processChoseAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_CHOOSE, processChoseAdapterImp);
			}else if (RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_SERVICE.equals(adaptertypeString)){
				map.put(key, dbServiceRoadWayAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB_SERVICE, dbServiceRoadWayAdapterImp);
			}else if (RoadWayConstants.Adapter_Type.ADAPTER_TYPE_JSON_BATCH.equals(adaptertypeString)){
				map.put(key, batchRedisRoadWayAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_JSON_BATCH, batchRedisRoadWayAdapterImp);
			}else{
				map.put(key, dbadapterAdapterImp);
				adaptertypeMap.put(RoadWayConstants.Adapter_Type.ADAPTER_TYPE_DB, dbadapterAdapterImp);
			}
			
			
		}
	}
	
	private Map<String,RoadWayAdapter> map = Maps.newHashMap();

	private Map<String, RoadWayAdapter> adaptertypeMap=Maps.newHashMap();
	
	@Override
	public InterStatusCode ProcessBusi(String key, String reqcontext,StringBuffer context) {
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		RoadWayAdapter adapter = map.get(key);
		if(adapter!=null){
			ret = adapter.NewRoadWayAdapter().ProcessBusi(key,reqcontext, context);
		}else{
			adapter = adaptertypeMap.get(key);
			if(adapter!=null){
				ret = adapter.NewRoadWayAdapter().ProcessBusi(key,reqcontext, context);
			}else {
				ret=InterStatusCode.GET_ADAPTER_ERROR;
				ret.setTempString(String.format(ret.getDescription(), key));
				log.debug(ret.getTempString());
			}
			
		}
		return ret;
	}
	
	
}
