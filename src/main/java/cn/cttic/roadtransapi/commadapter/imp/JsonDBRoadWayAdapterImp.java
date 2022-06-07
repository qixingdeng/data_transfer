package cn.cttic.roadtransapi.commadapter.imp;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.RoadWayAdapter;
import cn.cttic.roadtransapi.mgr.ObjectMapperMgr;
import cn.cttic.roadtransapi.mgr.ShmMgr;

import com.google.common.base.Strings;

public class JsonDBRoadWayAdapterImp extends DBRoadWayAdapterImp{

	public JsonDBRoadWayAdapterImp(){
		Init();
	}
	
	private void Init(){
		// 初始化数据库的适配器
	}

	private static Logger log = Logger.getLogger(JsonDBRoadWayAdapterImp.class);
	
	@Override
	public RoadWayAdapter NewRoadWayAdapter() {
		// TODO Auto-generated method stub
		return new JsonDBRoadWayAdapterImp();
	}
	
	@Override
	public InterStatusCode ProcessRespAdapter(String reqcontext ,StringBuffer context){
		InterStatusCode ret = InterStatusCode.SUCCESS;
		String xmlcontext = context.toString();
		if(!Strings.isNullOrEmpty(context.toString())){
			Object object = ShmMgr.getInstance().GetXmlObj(xmlcontext);
			if(object!=null){
				String jsonxml="";
				try {
					jsonxml = ObjectMapperMgr.getInstance().fromBeanToJson(object);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(Strings.isNullOrEmpty(jsonxml)){
					ret = InterStatusCode.REST_RSP_CONTEXT_ERROR;
				}else {
					context.delete(0, context.length());
					context.append(jsonxml);
				}
				
			
			}else {
				ret = InterStatusCode.REST_XML_TO_JSON_CODE;
			}
			
		}else{
			ret = InterStatusCode.REST_XML_TO_JSON_CODE;
		}
		
		return ret;
	}
	
	
}
