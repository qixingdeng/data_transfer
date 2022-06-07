package cn.cttic.roadtransapi.thread.command.imp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.message.Message;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.cttic.roadtransapi.code.InterLogProcCode;
import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.common.XmlBuilder;
import cn.cttic.roadtransapi.common.XmlOper;
import cn.cttic.roadtransapi.constants.RoadWayConstants;
import cn.cttic.roadtransapi.domain.InterSpcLogWithBLOBs;
import cn.cttic.roadtransapi.domain.InterSwapPlatformConfigWithBLOBs;
import cn.cttic.roadtransapi.mgr.DBMgr;
import cn.cttic.roadtransapi.mgr.ShmMgr;
import cn.cttic.roadtransapi.mgr.XMLTransformerMgr;
import cn.cttic.roadtransapi.thread.command.TaskCommandBase;
import cn.cttic.roadtransapi.ws_roadway.Transaction;
import cn.cttic.sysframe.common.util.DateUtil;

import com.google.common.base.Strings;

public class DataLoadLogCommand extends TaskCommandBase {

	private static Logger log = Logger.getLogger(DataLoadLogCommand.class);

	@Override
	public void Run() {
		
		if(this.getSource()!=null){
			
			@SuppressWarnings("unchecked")
			Map<String, Object> map = (Map<String, Object>) this.getSource();
			
			InterLogProcCode code = (InterLogProcCode) map.get(RoadWayConstants.CXF_STEP);
			
			InterSpcLogWithBLOBs logobj = null;
			switch (code) {
			case ALL_STEP:
				logobj = processAllstep(map);
				break;
			case RECEIVE_REQ_STEP:
				logobj = processReceiveReqStep(map);
				break;
			case REQ_SIGNATURE_STEP:
				//logobj = processReqSignatureStep(map);
				break;
			case TRANSFORM_REQ_STEP:
				//logobj = processTransformReqStep(map);
				break;
			case ADAPTER_PROCESS_STEP:
				//logobj = processAdapterProcessStep(map);
				break;
			case APAPTER_DETAIL_STEP:
				//logobj = processAdapterDetailStep(map);
				break;
			case RECEIVE_REQ_SERIALIZE_STEP:
				//logobj = processReceiveReqSerializeStep(map);
				break;
			case TRANSFORM_RESP_STEP:
				//logobj = processTransformRespStep(map);
				break;
			case SEND_RESP_STEP:
				logobj = processSendRespStep(map);
				break;
			default:
				break;
			}
			
			if(logobj!=null){
				String reqcontext = ShmMgr.getInstance().GetXmlContext(logobj);
				if(!Strings.isNullOrEmpty(reqcontext)){
					StringBuffer context = new StringBuffer();
					try {
						String key = XMLTransformerMgr.CLIENT_REQ_PREFIX + "_" + "CHOOSE" ; 
						String  mml = XMLTransformerMgr.getInstance().BusiProecess(reqcontext, "",key,null);
						DBMgr.getInstance().ProcessBusiForChose("CHOOSE", mml, context);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						log.debug(e.getMessage()); ;
					}
				}else {
					log.debug("DataLoadLogCommand context 是null");
				}
			}
			
		}else {
			log.debug("DataLoadLogCommand的source是null");
		}
		
	}
	












	private InterSpcLogWithBLOBs processAllstep(Map<String, Object> map){
		InterSpcLogWithBLOBs log = new InterSpcLogWithBLOBs();
		
		Date end = (Date) map.get(RoadWayConstants.BUSI_END_DATE);
		Date begin = (Date) map.get(RoadWayConstants.BUSI_BEGIN_DATE);
		InterLogProcCode step = (InterLogProcCode)map.get(RoadWayConstants.CXF_STEP);
		Transaction req = (Transaction)map.get("BUSI_REQ");
		Transaction resp = (Transaction)map.get("BUSI_RESP");
		
		String remoteAddr = (String)map.get("remote_addr");
		
        
        log.setProcStep(step.getCode());
        log.setProcStartTime(begin);
        log.setProcEndTime(end);
        log.setCreateDate(DateUtil.getServerDate());
        log.setProcContext(req.getTransactionBody());
        //log.setId("234999");
        log.setReqSerial(req.getTransactionHeader().getTransactionSerialnum());
        log.setDstSystemId(req.getTransactionHeader().getTransactionTargetservice());
        log.setSrcSystemId(req.getTransactionHeader().getTransactionSourceservice());
        log.setServiceId(req.getTransactionHeader().getTransactionServiceId());
        
        							
        log.setRespCode(resp.getTransactionHeader().getTransactionResponse().getTransactionRetcode());
        log.setRespMsg(resp.getTransactionHeader().getTransactionResponse().getTransactionRetmsg());
        
        log.setExtension("remote_addr:"+remoteAddr);
        
        InterSwapPlatformConfigWithBLOBs ib = DBMgr.getInstance().GetConfig("1001"+log.getServiceId());
        if(ib != null){
        	log.setServiceName(ib.getServiceName());
        }else{
        	log.setServiceName("-");
        }
        
		return log;
	}
	
	
	public static String slurp(final InputStream is, final int bufferSize,String decode)
	{
	  final char[] buffer = new char[bufferSize];
	  final StringBuilder out = new StringBuilder();
	  try (Reader in = new InputStreamReader(is, decode)) {
	    for (;;) {
	      int rsz = in.read(buffer, 0, buffer.length);
	      if (rsz < 0)
	        break;
	      out.append(buffer, 0, rsz);
	    }
	  }
	  catch (UnsupportedEncodingException ex) {
	    /* ... */
	  }
	  catch (IOException ex) {
	      /* ... */
	  }
	  return out.toString();
	}
	
	public static String convertStreamToString(java.io.InputStream is) {
	    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
	    return s.hasNext() ? s.next() : "";
	}
	
	private InterSpcLogWithBLOBs processReceiveReqStep(Map<String, Object> map){
		
		InterSpcLogWithBLOBs log = new InterSpcLogWithBLOBs();
		
		Date receivDate = (Date) map.get(RoadWayConstants.RECVIVE_DATE);
		
		String encoding = (String)map.get(Message.ENCODING);
		String httpMethod = (String)map.get(Message.HTTP_REQUEST_METHOD);
		String ct = (String)map.get(Message.CONTENT_TYPE);
		String address = (String)map.get(Message.ENDPOINT_ADDRESS);
		
		HttpServletRequest client = (HttpServletRequest)map.get("client");
		
        String result = (String)map.get(RoadWayConstants.BUSI_CONTEXT); 
        
        String format = "ENCODING:[%s]   \n"
        				+ "HTTP_REQUEST_METHOD:[%s]   \n"
        				+ "CONTENT_TYPE:[%s]   \n"
        				+ "ENDPOINT_ADDRESS:[%s]   \n"
        				+ "Content:[%s]";
        String context=String.format(format, encoding,httpMethod,ct,address,result);
        
        
        if(!Strings.isNullOrEmpty(result)){
        	XmlBuilder pathBuilder = new XmlBuilder(result, false);
    		Document pathDoc = pathBuilder.getDoc();

    		if (pathDoc != null) {
    			NodeList nodes = XmlOper.SelectNodes(pathDoc, "//transaction/header/*");
    			if (nodes != null && nodes.getLength() > 0) {
    				
    				for (int i = 0; i < nodes.getLength(); i++) {
    					Node node = nodes.item(i);
    					String value =node.getTextContent();
    					if(Strings.isNullOrEmpty(value)){
    						continue;
    					}
    					
    					if ("serialnum".equals(node.getNodeName())) {
    						log.setReqSerial(value);
    					} else if("targetservice".equals(node.getNodeName())){
    						log.setDstSystemId(value);
    					} else if("sourceservice".equals(node.getNodeName())){
    						log.setSrcSystemId(value);
    					}else if("serviceid".equals(node.getNodeName())){
    						log.setServiceId(value);
    					}else if("date".equals(node.getNodeName())){
    						//暂放在extendsion
    						log.setExtension(value);
    					}else if("time".equals(node.getNodeName())){
    						String date = log.getExtension();
    						String str = date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8)
    								+" "+value.substring(0,2)+":"+value.substring(2,4)+":"+value.substring(4,6);
    						try {
								Date d = DateUtil.parse(str, DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS);
								log.setProcStartTime(d);
							} catch (ParseException e) {
								e.printStackTrace();
							}
    						log.setExtension(null);
    					}
    				}
    			}
    		}

    		
        }
        InterLogProcCode code = (InterLogProcCode) map.get(RoadWayConstants.CXF_STEP);
        log.setProcStep(code.getCode());
        log.setProcEndTime(receivDate);
        log.setRespCode(InterStatusCode.SUCCESS.getCode());
        log.setRespMsg(InterStatusCode.SUCCESS.getDescription());
        log.setCreateDate(new Date());
        log.setProcContext(context);
        //log.setId("234999");
        
        InterSwapPlatformConfigWithBLOBs ib = DBMgr.getInstance().GetConfig("1001"+log.getServiceId());
        if(ib != null){
        	log.setServiceName(ib.getServiceName());
        }else{
        	log.setServiceName("-");
        }
        
		return log;
	}
	
	
	private InterSpcLogWithBLOBs processSendRespStep(Map<String, Object> map) {
		
		InterSpcLogWithBLOBs log = null;
		
		Date receivDate = (Date) map.get(RoadWayConstants.RECVIVE_DATE);
		
		String encoding = (String)map.get(Message.ENCODING);
		String httpMethod = (String)map.get(Message.HTTP_REQUEST_METHOD);
		String ct = (String)map.get(Message.CONTENT_TYPE);
		String address = (String)map.get(Message.ENDPOINT_ADDRESS);
		
        String result = (String)map.get(RoadWayConstants.BUSI_CONTEXT); 
        
        String format = "ENCODING:[%s]   \n"
        				+ "HTTP_REQUEST_METHOD:[%s]   \n"
        				+ "CONTENT_TYPE:[%s]   \n"
        				+ "ENDPOINT_ADDRESS:[%s]   \n"
        				+ "Content:[%s]";
        String context=String.format(format, encoding,httpMethod,ct,address,result);
        
        if(!Strings.isNullOrEmpty(result)){
        	XmlBuilder pathBuilder = new XmlBuilder(result, false);
    		Document pathDoc = pathBuilder.getDoc();

    		if (pathDoc != null) {
    			NodeList nodes = XmlOper.SelectNodes(pathDoc, "//transaction/header/*");
    			if (nodes != null && nodes.getLength() > 0) {
    				log = new InterSpcLogWithBLOBs();
    				for (int i = 0; i < nodes.getLength(); i++) {
    					Node node = nodes.item(i);
    					String value =node.getTextContent();
    					if(Strings.isNullOrEmpty(value)){
    						continue;
    					}
    					
    					if ("serialnum".equals(node.getNodeName())) {
    						log.setReqSerial(value);
    					} else if("targetservice".equals(node.getNodeName())){
    						log.setDstSystemId(value);
    					} else if("sourceservice".equals(node.getNodeName())){
    						log.setSrcSystemId(value);
    					}else if("serviceid".equals(node.getNodeName())){
    						log.setServiceId(value);
    					}else if("date".equals(node.getNodeName())){
    						//暂放在extendsion
    						log.setExtension(value);
    					}else if("time".equals(node.getNodeName())){
    						String date = log.getExtension();
    						String str = date.substring(0,4)+"-"+date.substring(4,6)+"-"+date.substring(6,8)
    								+" "+value.substring(0,2)+":"+value.substring(2,4)+":"+value.substring(4,6);
    						try {
								Date d = DateUtil.parse(str, DateUtil.PATTERN_YYYY_MM_DD_HH_MM_SS);
								log.setProcStartTime(d);
							} catch (ParseException e) {
								e.printStackTrace();
							}
    						log.setExtension(null);
    					}
    				}
    			}
    		}

    		
        }
        InterLogProcCode code = (InterLogProcCode) map.get(RoadWayConstants.CXF_STEP);
        log.setProcStep(code.getCode());
        log.setProcEndTime(receivDate);
        log.setRespCode(InterStatusCode.SUCCESS.getCode());
        log.setRespMsg(InterStatusCode.SUCCESS.getDescription());
        log.setCreateDate(new Date());
        log.setProcContext(context);
        
        InterSwapPlatformConfigWithBLOBs ib = DBMgr.getInstance().GetConfig("1001"+log.getServiceId());
        if(ib != null){
        	log.setServiceName(ib.getServiceName());
        }else{
        	log.setServiceName("-");
        }
        
		return log;
	}
	private InterSpcLogWithBLOBs processReqSignatureStep(Map<String, Object> map) {
		InterSpcLogWithBLOBs log = new InterSpcLogWithBLOBs();
		log.setReqSerial("_");
		log.setDstSystemId("_");
		log.setSrcSystemId("_");
		log.setServiceId("_");
		log.setProcStartTime(new Date());
		
        
        InterLogProcCode interLog = (InterLogProcCode) map.get(RoadWayConstants.CXF_STEP);
        String code = interLog.getCode();
        log.setProcStep(code);
        log.setProcEndTime((Date)map.get("RECVIVE_SERIALIZE_DATE"));
        log.setRespCode(InterStatusCode.SUCCESS.getCode());
        log.setRespMsg(InterStatusCode.SUCCESS.getDescription());
        log.setCreateDate(new Date());
        log.setProcContext(map.get(code).toString());
        
        log.setServiceName("_");
        
		return log;
	}
	
	private InterSpcLogWithBLOBs processReceiveReqSerializeStep(
			Map<String, Object> map) {
		InterSpcLogWithBLOBs log = new InterSpcLogWithBLOBs();
		log.setReqSerial("_");
		log.setDstSystemId("_");
		log.setSrcSystemId("_");
		log.setServiceId("_");
		log.setProcStartTime(new Date());
		
        
        InterLogProcCode interLog = (InterLogProcCode) map.get(RoadWayConstants.CXF_STEP);
        String code = interLog.getCode();
        log.setProcStep(code);
        log.setProcEndTime((Date)map.get("RECVIVE_SERIALIZE_DATE"));
        log.setRespCode(InterStatusCode.SUCCESS.getCode());
        log.setRespMsg(InterStatusCode.SUCCESS.getDescription());
        log.setCreateDate(new Date());
        log.setProcContext(map.get(code).toString());
        
        log.setServiceName("_");
        
		return log;
	}
	//TODO 没走
	private InterSpcLogWithBLOBs processTransformReqStep(Map<String, Object> map) {
		InterSpcLogWithBLOBs log = new InterSpcLogWithBLOBs();
		log.setReqSerial("_");
		log.setDstSystemId("_");
		log.setSrcSystemId("_");
		log.setServiceId("_");
		log.setProcStartTime(new Date());
		
        
        InterLogProcCode interLog = (InterLogProcCode) map.get(RoadWayConstants.CXF_STEP);
        String code = interLog.getCode();
        log.setProcStep(code);
        log.setProcEndTime((Date)map.get("RECVIVE_SERIALIZE_DATE"));
        log.setRespCode(InterStatusCode.SUCCESS.getCode());
        log.setRespMsg(InterStatusCode.SUCCESS.getDescription());
        log.setCreateDate(new Date());
        log.setProcContext(map.get(code).toString());
        
        log.setServiceName("_");
        
		return log;
	}
	
	//TODO 没进
	private InterSpcLogWithBLOBs processAdapterProcessStep(
			Map<String, Object> map) {
		InterSpcLogWithBLOBs log = new InterSpcLogWithBLOBs();
		log.setReqSerial("_");
		log.setDstSystemId("_");
		log.setSrcSystemId("_");
		log.setServiceId("_");
		log.setProcStartTime(new Date());
		
        
        InterLogProcCode interLog = (InterLogProcCode) map.get(RoadWayConstants.CXF_STEP);
        String code = interLog.getCode();
        log.setProcStep(code);
        log.setProcEndTime((Date)map.get("RECVIVE_SERIALIZE_DATE"));
        log.setRespCode(InterStatusCode.SUCCESS.getCode());
        log.setRespMsg(InterStatusCode.SUCCESS.getDescription());
        log.setCreateDate(new Date());
        log.setProcContext(map.get(code).toString());
        
        log.setServiceName("_");
        
		return log;
	}
	//TODO 没进
	private InterSpcLogWithBLOBs processAdapterDetailStep(
			Map<String, Object> map) {
		InterSpcLogWithBLOBs log = new InterSpcLogWithBLOBs();
		log.setReqSerial("_");
		log.setDstSystemId("_");
		log.setSrcSystemId("_");
		log.setServiceId("_");
		log.setProcStartTime(new Date());
		
        
        InterLogProcCode interLog = (InterLogProcCode) map.get(RoadWayConstants.CXF_STEP);
        String code = interLog.getCode();
        log.setProcStep(code);
        log.setProcEndTime((Date)map.get("RECVIVE_SERIALIZE_DATE"));
        log.setRespCode(InterStatusCode.SUCCESS.getCode());
        log.setRespMsg(InterStatusCode.SUCCESS.getDescription());
        log.setCreateDate(new Date());
        log.setProcContext(map.get(code).toString());
        
        log.setServiceName("_");
        
		return log;
	}
	
	//TODO 没进
	private InterSpcLogWithBLOBs processTransformRespStep(
			Map<String, Object> map) {
		InterSpcLogWithBLOBs log = new InterSpcLogWithBLOBs();
		log.setReqSerial("_");
		log.setDstSystemId("_");
		log.setSrcSystemId("_");
		log.setServiceId("_");
		log.setProcStartTime(new Date());
		
        
        InterLogProcCode interLog = (InterLogProcCode) map.get(RoadWayConstants.CXF_STEP);
        String code = interLog.getCode();
        log.setProcStep(code);
        log.setProcEndTime((Date)map.get("RECVIVE_SERIALIZE_DATE"));
        log.setRespCode(InterStatusCode.SUCCESS.getCode());
        log.setRespMsg(InterStatusCode.SUCCESS.getDescription());
        log.setCreateDate(new Date());
        log.setProcContext(map.get(code).toString());
        
        log.setServiceName("_");
        
		return log;
	}
	
	
	
	

}
