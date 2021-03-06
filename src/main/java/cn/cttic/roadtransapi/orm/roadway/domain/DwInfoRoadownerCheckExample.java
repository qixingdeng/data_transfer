package cn.cttic.roadtransapi.orm.roadway.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DwInfoRoadownerCheckExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
     */
    public DwInfoRoadownerCheckExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
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
     * This method corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
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

        public Criteria andOwnerIdIsNull() {
            addCriterion("OWNER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("OWNER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(String value) {
            addCriterion("OWNER_ID =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(String value) {
            addCriterion("OWNER_ID <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(String value) {
            addCriterion("OWNER_ID >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("OWNER_ID >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(String value) {
            addCriterion("OWNER_ID <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(String value) {
            addCriterion("OWNER_ID <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLike(String value) {
            addCriterion("OWNER_ID like", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotLike(String value) {
            addCriterion("OWNER_ID not like", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<String> values) {
            addCriterion("OWNER_ID in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<String> values) {
            addCriterion("OWNER_ID not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(String value1, String value2) {
            addCriterion("OWNER_ID between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(String value1, String value2) {
            addCriterion("OWNER_ID not between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIsNull() {
            addCriterion("OWNER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIsNotNull() {
            addCriterion("OWNER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerNameEqualTo(String value) {
            addCriterion("OWNER_NAME =", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotEqualTo(String value) {
            addCriterion("OWNER_NAME <>", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThan(String value) {
            addCriterion("OWNER_NAME >", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameGreaterThanOrEqualTo(String value) {
            addCriterion("OWNER_NAME >=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThan(String value) {
            addCriterion("OWNER_NAME <", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLessThanOrEqualTo(String value) {
            addCriterion("OWNER_NAME <=", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameLike(String value) {
            addCriterion("OWNER_NAME like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotLike(String value) {
            addCriterion("OWNER_NAME not like", value, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameIn(List<String> values) {
            addCriterion("OWNER_NAME in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotIn(List<String> values) {
            addCriterion("OWNER_NAME not in", values, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameBetween(String value1, String value2) {
            addCriterion("OWNER_NAME between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerNameNotBetween(String value1, String value2) {
            addCriterion("OWNER_NAME not between", value1, value2, "ownerName");
            return (Criteria) this;
        }

        public Criteria andOwnerAddressIsNull() {
            addCriterion("OWNER_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andOwnerAddressIsNotNull() {
            addCriterion("OWNER_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerAddressEqualTo(String value) {
            addCriterion("OWNER_ADDRESS =", value, "ownerAddress");
            return (Criteria) this;
        }

        public Criteria andOwnerAddressNotEqualTo(String value) {
            addCriterion("OWNER_ADDRESS <>", value, "ownerAddress");
            return (Criteria) this;
        }

        public Criteria andOwnerAddressGreaterThan(String value) {
            addCriterion("OWNER_ADDRESS >", value, "ownerAddress");
            return (Criteria) this;
        }

        public Criteria andOwnerAddressGreaterThanOrEqualTo(String value) {
            addCriterion("OWNER_ADDRESS >=", value, "ownerAddress");
            return (Criteria) this;
        }

        public Criteria andOwnerAddressLessThan(String value) {
            addCriterion("OWNER_ADDRESS <", value, "ownerAddress");
            return (Criteria) this;
        }

        public Criteria andOwnerAddressLessThanOrEqualTo(String value) {
            addCriterion("OWNER_ADDRESS <=", value, "ownerAddress");
            return (Criteria) this;
        }

        public Criteria andOwnerAddressLike(String value) {
            addCriterion("OWNER_ADDRESS like", value, "ownerAddress");
            return (Criteria) this;
        }

        public Criteria andOwnerAddressNotLike(String value) {
            addCriterion("OWNER_ADDRESS not like", value, "ownerAddress");
            return (Criteria) this;
        }

        public Criteria andOwnerAddressIn(List<String> values) {
            addCriterion("OWNER_ADDRESS in", values, "ownerAddress");
            return (Criteria) this;
        }

        public Criteria andOwnerAddressNotIn(List<String> values) {
            addCriterion("OWNER_ADDRESS not in", values, "ownerAddress");
            return (Criteria) this;
        }

        public Criteria andOwnerAddressBetween(String value1, String value2) {
            addCriterion("OWNER_ADDRESS between", value1, value2, "ownerAddress");
            return (Criteria) this;
        }

        public Criteria andOwnerAddressNotBetween(String value1, String value2) {
            addCriterion("OWNER_ADDRESS not between", value1, value2, "ownerAddress");
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

        public Criteria andCheckOraNameIsNull() {
            addCriterion("CHECK_ORA_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCheckOraNameIsNotNull() {
            addCriterion("CHECK_ORA_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCheckOraNameEqualTo(String value) {
            addCriterion("CHECK_ORA_NAME =", value, "checkOraName");
            return (Criteria) this;
        }

        public Criteria andCheckOraNameNotEqualTo(String value) {
            addCriterion("CHECK_ORA_NAME <>", value, "checkOraName");
            return (Criteria) this;
        }

        public Criteria andCheckOraNameGreaterThan(String value) {
            addCriterion("CHECK_ORA_NAME >", value, "checkOraName");
            return (Criteria) this;
        }

        public Criteria andCheckOraNameGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_ORA_NAME >=", value, "checkOraName");
            return (Criteria) this;
        }

        public Criteria andCheckOraNameLessThan(String value) {
            addCriterion("CHECK_ORA_NAME <", value, "checkOraName");
            return (Criteria) this;
        }

        public Criteria andCheckOraNameLessThanOrEqualTo(String value) {
            addCriterion("CHECK_ORA_NAME <=", value, "checkOraName");
            return (Criteria) this;
        }

        public Criteria andCheckOraNameLike(String value) {
            addCriterion("CHECK_ORA_NAME like", value, "checkOraName");
            return (Criteria) this;
        }

        public Criteria andCheckOraNameNotLike(String value) {
            addCriterion("CHECK_ORA_NAME not like", value, "checkOraName");
            return (Criteria) this;
        }

        public Criteria andCheckOraNameIn(List<String> values) {
            addCriterion("CHECK_ORA_NAME in", values, "checkOraName");
            return (Criteria) this;
        }

        public Criteria andCheckOraNameNotIn(List<String> values) {
            addCriterion("CHECK_ORA_NAME not in", values, "checkOraName");
            return (Criteria) this;
        }

        public Criteria andCheckOraNameBetween(String value1, String value2) {
            addCriterion("CHECK_ORA_NAME between", value1, value2, "checkOraName");
            return (Criteria) this;
        }

        public Criteria andCheckOraNameNotBetween(String value1, String value2) {
            addCriterion("CHECK_ORA_NAME not between", value1, value2, "checkOraName");
            return (Criteria) this;
        }

        public Criteria andCheckMarkIsNull() {
            addCriterion("CHECK_MARK is null");
            return (Criteria) this;
        }

        public Criteria andCheckMarkIsNotNull() {
            addCriterion("CHECK_MARK is not null");
            return (Criteria) this;
        }

        public Criteria andCheckMarkEqualTo(String value) {
            addCriterion("CHECK_MARK =", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkNotEqualTo(String value) {
            addCriterion("CHECK_MARK <>", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkGreaterThan(String value) {
            addCriterion("CHECK_MARK >", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_MARK >=", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkLessThan(String value) {
            addCriterion("CHECK_MARK <", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkLessThanOrEqualTo(String value) {
            addCriterion("CHECK_MARK <=", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkLike(String value) {
            addCriterion("CHECK_MARK like", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkNotLike(String value) {
            addCriterion("CHECK_MARK not like", value, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkIn(List<String> values) {
            addCriterion("CHECK_MARK in", values, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkNotIn(List<String> values) {
            addCriterion("CHECK_MARK not in", values, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkBetween(String value1, String value2) {
            addCriterion("CHECK_MARK between", value1, value2, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckMarkNotBetween(String value1, String value2) {
            addCriterion("CHECK_MARK not between", value1, value2, "checkMark");
            return (Criteria) this;
        }

        public Criteria andCheckResultIsNull() {
            addCriterion("CHECK_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andCheckResultIsNotNull() {
            addCriterion("CHECK_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andCheckResultEqualTo(String value) {
            addCriterion("CHECK_RESULT =", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotEqualTo(String value) {
            addCriterion("CHECK_RESULT <>", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultGreaterThan(String value) {
            addCriterion("CHECK_RESULT >", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_RESULT >=", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLessThan(String value) {
            addCriterion("CHECK_RESULT <", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLessThanOrEqualTo(String value) {
            addCriterion("CHECK_RESULT <=", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultLike(String value) {
            addCriterion("CHECK_RESULT like", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotLike(String value) {
            addCriterion("CHECK_RESULT not like", value, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultIn(List<String> values) {
            addCriterion("CHECK_RESULT in", values, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotIn(List<String> values) {
            addCriterion("CHECK_RESULT not in", values, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultBetween(String value1, String value2) {
            addCriterion("CHECK_RESULT between", value1, value2, "checkResult");
            return (Criteria) this;
        }

        public Criteria andCheckResultNotBetween(String value1, String value2) {
            addCriterion("CHECK_RESULT not between", value1, value2, "checkResult");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated do_not_delete_during_merge Thu Jul 30 15:30:40 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table DW_INFO_ROADOWNER_CHECK
     *
     * @mbggenerated Thu Jul 30 15:30:40 CST 2015
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