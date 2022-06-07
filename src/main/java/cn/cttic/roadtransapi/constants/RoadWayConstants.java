package cn.cttic.roadtransapi.constants;


public class RoadWayConstants {
	public static class Adapter_Type{
		public static final String ADAPTER_TYPE_DB = "DB"; 
		public static final String ADAPTER_TYPE_HTTP_XML = "XML"; 
		public static final String ADAPTER_TYPE_HTTP_SOAP = "SOAP";
		public static final String ADAPTER_TYPE_DB_MODIFY = "DB_MOD";
		public static final String ADAPTER_TYPE_DB_INSERT_OR_UPDATE = "DB_AORM";
		public static final String ADAPTER_TYPE_DB_SMALL_TEE = "SMALLTEE"; //小三通
		public static final String ADAPTER_TYPE_DB_USERINFO = "USERINFO"; 
		public static final String ADAPTER_TYPE_DB_JSON = "JSON"; 
		public static final String ADAPTER_TYPE_DB_JSON_HIGN = "HIGNJSON";
		public static final String ADAPTER_TYPE_CACHE_REDIS = "REDIS";
		public static final String ADAPTER_TYPE_DB_CHOOSE = "CHOOSE"; 
		public static final String ADAPTER_TYPE_DB_SERVICE = "SERVICE";
		public static final String ADAPTER_TYPE_JSON_BATCH= "ALLJSON";
	}
	
	public static final String DEFAULT_ENCODING = "utf-8"; 
	
	public static class Rest_Type{
		public static final String REST_GET_MODE = "GET" ;
		public static final String REST_POST_MODE = "POST" ;
	}
	
	public static final String CXF_STEP = "CXF_STEP";
	public static final String RECVIVE_DATE = "RECVIVE_DATE";
	public static final String SEND_DATE = "SEND_DATE";
	public static final String RECVIVE_SERIALIZE_DATE = "RECVIVE_SERIALIZE_DATE";
	public static final String SEND_SERIALIZE_DATE = "SEND_SERIALIZE_DATE";
	public static final String TRANSFORM_REQ_STEP_DATE = "TRANSFORM_REQ_STEP_DATE";
	public static final String TRANSFORM_REQ_STEP_KEY = "TRANSFORM_REQ_STEP_KEY";
	
	public static final String ADAPTER_PROCESS_STEP_DATE = "ADAPTER_PROCESS_STEP_DATE";
	public static final String ADAPTER_PROCESS_STEP_KEY = "ADAPTER_PROCESS_STEP_KEY";
	
	public static final String ADAPTER_PROCESS_STEP_CODE = "ADAPTER_PROCESS_STEP_CODE";
	
	public static final String TRANSFORM_RESP_STEP_DATE = "TRANSFORM_RESP_STEP_DATE";
	public static final String TRANSFORM_RESP_STEP_CODE = "TRANSFORM_RESP_STEP_CODE";
	public static final String TRANSFORM_RESP_STEP_KEY = "TRANSFORM_RESP_STEP_KEY";
	
	public static final String BUSI_BEGIN_DATE = "BUSI_BEGIN_DATE";
	public static final String BUSI_END_DATE = "BUSI_END_DATE";
	
	public static final String BUSI_REQ = "BUSI_REQ";
	public static final String BUSI_RESP = "BUSI_RESP";
	
	public static final String BUSI_CONTEXT = "BUSI_CONTEXT";
	
}
