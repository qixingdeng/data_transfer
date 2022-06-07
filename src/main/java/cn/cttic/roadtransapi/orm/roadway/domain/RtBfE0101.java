package cn.cttic.roadtransapi.orm.roadway.domain;

import cn.cttic.roadtransapi.common.UnionPrimaryKeyAttr;

public class RtBfE0101 {
    
	@UnionPrimaryKeyAttr
    private Integer provinceCode;

    
	@UnionPrimaryKeyAttr
    private String staffId;

    
    private String staffName;

    
    private String sex;

    
    private String idType;

    
    private String idCard;

    
    private String nation;

    
    private String telephone;

    
    private String address;

    
    private String culturalLevel;

    
    private String technicalTitle;

    
    private String staffStatus;

    
    private String staffStatusCode;

    
    private Integer domicileCode;

    
    private String bornDate;

    
    private String operTime;

    
    private byte[] photo;

    
    public Integer getProvinceCode() {
        return provinceCode;
    }

    
    public void setProvinceCode(Integer provinceCode) {
        this.provinceCode = provinceCode;
    }

    
    public String getStaffId() {
        return staffId;
    }

    
    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    
    public String getStaffName() {
        return staffName;
    }

    
    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    
    public String getSex() {
        return sex;
    }

    
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
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

    
    public String getNation() {
        return nation;
    }

    
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    
    public String getTelephone() {
        return telephone;
    }

    
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    
    public String getAddress() {
        return address;
    }

    
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    
    public String getCulturalLevel() {
        return culturalLevel;
    }

    
    public void setCulturalLevel(String culturalLevel) {
        this.culturalLevel = culturalLevel == null ? null : culturalLevel.trim();
    }

    
    public String getTechnicalTitle() {
        return technicalTitle;
    }

    
    public void setTechnicalTitle(String technicalTitle) {
        this.technicalTitle = technicalTitle == null ? null : technicalTitle.trim();
    }

    
    public String getStaffStatus() {
        return staffStatus;
    }

    
    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus == null ? null : staffStatus.trim();
    }

    
    public String getStaffStatusCode() {
        return staffStatusCode;
    }

    
    public void setStaffStatusCode(String staffStatusCode) {
        this.staffStatusCode = staffStatusCode == null ? null : staffStatusCode.trim();
    }

    
    public Integer getDomicileCode() {
        return domicileCode;
    }

    
    public void setDomicileCode(Integer domicileCode) {
        this.domicileCode = domicileCode;
    }

    
    public String getBornDate() {
        return bornDate;
    }

    
    public void setBornDate(String bornDate) {
        this.bornDate = bornDate == null ? null : bornDate.trim();
    }

    
    public String getOperTime() {
        return operTime;
    }

    
    public void setOperTime(String operTime) {
        this.operTime = operTime == null ? null : operTime.trim();
    }

    
    public byte[] getPhoto() {
        return photo;
    }

    
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}