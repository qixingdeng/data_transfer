package cn.cttic.roadtransapi.interceptor;

import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.message.Message;

import cn.cttic.roadtransapi.code.InterLogProcCode;
import cn.cttic.roadtransapi.constants.RoadWayConstants;
import cn.cttic.roadtransapi.mgr.LogMgr;
import cn.cttic.sysframe.common.util.DateUtil;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

public class MyLoggingInInterceptor extends LoggingInInterceptor{
	public void handleMessage(Message message) throws Fault {
		if(LogMgr.getInstance().isSign()){
			HttpServletRequest client= (HttpServletRequest)message.get("HTTP.REQUEST");
			
			InputStream is = message.getContent(InputStream.class);
			
			String result = null;
			if(is!=null){
				final LoggingMessage buffer 
	            = new LoggingMessage("Inbound Message", "AAA");
				String encoding = (String)message.get(Message.ENCODING);
				String ct = (String)message.get(Message.CONTENT_TYPE);
				logInputStream(message, is, buffer, encoding, ct);
				result = buffer.getPayload().toString();
			}
			
			Map<String, Object> sourecMap= Maps.newHashMap();
            
            sourecMap.put(RoadWayConstants.CXF_STEP, InterLogProcCode.RECEIVE_REQ_STEP); 
            
            //sourecMap.put(InterLogProcCode.RECEIVE_REQ_STEP.getCode(), message);
            
            String encoding = (String)message.get(Message.ENCODING);
    		String httpMethod = (String)message.get(Message.HTTP_REQUEST_METHOD);
    		String ct = (String)message.get(Message.CONTENT_TYPE);
    		String address = (String)message.get(Message.ENDPOINT_ADDRESS);
    		
    		
    		sourecMap.put(Message.ENCODING, encoding);
    		sourecMap.put(Message.HTTP_REQUEST_METHOD, httpMethod);
    		sourecMap.put(Message.CONTENT_TYPE, ct);
    		sourecMap.put(Message.ENDPOINT_ADDRESS, address);
    		sourecMap.put("client", client);
    		
            java.util.Date receivDate = (java.util.Date) DateUtil.getServerDate();
            sourecMap.put(RoadWayConstants.RECVIVE_DATE, receivDate);
            
            if(!Strings.isNullOrEmpty(result)){
            	sourecMap.put(RoadWayConstants.BUSI_CONTEXT, result);
            	LogMgr.getInstance().BusiProc(this, sourecMap);
            }
		}
		
        super.handleMessage(message);
        
    }
}
