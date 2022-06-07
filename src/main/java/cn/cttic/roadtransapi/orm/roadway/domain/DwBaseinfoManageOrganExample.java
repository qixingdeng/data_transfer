package cn.cttic.roadtransapi.orm.roadway.domain;

import java.util.ArrayList;
import java.util.List;

public class DwBaseinfoManageOrganExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public DwBaseinfoManageOrganExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("PROVINCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("PROVINCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(Integer value) {
            addCriterion("PROVINCE_CODE =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(Integer value) {
            addCriterion("PROVINCE_CODE <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(Integer value) {
            addCriterion("PROVINCE_CODE >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROVINCE_CODE >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(Integer value) {
            addCriterion("PROVINCE_CODE <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(Integer value) {
            addCriterion("PROVINCE_CODE <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<Integer> values) {
            addCriterion("PROVINCE_CODE in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<Integer> values) {
            addCriterion("PROVINCE_CODE not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(Integer value1, Integer value2) {
            addCriterion("PROVINCE_CODE between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("PROVINCE_CODE not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andOrganNameIsNull() {
            addCriterion("ORGAN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOrganNameIsNotNull() {
            addCriterion("ORGAN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrganNameEqualTo(String value) {
            addCriterion("ORGAN_NAME =", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameNotEqualTo(String value) {
            addCriterion("ORGAN_NAME <>", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameGreaterThan(String value) {
            addCriterion("ORGAN_NAME >", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameGreaterThanOrEqualTo(String value) {
            addCriterion("ORGAN_NAME >=", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameLessThan(String value) {
            addCriterion("ORGAN_NAME <", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameLessThanOrEqualTo(String value) {
            addCriterion("ORGAN_NAME <=", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameLike(String value) {
            addCriterion("ORGAN_NAME like", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameNotLike(String value) {
            addCriterion("ORGAN_NAME not like", value, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameIn(List<String> values) {
            addCriterion("ORGAN_NAME in", values, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameNotIn(List<String> values) {
            addCriterion("ORGAN_NAME not in", values, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameBetween(String value1, String value2) {
            addCriterion("ORGAN_NAME between", value1, value2, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganNameNotBetween(String value1, String value2) {
            addCriterion("ORGAN_NAME not between", value1, value2, "organName");
            return (Criteria) this;
        }

        public Criteria andOrganCodeIsNull() {
            addCriterion("ORGAN_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOrganCodeIsNotNull() {
            addCriterion("ORGAN_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrganCodeEqualTo(String value) {
            addCriterion("ORGAN_CODE =", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeNotEqualTo(String value) {
            addCriterion("ORGAN_CODE <>", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeGreaterThan(String value) {
            addCriterion("ORGAN_CODE >", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORGAN_CODE >=", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeLessThan(String value) {
            addCriterion("ORGAN_CODE <", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeLessThanOrEqualTo(String value) {
            addCriterion("ORGAN_CODE <=", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeLike(String value) {
            addCriterion("ORGAN_CODE like", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeNotLike(String value) {
            addCriterion("ORGAN_CODE not like", value, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeIn(List<String> values) {
            addCriterion("ORGAN_CODE in", values, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeNotIn(List<String> values) {
            addCriterion("ORGAN_CODE not in", values, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeBetween(String value1, String value2) {
            addCriterion("ORGAN_CODE between", value1, value2, "organCode");
            return (Criteria) this;
        }

        public Criteria andOrganCodeNotBetween(String value1, String value2) {
            addCriterion("ORGAN_CODE not between", value1, value2, "organCode");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andZoneIsNull() {
            addCriterion("ZONE is null");
            return (Criteria) this;
        }

        public Criteria andZoneIsNotNull() {
            addCriterion("ZONE is not null");
            return (Criteria) this;
        }

        public Criteria andZoneEqualTo(Integer value) {
            addCriterion("ZONE =", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotEqualTo(Integer value) {
            addCriterion("ZONE <>", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneGreaterThan(Integer value) {
            addCriterion("ZONE >", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("ZONE >=", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneLessThan(Integer value) {
            addCriterion("ZONE <", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneLessThanOrEqualTo(Integer value) {
            addCriterion("ZONE <=", value, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneIn(List<Integer> values) {
            addCriterion("ZONE in", values, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotIn(List<Integer> values) {
            addCriterion("ZONE not in", values, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneBetween(Integer value1, Integer value2) {
            addCriterion("ZONE between", value1, value2, "zone");
            return (Criteria) this;
        }

        public Criteria andZoneNotBetween(Integer value1, Integer value2) {
            addCriterion("ZONE not between", value1, value2, "zone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("TELEPHONE is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("TELEPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("TELEPHONE =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("TELEPHONE <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("TELEPHONE >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("TELEPHONE >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("TELEPHONE <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("TELEPHONE <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("TELEPHONE like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("TELEPHONE not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("TELEPHONE in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("TELEPHONE not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("TELEPHONE between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("TELEPHONE not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("FAX is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("FAX is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("FAX =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("FAX <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("FAX >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("FAX >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("FAX <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("FAX <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("FAX like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("FAX not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("FAX in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("FAX not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("FAX between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("FAX not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andEmergencyCallIsNull() {
            addCriterion("EMERGENCY_CALL is null");
            return (Criteria) this;
        }

        public Criteria andEmergencyCallIsNotNull() {
            addCriterion("EMERGENCY_CALL is not null");
            return (Criteria) this;
        }

        public Criteria andEmergencyCallEqualTo(String value) {
            addCriterion("EMERGENCY_CALL =", value, "emergencyCall");
            return (Criteria) this;
        }

        public Criteria andEmergencyCallNotEqualTo(String value) {
            addCriterion("EMERGENCY_CALL <>", value, "emergencyCall");
            return (Criteria) this;
        }

        public Criteria andEmergencyCallGreaterThan(String value) {
            addCriterion("EMERGENCY_CALL >", value, "emergencyCall");
            return (Criteria) this;
        }

        public Criteria andEmergencyCallGreaterThanOrEqualTo(String value) {
            addCriterion("EMERGENCY_CALL >=", value, "emergencyCall");
            return (Criteria) this;
        }

        public Criteria andEmergencyCallLessThan(String value) {
            addCriterion("EMERGENCY_CALL <", value, "emergencyCall");
            return (Criteria) this;
        }

        public Criteria andEmergencyCallLessThanOrEqualTo(String value) {
            addCriterion("EMERGENCY_CALL <=", value, "emergencyCall");
            return (Criteria) this;
        }

        public Criteria andEmergencyCallLike(String value) {
            addCriterion("EMERGENCY_CALL like", value, "emergencyCall");
            return (Criteria) this;
        }

        public Criteria andEmergencyCallNotLike(String value) {
            addCriterion("EMERGENCY_CALL not like", value, "emergencyCall");
            return (Criteria) this;
        }

        public Criteria andEmergencyCallIn(List<String> values) {
            addCriterion("EMERGENCY_CALL in", values, "emergencyCall");
            return (Criteria) this;
        }

        public Criteria andEmergencyCallNotIn(List<String> values) {
            addCriterion("EMERGENCY_CALL not in", values, "emergencyCall");
            return (Criteria) this;
        }

        public Criteria andEmergencyCallBetween(String value1, String value2) {
            addCriterion("EMERGENCY_CALL between", value1, value2, "emergencyCall");
            return (Criteria) this;
        }

        public Criteria andEmergencyCallNotBetween(String value1, String value2) {
            addCriterion("EMERGENCY_CALL not between", value1, value2, "emergencyCall");
            return (Criteria) this;
        }

        public Criteria andComplaintsCallIsNull() {
            addCriterion("COMPLAINTS_CALL is null");
            return (Criteria) this;
        }

        public Criteria andComplaintsCallIsNotNull() {
            addCriterion("COMPLAINTS_CALL is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintsCallEqualTo(String value) {
            addCriterion("COMPLAINTS_CALL =", value, "complaintsCall");
            return (Criteria) this;
        }

        public Criteria andComplaintsCallNotEqualTo(String value) {
            addCriterion("COMPLAINTS_CALL <>", value, "complaintsCall");
            return (Criteria) this;
        }

        public Criteria andComplaintsCallGreaterThan(String value) {
            addCriterion("COMPLAINTS_CALL >", value, "complaintsCall");
            return (Criteria) this;
        }

        public Criteria andComplaintsCallGreaterThanOrEqualTo(String value) {
            addCriterion("COMPLAINTS_CALL >=", value, "complaintsCall");
            return (Criteria) this;
        }

        public Criteria andComplaintsCallLessThan(String value) {
            addCriterion("COMPLAINTS_CALL <", value, "complaintsCall");
            return (Criteria) this;
        }

        public Criteria andComplaintsCallLessThanOrEqualTo(String value) {
            addCriterion("COMPLAINTS_CALL <=", value, "complaintsCall");
            return (Criteria) this;
        }

        public Criteria andComplaintsCallLike(String value) {
            addCriterion("COMPLAINTS_CALL like", value, "complaintsCall");
            return (Criteria) this;
        }

        public Criteria andComplaintsCallNotLike(String value) {
            addCriterion("COMPLAINTS_CALL not like", value, "complaintsCall");
            return (Criteria) this;
        }

        public Criteria andComplaintsCallIn(List<String> values) {
            addCriterion("COMPLAINTS_CALL in", values, "complaintsCall");
            return (Criteria) this;
        }

        public Criteria andComplaintsCallNotIn(List<String> values) {
            addCriterion("COMPLAINTS_CALL not in", values, "complaintsCall");
            return (Criteria) this;
        }

        public Criteria andComplaintsCallBetween(String value1, String value2) {
            addCriterion("COMPLAINTS_CALL between", value1, value2, "complaintsCall");
            return (Criteria) this;
        }

        public Criteria andComplaintsCallNotBetween(String value1, String value2) {
            addCriterion("COMPLAINTS_CALL not between", value1, value2, "complaintsCall");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNull() {
            addCriterion("PRINCIPAL is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalIsNotNull() {
            addCriterion("PRINCIPAL is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalEqualTo(String value) {
            addCriterion("PRINCIPAL =", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotEqualTo(String value) {
            addCriterion("PRINCIPAL <>", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThan(String value) {
            addCriterion("PRINCIPAL >", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalGreaterThanOrEqualTo(String value) {
            addCriterion("PRINCIPAL >=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThan(String value) {
            addCriterion("PRINCIPAL <", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLessThanOrEqualTo(String value) {
            addCriterion("PRINCIPAL <=", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalLike(String value) {
            addCriterion("PRINCIPAL like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotLike(String value) {
            addCriterion("PRINCIPAL not like", value, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalIn(List<String> values) {
            addCriterion("PRINCIPAL in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotIn(List<String> values) {
            addCriterion("PRINCIPAL not in", values, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalBetween(String value1, String value2) {
            addCriterion("PRINCIPAL between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andPrincipalNotBetween(String value1, String value2) {
            addCriterion("PRINCIPAL not between", value1, value2, "principal");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated do_not_delete_during_merge Fri Jul 24 08:19:14 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table DW_BASEINFO_MANAGE_ORGAN
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}