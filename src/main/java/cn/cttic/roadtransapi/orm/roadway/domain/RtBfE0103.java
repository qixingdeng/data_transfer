package cn.cttic.roadtransapi.orm.roadway.domain;

import cn.cttic.roadtransapi.common.UnionPrimaryKeyAttr;

public class RtBfE0103 {
    
    private String ownerId;

    
    private String ownerName;

    
    private String address;

    
    private Integer archiveDate;

    
    @UnionPrimaryKeyAttr
    private Integer provinceCode;

    
    @UnionPrimaryKeyAttr
    private String staffId;

    
    private String idType;

    
    private String idCard;

    
    private String operTime;

    
    public String getOwnerId() {
        return ownerId;
    }

    
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    
    public String getOwnerName() {
        return ownerName;
    }

    
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    
    public String getAddress() {
        return address;
    }

    
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    
    public Integer getArchiveDate() {
        return archiveDate;
    }

    
    public void setArchiveDate(Integer archiveDate) {
        this.archiveDate = archiveDate;
    }

    
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