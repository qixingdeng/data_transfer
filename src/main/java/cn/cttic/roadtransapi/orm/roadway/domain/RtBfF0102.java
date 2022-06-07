package cn.cttic.roadtransapi.orm.roadway.domain;

import cn.cttic.roadtransapi.common.UnionPrimaryKeyAttr;

public class RtBfF0102 {
    
    private Integer punishDate;

    
    private String punishType;

    
    private String punishTypeCode;

    
    private String fineAmount;

    
    private String scoring;

    
    @UnionPrimaryKeyAttr
    private String caseRegNo;

    
    private String operTime;

    
    @UnionPrimaryKeyAttr
    private Integer provinceCode;

    
    private String roadOwnerName;

    
    private String licenseCode;

    
    private String partyName;

    
    private String certificateCode;

    
    public Integer getPunishDate() {
        return punishDate;
    }

    
    public void setPunishDate(Integer punishDate) {
        this.punishDate = punishDate;
    }

    
    public String getPunishType() {
        return punishType;
    }

    
    public void setPunishType(String punishType) {
        this.punishType = punishType == null ? null : punishType.trim();
    }

    
    public String getPunishTypeCode() {
        return punishTypeCode;
    }

    
    public void setPunishTypeCode(String punishTypeCode) {
        this.punishTypeCode = punishTypeCode == null ? null : punishTypeCode.trim();
    }

    
    public String getFineAmount() {
        return fineAmount;
    }

    
    public void setFineAmount(String fineAmount) {
        this.fineAmount = fineAmount == null ? null : fineAmount.trim();
    }

    
    public String getScoring() {
        return scoring;
    }

    
    public void setScoring(String scoring) {
        this.scoring = scoring == null ? null : scoring.trim();
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

    
    public String getRoadOwnerName() {
        return roadOwnerName;
    }

    
    public void setRoadOwnerName(String roadOwnerName) {
        this.roadOwnerName = roadOwnerName == null ? null : roadOwnerName.trim();
    }

    
    public String getLicenseCode() {
        return licenseCode;
    }

    
    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode == null ? null : licenseCode.trim();
    }

    
    public String getPartyName() {
        return partyName;
    }

    
    public void setPartyName(String partyName) {
        this.partyName = partyName == null ? null : partyName.trim();
    }

    
    public String getCertificateCode() {
        return certificateCode;
    }

    
    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode == null ? null : certificateCode.trim();
    }
}