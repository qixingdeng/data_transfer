package cn.cttic.roadtransapi.orm.roadway.domain;

import cn.cttic.roadtransapi.common.UnionPrimaryKeyAttr;

public class RtBfC0103 {
    
	@UnionPrimaryKeyAttr
    private String signId;

    
    private String operLineId;

    
    private String signCode;

    
    private String plateColor;

    
    private String vehicleNo;

    
    private String signType;

    
    private Integer validDate;

    
    private Integer expireDate;

    
    private Integer issueDate;

    
    @UnionPrimaryKeyAttr
    private Integer provinceCode;

    
    private String operTime;

    
    public String getSignId() {
        return signId;
    }

    
    public void setSignId(String signId) {
        this.signId = signId == null ? null : signId.trim();
    }

    
    public String getOperLineId() {
        return operLineId;
    }

    
    public void setOperLineId(String operLineId) {
        this.operLineId = operLineId == null ? null : operLineId.trim();
    }

    
    public String getSignCode() {
        return signCode;
    }

    
    public void setSignCode(String signCode) {
        this.signCode = signCode == null ? null : signCode.trim();
    }

    
    public String getPlateColor() {
        return plateColor;
    }

    
    public void setPlateColor(String plateColor) {
        this.plateColor = plateColor == null ? null : plateColor.trim();
    }

    
    public String getVehicleNo() {
        return vehicleNo;
    }

    
    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo == null ? null : vehicleNo.trim();
    }

    
    public String getSignType() {
        return signType;
    }

    
    public void setSignType(String signType) {
        this.signType = signType == null ? null : signType.trim();
    }

    
    public Integer getValidDate() {
        return validDate;
    }

    
    public void setValidDate(Integer validDate) {
        this.validDate = validDate;
    }

    
    public Integer getExpireDate() {
        return expireDate;
    }

    
    public void setExpireDate(Integer expireDate) {
        this.expireDate = expireDate;
    }

    
    public Integer getIssueDate() {
        return issueDate;
    }

    
    public void setIssueDate(Integer issueDate) {
        this.issueDate = issueDate;
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
}