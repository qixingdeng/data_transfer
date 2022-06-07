package cn.cttic.roadtransapi.ws_rest;

import cn.cttic.roadtransapi.code.DyncQueryDataTypeCode;


public class TransactionFactory {
	public static String GetTransactionFactory(DyncQueryDataTypeCode urlmode){
		String key="";
		String systemId = "";
		String serviceId = "";
		switch (urlmode) {
		case LOGIN_MODE:
			serviceId  = "W0101";
			systemId = "3001";
			break;
		case QUERY_BICYCLE_CURINFO:
			serviceId = "W0102";
			systemId = "3001";
			break;
		case QUERY_HIGHWAYROUTE_CURINFO:
			serviceId = "W0103";
			systemId = "3001";
			break;
		case QUERY_HISTORY_CURINFO:
			serviceId = "W0104";
			systemId = "3001";
			break;
		case QUERY_STATISTICAL_CURINFO:
			serviceId = "W0105";
			systemId = "3001";
			break;
		case QUERY_VEHICLEAREA_CURINFO:
			serviceId = "W0106";
			systemId = "3001";
			break;
		default:
			break;
		}
		
		key = systemId + serviceId;
		return key;
	}
}
