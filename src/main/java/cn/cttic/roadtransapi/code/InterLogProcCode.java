package cn.cttic.roadtransapi.code;

import java.util.EnumSet;


public enum InterLogProcCode {
	ALL_STEP(0,"ALL_STEP", "全部统计流程"),
	RECEIVE_REQ_STEP(1,"RECEIVE_REQ_STEP", "接收请求报文阶段"),
	RECEIVE_REQ_SERIALIZE_STEP(2,"RECEIVE_REQ_SERIALIZE_STEP", "接收请求报文序列化对象阶段"),
	REQ_SIGNATURE_STEP(2,"REQ_SIGNATURE_STEP","对请求报文进行验证阶段"),
	TRANSFORM_REQ_STEP (3,"TRANSFORM_REQ_STEP", "通过xml模板对请求报文转换阶段"),
	ADAPTER_PROCESS_STEP(4,"ADAPTER_PROCESS_STEP", "使用对应的适配器进行业务处理"),
	APAPTER_DETAIL_STEP(5,"APAPTER_DETAIL_STEP","具体适配器业务处理阶段"),
	TRANSFORM_RESP_STEP(6,"TRANSFORM_RESP_STEP","对响应报文进行转换阶段"),
	SEND_RESP_UNSERIALIZE_STEP(7,"SEND_RESP_UNSERIALIZE_STEP","对外发送的报文的对象阶段"),
	SEND_RESP_STEP(7,"SEND_RESP_STEP","对外发送的报文的阶段");
	
	private String code;

	public String getCode() {
		return code;
	}

	private int id;

	private String description;

	public void setDescription(String description) {
		this.description = description;
	}


	private InterLogProcCode(int id , String code, String description) {
		this.code = code;
		this.id=id;
		this.description=description;
	}

	
	public static InterLogProcCode getOperType(String code) {
		EnumSet<InterLogProcCode> operTypes = EnumSet.allOf(InterLogProcCode.class);
		for (InterLogProcCode operType : operTypes) {
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

}
