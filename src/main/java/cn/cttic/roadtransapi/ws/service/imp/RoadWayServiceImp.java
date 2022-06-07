package cn.cttic.roadtransapi.ws.service.imp;

import java.util.Date;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.common.ChangeCharset;
import cn.cttic.roadtransapi.mgr.CommMgr;
import cn.cttic.roadtransapi.mgr.SignatureMgr;
import cn.cttic.roadtransapi.ws.Transaction;
import cn.cttic.roadtransapi.ws.TransactionHeaderList;
import cn.cttic.roadtransapi.ws.TransactionResponse;
import cn.cttic.roadtransapi.ws.service.RoadWayService;
import cn.cttic.sysframe.common.util.DateUtil;
import cn.cttic.sysframe.common.util.SpringContextUtil;
import cn.cttic.sysframe.frame.service.SystemService;
import cn.cttic.sysframe.frame.service.impl.SystemServiceImpl;

import com.google.common.base.Strings;



public class RoadWayServiceImp implements RoadWayService {

	public RoadWayServiceImp(){
		
	}
	private static Logger logger = Logger.getLogger(RoadWayServiceImp.class);

	private ChangeCharset charset = new ChangeCharset();
	
	@Override
	public Transaction Command(Transaction request) {
		
		TransactionHeaderList header = request.getTransactionHeader();
		StringBuffer context = new StringBuffer();
		InterStatusCode ret = PreocessHeader(header);
		if(ret == InterStatusCode.SUCCESS){
			ret = SignatureMgr.getInstance().ProcessBusi(request);
			if(ret == InterStatusCode.SUCCESS){
				//String contextString = Base64.getFromBase64(request.getTransactionBody());
				//request.setTransactionBody(contextString);
				//
				ret = CommMgr.getInstance().ProcessBusi(request, context);
			}
		}
		
		Transaction responese = new Transaction();
		ret = PreocessResponse(ret,header,responese,context.toString());
		
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