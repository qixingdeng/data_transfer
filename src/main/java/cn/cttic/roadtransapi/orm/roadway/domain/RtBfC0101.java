package cn.cttic.roadtransapi.orm.roadway.domain;

import cn.cttic.roadtransapi.common.UnionPrimaryKeyAttr;

public class RtBfC0101 {
    
    private String lineId;

    
    private String lineZone;

    
    private String lineZoneCode;

    
    private String lineTransPlace;

    
    private String lineMileage;

    
    private String lineHighspeedMileage;

    
    @UnionPrimaryKeyAttr
    private String phyLineId;

    
    @UnionPrimaryKeyAttr
    private Integer provinceCode;

    
    private String operTime;

    
    private String startStation;

    
    private Integer startStationZone;

    
    private String endStation;

    
    private Integer endStationZone;

    
    public String getLineId() {
        return lineId;
    }

    
    public void setLineId(String lineId) {
        this.lineId = lineId == null ? null : lineId.trim();
    }

    
    public String getLineZone() {
        return lineZone;
    }

    
    public void setLineZone(String lineZone) {
        this.lineZone = lineZone == null ? null : lineZone.trim();
    }

    
    public String getLineZoneCode() {
        return lineZoneCode;
    }

    
    public void setLineZoneCode(String lineZoneCode) {
        this.lineZoneCode = lineZoneCode == null ? null : lineZoneCode.trim();
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

    
    public String getLineHighspeedMileage() {
        return lineHighspeedMileage;
    }

    
    public void setLineHighspeedMileage(String lineHighspeedMileage) {
        this.lineHighspeedMileage = lineHighspeedMileage == null ? null : lineHighspeedMileage.trim();
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
}