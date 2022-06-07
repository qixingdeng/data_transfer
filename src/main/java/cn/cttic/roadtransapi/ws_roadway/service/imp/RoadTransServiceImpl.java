package cn.cttic.roadtransapi.ws_roadway.service.imp;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterLogProcCode;
import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.constants.RoadWayConstants;
import cn.cttic.roadtransapi.mgr.CommMgr;
import cn.cttic.roadtransapi.mgr.LogMgr;
import cn.cttic.roadtransapi.mgr.SignatureMgr;
import cn.cttic.roadtransapi.ws.service.imp.RoadWayServiceImp;
import cn.cttic.roadtransapi.ws_roadway.Transaction;
import cn.cttic.roadtransapi.ws_roadway.TransactionHeaderList;
import cn.cttic.roadtransapi.ws_roadway.TransactionResponse;
import cn.cttic.roadtransapi.ws_roadway.service.RoadTransService;
import cn.cttic.sysframe.common.util.DateUtil;
import cn.cttic.sysframe.common.util.SpringContextUtil;
import cn.cttic.sysframe.frame.service.SystemService;
import cn.cttic.sysframe.frame.service.impl.SystemServiceImpl;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;


public class RoadTransServiceImpl implements RoadTransService {
	
	@Resource
	private WebServiceContext context;

	public RoadTransServiceImpl(){
		
	}
	
	private static Logger logger = Logger.getLogger(RoadWayServiceImp.class);

	private String getIp() {
	    try {
	    	MessageContext ctx = context.getMessageContext();
		    HttpServletRequest request = (HttpServletRequest) ctx.get(AbstractHTTPDestination.HTTP_REQUEST);
		    String ip = request.getRemoteAddr();
		    return ip;
		} catch (Exception e) {
		 return "获取ip失败";
		 }
	}
		  
	
	@Override
	public Transaction command(Transaction request) {
		
		Date sendDate =null;
		Date receivDate = null;
		if(LogMgr.getInstance().isSign()){
			Map<String, Object> sourecMap= Maps.newHashMap();
	        sourecMap.put(RoadWayConstants.CXF_STEP, InterLogProcCode.RECEIVE_REQ_SERIALIZE_STEP); 
	        sourecMap.put(InterLogProcCode.RECEIVE_REQ_SERIALIZE_STEP.getCode(), request);
	        receivDate = (Date) DateUtil.getServerDate();
	        sourecMap.put(RoadWayConstants.RECVIVE_SERIALIZE_DATE, receivDate);
	        LogMgr.getInstance().BusiProc(this, sourecMap);
		}
		
        
		TransactionHeaderList header = request.getTransactionHeader();
		StringBuffer context = new StringBuffer();
		InterStatusCode ret = PreocessHeader(header);
		if(ret == InterStatusCode.SUCCESS){
			ret = SignatureMgr.getInstance().ProcessBusi(request);
			if(ret == InterStatusCode.SUCCESS){
				ret = CommMgr.getInstance().ProcessBusi(request, context);
			}
		}
		
		Transaction responese = new Transaction();
		ret = PreocessResponse(ret,header,responese,context.toString());
		
		if(LogMgr.getInstance().isSign()){
			Map<String, Object> respsourecMap= Maps.newHashMap();
			respsourecMap.put(RoadWayConstants.CXF_STEP, InterLogProcCode.SEND_RESP_UNSERIALIZE_STEP); 
			respsourecMap.put(InterLogProcCode.SEND_RESP_UNSERIALIZE_STEP.getCode(), responese);
		    sendDate = (Date) DateUtil.getServerDate();
			respsourecMap.put(RoadWayConstants.SEND_SERIALIZE_DATE, sendDate);
			LogMgr.getInstance().BusiProc(this, respsourecMap);
		}
		
		if(LogMgr.getInstance().isSign()){
			Map<String, Object> allMap= Maps.newHashMap();
			allMap.put(RoadWayConstants.CXF_STEP, InterLogProcCode.ALL_STEP); 
        
			allMap.put(RoadWayConstants.BUSI_BEGIN_DATE, receivDate);
			allMap.put(RoadWayConstants.BUSI_END_DATE, sendDate);
        
			allMap.put(RoadWayConstants.BUSI_REQ, request);
			allMap.put(RoadWayConstants.BUSI_RESP, responese);
			
			allMap.put("remote_addr",getIp());
        
			LogMgr.getInstance().BusiProc(this, allMap);
        }
        
		String tempString = String.format(header_format_2, header.getTransactionDate(),header.getTransactionTime(),header.getTransactionServiceId(),responese.getTransactionBody());
		logger.debug(tempString);
		return responese;
	}
	
	private String header_format="服务请求时间是:[%s %s],报文流水号:[%s],系统ID是:[%s],服务ID是:[%s]";
	private String header_format_1="源系统编号是[%s]";
	private String header_format_2="服务响应时间是:[%s %s],报文流水号:[%s],服务响应报文是:[%s]";
	
	private InterStatusCode PreocessResponse(InterStatusCode responsecode,TransactionHeaderList header ,Transaction response,String xmlcontext){
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		TransactionHeaderList newHeaderList = new TransactionHeaderList();
		newHeaderList.setTransactionSerialnum(header.getTransactionSerialnum());
		newHeaderList.setTransactionIsreq("1");
		newHeaderList.setTransactionSourceservice(header.getTransactionTargetservice());
		newHeaderList.setTransactionTargetservice(header.getTransactionSourceservice());
		newHeaderList.setTransactionServiceId(header.getTransactionServiceId());
		newHeaderList.setTransactionSystemId(header.getTransactionSystemId());
		TransactionResponse responsemsg = new TransactionResponse();
		responsemsg.setTransactionRetcode(responsecode.getCode());
		if(Strings.isNullOrEmpty(responsecode.getTempString())){
			responsemsg.setTransactionRetmsg(responsecode.getDescription());
		}else {
			responsemsg.setTransactionRetmsg(responsecode.getTempString());
		}
		newHeaderList.setTransactionResponse(responsemsg);
		
		
		response.setTransactionHeader(newHeaderList);
		
		SystemService dateservice = SpringContextUtil.getBean(SystemServiceImpl.class);
		Date date = dateservice.getSystemDate();
		String dateformat= DateUtil.format(date, DateUtil.PATTERN_YYYYMMDDHHMMSS);
		String day=dateformat.substring(0,8);
		String other = dateformat.substring(8);
		
		response.getTransactionHeader().setTransactionDate(day);
		response.getTransactionHeader().setTransactionTime(other);
		if(Strings.isNullOrEmpty(xmlcontext)||responsecode!=InterStatusCode.SUCCESS){
			xmlcontext="";
		}else{
			//xmlcontext = Base64.getBase64(xmlcontext);
			response.setTransactionBody(xmlcontext);
			ret = InterStatusCode.SUCCESS;
		}
		
		return ret;
	}
	
	private InterStatusCode PreocessHeader(TransactionHeaderList header){
		String tempString;
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		if(!Strings.isNullOrEmpty(header.getTransactionSourceservice())){
			tempString=String.format(header_format_1, header.getTransactionSourceservice());
			logger.debug(tempString);
		}
		
		if(Strings.isNullOrEmpty(header.getTransactionSerialnum())||
		   Strings.isNullOrEmpty(header.getTransactionServiceId())||
		   Strings.isNullOrEmpty(header.getTransactionSystemId())){
			 ret = InterStatusCode.PARSE_SOAP_HEADER_NULL_ERROR;
		   }else{
			   tempString = String.format(header_format, header.getTransactionDate(),header.getTransactionTime()
					   							,header.getTransactionSerialnum(),header.getTransactionSystemId(),header.getTransactionServiceId());
			   logger.debug(tempString);
			   
			   // 验证数字签名
			   ret=InterStatusCode.SUCCESS;
		   }
		
		return ret;
	}
}