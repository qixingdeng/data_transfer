package cn.cttic.roadtransapi.orm.roadway.domain;

import cn.cttic.roadtransapi.common.UnionPrimaryKeyAttr;

public class RtBfC0102 {
    
    private String lineId;

    
    private String lineTransPlace;

    
    private String lineMileage;

    
    private String phyLineId;

    
    @UnionPrimaryKeyAttr
    private Integer provinceCode;

    
    private String operTime;

    
    private String startStation;

    
    private Integer startStationZone;

    
    private String endStation;

    
    private Integer endStationZone;

    
    @UnionPrimaryKeyAttr
    private String operLineId;

    
    private String operLineName;

    
    private String ownerId;

    
    private String lineOpType;

    
    private String lineOpTypeCode;

    
    private String lineFrequency;

    
    private String lineExpresswayMileage;

    
    private String lineArea;

    
    private String lineAreaCode;

    
    private String countrysideFlag;

    
    private String lineOpStatus;

    
    private String lineOpStatusCode;

    
    private Integer lineValidBegin;

    
    private Integer lineValidEnd;

    
    private Integer issueDate;

    
    public String getLineId() {
        return lineId;
    }

    
    public void setLineId(String lineId) {
        this.lineId = lineId == null ? null : lineId.trim();
    }

    
    public String getLineTransPlace() {
        return lineTransPlace;
    }

    
    public void setLineTransPlace(String lineTransPlace) {
        this.lineTransPlace = lineTransPlace == null ? null : lineTransPlace.trim();
    }

    
    public String getLineMileage() {
        return lineMileage;
    }

    
    public void setLineMileage(String lineMileage) {
        this.lineMileage = lineMileage == null ? null : lineMileage.trim();
    }

    
    public String getPhyLineId() {
        return phyLineId;
    }

    
    public void setPhyLineId(String phyLineId) {
        this.phyLineId = phyLineId == null ? null : phyLineId.trim();
    }

    
    public Integer getProvinceCode() {
        return provinceCode;
    }

    
    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    
    public String getOperTime() {
        return operTime;
    }

    
    public void setOperTime(String operTime) {
        this.operTime = operTime == null ? null : operTime.trim();
    }

    
    public String getStartStation() {
        return startStation;
    }

    
    public void setStartStation(String startStation) {
        this.startStation = startStation == null ? null : startStation.trim();
    }

    
    public Integer getStartStationZone() {
        return startStationZone;
    }

    
    public void setStartStationZone(Integer startStationZone) {
        this.startStationZone = startStationZone;
    }

    
    public String getEndStation() {
        return endStation;
    }

    
    public void setEndStation(String endStation) {
        this.endStation = endStation == null ? null : endStation.trim();
    }

    
    public Integer getEndStationZone() {
        return endStationZone;
    }

    
    public void setEndStationZone(Integer endStationZone) {
        this.endStationZone = endStationZone;
    }

    
    public String getOperLineId() {
        return operLineId;
    }

    
    public void setOperLineId(String operLineId) {
        this.operLineId = operLineId == null ? null : operLineId.trim();
    }

    
    public String getOperLineName() {
        return operLineName;
    }

    
    public void setOperLineName(String operLineName) {
        this.operLineName = operLineName == null ? null : operLineName.trim();
    }

    
    public String getOwnerId() {
        return ownerId;
    }

    
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    
    public String getLineOpType() {
        return lineOpType;
    }

    
    public void setLineOpType(String lineOpType) {
        this.lineOpType = lineOpType == null ? null : lineOpType.trim();
    }

    
    public String getLineOpTypeCode() {
        return lineOpTypeCode;
    }

    
    public void setLineOpTypeCode(String lineOpTypeCode) {
        this.lineOpTypeCode = lineOpTypeCode == null ? null : lineOpTypeCode.trim();
    }

    
    public String getLineFrequency() {
        return lineFrequency;
    }

    
    public void setLineFrequency(String lineFrequency) {
        this.lineFrequency = lineFrequency == null ? null : lineFrequency.trim();
    }

    
    public String getLineExpresswayMileage() {
        return lineExpresswayMileage;
    }

    
    public void setLineExpresswayMileage(String lineExpresswayMileage) {
        this.lineExpresswayMileage = lineExpresswayMileage == null ? null : lineExpresswayMileage.trim();
    }

    
    public String getLineArea() {
        return lineArea;
    }

    
    public void setLineArea(String lineArea) {
        this.lineArea = lineArea == null ? null : lineArea.trim();
    }

    
    public String getLineAreaCode() {
        return lineAreaCode;
    }

    
    public void setLineAreaCode(String lineAreaCode) {
        this.lineAreaCode = lineAreaCode == null ? null : lineAreaCode.trim();
    }

    
    public String getCountrysideFlag() {
        return countrysideFlag;
    }

    
    public void setCountrysideFlag(String countrysideFlag) {
        this.countrysideFlag = countrysideFlag == null ? null : countrysideFlag.trim();
    }

    
    public String getLineOpStatus() {
        return lineOpStatus;
    }

    
    public void setLineOpStatus(String lineOpStatus) {
        this.lineOpStatus = lineOpStatus == null ? null : lineOpStatus.trim();
    }

    
    public String getLineOpStatusCode() {
        return lineOpStatusCode;
    }

    
    public void setLineOpStatusCode(String lineOpStatusCode) {
        this.lineOpStatusCode = lineOpStatusCode == null ? null : lineOpStatusCode.trim();
    }

    
    public Integer getLineValidBegin() {
        return lineValidBegin;
    }

    
    public void setLineValidBegin(Integer lineValidBegin) {
        this.lineValidBegin = lineValidBegin;
    }

    
    public Integer getLineValidEnd() {
        return lineValidEnd;
    }

    
    public void setLineValidEnd(Integer lineValidEnd) {
        this.lineValidEnd = lineValidEnd;
    }

    
    public Integer getIssueDate() {
        return issueDate;
    }

    
    public void setIssueDate(Integer issueDate) {
        this.issueDate = issueDate;
    }
}