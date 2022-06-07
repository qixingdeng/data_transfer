package cn.cttic.roadtransapi.commadapter;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.cttic.roadtransapi.code.InterLogProcCode;
import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.common.XMLUtil;
import cn.cttic.roadtransapi.constants.RoadWayConstants;
import cn.cttic.roadtransapi.domain.InterSwapPlatformConfigWithBLOBs;
import cn.cttic.roadtransapi.mgr.DBMgr;
import cn.cttic.roadtransapi.mgr.LogMgr;
import cn.cttic.roadtransapi.mgr.XMLTransformerMgr;
import cn.cttic.sysframe.common.util.DateUtil;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;


public class RoadWayBaseAdapter implements RoadWayAdapter{

	private static Logger log = Logger.getLogger(RoadWayBaseAdapter.class);
	
	public RoadWayBaseAdapter(){
		
	}
	
	@Override
	public InterStatusCode ProcessBusi(String key, String reqcontext,
			StringBuffer context) {
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		this.key = key;
		String logString;
		if(Strings.isNullOrEmpty(reqcontext)||Strings.isNullOrEmpty(key)){
			ret=InterStatusCode.GET_REQ_ERROR;
			ret.setTempString(String.format(ret.getDescription(), key));
			log.debug(ret.getTempString());
		}else{
		    config = DBMgr.getInstance().GetConfig(key);
			if(config!=null){
				String reqkey = GetReqkey();
				
				ret = validateXml(reqcontext);
				if(ret != InterStatusCode.SUCCESS){
					return ret ;
				}
				
				SourceReqContext = reqcontext;
				
				
				reqcontext=ProcessReqContext(reqcontext);
				
				String  mml = XMLTransformerMgr.getInstance().BusiProecess(reqcontext, "",reqkey,null);
				
				if(LogMgr.getInstance().isSign()){
					Map<String, Object> sourecMap= Maps.newHashMap();
					sourecMap.put(RoadWayConstants.CXF_STEP, InterLogProcCode.TRANSFORM_REQ_STEP); 
					sourecMap.put(InterLogProcCode.TRANSFORM_REQ_STEP.getCode(), mml);
					Date date = (Date) DateUtil.getServerDate();
					sourecMap.put(RoadWayConstants.TRANSFORM_REQ_STEP_DATE, date);
					sourecMap.put(RoadWayConstants.TRANSFORM_REQ_STEP_KEY, reqkey);
					LogMgr.getInstance().BusiProc(this, sourecMap);
				}
				
				if(Strings.isNullOrEmpty(mml)){
					ret=InterStatusCode.GET_DBCONFIG_TR_BEGIN_ERROR;
					ret.setTempString(String.format(ret.getDescription(), key));
					log.debug(ret.getTempString());
				}else{
					logString="转化后的请求体:[%s][%s]";
					logString=String.format(logString,key, mml);
					log.debug(logString);
					ret = ProcessAdapter(mml,context);
					
					if(LogMgr.getInstance().isSign()){
						Map<String, Object> ProcessAdaptermap= Maps.newHashMap();
						ProcessAdaptermap.put(RoadWayConstants.CXF_STEP, InterLogProcCode.ADAPTER_PROCESS_STEP); 
						ProcessAdaptermap.put(InterLogProcCode.ADAPTER_PROCESS_STEP.getCode(), context);
						Date adpatedate = (Date) DateUtil.getServerDate();
						ProcessAdaptermap.put(RoadWayConstants.ADAPTER_PROCESS_STEP_DATE, adpatedate);
						ProcessAdaptermap.put(RoadWayConstants.ADAPTER_PROCESS_STEP_CODE, ret);
			        
						LogMgr.getInstance().BusiProc(this, ProcessAdaptermap);
					}
					
					if(ret==InterStatusCode.SUCCESS){
						if(Strings.isNullOrEmpty(config.getRespBody())){
							logString="getRespBadyTran是null,不处理返回报文";
							log.debug(logString);
						}else{
							logString="getRespBadyTran不是null，将转换报文,[%s]";
							
							log.debug(String.format(logString, config.getServiceId()));
							
							String xmlcontext = context.toString();
							String respkey = this.GetRespkey();
							String newxmlcontext = XMLTransformerMgr.getInstance().BusiProecess(xmlcontext,"", respkey,null);
							
							if(Strings.isNullOrEmpty(newxmlcontext)){
								ret=InterStatusCode.PARSE_RESULT_XML_ERROR;
								ret.setTempString(String.format(ret.getDescription(), key));
								context.delete(0, context.length());
								log.debug(ret.getTempString());
							}else{
								context.delete(0, context.length());
								context.append(newxmlcontext);
							}
							
							if(LogMgr.getInstance().isSign()){
								Map<String, Object> respkeymap= Maps.newHashMap();
								respkeymap.put(RoadWayConstants.CXF_STEP, InterLogProcCode.TRANSFORM_RESP_STEP); 
								respkeymap.put(InterLogProcCode.TRANSFORM_RESP_STEP.getCode(), newxmlcontext);
								Date respadpatedate = (Date) DateUtil.getServerDate();
								respkeymap.put(RoadWayConstants.TRANSFORM_RESP_STEP_DATE, respadpatedate);
								respkeymap.put(RoadWayConstants.TRANSFORM_RESP_STEP_CODE, ret);
								respkeymap.put(RoadWayConstants.TRANSFORM_RESP_STEP_KEY, respkey);
					        
								LogMgr.getInstance().BusiProc(this, respkeymap);
							}
						}
						
						ret=ProcessRespAdapter(reqcontext,context);
					}
				}
				
			}else{
				ret=InterStatusCode.GET_DBCONFIG_ERROR;
				ret.setTempString(String.format(ret.getDescription(), key));
				log.debug(ret.getTempString());
			}
			
		}
		
		return ret;
	}
	
	
	public String getAdapterType() {
		return AdapterType;
	}	

	
	public InterStatusCode ProcessAdapter(String reqcontext,StringBuffer context){
		InterStatusCode ret = InterStatusCode.SUCCESS;
		return ret;
	}
	
	public InterStatusCode ProcessRespAdapter(String reqcontext,StringBuffer context){
		InterStatusCode ret = InterStatusCode.SUCCESS;
		return ret;
	} 
	
	private InterStatusCode validateXml(String xmlStr){
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		
		String schma = this.config.getExtension();
		if(Strings.isNullOrEmpty(schma)){
			ret = InterStatusCode.SUCCESS;
		}else{
			StringBuilder error = new StringBuilder() ;
			boolean sign = XMLUtil.validateXMLByXSD(xmlStr, schma,error);
			if(sign){
				ret = InterStatusCode.SUCCESS;
			}else{
				ret=InterStatusCode.REQ_VALIDATA_LOST_ERROR;
				ret.setTempString(String.format(ret.getDescription(), error.toString()));
				log.debug(ret.getTempString());
			}
		}
		return ret;
	}
	
	protected String ProcessReqContext(String reqcontext){
		return reqcontext;
	}

	protected String GetReqkey(){
		return XMLTransformerMgr.CLIENT_REQ_PREFIX + "_" + key;
	}
	
	protected String GetRespkey(){
		return XMLTransformerMgr.CLIENT_RSP_PREFIX + "_" + key;
	}
	
	
	protected  String  AdapterType ;
	
	protected InterSwapPlatformConfigWithBLOBs config;
	
	protected String key;
	
	protected String SourceReqContext;

	@Override
	public RoadWayAdapter NewRoadWayAdapter() {
		// TODO Auto-generated method stub
		return new RoadWayBaseAdapter();
	}
}
