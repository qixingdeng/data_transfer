package cn.cttic.roadtransapi.orm.roadway.domain;

import java.util.Date;

public class DwBaseinfoLineOperating {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.ID
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.PROVINCE_CODE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private Integer provinceCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.PHY_LINE_ID
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String phyLineId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.OPER_LINE_ID
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String operLineId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.OPER_LINE_NAME
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String operLineName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.OWNER_ID
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String ownerId;
    
    private String ownerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.LINE_OP_TYPE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String lineOpType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.LINE_OP_TYPE_CODE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String lineOpTypeCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.START_STATION
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String startStation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.START_STATION_ZONE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private Long startStationZone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.END_STATION
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String endStation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.END_STATION_ZONE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private Long endStationZone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.LINE_TRANS_PLACE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String lineTransPlace;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.LINE_FREQUENCY
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private Integer lineFrequency;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.LINE_MILEAGE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private Long lineMileage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.LINE_HIGHWAY_MILEAGE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private Long lineHighwayMileage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.LINE_OPER_ZONE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String lineOperZone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.LINE_OPER_ZONE_CODE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String lineOperZoneCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.IS_COUNTRY_LINE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String isCountryLine;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.LINE_OP_STATUS
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String lineOpStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.LINE_OP_STATUS_CODE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private String lineOpStatusCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.LINE_VALID_DATE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private Date lineValidDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.LINE_EXPIRE_DATE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private Date lineExpireDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column DW_BASEINFO_LINE_OPERATING.ISSUE_DATE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    private Date issueDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.ID
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.ID
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.ID
     *
     * @param id the value for DW_BASEINFO_LINE_OPERATING.ID
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.PROVINCE_CODE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.PROVINCE_CODE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public Integer getProvinceCode() {
        return provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.PROVINCE_CODE
     *
     * @param provinceCode the value for DW_BASEINFO_LINE_OPERATING.PROVINCE_CODE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.PHY_LINE_ID
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.PHY_LINE_ID
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getPhyLineId() {
        return phyLineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.PHY_LINE_ID
     *
     * @param phyLineId the value for DW_BASEINFO_LINE_OPERATING.PHY_LINE_ID
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setPhyLineId(String phyLineId) {
        this.phyLineId = phyLineId == null ? null : phyLineId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.OPER_LINE_ID
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.OPER_LINE_ID
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getOperLineId() {
        return operLineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.OPER_LINE_ID
     *
     * @param operLineId the value for DW_BASEINFO_LINE_OPERATING.OPER_LINE_ID
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setOperLineId(String operLineId) {
        this.operLineId = operLineId == null ? null : operLineId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.OPER_LINE_NAME
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.OPER_LINE_NAME
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getOperLineName() {
        return operLineName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.OPER_LINE_NAME
     *
     * @param operLineName the value for DW_BASEINFO_LINE_OPERATING.OPER_LINE_NAME
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setOperLineName(String operLineName) {
        this.operLineName = operLineName == null ? null : operLineName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.OWNER_ID
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.OWNER_ID
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.OWNER_ID
     *
     * @param ownerId the value for DW_BASEINFO_LINE_OPERATING.OWNER_ID
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }
    
    

    /**
	 * @return the ownerName
	 */
	public String getOwnerName()
	{
		return ownerName;
	}

	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName)
	{
		this.ownerName = ownerName;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_OP_TYPE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.LINE_OP_TYPE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getLineOpType() {
        return lineOpType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_OP_TYPE
     *
     * @param lineOpType the value for DW_BASEINFO_LINE_OPERATING.LINE_OP_TYPE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setLineOpType(String lineOpType) {
        this.lineOpType = lineOpType == null ? null : lineOpType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_OP_TYPE_CODE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.LINE_OP_TYPE_CODE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getLineOpTypeCode() {
        return lineOpTypeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_OP_TYPE_CODE
     *
     * @param lineOpTypeCode the value for DW_BASEINFO_LINE_OPERATING.LINE_OP_TYPE_CODE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setLineOpTypeCode(String lineOpTypeCode) {
        this.lineOpTypeCode = lineOpTypeCode == null ? null : lineOpTypeCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.START_STATION
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.START_STATION
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getStartStation() {
        return startStation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.START_STATION
     *
     * @param startStation the value for DW_BASEINFO_LINE_OPERATING.START_STATION
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setStartStation(String startStation) {
        this.startStation = startStation == null ? null : startStation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.START_STATION_ZONE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.START_STATION_ZONE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public Long getStartStationZone() {
        return startStationZone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.START_STATION_ZONE
     *
     * @param startStationZone the value for DW_BASEINFO_LINE_OPERATING.START_STATION_ZONE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setStartStationZone(Long startStationZone) {
        this.startStationZone = startStationZone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.END_STATION
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.END_STATION
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getEndStation() {
        return endStation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.END_STATION
     *
     * @param endStation the value for DW_BASEINFO_LINE_OPERATING.END_STATION
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setEndStation(String endStation) {
        this.endStation = endStation == null ? null : endStation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.END_STATION_ZONE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.END_STATION_ZONE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public Long getEndStationZone() {
        return endStationZone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.END_STATION_ZONE
     *
     * @param endStationZone the value for DW_BASEINFO_LINE_OPERATING.END_STATION_ZONE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setEndStationZone(Long endStationZone) {
        this.endStationZone = endStationZone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_TRANS_PLACE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.LINE_TRANS_PLACE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getLineTransPlace() {
        return lineTransPlace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_TRANS_PLACE
     *
     * @param lineTransPlace the value for DW_BASEINFO_LINE_OPERATING.LINE_TRANS_PLACE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setLineTransPlace(String lineTransPlace) {
        this.lineTransPlace = lineTransPlace == null ? null : lineTransPlace.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_FREQUENCY
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.LINE_FREQUENCY
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public Integer getLineFrequency() {
        return lineFrequency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_FREQUENCY
     *
     * @param lineFrequency the value for DW_BASEINFO_LINE_OPERATING.LINE_FREQUENCY
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setLineFrequency(Integer lineFrequency) {
        this.lineFrequency = lineFrequency;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_MILEAGE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.LINE_MILEAGE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public Long getLineMileage() {
        return lineMileage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_MILEAGE
     *
     * @param lineMileage the value for DW_BASEINFO_LINE_OPERATING.LINE_MILEAGE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setLineMileage(Long lineMileage) {
        this.lineMileage = lineMileage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_HIGHWAY_MILEAGE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.LINE_HIGHWAY_MILEAGE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public Long getLineHighwayMileage() {
        return lineHighwayMileage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_HIGHWAY_MILEAGE
     *
     * @param lineHighwayMileage the value for DW_BASEINFO_LINE_OPERATING.LINE_HIGHWAY_MILEAGE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setLineHighwayMileage(Long lineHighwayMileage) {
        this.lineHighwayMileage = lineHighwayMileage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_OPER_ZONE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.LINE_OPER_ZONE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getLineOperZone() {
        return lineOperZone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_OPER_ZONE
     *
     * @param lineOperZone the value for DW_BASEINFO_LINE_OPERATING.LINE_OPER_ZONE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setLineOperZone(String lineOperZone) {
        this.lineOperZone = lineOperZone == null ? null : lineOperZone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_OPER_ZONE_CODE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.LINE_OPER_ZONE_CODE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getLineOperZoneCode() {
        return lineOperZoneCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_OPER_ZONE_CODE
     *
     * @param lineOperZoneCode the value for DW_BASEINFO_LINE_OPERATING.LINE_OPER_ZONE_CODE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setLineOperZoneCode(String lineOperZoneCode) {
        this.lineOperZoneCode = lineOperZoneCode == null ? null : lineOperZoneCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.IS_COUNTRY_LINE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.IS_COUNTRY_LINE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getIsCountryLine() {
        return isCountryLine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.IS_COUNTRY_LINE
     *
     * @param isCountryLine the value for DW_BASEINFO_LINE_OPERATING.IS_COUNTRY_LINE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setIsCountryLine(String isCountryLine) {
        this.isCountryLine = isCountryLine == null ? null : isCountryLine.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_OP_STATUS
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.LINE_OP_STATUS
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getLineOpStatus() {
        return lineOpStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_OP_STATUS
     *
     * @param lineOpStatus the value for DW_BASEINFO_LINE_OPERATING.LINE_OP_STATUS
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setLineOpStatus(String lineOpStatus) {
        this.lineOpStatus = lineOpStatus == null ? null : lineOpStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_OP_STATUS_CODE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.LINE_OP_STATUS_CODE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getLineOpStatusCode() {
        return lineOpStatusCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_OP_STATUS_CODE
     *
     * @param lineOpStatusCode the value for DW_BASEINFO_LINE_OPERATING.LINE_OP_STATUS_CODE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setLineOpStatusCode(String lineOpStatusCode) {
        this.lineOpStatusCode = lineOpStatusCode == null ? null : lineOpStatusCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_VALID_DATE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.LINE_VALID_DATE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public Date getLineValidDate() {
        return lineValidDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_VALID_DATE
     *
     * @param lineValidDate the value for DW_BASEINFO_LINE_OPERATING.LINE_VALID_DATE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setLineValidDate(Date lineValidDate) {
        this.lineValidDate = lineValidDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_EXPIRE_DATE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.LINE_EXPIRE_DATE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public Date getLineExpireDate() {
        return lineExpireDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.LINE_EXPIRE_DATE
     *
     * @param lineExpireDate the value for DW_BASEINFO_LINE_OPERATING.LINE_EXPIRE_DATE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setLineExpireDate(Date lineExpireDate) {
        this.lineExpireDate = lineExpireDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column DW_BASEINFO_LINE_OPERATING.ISSUE_DATE
     *
     * @return the value of DW_BASEINFO_LINE_OPERATING.ISSUE_DATE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public Date getIssueDate() {
        return issueDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column DW_BASEINFO_LINE_OPERATING.ISSUE_DATE
     *
     * @param issueDate the value for DW_BASEINFO_LINE_OPERATING.ISSUE_DATE
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
}