package cn.cttic.roadtransapi.ws_rest.imp;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;

import cn.cttic.roadtransapi.code.DyncQueryDataTypeCode;
import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.common.XmlOper;
import cn.cttic.roadtransapi.common.smParamNode;
import cn.cttic.roadtransapi.mgr.CommMgr;
import cn.cttic.roadtransapi.mgr.ShmMgr;
import cn.cttic.roadtransapi.ws_rest.HighwayDynamicQueryService;
import cn.cttic.roadtransapi.ws_rest.TransactionFactory;
import cn.cttic.roadtransapi.ws_rest.VerifyTransactionFactory;

import com.google.common.base.Strings;

@Path("/data")
public class HighwayDynamicQueryServiceImp implements HighwayDynamicQueryService{

	private static Logger logger = Logger.getLogger(HighwayDynamicQueryServiceImp.class);

	
	private String header_format="服务请求Path是:[%s],請求报文:[%s]";
	private String header_format_1="服务请求Path是:[%s],響應报文:[%s]";
	@GET
	@Path("/{id}")
	@Consumes(MediaType.TEXT_PLAIN_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response  HighwayDynamicQueryService_Get(@PathParam(value="id")String id,@Context UriInfo info) {
		InterStatusCode code = InterStatusCode.SUCCESS ; 
		String tempString = "";
		String resp = "";
		String path = id ;
		StringBuffer context = new StringBuffer() ;
		
		
		String verifycode = "";
		MultivaluedMap<String, String> map = info.getQueryParameters() ; 
		smParamNode  node = new smParamNode();
		smParamNode  temp = null;
		for(Map.Entry<String, List<String>> entry : map.entrySet()){
			String key = entry.getKey() ;
			List<String> valueList = entry.getValue() ;
			temp = new smParamNode() ;
			temp.setKey(key);
			String value="" ;
			for (String str : valueList) {
				if(Strings.isNullOrEmpty(value)){
					value = str;
				}else {
					value = value + "#" +str;
				}
			}
			temp.setValue(value);
			
			if(temp.getKey().equals("verifycode")){
				verifycode = temp.getValue();
			}
			node.getSmParamNode().add(temp);
		}
		
		DyncQueryDataTypeCode urlmode = DyncQueryDataTypeCode.getOperType(path);
		if(urlmode == null){
			code = InterStatusCode.REST_REQ_COMMAND_NULL;
			code.setTempString(String.format(code.getDescription(), path));
			logger.debug(code.getTempString());
		}else {
			boolean verifysign = VerifyTransactionFactory.GetTransactionFactory(urlmode);
			
			if(!verifysign){
				logger.debug("該請求是不需要經過驗證功能");
			}else {
				logger.debug("該請求需要經過驗證功能");
				boolean sign = ShmMgr.getInstance().Check(verifycode);
				if(!sign){
					code = InterStatusCode.REST_VERIFY_CODE;
					code.setTempString(String.format(code.getDescription(), verifycode));
					logger.debug(code.getTempString());
				}
			}
		}
		
		
		if(code==InterStatusCode.SUCCESS){
			String req_contextString = ShmMgr.getInstance().GetXmlContext(node);
		    tempString = String.format(header_format, id,req_contextString);
			logger.debug(tempString);
			code = ProcessBusi(path,req_contextString,context);
		}
		
		if(code!=InterStatusCode.SUCCESS){
			resp = GetReturnValue(code);
			
		}else{
			resp= context.toString();
		}
		
		tempString = String.format(header_format_1, id,resp);
		logger.debug(tempString);
		return Response.ok().entity(resp).build();
	}
	
	
	private String GetReturnValue(InterStatusCode code){
		JSONObject retObject = new JSONObject();
		retObject.put("code", code.getCode());
		JSONArray array = new JSONArray();
		JSONObject temp=null;
		temp = new JSONObject();
		if(Strings.isNullOrEmpty(code.getTempString())){
			temp.put("remark", code.getDescription());
		}else {
			temp.put("remark", code.getTempString());
		}
		
		array.add(temp);
		retObject.put("data", array);
		return retObject.toString();
	}
	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response  HighwayDynamicQueryService_Post(@PathParam(value="id")String id,String info ) {
		InterStatusCode code = InterStatusCode.SUCCESS ; 
		String tempString = "";
		String resp = "";
		String path = id ;
		StringBuffer context = new StringBuffer() ;
		tempString = String.format(header_format, id,info);
		logger.debug(tempString);
		Map<String, String> map = XmlOper.GetRestValue(info,"&");
		smParamNode  node = new smParamNode();
		smParamNode  temp = null;
		String verifycode = "";
		for(Map.Entry<String, String> entry : map.entrySet()){
			String key = entry.getKey() ;
			
			temp = new smParamNode() ;
			temp.setKey(key);
			
			temp.setValue(entry.getValue());
			
			if(temp.getKey().equals("verifycode")){
				verifycode = temp.getValue();
			}
			node.getSmParamNode().add(temp);
		}
		
		DyncQueryDataTypeCode urlmode = DyncQueryDataTypeCode.getOperType(path);
		if(urlmode == null){
			code = InterStatusCode.REST_REQ_COMMAND_NULL;
			code.setTempString(String.format(code.getDescription(), path));
			logger.debug(code.getTempString());
		}else {
			boolean verifysign = VerifyTransactionFactory.GetTransactionFactory(urlmode);
			
			if(!verifysign){
				logger.debug("該請求是不需要經過驗證功能");
			}else {
				logger.debug("該請求需要經過驗證功能");
				boolean sign = ShmMgr.getInstance().Check(verifycode);
				if(!sign){
					code = InterStatusCode.REST_VERIFY_CODE;
					code.setTempString(String.format(code.getDescription(), verifycode));
					logger.debug(code.getTempString());
				}
			}
		}
		
		if(code==InterStatusCode.SUCCESS){
			String req_contextString = ShmMgr.getInstance().GetXmlContext(node);
		    tempString = String.format(header_format, id,req_contextString);
			logger.debug(tempString);
			code = ProcessBusi(path,req_contextString,context);
		}
		
		if(code!=InterStatusCode.SUCCESS){
			resp = GetReturnValue(code);;
		}else{
			resp = context.toString();
			
		}
		
		tempString = String.format(header_format_1, id,resp);
		logger.debug(tempString);
		return Response.ok().entity(resp).build();
	}
	
	private InterStatusCode ProcessBusi(String path,String reqcontext ,StringBuffer context){
		InterStatusCode code = InterStatusCode.SUCCESS ;
		DyncQueryDataTypeCode urlmode = DyncQueryDataTypeCode.getOperType(path);
		String key = TransactionFactory.GetTransactionFactory(urlmode);
		if(Strings.isNullOrEmpty(path)){
			code = InterStatusCode.REST_GET_PATH_NULL_ERROR;
		}else{
			code = CommMgr.getInstance().ProcessBusiRest(key,reqcontext, context);
		}
		return code ;
	}

}
