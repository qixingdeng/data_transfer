package cn.cttic.roadtransapi.code;

import java.util.EnumSet;


public enum InterStatusCode {
	SUCCESS(0,"0000", "成功"),
	NUKONW_ERROR(1,"0001", "未知错误"),
	PARSE_SOAP_HEADER_ERROR(2,"0002", "解析请求报文中的报文header信息失败！"),
	PARSE_SOAP_HEADER_NULL_ERROR(3,"0003", "解析请求报文中的报文header中的非空字段[transaction_serialnum,transaction_system_id,transaction_service_id],一个或者多个为null"),
	USER_DEFINDES_ERROR(4,"0004","解析xslt失败"),
	GET_DBCONFIG_ERROR(5,"0005","key:[%s],在配置表中没有查询中此记录不能做处理"),
	GET_DBCONFIG_TR_ERROR(6,"0006","使用转化模板后,字符串为null"),
	GET_DBCONFIG_TR_BEGIN_ERROR(7,"0007","key:[%s],请求报文转换为内部数据结构体 "),
	PARSE_EXAMPLE_ERROR(8,"0008","key:[%s],解析example对象失败 "),
	PARSE_RESULT_ERROR(9,"0009","classname:[%s],调用selectbyexample对象返回null "),
	PARSE_RESULT_XML_ERROR(10,"0010","classname:[%s],调用xlst转换返回报文出错 "),
	PARSE_RESULT_RESP_ERROR(11,"0011","classname:[%s],调用resp xlst转换返回报文出错 "),
	GET_REQ_ERROR(12,"0012","key:[%s],请求报文为null"),
	GET_REQ_HTTP_ERROR(13,"0013","key:[%s],在http适配器中,请求报文为null"),
	GET_REQ_HTTP_URL_ERROR(14,"0014","key:[%s],在http适配器中,配置表中的url字段为null"),
	GET_REQ_HTTP_SEND_ERROR(15,"0015","key:[%s],在http适配器中,与url[%s]通信失败"),
	GET_ADAPTER_ERROR(15,"0015","key:[%s],没有配置业务的adapter"),
	GET_REQ_SUB_ERROR(16,"0016","key:[%s],请求报文的配置没有得到"),
	GET_REQ_SUB_PROCESS_ERROR(17,"0017","key:[%s],转化请求报文失败"),
	GET_SIGNATURE_ERROR(18,"0018","数据摘要的报文是null"),
	GET_SIGNATURE_PRIVATE_ERROR(19,"0019","[%s]对应的私钥为null"),
	GET_SIGNATURE_INFO_ERROR(20,"0020","[%s]对应的数据摘要或者MD5字符串为null"),
	GET_SIGNATURE_TEST_ERROR(21,"0021","[%s]的数字签名验证不通过"),
	PARSE_MODIFY_REQ_ERROR(22,"0022","key:[%s],请求体解析modify对象失败 "),
	PARSE_MODIFY_SQL_ERROR(23,"0023","数据库出错[%s] "),
	CREATE_OBJ_ERROR(24,"0024","[%s]生成object出错 "),
	CHANGET_OBJ_REQ_ERROR(25,"0025","[%s]对请求报文进行GBK转换失败 "),
	CHANGET_OBJ_RESP_ERROR(26,"0026","[%s]对响应报文进行Utf-8转换失败 "),
	REQ_VALIDATA_LOST_ERROR(27,"0027","请求报文的验证失败,原因是:[%s]"),
	REST_GET_REQ_NULL_ERROR(28,"0028","Rest的Get请求报文是null"),
	REST_GET_PATH_NULL_ERROR(29,"0029","Rest的Get的path是null"),
	REST_GET_USERINFO_NULL(30,"0030","請求報文中用戶名或者密碼爲null"),
	REST_GET_USERINFO_DB_NULL(31,"0031","用戶名或者密碼不正確"),
	REST_VERIFY_CODE(32,"0032","該請求的驗證碼:[%s],失效或者不可能"),
	REST_XML_TO_JSON_CODE(33,"0033","转换的响应报文为null"),
	REST_XML_TO_JSON_RESP(34,"0034","转换的响应报文转换为json为null"),
	REST_REDIS_NULL(35,"0035","redis的请求报文是null"),
	REST_REQ_COMMAND_NULL(36,"0036","key:[%s],没有配置"),
	REST_REDIS_CLIENT_ERROR(37,"0037","ip:[%s],port:[%s],没有链接成功"),
	DB_NO_MATCH_ERROR(38,"0037","此操作现在不支持"),
	DB_NULL_ERROR(39,"0039","[%s],domain,example,mapper中，一个或者是null"),
	DB_INSERT_ERROR(40,"0040","[%s],不能插入，因为记录已经存在"),
	DB_UPDATE_ERROR(41,"0041","[%s],不能更新，因为记录不存在或者操作失败"),
	DB_DELETE_ERROR(42,"0042","[%s],不能删除，因为记录不存在或者操作失败"),
	DB_MOD_ERROR(43,"0043","[%s],此次操作的影响条数是0"),
	DB_SIGN_ERROR(44,"0044","报文中的请求表名或者操作标志错误"),
	DB_KEY_ERROR(45,"0045","实体类中没有主键标志，不支持此业务"),
	REST_REQ_CONTEXT_ERROR(46,"0046","查询结果为null"),
	REST_RSP_CONTEXT_ERROR(47,"0047","查询结果转换json报文失败"),
	LOG_CONTEXT_METHOD_ERROR(48,"0048","没有查找到日志表对应的mapper方法"),
	LOG_CONTEXT_CREATETABLE_ERROR(49,"0049","生成日志表失败"),
	LOG_CONTEXT_CREATETABLEMETHOD_ERROR(50,"0050","没有查找到生成日志表的mapper方法"),
	LOG_CONTEXT_INSERTMETHOD_ERROR(50,"0050","没有查找到插入日志表的mapper方法"),
	SERVICE_INSERTMETHOD_ERROR(51,"0051","没有查找出来相关的业务处理策略"),
	REST_REDIS_BATCH_TEXT_ERROR(52,"0052","数据从redis取出后，拼装批量json报文失败"),;
	private String code;

	public String getCode() {
		return code;
	}

	private int id;

	private String description;

	
	private InterStatusCode(int id , String code, String description) {
		this.code = code;
		this.id=id;
		this.description=description;
	}

	
	public static InterStatusCode getOperType(String code) {
		EnumSet<InterStatusCode> operTypes = EnumSet.allOf(InterStatusCode.class);
		for (InterStatusCode operType : operTypes) {
			if (operType.code.equals(code)) {
				return operType;
			}
		}
		return null ;
	}


	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	private String tempString;

	public String getTempString() {
		return tempString;
	}


	public void setTempString(String tempString) {
		this.tempString = tempString;
	} 

}
