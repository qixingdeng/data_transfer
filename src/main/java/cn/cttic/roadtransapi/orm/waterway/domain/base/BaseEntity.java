package cn.cttic.roadtransapi.orm.waterway.domain.base;

import java.util.Date;
import java.util.EnumSet;

import cn.cttic.sysframe.common.exception.SystemException;
import cn.cttic.sysframe.common.util.SpringContextUtil;

public abstract class BaseEntity {

	public static <E> E getMapper(Class<E> mapperClass) {
		return (E) SpringContextUtil.getBean(mapperClass);
	}

	public enum OperType {
		KIP("0"), ADD("1"), UPDATE("2"), DELETE("3");

		private String code;

		private OperType(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

		public static OperType getOperType(String code) {
			EnumSet<OperType> operTypes = EnumSet.allOf(OperType.class);
			for (OperType operType : operTypes) {
				if (operType.code.equals(code)) {
					return operType;
				}
			}
			return KIP;
		}

	}

	protected String operType;// 操作类型

	protected Date createDate;// 创建日期

	protected String orgId;// 创建组织

	protected String creator;// 创建人

	protected String state;// 工单状态

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	// 反序列化是，统一赋值Date
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

}
