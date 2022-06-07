package cn.cttic.roadtransapi.orm.roadway.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DwInfoVehicleAnnulcheckExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public DwInfoVehicleAnnulcheckExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
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
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
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
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
     *
     * @mbggenerated Fri Jul 24 08:19:14 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
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
     * This class corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
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

        public Criteria andVehicleNoIsNull() {
            addCriterion("VEHICLE_NO is null");
            return (Criteria) this;
        }

        public Criteria andVehicleNoIsNotNull() {
            addCriterion("VEHICLE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleNoEqualTo(String value) {
            addCriterion("VEHICLE_NO =", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoNotEqualTo(String value) {
            addCriterion("VEHICLE_NO <>", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoGreaterThan(String value) {
            addCriterion("VEHICLE_NO >", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoGreaterThanOrEqualTo(String value) {
            addCriterion("VEHICLE_NO >=", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoLessThan(String value) {
            addCriterion("VEHICLE_NO <", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoLessThanOrEqualTo(String value) {
            addCriterion("VEHICLE_NO <=", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoLike(String value) {
            addCriterion("VEHICLE_NO like", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoNotLike(String value) {
            addCriterion("VEHICLE_NO not like", value, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoIn(List<String> values) {
            addCriterion("VEHICLE_NO in", values, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoNotIn(List<String> values) {
            addCriterion("VEHICLE_NO not in", values, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoBetween(String value1, String value2) {
            addCriterion("VEHICLE_NO between", value1, value2, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNoNotBetween(String value1, String value2) {
            addCriterion("VEHICLE_NO not between", value1, value2, "vehicleNo");
            return (Criteria) this;
        }

        public Criteria andPlateColorIsNull() {
            addCriterion("PLATE_COLOR is null");
            return (Criteria) this;
        }

        public Criteria andPlateColorIsNotNull() {
            addCriterion("PLATE_COLOR is not null");
            return (Criteria) this;
        }

        public Criteria andPlateColorEqualTo(String value) {
            addCriterion("PLATE_COLOR =", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorNotEqualTo(String value) {
            addCriterion("PLATE_COLOR <>", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorGreaterThan(String value) {
            addCriterion("PLATE_COLOR >", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorGreaterThanOrEqualTo(String value) {
            addCriterion("PLATE_COLOR >=", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorLessThan(String value) {
            addCriterion("PLATE_COLOR <", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorLessThanOrEqualTo(String value) {
            addCriterion("PLATE_COLOR <=", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorLike(String value) {
            addCriterion("PLATE_COLOR like", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorNotLike(String value) {
            addCriterion("PLATE_COLOR not like", value, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorIn(List<String> values) {
            addCriterion("PLATE_COLOR in", values, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorNotIn(List<String> values) {
            addCriterion("PLATE_COLOR not in", values, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorBetween(String value1, String value2) {
            addCriterion("PLATE_COLOR between", value1, value2, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorNotBetween(String value1, String value2) {
            addCriterion("PLATE_COLOR not between", value1, value2, "plateColor");
            return (Criteria) this;
        }

        public Criteria andPlateColorCodeIsNull() {
            addCriterion("PLATE_COLOR_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPlateColorCodeIsNotNull() {
            addCriterion("PLATE_COLOR_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPlateColorCodeEqualTo(String value) {
            addCriterion("PLATE_COLOR_CODE =", value, "plateColorCode");
            return (Criteria) this;
        }

        public Criteria andPlateColorCodeNotEqualTo(String value) {
            addCriterion("PLATE_COLOR_CODE <>", value, "plateColorCode");
            return (Criteria) this;
        }

        public Criteria andPlateColorCodeGreaterThan(String value) {
            addCriterion("PLATE_COLOR_CODE >", value, "plateColorCode");
            return (Criteria) this;
        }

        public Criteria andPlateColorCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PLATE_COLOR_CODE >=", value, "plateColorCode");
            return (Criteria) this;
        }

        public Criteria andPlateColorCodeLessThan(String value) {
            addCriterion("PLATE_COLOR_CODE <", value, "plateColorCode");
            return (Criteria) this;
        }

        public Criteria andPlateColorCodeLessThanOrEqualTo(String value) {
            addCriterion("PLATE_COLOR_CODE <=", value, "plateColorCode");
            return (Criteria) this;
        }

        public Criteria andPlateColorCodeLike(String value) {
            addCriterion("PLATE_COLOR_CODE like", value, "plateColorCode");
            return (Criteria) this;
        }

        public Criteria andPlateColorCodeNotLike(String value) {
            addCriterion("PLATE_COLOR_CODE not like", value, "plateColorCode");
            return (Criteria) this;
        }

        public Criteria andPlateColorCodeIn(List<String> values) {
            addCriterion("PLATE_COLOR_CODE in", values, "plateColorCode");
            return (Criteria) this;
        }

        public Criteria andPlateColorCodeNotIn(List<String> values) {
            addCriterion("PLATE_COLOR_CODE not in", values, "plateColorCode");
            return (Criteria) this;
        }

        public Criteria andPlateColorCodeBetween(String value1, String value2) {
            addCriterion("PLATE_COLOR_CODE between", value1, value2, "plateColorCode");
            return (Criteria) this;
        }

        public Criteria andPlateColorCodeNotBetween(String value1, String value2) {
            addCriterion("PLATE_COLOR_CODE not between", value1, value2, "plateColorCode");
            return (Criteria) this;
        }

        public Criteria andCheckYearIsNull() {
            addCriterion("CHECK_YEAR is null");
            return (Criteria) this;
        }

        public Criteria andCheckYearIsNotNull() {
            addCriterion("CHECK_YEAR is not null");
            return (Criteria) this;
        }

        public Criteria andCheckYearEqualTo(String value) {
            addCriterion("CHECK_YEAR =", value, "checkYear");
            return (Criteria) this;
        }

        public Criteria andCheckYearNotEqualTo(String value) {
            addCriterion("CHECK_YEAR <>", value, "checkYear");
            return (Criteria) this;
        }

        public Criteria andCheckYearGreaterThan(String value) {
            addCriterion("CHECK_YEAR >", value, "checkYear");
            return (Criteria) this;
        }

        public Criteria andCheckYearGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_YEAR >=", value, "checkYear");
            return (Criteria) this;
        }

        public Criteria andCheckYearLessThan(String value) {
            addCriterion("CHECK_YEAR <", value, "checkYear");
            return (Criteria) this;
        }

        public Criteria andCheckYearLessThanOrEqualTo(String value) {
            addCriterion("CHECK_YEAR <=", value, "checkYear");
            return (Criteria) this;
        }

        public Criteria andCheckYearLike(String value) {
            addCriterion("CHECK_YEAR like", value, "checkYear");
            return (Criteria) this;
        }

        public Criteria andCheckYearNotLike(String value) {
            addCriterion("CHECK_YEAR not like", value, "checkYear");
            return (Criteria) this;
        }

        public Criteria andCheckYearIn(List<String> values) {
            addCriterion("CHECK_YEAR in", values, "checkYear");
            return (Criteria) this;
        }

        public Criteria andCheckYearNotIn(List<String> values) {
            addCriterion("CHECK_YEAR not in", values, "checkYear");
            return (Criteria) this;
        }

        public Criteria andCheckYearBetween(String value1, String value2) {
            addCriterion("CHECK_YEAR between", value1, value2, "checkYear");
            return (Criteria) this;
        }

        public Criteria andCheckYearNotBetween(String value1, String value2) {
            addCriterion("CHECK_YEAR not between", value1, value2, "checkYear");
            return (Criteria) this;
        }

        public Criteria andCheckStateIsNull() {
            addCriterion("CHECK_STATE is null");
            return (Criteria) this;
        }

        public Criteria andCheckStateIsNotNull() {
            addCriterion("CHECK_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStateEqualTo(String value) {
            addCriterion("CHECK_STATE =", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotEqualTo(String value) {
            addCriterion("CHECK_STATE <>", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateGreaterThan(String value) {
            addCriterion("CHECK_STATE >", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_STATE >=", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLessThan(String value) {
            addCriterion("CHECK_STATE <", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLessThanOrEqualTo(String value) {
            addCriterion("CHECK_STATE <=", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLike(String value) {
            addCriterion("CHECK_STATE like", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotLike(String value) {
            addCriterion("CHECK_STATE not like", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateIn(List<String> values) {
            addCriterion("CHECK_STATE in", values, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotIn(List<String> values) {
            addCriterion("CHECK_STATE not in", values, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateBetween(String value1, String value2) {
            addCriterion("CHECK_STATE between", value1, value2, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotBetween(String value1, String value2) {
            addCriterion("CHECK_STATE not between", value1, value2, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNull() {
            addCriterion("CHECK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNotNull() {
            addCriterion("CHECK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDateEqualTo(Date value) {
            addCriterion("CHECK_DATE =", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotEqualTo(Date value) {
            addCriterion("CHECK_DATE <>", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThan(Date value) {
            addCriterion("CHECK_DATE >", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CHECK_DATE >=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThan(Date value) {
            addCriterion("CHECK_DATE <", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThanOrEqualTo(Date value) {
            addCriterion("CHECK_DATE <=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateIn(List<Date> values) {
            addCriterion("CHECK_DATE in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotIn(List<Date> values) {
            addCriterion("CHECK_DATE not in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateBetween(Date value1, Date value2) {
            addCriterion("CHECK_DATE between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotBetween(Date value1, Date value2) {
            addCriterion("CHECK_DATE not between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateIsNull() {
            addCriterion("EXPIRE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andExpireDateIsNotNull() {
            addCriterion("EXPIRE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andExpireDateEqualTo(Date value) {
            addCriterion("EXPIRE_DATE =", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotEqualTo(Date value) {
            addCriterion("EXPIRE_DATE <>", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThan(Date value) {
            addCriterion("EXPIRE_DATE >", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThanOrEqualTo(Date value) {
            addCriterion("EXPIRE_DATE >=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThan(Date value) {
            addCriterion("EXPIRE_DATE <", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThanOrEqualTo(Date value) {
            addCriterion("EXPIRE_DATE <=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateIn(List<Date> values) {
            addCriterion("EXPIRE_DATE in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotIn(List<Date> values) {
            addCriterion("EXPIRE_DATE not in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateBetween(Date value1, Date value2) {
            addCriterion("EXPIRE_DATE between", value1, value2, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotBetween(Date value1, Date value2) {
            addCriterion("EXPIRE_DATE not between", value1, value2, "expireDate");
            return (Criteria) this;
        }

        public Criteria andNextDateIsNull() {
            addCriterion("NEXT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andNextDateIsNotNull() {
            addCriterion("NEXT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andNextDateEqualTo(Date value) {
            addCriterion("NEXT_DATE =", value, "nextDate");
            return (Criteria) this;
        }

        public Criteria andNextDateNotEqualTo(Date value) {
            addCriterion("NEXT_DATE <>", value, "nextDate");
            return (Criteria) this;
        }

        public Criteria andNextDateGreaterThan(Date value) {
            addCriterion("NEXT_DATE >", value, "nextDate");
            return (Criteria) this;
        }

        public Criteria andNextDateGreaterThanOrEqualTo(Date value) {
            addCriterion("NEXT_DATE >=", value, "nextDate");
            return (Criteria) this;
        }

        public Criteria andNextDateLessThan(Date value) {
            addCriterion("NEXT_DATE <", value, "nextDate");
            return (Criteria) this;
        }

        public Criteria andNextDateLessThanOrEqualTo(Date value) {
            addCriterion("NEXT_DATE <=", value, "nextDate");
            return (Criteria) this;
        }

        public Criteria andNextDateIn(List<Date> values) {
            addCriterion("NEXT_DATE in", values, "nextDate");
            return (Criteria) this;
        }

        public Criteria andNextDateNotIn(List<Date> values) {
            addCriterion("NEXT_DATE not in", values, "nextDate");
            return (Criteria) this;
        }

        public Criteria andNextDateBetween(Date value1, Date value2) {
            addCriterion("NEXT_DATE between", value1, value2, "nextDate");
            return (Criteria) this;
        }

        public Criteria andNextDateNotBetween(Date value1, Date value2) {
            addCriterion("NEXT_DATE not between", value1, value2, "nextDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateIsNull() {
            addCriterion("PROCESS_DATE is null");
            return (Criteria) this;
        }

        public Criteria andProcessDateIsNotNull() {
            addCriterion("PROCESS_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andProcessDateEqualTo(Date value) {
            addCriterion("PROCESS_DATE =", value, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateNotEqualTo(Date value) {
            addCriterion("PROCESS_DATE <>", value, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateGreaterThan(Date value) {
            addCriterion("PROCESS_DATE >", value, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateGreaterThanOrEqualTo(Date value) {
            addCriterion("PROCESS_DATE >=", value, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateLessThan(Date value) {
            addCriterion("PROCESS_DATE <", value, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateLessThanOrEqualTo(Date value) {
            addCriterion("PROCESS_DATE <=", value, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateIn(List<Date> values) {
            addCriterion("PROCESS_DATE in", values, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateNotIn(List<Date> values) {
            addCriterion("PROCESS_DATE not in", values, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateBetween(Date value1, Date value2) {
            addCriterion("PROCESS_DATE between", value1, value2, "processDate");
            return (Criteria) this;
        }

        public Criteria andProcessDateNotBetween(Date value1, Date value2) {
            addCriterion("PROCESS_DATE not between", value1, value2, "processDate");
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
     * This class corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
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
     * This class corresponds to the database table DW_INFO_VEHICLE_ANNULCHECK
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