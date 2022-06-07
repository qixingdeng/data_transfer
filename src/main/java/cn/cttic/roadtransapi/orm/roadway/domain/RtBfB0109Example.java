package cn.cttic.roadtransapi.orm.roadway.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RtBfB0109Example {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    public RtBfB0109Example() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
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
     * This method corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
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

        public Criteria andMcuIdIsNull() {
            addCriterion("MCU_ID is null");
            return (Criteria) this;
        }

        public Criteria andMcuIdIsNotNull() {
            addCriterion("MCU_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMcuIdEqualTo(String value) {
            addCriterion("MCU_ID =", value, "mcuId");
            return (Criteria) this;
        }

        public Criteria andMcuIdNotEqualTo(String value) {
            addCriterion("MCU_ID <>", value, "mcuId");
            return (Criteria) this;
        }

        public Criteria andMcuIdGreaterThan(String value) {
            addCriterion("MCU_ID >", value, "mcuId");
            return (Criteria) this;
        }

        public Criteria andMcuIdGreaterThanOrEqualTo(String value) {
            addCriterion("MCU_ID >=", value, "mcuId");
            return (Criteria) this;
        }

        public Criteria andMcuIdLessThan(String value) {
            addCriterion("MCU_ID <", value, "mcuId");
            return (Criteria) this;
        }

        public Criteria andMcuIdLessThanOrEqualTo(String value) {
            addCriterion("MCU_ID <=", value, "mcuId");
            return (Criteria) this;
        }

        public Criteria andMcuIdLike(String value) {
            addCriterion("MCU_ID like", value, "mcuId");
            return (Criteria) this;
        }

        public Criteria andMcuIdNotLike(String value) {
            addCriterion("MCU_ID not like", value, "mcuId");
            return (Criteria) this;
        }

        public Criteria andMcuIdIn(List<String> values) {
            addCriterion("MCU_ID in", values, "mcuId");
            return (Criteria) this;
        }

        public Criteria andMcuIdNotIn(List<String> values) {
            addCriterion("MCU_ID not in", values, "mcuId");
            return (Criteria) this;
        }

        public Criteria andMcuIdBetween(String value1, String value2) {
            addCriterion("MCU_ID between", value1, value2, "mcuId");
            return (Criteria) this;
        }

        public Criteria andMcuIdNotBetween(String value1, String value2) {
            addCriterion("MCU_ID not between", value1, value2, "mcuId");
            return (Criteria) this;
        }

        public Criteria andEngineNoIsNull() {
            addCriterion("ENGINE_NO is null");
            return (Criteria) this;
        }

        public Criteria andEngineNoIsNotNull() {
            addCriterion("ENGINE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andEngineNoEqualTo(String value) {
            addCriterion("ENGINE_NO =", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotEqualTo(String value) {
            addCriterion("ENGINE_NO <>", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoGreaterThan(String value) {
            addCriterion("ENGINE_NO >", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoGreaterThanOrEqualTo(String value) {
            addCriterion("ENGINE_NO >=", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLessThan(String value) {
            addCriterion("ENGINE_NO <", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLessThanOrEqualTo(String value) {
            addCriterion("ENGINE_NO <=", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLike(String value) {
            addCriterion("ENGINE_NO like", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotLike(String value) {
            addCriterion("ENGINE_NO not like", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoIn(List<String> values) {
            addCriterion("ENGINE_NO in", values, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotIn(List<String> values) {
            addCriterion("ENGINE_NO not in", values, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoBetween(String value1, String value2) {
            addCriterion("ENGINE_NO between", value1, value2, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotBetween(String value1, String value2) {
            addCriterion("ENGINE_NO not between", value1, value2, "engineNo");
            return (Criteria) this;
        }

        public Criteria andVinNoIsNull() {
            addCriterion("VIN_NO is null");
            return (Criteria) this;
        }

        public Criteria andVinNoIsNotNull() {
            addCriterion("VIN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andVinNoEqualTo(String value) {
            addCriterion("VIN_NO =", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoNotEqualTo(String value) {
            addCriterion("VIN_NO <>", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoGreaterThan(String value) {
            addCriterion("VIN_NO >", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoGreaterThanOrEqualTo(String value) {
            addCriterion("VIN_NO >=", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoLessThan(String value) {
            addCriterion("VIN_NO <", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoLessThanOrEqualTo(String value) {
            addCriterion("VIN_NO <=", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoLike(String value) {
            addCriterion("VIN_NO like", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoNotLike(String value) {
            addCriterion("VIN_NO not like", value, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoIn(List<String> values) {
            addCriterion("VIN_NO in", values, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoNotIn(List<String> values) {
            addCriterion("VIN_NO not in", values, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoBetween(String value1, String value2) {
            addCriterion("VIN_NO between", value1, value2, "vinNo");
            return (Criteria) this;
        }

        public Criteria andVinNoNotBetween(String value1, String value2) {
            addCriterion("VIN_NO not between", value1, value2, "vinNo");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("BUSINESS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("BUSINESS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(Short value) {
            addCriterion("BUSINESS_TYPE =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(Short value) {
            addCriterion("BUSINESS_TYPE <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(Short value) {
            addCriterion("BUSINESS_TYPE >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("BUSINESS_TYPE >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(Short value) {
            addCriterion("BUSINESS_TYPE <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(Short value) {
            addCriterion("BUSINESS_TYPE <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<Short> values) {
            addCriterion("BUSINESS_TYPE in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<Short> values) {
            addCriterion("BUSINESS_TYPE not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(Short value1, Short value2) {
            addCriterion("BUSINESS_TYPE between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(Short value1, Short value2) {
            addCriterion("BUSINESS_TYPE not between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andProvinceLeaveMarkIsNull() {
            addCriterion("PROVINCE_LEAVE_MARK is null");
            return (Criteria) this;
        }

        public Criteria andProvinceLeaveMarkIsNotNull() {
            addCriterion("PROVINCE_LEAVE_MARK is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceLeaveMarkEqualTo(Short value) {
            addCriterion("PROVINCE_LEAVE_MARK =", value, "provinceLeaveMark");
            return (Criteria) this;
        }

        public Criteria andProvinceLeaveMarkNotEqualTo(Short value) {
            addCriterion("PROVINCE_LEAVE_MARK <>", value, "provinceLeaveMark");
            return (Criteria) this;
        }

        public Criteria andProvinceLeaveMarkGreaterThan(Short value) {
            addCriterion("PROVINCE_LEAVE_MARK >", value, "provinceLeaveMark");
            return (Criteria) this;
        }

        public Criteria andProvinceLeaveMarkGreaterThanOrEqualTo(Short value) {
            addCriterion("PROVINCE_LEAVE_MARK >=", value, "provinceLeaveMark");
            return (Criteria) this;
        }

        public Criteria andProvinceLeaveMarkLessThan(Short value) {
            addCriterion("PROVINCE_LEAVE_MARK <", value, "provinceLeaveMark");
            return (Criteria) this;
        }

        public Criteria andProvinceLeaveMarkLessThanOrEqualTo(Short value) {
            addCriterion("PROVINCE_LEAVE_MARK <=", value, "provinceLeaveMark");
            return (Criteria) this;
        }

        public Criteria andProvinceLeaveMarkIn(List<Short> values) {
            addCriterion("PROVINCE_LEAVE_MARK in", values, "provinceLeaveMark");
            return (Criteria) this;
        }

        public Criteria andProvinceLeaveMarkNotIn(List<Short> values) {
            addCriterion("PROVINCE_LEAVE_MARK not in", values, "provinceLeaveMark");
            return (Criteria) this;
        }

        public Criteria andProvinceLeaveMarkBetween(Short value1, Short value2) {
            addCriterion("PROVINCE_LEAVE_MARK between", value1, value2, "provinceLeaveMark");
            return (Criteria) this;
        }

        public Criteria andProvinceLeaveMarkNotBetween(Short value1, Short value2) {
            addCriterion("PROVINCE_LEAVE_MARK not between", value1, value2, "provinceLeaveMark");
            return (Criteria) this;
        }

        public Criteria andInAreaCodeIsNull() {
            addCriterion("IN_AREA_CODE is null");
            return (Criteria) this;
        }

        public Criteria andInAreaCodeIsNotNull() {
            addCriterion("IN_AREA_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andInAreaCodeEqualTo(Integer value) {
            addCriterion("IN_AREA_CODE =", value, "inAreaCode");
            return (Criteria) this;
        }

        public Criteria andInAreaCodeNotEqualTo(Integer value) {
            addCriterion("IN_AREA_CODE <>", value, "inAreaCode");
            return (Criteria) this;
        }

        public Criteria andInAreaCodeGreaterThan(Integer value) {
            addCriterion("IN_AREA_CODE >", value, "inAreaCode");
            return (Criteria) this;
        }

        public Criteria andInAreaCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("IN_AREA_CODE >=", value, "inAreaCode");
            return (Criteria) this;
        }

        public Criteria andInAreaCodeLessThan(Integer value) {
            addCriterion("IN_AREA_CODE <", value, "inAreaCode");
            return (Criteria) this;
        }

        public Criteria andInAreaCodeLessThanOrEqualTo(Integer value) {
            addCriterion("IN_AREA_CODE <=", value, "inAreaCode");
            return (Criteria) this;
        }

        public Criteria andInAreaCodeIn(List<Integer> values) {
            addCriterion("IN_AREA_CODE in", values, "inAreaCode");
            return (Criteria) this;
        }

        public Criteria andInAreaCodeNotIn(List<Integer> values) {
            addCriterion("IN_AREA_CODE not in", values, "inAreaCode");
            return (Criteria) this;
        }

        public Criteria andInAreaCodeBetween(Integer value1, Integer value2) {
            addCriterion("IN_AREA_CODE between", value1, value2, "inAreaCode");
            return (Criteria) this;
        }

        public Criteria andInAreaCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("IN_AREA_CODE not between", value1, value2, "inAreaCode");
            return (Criteria) this;
        }

        public Criteria andOutAreaCodeIsNull() {
            addCriterion("OUT_AREA_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOutAreaCodeIsNotNull() {
            addCriterion("OUT_AREA_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOutAreaCodeEqualTo(Integer value) {
            addCriterion("OUT_AREA_CODE =", value, "outAreaCode");
            return (Criteria) this;
        }

        public Criteria andOutAreaCodeNotEqualTo(Integer value) {
            addCriterion("OUT_AREA_CODE <>", value, "outAreaCode");
            return (Criteria) this;
        }

        public Criteria andOutAreaCodeGreaterThan(Integer value) {
            addCriterion("OUT_AREA_CODE >", value, "outAreaCode");
            return (Criteria) this;
        }

        public Criteria andOutAreaCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OUT_AREA_CODE >=", value, "outAreaCode");
            return (Criteria) this;
        }

        public Criteria andOutAreaCodeLessThan(Integer value) {
            addCriterion("OUT_AREA_CODE <", value, "outAreaCode");
            return (Criteria) this;
        }

        public Criteria andOutAreaCodeLessThanOrEqualTo(Integer value) {
            addCriterion("OUT_AREA_CODE <=", value, "outAreaCode");
            return (Criteria) this;
        }

        public Criteria andOutAreaCodeIn(List<Integer> values) {
            addCriterion("OUT_AREA_CODE in", values, "outAreaCode");
            return (Criteria) this;
        }

        public Criteria andOutAreaCodeNotIn(List<Integer> values) {
            addCriterion("OUT_AREA_CODE not in", values, "outAreaCode");
            return (Criteria) this;
        }

        public Criteria andOutAreaCodeBetween(Integer value1, Integer value2) {
            addCriterion("OUT_AREA_CODE between", value1, value2, "outAreaCode");
            return (Criteria) this;
        }

        public Criteria andOutAreaCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("OUT_AREA_CODE not between", value1, value2, "outAreaCode");
            return (Criteria) this;
        }

        public Criteria andNoterIsNull() {
            addCriterion("NOTER is null");
            return (Criteria) this;
        }

        public Criteria andNoterIsNotNull() {
            addCriterion("NOTER is not null");
            return (Criteria) this;
        }

        public Criteria andNoterEqualTo(String value) {
            addCriterion("NOTER =", value, "noter");
            return (Criteria) this;
        }

        public Criteria andNoterNotEqualTo(String value) {
            addCriterion("NOTER <>", value, "noter");
            return (Criteria) this;
        }

        public Criteria andNoterGreaterThan(String value) {
            addCriterion("NOTER >", value, "noter");
            return (Criteria) this;
        }

        public Criteria andNoterGreaterThanOrEqualTo(String value) {
            addCriterion("NOTER >=", value, "noter");
            return (Criteria) this;
        }

        public Criteria andNoterLessThan(String value) {
            addCriterion("NOTER <", value, "noter");
            return (Criteria) this;
        }

        public Criteria andNoterLessThanOrEqualTo(String value) {
            addCriterion("NOTER <=", value, "noter");
            return (Criteria) this;
        }

        public Criteria andNoterLike(String value) {
            addCriterion("NOTER like", value, "noter");
            return (Criteria) this;
        }

        public Criteria andNoterNotLike(String value) {
            addCriterion("NOTER not like", value, "noter");
            return (Criteria) this;
        }

        public Criteria andNoterIn(List<String> values) {
            addCriterion("NOTER in", values, "noter");
            return (Criteria) this;
        }

        public Criteria andNoterNotIn(List<String> values) {
            addCriterion("NOTER not in", values, "noter");
            return (Criteria) this;
        }

        public Criteria andNoterBetween(String value1, String value2) {
            addCriterion("NOTER between", value1, value2, "noter");
            return (Criteria) this;
        }

        public Criteria andNoterNotBetween(String value1, String value2) {
            addCriterion("NOTER not between", value1, value2, "noter");
            return (Criteria) this;
        }

        public Criteria andNoteDateIsNull() {
            addCriterion("NOTE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andNoteDateIsNotNull() {
            addCriterion("NOTE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andNoteDateEqualTo(Date value) {
            addCriterion("NOTE_DATE =", value, "noteDate");
            return (Criteria) this;
        }

        public Criteria andNoteDateNotEqualTo(Date value) {
            addCriterion("NOTE_DATE <>", value, "noteDate");
            return (Criteria) this;
        }

        public Criteria andNoteDateGreaterThan(Date value) {
            addCriterion("NOTE_DATE >", value, "noteDate");
            return (Criteria) this;
        }

        public Criteria andNoteDateGreaterThanOrEqualTo(Date value) {
            addCriterion("NOTE_DATE >=", value, "noteDate");
            return (Criteria) this;
        }

        public Criteria andNoteDateLessThan(Date value) {
            addCriterion("NOTE_DATE <", value, "noteDate");
            return (Criteria) this;
        }

        public Criteria andNoteDateLessThanOrEqualTo(Date value) {
            addCriterion("NOTE_DATE <=", value, "noteDate");
            return (Criteria) this;
        }

        public Criteria andNoteDateIn(List<Date> values) {
            addCriterion("NOTE_DATE in", values, "noteDate");
            return (Criteria) this;
        }

        public Criteria andNoteDateNotIn(List<Date> values) {
            addCriterion("NOTE_DATE not in", values, "noteDate");
            return (Criteria) this;
        }

        public Criteria andNoteDateBetween(Date value1, Date value2) {
            addCriterion("NOTE_DATE between", value1, value2, "noteDate");
            return (Criteria) this;
        }

        public Criteria andNoteDateNotBetween(Date value1, Date value2) {
            addCriterion("NOTE_DATE not between", value1, value2, "noteDate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated do_not_delete_during_merge Tue Sep 08 12:31:54 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RT_BF_B0109
     *
     * @mbggenerated Tue Sep 08 12:31:54 CST 2015
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