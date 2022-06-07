package cn.cttic.roadtransapi.orm.roadway.domain;

import cn.cttic.roadtransapi.common.UnionPrimaryKeyAttr;

public class RtBfF0101 {
    
	@UnionPrimaryKeyAttr
    private String caseRegNo;

    
    private String caseSource;

    
    private String caseReason;

    
    private String caseSourceCode;

    
    private String casePunishProcess;

    
    private String punishParty;

    
    private String partyName;

    
    private String certificateCode;

    
    private String roadOwnerName;

    
    private String ownerId;

    
    private String licenseCode;

    
    private Integer illegalDate;

    
    private String illegalSites;

    
    private String illegalType;

    
    private String illegalContent;

    
    private String vehicleNo;

    
    private String plateColorId;

    
    private String vehicleNative;

    
    private Integer registerDate;

    
    private String idCard;

    
    private String illegalTypeCode;

    
    @UnionPrimaryKeyAttr
    private Integer provinceCode;

    
    private String operTime;

    
    public String getCaseRegNo() {
        return caseRegNo;
    }

    
    public void setCaseRegNo(String caseRegNo) {
        this.caseRegNo = caseRegNo == null ? null : caseRegNo.trim();
    }

    
    public String getCaseSource() {
        return caseSource;
    }

    
    public void setCaseSource(String caseSource) {
        this.caseSource = caseSource == null ? null : caseSource.trim();
    }

    
    public String getCaseReason() {
        return caseReason;
    }

    
    public void setCaseReason(String caseReason) {
        this.caseReason = caseReason == null ? null : caseReason.trim();
    }

    
    public String getCaseSourceCode() {
        return caseSourceCode;
    }

    
    public void setCaseSourceCode(String caseSourceCode) {
        this.caseSourceCode = caseSourceCode == null ? null : caseSourceCode.trim();
    }

    
    public String getCasePunishProcess() {
        return casePunishProcess;
    }

    
    public void setCasePunishProcess(String casePunishProcess) {
        this.casePunishProcess = casePunishProcess == null ? null : casePunishProcess.trim();
    }

    
    public String getPunishParty() {
        return punishParty;
    }

    
    public void setPunishParty(String punishParty) {
        this.punishParty = punishParty == null ? null : punishParty.trim();
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

    
    public String getRoadOwnerName() {
        return roadOwnerName;
    }

    
    public void setRoadOwnerName(String roadOwnerName) {
        this.roadOwnerName = roadOwnerName == null ? null : roadOwnerName.trim();
    }

    
    public String getOwnerId() {
        return ownerId;
    }

    
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    
    public String getLicenseCode() {
        return licenseCode;
    }

    
    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode == null ? null : licenseCode.trim();
    }

    
    public Integer getIllegalDate() {
        return illegalDate;
    }

    
    public void setIllegalDate(Integer illegalDate) {
        this.illegalDate = illegalDate;
    }

    
    public String getIllegalSites() {
        return illegalSites;
    }

    
    public void setIllegalSites(String illegalSites) {
        this.illegalSites = illegalSites == null ? null : illegalSites.trim();
    }

    
    public String getIllegalType() {
        return illegalType;
    }

    
    public void setIllegalType(String illegalType) {
        this.illegalType = illegalType == null ? null : illegalType.trim();
    }

    
    public String getIllegalContent() {
        return illegalContent;
    }

    
    public void setIllegalContent(String illegalContent) {
        this.illegalContent = illegalContent == null ? null : illegalContent.trim();
    }

    
    public String getVehicleNo() {
        return vehicleNo;
    }

    
    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo == null ? null : vehicleNo.trim();
    }

    
    public String getPlateColorId() {
        return plateColorId;
    }

    
    public void setPlateColorId(String plateColorId) {
        this.plateColorId = plateColorId == null ? null : plateColorId.trim();
    }

    
    public String getVehicleNative() {
        return vehicleNative;
    }

    
    public void setVehicleNative(String vehicleNative) {
        this.vehicleNative = vehicleNative == null ? null : vehicleNative.trim();
    }

    
    public Integer getRegisterDate() {
        return registerDate;
    }

    
    public void setRegisterDate(Integer registerDate) {
        this.registerDate = registerDate;
    }

    
    public String getIdCard() {
        return idCard;
    }

    
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    
    public String getIllegalTypeCode() {
        return illegalTypeCode;
    }

    
    public void setIllegalTypeCode(String illegalTypeCode) {
        this.illegalTypeCode = illegalTypeCode == null ? null : illegalTypeCode.trim();
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