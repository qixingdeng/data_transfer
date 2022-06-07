package cn.cttic.roadtransapi.orm.roadway.domain;

import cn.cttic.roadtransapi.common.UnionPrimaryKeyAttr;

public class RtBfE0102 {
    
	@UnionPrimaryKeyAttr
    private Integer provinceCode;

    
    private String icCardCertificateCodeic;

    
    private String busiType;

    
    @UnionPrimaryKeyAttr
    private String staffId;

    
    private String workTypeCode;

    
    private String certificateCode;

    
    private Integer certificateFirstIssueDate;

    
    private Integer certificateissueDate;

    
    private Integer certificateExpireDate;

    
    private String issueOrgan;

    
    private Integer issueOrganLocCode;

    
    private String issueOrganCode;

    
    private String certificateState;

    
    private String certificateType;

    
    private String idType;

    
    private String idCard;

    
    private String operTime;

    
    public Integer getProvinceCode() {
        return provinceCode;
    }

    
    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    
    public String getIcCardCertificateCodeic() {
        return icCardCertificateCodeic;
    }

    
    public void setIcCardCertificateCodeic(String icCardCertificateCodeic) {
        this.icCardCertificateCodeic = icCardCertificateCodeic == null ? null : icCardCertificateCodeic.trim();
    }

    
    public String getBusiType() {
        return busiType;
    }

    
    public void setBusiType(String busiType) {
        this.busiType = busiType == null ? null : busiType.trim();
    }

    
    public String getStaffId() {
        return staffId;
    }

    
    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    
    public String getWorkTypeCode() {
        return workTypeCode;
    }

    
    public void setWorkTypeCode(String workTypeCode) {
        this.workTypeCode = workTypeCode == null ? null : workTypeCode.trim();
    }

    
    public String getCertificateCode() {
        return certificateCode;
    }

    
    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode == null ? null : certificateCode.trim();
    }

    
    public Integer getCertificateFirstIssueDate() {
        return certificateFirstIssueDate;
    }

    
    public void setCertificateFirstIssueDate(Integer certificateFirstIssueDate) {
        this.certificateFirstIssueDate = certificateFirstIssueDate;
    }

    
    public Integer getCertificateissueDate() {
        return certificateissueDate;
    }

    
    public void setCertificateissueDate(Integer certificateissueDate) {
        this.certificateissueDate = certificateissueDate;
    }

    
    public Integer getCertificateExpireDate() {
        return certificateExpireDate;
    }

    
    public void setCertificateExpireDate(Integer certificateExpireDate) {
        this.certificateExpireDate = certificateExpireDate;
    }

    
    public String getIssueOrgan() {
        return issueOrgan;
    }

    
    public void setIssueOrgan(String issueOrgan) {
        this.issueOrgan = issueOrgan == null ? null : issueOrgan.trim();
    }

    
    public Integer getIssueOrganLocCode() {
        return issueOrganLocCode;
    }

    
    public void setIssueOrganLocCode(Integer issueOrganLocCode) {
        this.issueOrganLocCode = issueOrganLocCode;
    }

    
    public String getIssueOrganCode() {
        return issueOrganCode;
    }

    
    public void setIssueOrganCode(String issueOrganCode) {
        this.issueOrganCode = issueOrganCode == null ? null : issueOrganCode.trim();
    }

    
    public String getCertificateState() {
        return certificateState;
    }

    
    public void setCertificateState(String certificateState) {
        this.certificateState = certificateState == null ? null : certificateState.trim();
    }

    
    public String getCertificateType() {
        return certificateType;
    }

    
    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType == null ? null : certificateType.trim();
    }

    
    public String getIdType() {
        return idType;
    }

    
    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    
    public String getIdCard() {
        return idCard;
    }

    
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    
    public String getOperTime() {
        return operTime;
    }

    
    public void setOperTime(String operTime) {
        this.operTime = operTime == null ? null : operTime.trim();
    }
}