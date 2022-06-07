package cn.cttic.roadtransapi.common;

/**
 * 
 * 工单处理的一些常量. <br>
 * 
 * @author guoshouzhong@cttic.cn
 * @date 2014年12月3日 上午11:51:35 <br>
 *       Copyright: Copyright (c) 2014 CTTIC
 */
public class OrderDomain {

	public static final String ORD_DOMAIN_PACKAGE_NAME = "cn.cttic.wtms.common.order.domain";

	public static final String ORD_DAO_PACKAGE_NAME = "cn.cttic.wtms.common.order.dao";

	public static final String ORD_MODEL_PACKAGE_NAME = "cn.cttic.wtms.common.order.model";

	public static final String SHIP_DAO_PACKAGE_NAME = "cn.cttic.wtms.common.ship.dao";

	public static final String SHIP_DOMAIN_PACKAGE_NAME = "cn.cttic.wtms.common.ship.domain";

	public static final String BUSI_DAO_PACKAGE_NAME = "cn.cttic.wtms.common.business.dao";

	public static final String BUSI_DOMAIN_PACKAGE_NAME = "cn.cttic.wtms.common.business.domain";

	public static final String CERTIFICATE_DAO_PACKAGE_NAME = "cn.cttic.wtms.common.certificate.dao";

	public static final String CERTIFICATE_DOMAIN_PACKAGE_NAME = "cn.cttic.wtms.common.certificate.domain";
	
	public static final String PORT_DAO_PACKAGE_NAME = "cn.cttic.wtms.approval.port.dao";

	public static final String PORT_DOMAIN_PACKAGE_NAME = "cn.cttic.wtms.approval.port.domain";

	public static final String[] JAVA_BASE_TYPE_ARRAY = new String[] { "String", "long", "int", "Integer", "Long" };

	public static final String[] ALL_JAVA_BASE_TYPE_ARRAY = new String[] { "OrderHeader", "orderHeader", "boolean", "Boolean", "String", "long","int", "Integer", "Long", "Date", "BigDecimal", "Short", "Char" };

	public static final String[] FIELD_NAME_TYPE_ARRAY = new String[] { "orderHeader", "enterpriseOrderInfo", "shipOrderInfo","certificateOrderInfo", "portOrderInfo" };

	public static final String FIELD_BUSI_ORD_ID = "getBusiOrdId";

	public static final String CRITERIA_OR_METHOD_NAME = "or";

	public static final String EQUAL_BUSI_ORD_ID_METHOD_NAME = "andBusiOrdIdEqualTo";

	public static final String SELECT_BY_EXAMPLE_METHOD_NAME = "selectByExample";

	public static final String GET_OPER_TYPE_METHOD_NAME = "getOperType";

	public static final String BUSI_ORD_ID_FIELD = "busiOrdId";

	public static final String ORD_CLASS_NAME_FIELD = "ordClassName";

	public static final String CONST_TEMP_BUSI_TYPE = "1034";

	public static final String CONST_BIZ_PERIOD = "bizPeriod";

	public static final String CONST_ISSUE_DATE = "issueDate";

	public static final int CONST_BIZ_PERIOD_YEAR_DOMESTIC = 5;// 证书默认经营期限5年

	public static final int CONST_BIZ_PERIOD_YEAR_INTERNATIONAL = 3;// 国际 证书默认经营期限3年

	public static final int CONST_BIZ_PERIOD_YEAR_TAIWAN = 3;// 海峡 证书默认经营期限3年

	public static final int CONST_BIZ_PERIOD_MONTH = 3;// 国内水路运输企业船舶临时营运证申领 ,默认3个月

	public static final String ORDER_INSERT_FLAG_I = "INSERT";

	public static final String ORDER_INSERT_FLAG_U = "UPDATE";

	public static final String ORDER_INSERT_FLAG_D = "DELETE";

	public static final String CONST_DEFAULT_ORG_ID = "1001"; // 默认组织

	public static final String CONST_DEFAULT_CREATOR = "SYSTEM"; // 默认创建人

}
