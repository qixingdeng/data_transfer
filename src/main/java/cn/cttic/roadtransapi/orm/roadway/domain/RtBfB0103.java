package cn.cttic.roadtransapi.orm.roadway.domain;

import cn.cttic.roadtransapi.common.UnionPrimaryKeyAttr;

public class RtBfB0103 {
    
	@UnionPrimaryKeyAttr
    private Integer provinceCode;

    
	@UnionPrimaryKeyAttr
    private String mcuId;

    
    private String vehicleNo;

    
    private Short checkYear;

    
    private Short checkState;

    
    private Integer checkDate;

    
    private Integer expireDate;

    
    private Integer nextDate;

    
    private String plateColor;

    
    private String platecolorcode;

    
    private String operTime;

    
    public Integer getProvinceCode() {
        return provinceCode;
    }

    
    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    
    public String getMcuId() {
        return mcuId;
    }

    
    public void setMcuId(String mcuId) {
        this.mcuId = mcuId == null ? null : mcuId.trim();
    }

    
    public String getVehicleNo() {
        return vehicleNo;
    }

    
    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo == null ? null : vehicleNo.trim();
    }

    
    public Short getCheckYear() {
        return checkYear;
    }

    
    public void setCheckYear(Short checkYear) {
        this.checkYear = checkYear;
    }

    
    public Short getCheckState() {
        return checkState;
    }

    
    public void setCheckState(Short checkState) {
        this.checkState = checkState;
    }

    
    public Integer getCheckDate() {
        return checkDate;
    }

    
    public void setCheckDate(Integer checkDate) {
        this.checkDate = checkDate;
    }

    
    public Integer getExpireDate() {
        return expireDate;
    }

    
    public void setExpireDate(Integer expireDate) {
        this.expireDate = expireDate;
    }

    
    public Integer getNextDate() {
        return nextDate;
    }

    
    public void setNextDate(Integer nextDate) {
        this.nextDate = nextDate;
    }

    
    public String getPlateColor() {
        return plateColor;
    }

    
    public void setPlateColor(String plateColor) {
        this.plateColor = plateColor == null ? null : plateColor.trim();
    }

    
    public String getPlatecolorcode() {
        return platecolorcode;
    }

    
    public void setPlatecolorcode(String platecolorcode) {
        this.platecolorcode = platecolorcode == null ? null : platecolorcode.trim();
    }

    
    public String getOperTime() {
        return operTime;
    }

    
    public void setOperTime(String operTime) {
        this.operTime = operTime == null ? null : operTime.trim();
    }
}