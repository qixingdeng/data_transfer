package cn.cttic.roadtransapi.orm.map.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InterMapLcpInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
     */
    public InterMapLcpInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
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
     * This method corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
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

        public Criteria andSectioncodeIsNull() {
            addCriterion("SECTIONCODE is null");
            return (Criteria) this;
        }

        public Criteria andSectioncodeIsNotNull() {
            addCriterion("SECTIONCODE is not null");
            return (Criteria) this;
        }

        public Criteria andSectioncodeEqualTo(String value) {
            addCriterion("SECTIONCODE =", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeNotEqualTo(String value) {
            addCriterion("SECTIONCODE <>", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeGreaterThan(String value) {
            addCriterion("SECTIONCODE >", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeGreaterThanOrEqualTo(String value) {
            addCriterion("SECTIONCODE >=", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeLessThan(String value) {
            addCriterion("SECTIONCODE <", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeLessThanOrEqualTo(String value) {
            addCriterion("SECTIONCODE <=", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeLike(String value) {
            addCriterion("SECTIONCODE like", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeNotLike(String value) {
            addCriterion("SECTIONCODE not like", value, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeIn(List<String> values) {
            addCriterion("SECTIONCODE in", values, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeNotIn(List<String> values) {
            addCriterion("SECTIONCODE not in", values, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeBetween(String value1, String value2) {
            addCriterion("SECTIONCODE between", value1, value2, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andSectioncodeNotBetween(String value1, String value2) {
            addCriterion("SECTIONCODE not between", value1, value2, "sectioncode");
            return (Criteria) this;
        }

        public Criteria andCountrycodeIsNull() {
            addCriterion("COUNTRYCODE is null");
            return (Criteria) this;
        }

        public Criteria andCountrycodeIsNotNull() {
            addCriterion("COUNTRYCODE is not null");
            return (Criteria) this;
        }

        public Criteria andCountrycodeEqualTo(String value) {
            addCriterion("COUNTRYCODE =", value, "countrycode");
            return (Criteria) this;
        }

        public Criteria andCountrycodeNotEqualTo(String value) {
            addCriterion("COUNTRYCODE <>", value, "countrycode");
            return (Criteria) this;
        }

        public Criteria andCountrycodeGreaterThan(String value) {
            addCriterion("COUNTRYCODE >", value, "countrycode");
            return (Criteria) this;
        }

        public Criteria andCountrycodeGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTRYCODE >=", value, "countrycode");
            return (Criteria) this;
        }

        public Criteria andCountrycodeLessThan(String value) {
            addCriterion("COUNTRYCODE <", value, "countrycode");
            return (Criteria) this;
        }

        public Criteria andCountrycodeLessThanOrEqualTo(String value) {
            addCriterion("COUNTRYCODE <=", value, "countrycode");
            return (Criteria) this;
        }

        public Criteria andCountrycodeLike(String value) {
            addCriterion("COUNTRYCODE like", value, "countrycode");
            return (Criteria) this;
        }

        public Criteria andCountrycodeNotLike(String value) {
            addCriterion("COUNTRYCODE not like", value, "countrycode");
            return (Criteria) this;
        }

        public Criteria andCountrycodeIn(List<String> values) {
            addCriterion("COUNTRYCODE in", values, "countrycode");
            return (Criteria) this;
        }

        public Criteria andCountrycodeNotIn(List<String> values) {
            addCriterion("COUNTRYCODE not in", values, "countrycode");
            return (Criteria) this;
        }

        public Criteria andCountrycodeBetween(String value1, String value2) {
            addCriterion("COUNTRYCODE between", value1, value2, "countrycode");
            return (Criteria) this;
        }

        public Criteria andCountrycodeNotBetween(String value1, String value2) {
            addCriterion("COUNTRYCODE not between", value1, value2, "countrycode");
            return (Criteria) this;
        }

        public Criteria andLcpIsNull() {
            addCriterion("LCP is null");
            return (Criteria) this;
        }

        public Criteria andLcpIsNotNull() {
            addCriterion("LCP is not null");
            return (Criteria) this;
        }

        public Criteria andLcpEqualTo(String value) {
            addCriterion("LCP =", value, "lcp");
            return (Criteria) this;
        }

        public Criteria andLcpNotEqualTo(String value) {
            addCriterion("LCP <>", value, "lcp");
            return (Criteria) this;
        }

        public Criteria andLcpGreaterThan(String value) {
            addCriterion("LCP >", value, "lcp");
            return (Criteria) this;
        }

        public Criteria andLcpGreaterThanOrEqualTo(String value) {
            addCriterion("LCP >=", value, "lcp");
            return (Criteria) this;
        }

        public Criteria andLcpLessThan(String value) {
            addCriterion("LCP <", value, "lcp");
            return (Criteria) this;
        }

        public Criteria andLcpLessThanOrEqualTo(String value) {
            addCriterion("LCP <=", value, "lcp");
            return (Criteria) this;
        }

        public Criteria andLcpLike(String value) {
            addCriterion("LCP like", value, "lcp");
            return (Criteria) this;
        }

        public Criteria andLcpNotLike(String value) {
            addCriterion("LCP not like", value, "lcp");
            return (Criteria) this;
        }

        public Criteria andLcpIn(List<String> values) {
            addCriterion("LCP in", values, "lcp");
            return (Criteria) this;
        }

        public Criteria andLcpNotIn(List<String> values) {
            addCriterion("LCP not in", values, "lcp");
            return (Criteria) this;
        }

        public Criteria andLcpBetween(String value1, String value2) {
            addCriterion("LCP between", value1, value2, "lcp");
            return (Criteria) this;
        }

        public Criteria andLcpNotBetween(String value1, String value2) {
            addCriterion("LCP not between", value1, value2, "lcp");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateIsNull() {
            addCriterion("DONE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andDoneDateIsNotNull() {
            addCriterion("DONE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andDoneDateEqualTo(Date value) {
            addCriterion("DONE_DATE =", value, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateNotEqualTo(Date value) {
            addCriterion("DONE_DATE <>", value, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateGreaterThan(Date value) {
            addCriterion("DONE_DATE >", value, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateGreaterThanOrEqualTo(Date value) {
            addCriterion("DONE_DATE >=", value, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateLessThan(Date value) {
            addCriterion("DONE_DATE <", value, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateLessThanOrEqualTo(Date value) {
            addCriterion("DONE_DATE <=", value, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateIn(List<Date> values) {
            addCriterion("DONE_DATE in", values, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateNotIn(List<Date> values) {
            addCriterion("DONE_DATE not in", values, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateBetween(Date value1, Date value2) {
            addCriterion("DONE_DATE between", value1, value2, "doneDate");
            return (Criteria) this;
        }

        public Criteria andDoneDateNotBetween(Date value1, Date value2) {
            addCriterion("DONE_DATE not between", value1, value2, "doneDate");
            return (Criteria) this;
        }

        public Criteria andExtensionIsNull() {
            addCriterion("EXTENSION is null");
            return (Criteria) this;
        }

        public Criteria andExtensionIsNotNull() {
            addCriterion("EXTENSION is not null");
            return (Criteria) this;
        }

        public Criteria andExtensionEqualTo(String value) {
            addCriterion("EXTENSION =", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotEqualTo(String value) {
            addCriterion("EXTENSION <>", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionGreaterThan(String value) {
            addCriterion("EXTENSION >", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionGreaterThanOrEqualTo(String value) {
            addCriterion("EXTENSION >=", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionLessThan(String value) {
            addCriterion("EXTENSION <", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionLessThanOrEqualTo(String value) {
            addCriterion("EXTENSION <=", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionLike(String value) {
            addCriterion("EXTENSION like", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotLike(String value) {
            addCriterion("EXTENSION not like", value, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionIn(List<String> values) {
            addCriterion("EXTENSION in", values, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotIn(List<String> values) {
            addCriterion("EXTENSION not in", values, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionBetween(String value1, String value2) {
            addCriterion("EXTENSION between", value1, value2, "extension");
            return (Criteria) this;
        }

        public Criteria andExtensionNotBetween(String value1, String value2) {
            addCriterion("EXTENSION not between", value1, value2, "extension");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated do_not_delete_during_merge Fri Aug 28 10:19:23 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table INTER_MAP_LCP_INFO
     *
     * @mbggenerated Fri Aug 28 10:19:23 CST 2015
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