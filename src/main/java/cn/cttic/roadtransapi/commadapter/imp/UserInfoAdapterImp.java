package cn.cttic.roadtransapi.commadapter.imp;

import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.RoadWayAdapter;
import cn.cttic.roadtransapi.commadapter.RoadWayBaseAdapter;
import cn.cttic.roadtransapi.common.XmlOper;
import cn.cttic.roadtransapi.common.smParamNode;
import cn.cttic.roadtransapi.mgr.DBMgr;
import cn.cttic.roadtransapi.mgr.ShmMgr;
import cn.cttic.roadtransapi.mgr.ShmMgr.CheckDetail;

import com.google.common.base.Strings;

public class UserInfoAdapterImp extends RoadWayBaseAdapter{

	public UserInfoAdapterImp(){

	}
	
	private static Logger log = Logger.getLogger(UserInfoAdapterImp.class);
	
	
	@Override
	public InterStatusCode ProcessAdapter(String reqcontext,StringBuffer context){
			return  DBMgr.getInstance().ProcessBusi(this.key+"_"+"0",reqcontext, context);
	}
	
	@Override
	public InterStatusCode ProcessRespAdapter(String reqcontext ,StringBuffer context){
		InterStatusCode ret = InterStatusCode.SUCCESS;
		String tempString ;
		tempString = String.format("進行處理中");
		log.debug(tempString);
		
		Map<String, String> map = XmlOper.GetRestValue(context.toString(),",");
		String serviceName = map.get("serviceName");
		String servicePword = map.get("servicePword");
		String systemDesc = map.get("systemDesc");
		
		
		String requser="";
		String reqpasswd="";
		
		smParamNode resObject = (smParamNode) ShmMgr.getInstance().GetXmlObj(reqcontext);
		if(resObject!=null){
			for (smParamNode sNode : resObject.getSmParamNode()) {
				if(sNode.getKey().equals("user")){
					requser = sNode.getValue();
				} else if (sNode.getKey().equals("password")){
					reqpasswd = sNode.getValue();
				}else {
					
				}
			}
		}
		
		if(!Strings.isNullOrEmpty(systemDesc)){
			log.debug(String.format("處理:[%s]", systemDesc));
		}
		
		if(Strings.isNullOrEmpty(requser)||Strings.isNullOrEmpty(reqpasswd)){
			ret = InterStatusCode.REST_GET_USERINFO_NULL;
			return ret ;
		}
		
		if(Strings.isNullOrEmpty(serviceName)){
			ret = InterStatusCode.REST_GET_USERINFO_DB_NULL; 
			return ret ;
		}
		
		if(reqpasswd.equals(servicePword)){
			// 生成隨機碼
			CheckDetail detail = ShmMgr.getInstance().CreateCheckDetail(requser);
			ShmMgr.getInstance().AddCheckDetail(detail);
			String respString = GetReturnValue(detail);
			context.delete(0,context.length());
			context.append(respString);
		}else{
			ret = InterStatusCode.REST_GET_USERINFO_DB_NULL; 
		}
		
		return ret;
	} 
	
	private String GetReturnValue(CheckDetail detail){
		JSONObject retObject = new JSONObject();
		retObject.put("code", "0");
		JSONArray array = new JSONArray();
		JSONObject temp=null;
		temp = new JSONObject();
		temp.put("remark", "success");
		temp.put("verifycode", detail.getVerifycode());
		array.add(temp);
		retObject.put("data", array);
		return retObject.toString();
	}
	
	@Override
	public RoadWayAdapter NewRoadWayAdapter() {
		// TODO Auto-generated method stub
		return new UserInfoAdapterImp();
	}
	
	
}
