package cn.cttic.roadtransapi.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Holder;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * 
 */
@WebService(name = "roadwayservicetype", targetNamespace = "http://roadwayservice.cttic.cn/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Roadwayservicetype {

	/**
	 * 
	 * @param parameters
	 */
	@WebMethod(operationName = "Service")
	public void service(
			@WebParam(name = "Transaction", targetNamespace = "http://roadwayservice.cttic.cn/", mode = WebParam.Mode.INOUT, partName = "parameters") Holder<Transaction> parameters);

}
