package cn.cttic.roadtransapi.commadapter.imp;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.RoadWayAdapter;
import cn.cttic.roadtransapi.commadapter.RoadWayBaseAdapter;
import cn.cttic.roadtransapi.common.HttpSender;

import com.google.common.base.Strings;



public class HttpRoadWayAdapterImp  extends RoadWayBaseAdapter{

	public HttpRoadWayAdapterImp(){
		Init();
	}
	
	private static Logger log = Logger.getLogger(HttpRoadWayAdapterImp.class);
	
	private void Init(){
		
	}

	@Override
	public InterStatusCode ProcessAdapter(String reqcontext,StringBuffer context){
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		String logString;
		if(Strings.isNullOrEmpty(reqcontext)){
			ret=InterStatusCode.GET_REQ_HTTP_ERROR;
			ret.setTempString(String.format(ret.getDescription(), key));
			log.debug(ret.getTempString());
		}else{
			String requestURL = config.getServiceUrl();
			if(Strings.isNullOrEmpty(requestURL)){
				ret=InterStatusCode.GET_REQ_HTTP_URL_ERROR;
				ret.setTempString(String.format(ret.getDescription(), key));
				log.debug(ret.getDescription());
			}else{
				logString  = "url:[%s],send context:[%s]";
				log.debug(String.format(logString, requestURL,reqcontext));
				try {
					String  valueString = HttpSender.doPost(reqcontext, requestURL);
					logString  = "url:[%s],recv context:[%s]";
					log.debug(String.format(logString, requestURL,valueString));
					context.append(valueString);
					ret = InterStatusCode.SUCCESS;
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					ret=InterStatusCode.GET_REQ_HTTP_SEND_ERROR;
					ret.setTempString(String.format(ret.getDescription(), key,requestURL));
					log.debug(ret.getTempString());
				}
				
			}
			
		}
		
		return ret;
	}
	
	@Override
	public RoadWayAdapter NewRoadWayAdapter() {
		// TODO Auto-generated method stub
		return new HttpRoadWayAdapterImp();
	}

}
