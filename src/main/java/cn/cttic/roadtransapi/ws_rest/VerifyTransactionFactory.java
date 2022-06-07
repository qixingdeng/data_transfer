package cn.cttic.roadtransapi.ws_rest;

import cn.cttic.roadtransapi.code.DyncQueryDataTypeCode;


public class VerifyTransactionFactory {
	public static boolean GetTransactionFactory(DyncQueryDataTypeCode urlmode){
		boolean is = false;
		switch (urlmode) {
		case LOGIN_MODE:
			is = false;
			break;
		case QUERY_BICYCLE_CURINFO:
			is = true;
			break;
		case QUERY_HIGHWAYROUTE_CURINFO:
			is = true;
			break;
		case QUERY_HISTORY_CURINFO:
			is = true;
			break;
		case QUERY_STATISTICAL_CURINFO:
			is = true;
			break;
		case QUERY_VEHICLEAREA_CURINFO:
			is = true;
			break;
		default:
			break;
		}
		
		
		return is;
	}
}
