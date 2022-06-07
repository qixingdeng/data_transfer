package cn.cttic.roadtransapi.ws_rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;



public interface  HighwayDynamicQueryService {
	
    Response  HighwayDynamicQueryService_Get(String id, UriInfo info) ;
	
	
    Response  HighwayDynamicQueryService_Post( String id, String info );
}
