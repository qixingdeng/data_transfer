package cn.cttic.roadtransapi.commadapter.imp;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.RoadWayAdapter;
import cn.cttic.roadtransapi.common.RoadWayServiceRoot;
import cn.cttic.roadtransapi.common.XmlOper;
import cn.cttic.roadtransapi.common.smParamNode;

import com.google.common.base.Strings;

public class HignWayJsonDBRoadWayAdapterImp extends DBRoadWayAdapterImp{

	public HignWayJsonDBRoadWayAdapterImp(){
		Init();
	}
	
	private void Init(){
		// 初始化数据库的适配器
	}

	private static Logger log = Logger.getLogger(HignWayJsonDBRoadWayAdapterImp.class);
	
	@Override
	public RoadWayAdapter NewRoadWayAdapter() {
		// TODO Auto-generated method stub
		return new HignWayJsonDBRoadWayAdapterImp();
	}
	
	@Override
	public InterStatusCode ProcessRespAdapter(String reqcontext ,StringBuffer context){
		InterStatusCode ret = InterStatusCode.SUCCESS;
		String xmlcontext = context.toString();
		if(!Strings.isNullOrEmpty(context.toString())){
			RoadWayServiceRoot root = (RoadWayServiceRoot) XmlOper.xml2Bean(RoadWayServiceRoot.class, xmlcontext);
			if(root!=null){
				JSONObject retObject = new JSONObject();
				retObject.put("code", "0");
				JSONObject temp = null;
				if(root.getSmParamNode().getSmParamNode().size() > 0){
					JSONArray array = new JSONArray();
					for (smParamNode node : root.getSmParamNode().getSmParamNode()) {
						temp = new JSONObject();
						for (smParamNode value : node.getSmParamNode()) {
							temp.put(value.getKey(), value.getValue());
						}
						
					}
					
					retObject.put("data", array);
				}
				
				context.delete(0, context.length());
				context.append(retObject.toString());
			}else {
				ret = InterStatusCode.REST_XML_TO_JSON_CODE;
			}
		}else{
			ret = InterStatusCode.REST_XML_TO_JSON_CODE;
		}
		
		return ret;
	}
	
	
}
