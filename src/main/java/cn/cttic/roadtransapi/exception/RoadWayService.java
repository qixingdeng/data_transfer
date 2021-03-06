package cn.cttic.roadtransapi.exception;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * 
 */
@WebService(name = "RoadWayService", targetNamespace = "http://roadwayservice.cttic.cn/")
public interface RoadWayService {

	/**
	 * 
	 * @param transaction
	 * @return returns cn.cttic.roadtransapi.exception.CommandResponse.Transaction
	 */
	@WebMethod(operationName = "Command")
	@WebResult(name = "transaction", targetNamespace = "")
	@RequestWrapper(localName = "Command", targetNamespace = "http://roadwayservice.cttic.cn/", className = "cn.cttic.roadtransapi.exception.Command")
	@ResponseWrapper(localName = "CommandResponse", targetNamespace = "http://roadwayservice.cttic.cn/", className = "cn.cttic.roadtransapi.exception.CommandResponse")
	public cn.cttic.roadtransapi.ws.CommandResponse.Transaction command(
			@WebParam(name = "transaction", targetNamespace = "") cn.cttic.roadtransapi.ws.Command.Transaction transaction);

}
