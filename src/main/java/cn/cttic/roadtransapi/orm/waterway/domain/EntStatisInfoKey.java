package cn.cttic.roadtransapi.orm.waterway.domain;

import cn.cttic.roadtransapi.orm.waterway.domain.base.BaseEntity;

public class EntStatisInfoKey extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ENT_STATIS_INFO.ENT_REPO_ID
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    private Long entRepoId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ENT_STATIS_INFO.ENT_ID
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    private String entId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ENT_STATIS_INFO.ENT_REPO_ID
     *
     * @return the value of ENT_STATIS_INFO.ENT_REPO_ID
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public Long getEntRepoId() {
        return entRepoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ENT_STATIS_INFO.ENT_REPO_ID
     *
     * @param entRepoId the value for ENT_STATIS_INFO.ENT_REPO_ID
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public void setEntRepoId(Long entRepoId) {
        this.entRepoId = entRepoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ENT_STATIS_INFO.ENT_ID
     *
     * @return the value of ENT_STATIS_INFO.ENT_ID
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public String getEntId() {
        return entId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ENT_STATIS_INFO.ENT_ID
     *
     * @param entId the value for ENT_STATIS_INFO.ENT_ID
     *
     * @mbggenerated Fri Mar 20 16:45:02 CST 2015
     */
    public void setEntId(String entId) {
        this.entId = entId == null ? null : entId.trim();
    }
}