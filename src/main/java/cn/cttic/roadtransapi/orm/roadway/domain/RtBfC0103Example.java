package cn.cttic.roadtransapi.orm.roadway.domain;

import java.util.ArrayList;
import java.util.List;

public class RtBfC0103Example {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public RtBfC0103Example() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
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
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
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

        public Criteria andSignIdIsNull() {
            addCriterion("SIGN_ID is null");
            return (Criteria) this;
        }

        public Criteria andSignIdIsNotNull() {
            addCriterion("SIGN_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSignIdEqualTo(String value) {
            addCriterion("SIGN_ID =", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdNotEqualTo(String value) {
            addCriterion("SIGN_ID <>", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdGreaterThan(String value) {
            addCriterion("SIGN_ID >", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_ID >=", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdLessThan(String value) {
            addCriterion("SIGN_ID <", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdLessThanOrEqualTo(String value) {
            addCriterion("SIGN_ID <=", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdLike(String value) {
            addCriterion("SIGN_ID like", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdNotLike(String value) {
            addCriterion("SIGN_ID not like", value, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdIn(List<String> values) {
            addCriterion("SIGN_ID in", values, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdNotIn(List<String> values) {
            addCriterion("SIGN_ID not in", values, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdBetween(String value1, String value2) {
            addCriterion("SIGN_ID between", value1, value2, "signId");
            return (Criteria) this;
        }

        public Criteria andSignIdNotBetween(String value1, String value2) {
            addCriterion("SIGN_ID not between", value1, value2, "signId");
            return (Criteria) this;
        }

        public Criteria andOperLineIdIsNull() {
            addCriterion("OPER_LINE_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperLineIdIsNotNull() {
            addCriterion("OPER_LINE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperLineIdEqualTo(String value) {
            addCriterion("OPER_LINE_ID =", value, "operLineId");
            return (Criteria) this;
        }

        public Criteria andOperLineIdNotEqualTo(String value) {
            addCriterion("OPER_LINE_ID <>", value, "operLineId");
            return (Criteria) this;
        }

        public Criteria andOperLineIdGreaterThan(String value) {
            addCriterion("OPER_LINE_ID >", value, "operLineId");
            return (Criteria) this;
        }

        public Criteria andOperLineIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_LINE_ID >=", value, "operLineId");
            return (Criteria) this;
        }

        public Criteria andOperLineIdLessThan(String value) {
            addCriterion("OPER_LINE_ID <", value, "operLineId");
            return (Criteria) this;
        }

        public Criteria andOperLineIdLessThanOrEqualTo(String value) {
            addCriterion("OPER_LINE_ID <=", value, "operLineId");
            return (Criteria) this;
        }

        public Criteria andOperLineIdLike(String value) {
            addCriterion("OPER_LINE_ID like", value, "operLineId");
            return (Criteria) this;
        }

        public Criteria andOperLineIdNotLike(String value) {
            addCriterion("OPER_LINE_ID not like", value, "operLineId");
            return (Criteria) this;
        }

        public Criteria andOperLineIdIn(List<String> values) {
            addCriterion("OPER_LINE_ID in", values, "operLineId");
            return (Criteria) this;
        }

        public Criteria andOperLineIdNotIn(List<String> values) {
            addCriterion("OPER_LINE_ID not in", values, "operLineId");
            return (Criteria) this;
        }

        public Criteria andOperLineIdBetween(String value1, String value2) {
            addCriterion("OPER_LINE_ID between", value1, value2, "operLineId");
            return (Criteria) this;
        }

        public Criteria andOperLineIdNotBetween(String value1, String value2) {
            addCriterion("OPER_LINE_ID not between", value1, value2, "operLineId");
            return (Criteria) this;
        }

        public Criteria andSignCodeIsNull() {
            addCriterion("SIGN_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSignCodeIsNotNull() {
            addCriterion("SIGN_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSignCodeEqualTo(String value) {
            addCriterion("SIGN_CODE =", value, "signCode");
            return (Criteria) this;
        }

        public Criteria andSignCodeNotEqualTo(String value) {
            addCriterion("SIGN_CODE <>", value, "signCode");
            return (Criteria) this;
        }

        public Criteria andSignCodeGreaterThan(String value) {
            addCriterion("SIGN_CODE >", value, "signCode");
            return (Criteria) this;
        }

        public Criteria andSignCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_CODE >=", value, "signCode");
            return (Criteria) this;
        }

        public Criteria andSignCodeLessThan(String value) {
            addCriterion("SIGN_CODE <", value, "signCode");
            return (Criteria) this;
        }

        public Criteria andSignCodeLessThanOrEqualTo(String value) {
            addCriterion("SIGN_CODE <=", value, "signCode");
            return (Criteria) this;
        }

        public Criteria andSignCodeLike(String value) {
            addCriterion("SIGN_CODE like", value, "signCode");
            return (Criteria) this;
        }

        public Criteria andSignCodeNotLike(String value) {
            addCriterion("SIGN_CODE not like", value, "signCode");
            return (Criteria) this;
        }

        public Criteria andSignCodeIn(List<String> values) {
            addCriterion("SIGN_CODE in", values, "signCode");
            return (Criteria) this;
        }

        public Criteria andSignCodeNotIn(List<String> values) {
            addCriterion("SIGN_CODE not in", values, "signCode");
            return (Criteria) this;
        }

        public Criteria andSignCodeBetween(String value1, String value2) {
            addCriterion("SIGN_CODE between", value1, value2, "signCode");
            return (Criteria) this;
        }

        public Criteria andSignCodeNotBetween(String value1, String value2) {
            addCriterion("SIGN_CODE not between", value1, value2, "signCode");
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

        public Criteria andSignTypeIsNull() {
            addCriterion("SIGN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSignTypeIsNotNull() {
            addCriterion("SIGN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSignTypeEqualTo(String value) {
            addCriterion("SIGN_TYPE =", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotEqualTo(String value) {
            addCriterion("SIGN_TYPE <>", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThan(String value) {
            addCriterion("SIGN_TYPE >", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SIGN_TYPE >=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThan(String value) {
            addCriterion("SIGN_TYPE <", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThanOrEqualTo(String value) {
            addCriterion("SIGN_TYPE <=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLike(String value) {
            addCriterion("SIGN_TYPE like", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotLike(String value) {
            addCriterion("SIGN_TYPE not like", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeIn(List<String> values) {
            addCriterion("SIGN_TYPE in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotIn(List<String> values) {
            addCriterion("SIGN_TYPE not in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeBetween(String value1, String value2) {
            addCriterion("SIGN_TYPE between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotBetween(String value1, String value2) {
            addCriterion("SIGN_TYPE not between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andValidDateIsNull() {
            addCriterion("VALID_DATE is null");
            return (Criteria) this;
        }

        public Criteria andValidDateIsNotNull() {
            addCriterion("VALID_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andValidDateEqualTo(Integer value) {
            addCriterion("VALID_DATE =", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateNotEqualTo(Integer value) {
            addCriterion("VALID_DATE <>", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateGreaterThan(Integer value) {
            addCriterion("VALID_DATE >", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("VALID_DATE >=", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateLessThan(Integer value) {
            addCriterion("VALID_DATE <", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateLessThanOrEqualTo(Integer value) {
            addCriterion("VALID_DATE <=", value, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateIn(List<Integer> values) {
            addCriterion("VALID_DATE in", values, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateNotIn(List<Integer> values) {
            addCriterion("VALID_DATE not in", values, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateBetween(Integer value1, Integer value2) {
            addCriterion("VALID_DATE between", value1, value2, "validDate");
            return (Criteria) this;
        }

        public Criteria andValidDateNotBetween(Integer value1, Integer value2) {
            addCriterion("VALID_DATE not between", value1, value2, "validDate");
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

        public Criteria andExpireDateEqualTo(Integer value) {
            addCriterion("EXPIRE_DATE =", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotEqualTo(Integer value) {
            addCriterion("EXPIRE_DATE <>", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThan(Integer value) {
            addCriterion("EXPIRE_DATE >", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("EXPIRE_DATE >=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThan(Integer value) {
            addCriterion("EXPIRE_DATE <", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateLessThanOrEqualTo(Integer value) {
            addCriterion("EXPIRE_DATE <=", value, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateIn(List<Integer> values) {
            addCriterion("EXPIRE_DATE in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotIn(List<Integer> values) {
            addCriterion("EXPIRE_DATE not in", values, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateBetween(Integer value1, Integer value2) {
            addCriterion("EXPIRE_DATE between", value1, value2, "expireDate");
            return (Criteria) this;
        }

        public Criteria andExpireDateNotBetween(Integer value1, Integer value2) {
            addCriterion("EXPIRE_DATE not between", value1, value2, "expireDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateIsNull() {
            addCriterion("ISSUE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andIssueDateIsNotNull() {
            addCriterion("ISSUE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andIssueDateEqualTo(Integer value) {
            addCriterion("ISSUE_DATE =", value, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateNotEqualTo(Integer value) {
            addCriterion("ISSUE_DATE <>", value, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateGreaterThan(Integer value) {
            addCriterion("ISSUE_DATE >", value, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("ISSUE_DATE >=", value, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateLessThan(Integer value) {
            addCriterion("ISSUE_DATE <", value, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateLessThanOrEqualTo(Integer value) {
            addCriterion("ISSUE_DATE <=", value, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateIn(List<Integer> values) {
            addCriterion("ISSUE_DATE in", values, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateNotIn(List<Integer> values) {
            addCriterion("ISSUE_DATE not in", values, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateBetween(Integer value1, Integer value2) {
            addCriterion("ISSUE_DATE between", value1, value2, "issueDate");
            return (Criteria) this;
        }

        public Criteria andIssueDateNotBetween(Integer value1, Integer value2) {
            addCriterion("ISSUE_DATE not between", value1, value2, "issueDate");
            return (Criteria) this;
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

        public Criteria andOperTimeIsNull() {
            addCriterion("OPER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andOperTimeIsNotNull() {
            addCriterion("OPER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andOperTimeEqualTo(String value) {
            addCriterion("OPER_TIME =", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotEqualTo(String value) {
            addCriterion("OPER_TIME <>", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThan(String value) {
            addCriterion("OPER_TIME >", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_TIME >=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThan(String value) {
            addCriterion("OPER_TIME <", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThanOrEqualTo(String value) {
            addCriterion("OPER_TIME <=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLike(String value) {
            addCriterion("OPER_TIME like", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotLike(String value) {
            addCriterion("OPER_TIME not like", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeIn(List<String> values) {
            addCriterion("OPER_TIME in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotIn(List<String> values) {
            addCriterion("OPER_TIME not in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeBetween(String value1, String value2) {
            addCriterion("OPER_TIME between", value1, value2, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotBetween(String value1, String value2) {
            addCriterion("OPER_TIME not between", value1, value2, "operTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated do_not_delete_during_merge Mon Jun 15 16:31:19 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table RT_BF_C0103
     *
     * @mbggenerated Mon Jun 15 16:31:19 CST 2015
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