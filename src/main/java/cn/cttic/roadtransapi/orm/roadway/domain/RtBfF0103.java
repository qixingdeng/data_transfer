package cn.cttic.roadtransapi.orm.roadway.domain;

import cn.cttic.roadtransapi.common.UnionPrimaryKeyAttr;

public class RtBfF0103 {
    
    private String closingReason;

    
    private String implementation;

    
    private Integer closingDate;

    
    @UnionPrimaryKeyAttr
    private String caseRegNo;

    
    private String operTime;

    
    @UnionPrimaryKeyAttr
    private Integer provinceCode;

    
    public String getClosingReason() {
        return closingReason;
    }

    
    public void setClosingReason(String closingReason) {
        this.closingReason = closingReason == null ? null : closingReason.trim();
    }

    
    public String getImplementation() {
        return implementation;
    }

    
    public void setImplementation(String implementation) {
        this.implementation = implementation == null ? null : implementation.trim();
    }

    
    public Integer getClosingDate() {
        return closingDate;
    }

    
    public void setClosingDate(Integer closingDate) {
        this.closingDate = closingDate;
    }

    
    public String getCaseRegNo() {
        return caseRegNo;
    }

    
    public void setCaseRegNo(String caseRegNo) {
        this.caseRegNo = caseRegNo == null ? null : caseRegNo.trim();
    }

    
    public String getOperTime() {
        return operTime;
    }

    
    public void setOperTime(String operTime) {
        this.operTime = operTime == null ? null : operTime.trim();
    }

    
    public Integer getProvinceCode() {
        return provinceCode;
    }

    
    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }
}