package cn.cttic.roadtransapi.ws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import cn.cttic.roadtransapi.ws.Transaction;



@WebService(name = "RoadWayService",targetNamespace = "http://roadwayservice.cttic.cn/")
public interface RoadWayService {

	@WebMethod
	@WebResult(name = "transaction")
	public Transaction Command(@WebParam(name = "transaction")Transaction request);
	
}
