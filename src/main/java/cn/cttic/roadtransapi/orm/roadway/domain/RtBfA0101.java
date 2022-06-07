package cn.cttic.roadtransapi.orm.roadway.domain;

import cn.cttic.roadtransapi.common.UnionPrimaryKeyAttr;

public class RtBfA0101 {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RT_BF_A0101.PROVINCE_CODE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
	@UnionPrimaryKeyAttr
    private Integer provinceCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RT_BF_A0101.OWNER_ID
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
	
	@UnionPrimaryKeyAttr
    private String ownerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RT_BF_A0101.OWNER_NAME
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    private String ownerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RT_BF_A0101.OWNER_ADDER
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    private String ownerAdder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RT_BF_A0101.ORGANIZATION_CODE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    private String organizationCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RT_BF_A0101.PARENT_OWNER_NAME
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    private String parentOwnerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RT_BF_A0101.NATIVE_AREA_CODE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    private Integer nativeAreaCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RT_BF_A0101.PRINCIPAL_NAME
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    private String principalName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RT_BF_A0101.PRINCIPAL_TELEPHONE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    private String principalTelephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RT_BF_A0101.PRINCIPAL_CELLPHONE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    private String principalCellphone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RT_BF_A0101.OPERATING_STATUS
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    private String operatingStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RT_BF_A0101.OPERATING_CODE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    private String operatingCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RT_BF_A0101.ECONOMIC_TYPE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    private String economicType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column RT_BF_A0101.OPER_TIME
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    private String operTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RT_BF_A0101.PROVINCE_CODE
     *
     * @return the value of RT_BF_A0101.PROVINCE_CODE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public Integer getProvinceCode() {
        return provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RT_BF_A0101.PROVINCE_CODE
     *
     * @param provinceCode the value for RT_BF_A0101.PROVINCE_CODE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RT_BF_A0101.OWNER_ID
     *
     * @return the value of RT_BF_A0101.OWNER_ID
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RT_BF_A0101.OWNER_ID
     *
     * @param ownerId the value for RT_BF_A0101.OWNER_ID
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RT_BF_A0101.OWNER_NAME
     *
     * @return the value of RT_BF_A0101.OWNER_NAME
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RT_BF_A0101.OWNER_NAME
     *
     * @param ownerName the value for RT_BF_A0101.OWNER_NAME
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RT_BF_A0101.OWNER_ADDER
     *
     * @return the value of RT_BF_A0101.OWNER_ADDER
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public String getOwnerAdder() {
        return ownerAdder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RT_BF_A0101.OWNER_ADDER
     *
     * @param ownerAdder the value for RT_BF_A0101.OWNER_ADDER
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setOwnerAdder(String ownerAdder) {
        this.ownerAdder = ownerAdder == null ? null : ownerAdder.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RT_BF_A0101.ORGANIZATION_CODE
     *
     * @return the value of RT_BF_A0101.ORGANIZATION_CODE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public String getOrganizationCode() {
        return organizationCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RT_BF_A0101.ORGANIZATION_CODE
     *
     * @param organizationCode the value for RT_BF_A0101.ORGANIZATION_CODE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode == null ? null : organizationCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RT_BF_A0101.PARENT_OWNER_NAME
     *
     * @return the value of RT_BF_A0101.PARENT_OWNER_NAME
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public String getParentOwnerName() {
        return parentOwnerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RT_BF_A0101.PARENT_OWNER_NAME
     *
     * @param parentOwnerName the value for RT_BF_A0101.PARENT_OWNER_NAME
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setParentOwnerName(String parentOwnerName) {
        this.parentOwnerName = parentOwnerName == null ? null : parentOwnerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RT_BF_A0101.NATIVE_AREA_CODE
     *
     * @return the value of RT_BF_A0101.NATIVE_AREA_CODE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public Integer getNativeAreaCode() {
        return nativeAreaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RT_BF_A0101.NATIVE_AREA_CODE
     *
     * @param nativeAreaCode the value for RT_BF_A0101.NATIVE_AREA_CODE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setNativeAreaCode(Integer nativeAreaCode) {
        this.nativeAreaCode = nativeAreaCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RT_BF_A0101.PRINCIPAL_NAME
     *
     * @return the value of RT_BF_A0101.PRINCIPAL_NAME
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public String getPrincipalName() {
        return principalName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RT_BF_A0101.PRINCIPAL_NAME
     *
     * @param principalName the value for RT_BF_A0101.PRINCIPAL_NAME
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setPrincipalName(String principalName) {
        this.principalName = principalName == null ? null : principalName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RT_BF_A0101.PRINCIPAL_TELEPHONE
     *
     * @return the value of RT_BF_A0101.PRINCIPAL_TELEPHONE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public String getPrincipalTelephone() {
        return principalTelephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RT_BF_A0101.PRINCIPAL_TELEPHONE
     *
     * @param principalTelephone the value for RT_BF_A0101.PRINCIPAL_TELEPHONE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setPrincipalTelephone(String principalTelephone) {
        this.principalTelephone = principalTelephone == null ? null : principalTelephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RT_BF_A0101.PRINCIPAL_CELLPHONE
     *
     * @return the value of RT_BF_A0101.PRINCIPAL_CELLPHONE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public String getPrincipalCellphone() {
        return principalCellphone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RT_BF_A0101.PRINCIPAL_CELLPHONE
     *
     * @param principalCellphone the value for RT_BF_A0101.PRINCIPAL_CELLPHONE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setPrincipalCellphone(String principalCellphone) {
        this.principalCellphone = principalCellphone == null ? null : principalCellphone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RT_BF_A0101.OPERATING_STATUS
     *
     * @return the value of RT_BF_A0101.OPERATING_STATUS
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public String getOperatingStatus() {
        return operatingStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RT_BF_A0101.OPERATING_STATUS
     *
     * @param operatingStatus the value for RT_BF_A0101.OPERATING_STATUS
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setOperatingStatus(String operatingStatus) {
        this.operatingStatus = operatingStatus == null ? null : operatingStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RT_BF_A0101.OPERATING_CODE
     *
     * @return the value of RT_BF_A0101.OPERATING_CODE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public String getOperatingCode() {
        return operatingCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RT_BF_A0101.OPERATING_CODE
     *
     * @param operatingCode the value for RT_BF_A0101.OPERATING_CODE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setOperatingCode(String operatingCode) {
        this.operatingCode = operatingCode == null ? null : operatingCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RT_BF_A0101.ECONOMIC_TYPE
     *
     * @return the value of RT_BF_A0101.ECONOMIC_TYPE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public String getEconomicType() {
        return economicType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RT_BF_A0101.ECONOMIC_TYPE
     *
     * @param economicType the value for RT_BF_A0101.ECONOMIC_TYPE
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setEconomicType(String economicType) {
        this.economicType = economicType == null ? null : economicType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column RT_BF_A0101.OPER_TIME
     *
     * @return the value of RT_BF_A0101.OPER_TIME
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public String getOperTime() {
        return operTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column RT_BF_A0101.OPER_TIME
     *
     * @param operTime the value for RT_BF_A0101.OPER_TIME
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setOperTime(String operTime) {
        this.operTime = operTime == null ? null : operTime.trim();
    }
}