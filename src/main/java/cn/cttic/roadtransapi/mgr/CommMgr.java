package cn.cttic.roadtransapi.mgr;

import cn.cttic.roadtransapi.code.InterStatusCode;
import cn.cttic.roadtransapi.commadapter.RoadWayAdapter;
import cn.cttic.roadtransapi.commadapter.imp.RoadWayAdapterImp;
import cn.cttic.roadtransapi.ws.Transaction;
import cn.cttic.roadtransapi.ws.TransactionHeaderList;



public class CommMgr  {
	
	private CommMgr(){
		Init();
	}
	
	private static CommMgr uniqueInstance = null;
	
	public static CommMgr getInstance() {
	    if (uniqueInstance == null) {
	           uniqueInstance = new CommMgr();
	       }
	       return uniqueInstance;   
	}
	
	private void Init(){
		
	}

	public InterStatusCode ProcessBusi(Transaction transaction,StringBuffer context){
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		TransactionHeaderList header = transaction.getTransactionHeader();
		String key = header.getTransactionSystemId()+ header.getTransactionServiceId();
		ret=adapter.ProcessBusi(key, transaction.getTransactionBody(), context);
		return ret;
	}
	
	public InterStatusCode ProcessBusi(cn.cttic.roadtransapi.ws_roadway.Transaction transaction,StringBuffer context){
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		cn.cttic.roadtransapi.ws_roadway.TransactionHeaderList header = transaction.getTransactionHeader();
		String key = header.getTransactionSystemId()+ header.getTransactionServiceId();
		ret=adapter.ProcessBusi(key, transaction.getTransactionBody(), context);
		return ret;
	}

	
	public InterStatusCode ProcessBusiRest(String key_xml ,String req_xml,StringBuffer context){
		InterStatusCode ret = InterStatusCode.NUKONW_ERROR;
		ret=adapter.ProcessBusi(key_xml, req_xml, context);
		return ret;
	}
	
	private RoadWayAdapter adapter = new RoadWayAdapterImp();
	
}
