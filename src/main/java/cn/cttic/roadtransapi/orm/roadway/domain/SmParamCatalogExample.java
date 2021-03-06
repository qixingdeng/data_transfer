package cn.cttic.roadtransapi.orm.roadway.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SmParamCatalogExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
     */
    public SmParamCatalogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
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
     * This method corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
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

        public Criteria andMetadataCodeIsNull() {
            addCriterion("METADATA_CODE is null");
            return (Criteria) this;
        }

        public Criteria andMetadataCodeIsNotNull() {
            addCriterion("METADATA_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andMetadataCodeEqualTo(String value) {
            addCriterion("METADATA_CODE =", value, "metadataCode");
            return (Criteria) this;
        }

        public Criteria andMetadataCodeNotEqualTo(String value) {
            addCriterion("METADATA_CODE <>", value, "metadataCode");
            return (Criteria) this;
        }

        public Criteria andMetadataCodeGreaterThan(String value) {
            addCriterion("METADATA_CODE >", value, "metadataCode");
            return (Criteria) this;
        }

        public Criteria andMetadataCodeGreaterThanOrEqualTo(String value) {
            addCriterion("METADATA_CODE >=", value, "metadataCode");
            return (Criteria) this;
        }

        public Criteria andMetadataCodeLessThan(String value) {
            addCriterion("METADATA_CODE <", value, "metadataCode");
            return (Criteria) this;
        }

        public Criteria andMetadataCodeLessThanOrEqualTo(String value) {
            addCriterion("METADATA_CODE <=", value, "metadataCode");
            return (Criteria) this;
        }

        public Criteria andMetadataCodeLike(String value) {
            addCriterion("METADATA_CODE like", value, "metadataCode");
            return (Criteria) this;
        }

        public Criteria andMetadataCodeNotLike(String value) {
            addCriterion("METADATA_CODE not like", value, "metadataCode");
            return (Criteria) this;
        }

        public Criteria andMetadataCodeIn(List<String> values) {
            addCriterion("METADATA_CODE in", values, "metadataCode");
            return (Criteria) this;
        }

        public Criteria andMetadataCodeNotIn(List<String> values) {
            addCriterion("METADATA_CODE not in", values, "metadataCode");
            return (Criteria) this;
        }

        public Criteria andMetadataCodeBetween(String value1, String value2) {
            addCriterion("METADATA_CODE between", value1, value2, "metadataCode");
            return (Criteria) this;
        }

        public Criteria andMetadataCodeNotBetween(String value1, String value2) {
            addCriterion("METADATA_CODE not between", value1, value2, "metadataCode");
            return (Criteria) this;
        }

        public Criteria andMetadataNameIsNull() {
            addCriterion("METADATA_NAME is null");
            return (Criteria) this;
        }

        public Criteria andMetadataNameIsNotNull() {
            addCriterion("METADATA_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andMetadataNameEqualTo(String value) {
            addCriterion("METADATA_NAME =", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameNotEqualTo(String value) {
            addCriterion("METADATA_NAME <>", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameGreaterThan(String value) {
            addCriterion("METADATA_NAME >", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameGreaterThanOrEqualTo(String value) {
            addCriterion("METADATA_NAME >=", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameLessThan(String value) {
            addCriterion("METADATA_NAME <", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameLessThanOrEqualTo(String value) {
            addCriterion("METADATA_NAME <=", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameLike(String value) {
            addCriterion("METADATA_NAME like", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameNotLike(String value) {
            addCriterion("METADATA_NAME not like", value, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameIn(List<String> values) {
            addCriterion("METADATA_NAME in", values, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameNotIn(List<String> values) {
            addCriterion("METADATA_NAME not in", values, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameBetween(String value1, String value2) {
            addCriterion("METADATA_NAME between", value1, value2, "metadataName");
            return (Criteria) this;
        }

        public Criteria andMetadataNameNotBetween(String value1, String value2) {
            addCriterion("METADATA_NAME not between", value1, value2, "metadataName");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIsNull() {
            addCriterion("TYPE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIsNotNull() {
            addCriterion("TYPE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeCodeEqualTo(String value) {
            addCriterion("TYPE_CODE =", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotEqualTo(String value) {
            addCriterion("TYPE_CODE <>", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThan(String value) {
            addCriterion("TYPE_CODE >", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE_CODE >=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThan(String value) {
            addCriterion("TYPE_CODE <", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLessThanOrEqualTo(String value) {
            addCriterion("TYPE_CODE <=", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeLike(String value) {
            addCriterion("TYPE_CODE like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotLike(String value) {
            addCriterion("TYPE_CODE not like", value, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeIn(List<String> values) {
            addCriterion("TYPE_CODE in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotIn(List<String> values) {
            addCriterion("TYPE_CODE not in", values, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeBetween(String value1, String value2) {
            addCriterion("TYPE_CODE between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andTypeCodeNotBetween(String value1, String value2) {
            addCriterion("TYPE_CODE not between", value1, value2, "typeCode");
            return (Criteria) this;
        }

        public Criteria andOperIdIsNull() {
            addCriterion("OPER_ID is null");
            return (Criteria) this;
        }

        public Criteria andOperIdIsNotNull() {
            addCriterion("OPER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOperIdEqualTo(String value) {
            addCriterion("OPER_ID =", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotEqualTo(String value) {
            addCriterion("OPER_ID <>", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThan(String value) {
            addCriterion("OPER_ID >", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_ID >=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThan(String value) {
            addCriterion("OPER_ID <", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLessThanOrEqualTo(String value) {
            addCriterion("OPER_ID <=", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdLike(String value) {
            addCriterion("OPER_ID like", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotLike(String value) {
            addCriterion("OPER_ID not like", value, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdIn(List<String> values) {
            addCriterion("OPER_ID in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotIn(List<String> values) {
            addCriterion("OPER_ID not in", values, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdBetween(String value1, String value2) {
            addCriterion("OPER_ID between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andOperIdNotBetween(String value1, String value2) {
            addCriterion("OPER_ID not between", value1, value2, "operId");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("MODIFY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("MODIFY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("MODIFY_DATE =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("MODIFY_DATE <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("MODIFY_DATE >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("MODIFY_DATE >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("MODIFY_DATE <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("MODIFY_DATE <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("MODIFY_DATE in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("MODIFY_DATE not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("MODIFY_DATE between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("MODIFY_DATE not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("NOTE is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("NOTE is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("NOTE =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("NOTE <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("NOTE >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("NOTE >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("NOTE <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("NOTE <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("NOTE like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("NOTE not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("NOTE in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("NOTE not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("NOTE between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("NOTE not between", value1, value2, "note");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated do_not_delete_during_merge Fri Aug 07 15:05:17 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table SM_PARAM_CATALOG
     *
     * @mbggenerated Fri Aug 07 15:05:17 CST 2015
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