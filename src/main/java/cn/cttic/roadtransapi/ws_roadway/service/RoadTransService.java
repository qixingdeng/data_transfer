package cn.cttic.roadtransapi.ws_roadway.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import cn.cttic.roadtransapi.ws_roadway.Transaction;


@WebService(name = "RoadTransService", targetNamespace = "http://roadtrans.service.cttic.cn/")
public interface RoadTransService {

	/**
	 * 
	 * @param transaction
	 * @return returns cn.cttic.service.roadtrans.CommandResponse.Transaction
	 */
	@WebMethod(operationName = "Command")
	@WebResult(name = "transaction", targetNamespace = "")
	@RequestWrapper(localName = "Command", targetNamespace = "http://roadtrans.service.cttic.cn/", className = "cn.cttic.service.roadtrans.Command")
	@ResponseWrapper(localName = "CommandResponse", targetNamespace = "http://roadtrans.service.cttic.cn/", className = "cn.cttic.service.roadtrans.CommandResponse")
	
	public Transaction command(
			@WebParam(name = "transaction", targetNamespace = "") Transaction transaction);
	
}
