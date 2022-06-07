package cn.cttic.roadtransapi.orm.map.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InterMapRectInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
     */
    public InterMapRectInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
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
     * This method corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
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

        public Criteria andPilenoIsNull() {
            addCriterion("PILENO is null");
            return (Criteria) this;
        }

        public Criteria andPilenoIsNotNull() {
            addCriterion("PILENO is not null");
            return (Criteria) this;
        }

        public Criteria andPilenoEqualTo(String value) {
            addCriterion("PILENO =", value, "pileno");
            return (Criteria) this;
        }

        public Criteria andPilenoNotEqualTo(String value) {
            addCriterion("PILENO <>", value, "pileno");
            return (Criteria) this;
        }

        public Criteria andPilenoGreaterThan(String value) {
            addCriterion("PILENO >", value, "pileno");
            return (Criteria) this;
        }

        public Criteria andPilenoGreaterThanOrEqualTo(String value) {
            addCriterion("PILENO >=", value, "pileno");
            return (Criteria) this;
        }

        public Criteria andPilenoLessThan(String value) {
            addCriterion("PILENO <", value, "pileno");
            return (Criteria) this;
        }

        public Criteria andPilenoLessThanOrEqualTo(String value) {
            addCriterion("PILENO <=", value, "pileno");
            return (Criteria) this;
        }

        public Criteria andPilenoLike(String value) {
            addCriterion("PILENO like", value, "pileno");
            return (Criteria) this;
        }

        public Criteria andPilenoNotLike(String value) {
            addCriterion("PILENO not like", value, "pileno");
            return (Criteria) this;
        }

        public Criteria andPilenoIn(List<String> values) {
            addCriterion("PILENO in", values, "pileno");
            return (Criteria) this;
        }

        public Criteria andPilenoNotIn(List<String> values) {
            addCriterion("PILENO not in", values, "pileno");
            return (Criteria) this;
        }

        public Criteria andPilenoBetween(String value1, String value2) {
            addCriterion("PILENO between", value1, value2, "pileno");
            return (Criteria) this;
        }

        public Criteria andPilenoNotBetween(String value1, String value2) {
            addCriterion("PILENO not between", value1, value2, "pileno");
            return (Criteria) this;
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

        public Criteria andMultipointIsNull() {
            addCriterion("MULTIPOINT is null");
            return (Criteria) this;
        }

        public Criteria andMultipointIsNotNull() {
            addCriterion("MULTIPOINT is not null");
            return (Criteria) this;
        }

        public Criteria andMultipointEqualTo(String value) {
            addCriterion("MULTIPOINT =", value, "multipoint");
            return (Criteria) this;
        }

        public Criteria andMultipointNotEqualTo(String value) {
            addCriterion("MULTIPOINT <>", value, "multipoint");
            return (Criteria) this;
        }

        public Criteria andMultipointGreaterThan(String value) {
            addCriterion("MULTIPOINT >", value, "multipoint");
            return (Criteria) this;
        }

        public Criteria andMultipointGreaterThanOrEqualTo(String value) {
            addCriterion("MULTIPOINT >=", value, "multipoint");
            return (Criteria) this;
        }

        public Criteria andMultipointLessThan(String value) {
            addCriterion("MULTIPOINT <", value, "multipoint");
            return (Criteria) this;
        }

        public Criteria andMultipointLessThanOrEqualTo(String value) {
            addCriterion("MULTIPOINT <=", value, "multipoint");
            return (Criteria) this;
        }

        public Criteria andMultipointLike(String value) {
            addCriterion("MULTIPOINT like", value, "multipoint");
            return (Criteria) this;
        }

        public Criteria andMultipointNotLike(String value) {
            addCriterion("MULTIPOINT not like", value, "multipoint");
            return (Criteria) this;
        }

        public Criteria andMultipointIn(List<String> values) {
            addCriterion("MULTIPOINT in", values, "multipoint");
            return (Criteria) this;
        }

        public Criteria andMultipointNotIn(List<String> values) {
            addCriterion("MULTIPOINT not in", values, "multipoint");
            return (Criteria) this;
        }

        public Criteria andMultipointBetween(String value1, String value2) {
            addCriterion("MULTIPOINT between", value1, value2, "multipoint");
            return (Criteria) this;
        }

        public Criteria andMultipointNotBetween(String value1, String value2) {
            addCriterion("MULTIPOINT not between", value1, value2, "multipoint");
            return (Criteria) this;
        }

        public Criteria andLefttoppointIsNull() {
            addCriterion("LEFTTOPPOINT is null");
            return (Criteria) this;
        }

        public Criteria andLefttoppointIsNotNull() {
            addCriterion("LEFTTOPPOINT is not null");
            return (Criteria) this;
        }

        public Criteria andLefttoppointEqualTo(String value) {
            addCriterion("LEFTTOPPOINT =", value, "lefttoppoint");
            return (Criteria) this;
        }

        public Criteria andLefttoppointNotEqualTo(String value) {
            addCriterion("LEFTTOPPOINT <>", value, "lefttoppoint");
            return (Criteria) this;
        }

        public Criteria andLefttoppointGreaterThan(String value) {
            addCriterion("LEFTTOPPOINT >", value, "lefttoppoint");
            return (Criteria) this;
        }

        public Criteria andLefttoppointGreaterThanOrEqualTo(String value) {
            addCriterion("LEFTTOPPOINT >=", value, "lefttoppoint");
            return (Criteria) this;
        }

        public Criteria andLefttoppointLessThan(String value) {
            addCriterion("LEFTTOPPOINT <", value, "lefttoppoint");
            return (Criteria) this;
        }

        public Criteria andLefttoppointLessThanOrEqualTo(String value) {
            addCriterion("LEFTTOPPOINT <=", value, "lefttoppoint");
            return (Criteria) this;
        }

        public Criteria andLefttoppointLike(String value) {
            addCriterion("LEFTTOPPOINT like", value, "lefttoppoint");
            return (Criteria) this;
        }

        public Criteria andLefttoppointNotLike(String value) {
            addCriterion("LEFTTOPPOINT not like", value, "lefttoppoint");
            return (Criteria) this;
        }

        public Criteria andLefttoppointIn(List<String> values) {
            addCriterion("LEFTTOPPOINT in", values, "lefttoppoint");
            return (Criteria) this;
        }

        public Criteria andLefttoppointNotIn(List<String> values) {
            addCriterion("LEFTTOPPOINT not in", values, "lefttoppoint");
            return (Criteria) this;
        }

        public Criteria andLefttoppointBetween(String value1, String value2) {
            addCriterion("LEFTTOPPOINT between", value1, value2, "lefttoppoint");
            return (Criteria) this;
        }

        public Criteria andLefttoppointNotBetween(String value1, String value2) {
            addCriterion("LEFTTOPPOINT not between", value1, value2, "lefttoppoint");
            return (Criteria) this;
        }

        public Criteria andRighttoppointIsNull() {
            addCriterion("RIGHTTOPPOINT is null");
            return (Criteria) this;
        }

        public Criteria andRighttoppointIsNotNull() {
            addCriterion("RIGHTTOPPOINT is not null");
            return (Criteria) this;
        }

        public Criteria andRighttoppointEqualTo(String value) {
            addCriterion("RIGHTTOPPOINT =", value, "righttoppoint");
            return (Criteria) this;
        }

        public Criteria andRighttoppointNotEqualTo(String value) {
            addCriterion("RIGHTTOPPOINT <>", value, "righttoppoint");
            return (Criteria) this;
        }

        public Criteria andRighttoppointGreaterThan(String value) {
            addCriterion("RIGHTTOPPOINT >", value, "righttoppoint");
            return (Criteria) this;
        }

        public Criteria andRighttoppointGreaterThanOrEqualTo(String value) {
            addCriterion("RIGHTTOPPOINT >=", value, "righttoppoint");
            return (Criteria) this;
        }

        public Criteria andRighttoppointLessThan(String value) {
            addCriterion("RIGHTTOPPOINT <", value, "righttoppoint");
            return (Criteria) this;
        }

        public Criteria andRighttoppointLessThanOrEqualTo(String value) {
            addCriterion("RIGHTTOPPOINT <=", value, "righttoppoint");
            return (Criteria) this;
        }

        public Criteria andRighttoppointLike(String value) {
            addCriterion("RIGHTTOPPOINT like", value, "righttoppoint");
            return (Criteria) this;
        }

        public Criteria andRighttoppointNotLike(String value) {
            addCriterion("RIGHTTOPPOINT not like", value, "righttoppoint");
            return (Criteria) this;
        }

        public Criteria andRighttoppointIn(List<String> values) {
            addCriterion("RIGHTTOPPOINT in", values, "righttoppoint");
            return (Criteria) this;
        }

        public Criteria andRighttoppointNotIn(List<String> values) {
            addCriterion("RIGHTTOPPOINT not in", values, "righttoppoint");
            return (Criteria) this;
        }

        public Criteria andRighttoppointBetween(String value1, String value2) {
            addCriterion("RIGHTTOPPOINT between", value1, value2, "righttoppoint");
            return (Criteria) this;
        }

        public Criteria andRighttoppointNotBetween(String value1, String value2) {
            addCriterion("RIGHTTOPPOINT not between", value1, value2, "righttoppoint");
            return (Criteria) this;
        }

        public Criteria andLeftbottompointIsNull() {
            addCriterion("LEFTBOTTOMPOINT is null");
            return (Criteria) this;
        }

        public Criteria andLeftbottompointIsNotNull() {
            addCriterion("LEFTBOTTOMPOINT is not null");
            return (Criteria) this;
        }

        public Criteria andLeftbottompointEqualTo(String value) {
            addCriterion("LEFTBOTTOMPOINT =", value, "leftbottompoint");
            return (Criteria) this;
        }

        public Criteria andLeftbottompointNotEqualTo(String value) {
            addCriterion("LEFTBOTTOMPOINT <>", value, "leftbottompoint");
            return (Criteria) this;
        }

        public Criteria andLeftbottompointGreaterThan(String value) {
            addCriterion("LEFTBOTTOMPOINT >", value, "leftbottompoint");
            return (Criteria) this;
        }

        public Criteria andLeftbottompointGreaterThanOrEqualTo(String value) {
            addCriterion("LEFTBOTTOMPOINT >=", value, "leftbottompoint");
            return (Criteria) this;
        }

        public Criteria andLeftbottompointLessThan(String value) {
            addCriterion("LEFTBOTTOMPOINT <", value, "leftbottompoint");
            return (Criteria) this;
        }

        public Criteria andLeftbottompointLessThanOrEqualTo(String value) {
            addCriterion("LEFTBOTTOMPOINT <=", value, "leftbottompoint");
            return (Criteria) this;
        }

        public Criteria andLeftbottompointLike(String value) {
            addCriterion("LEFTBOTTOMPOINT like", value, "leftbottompoint");
            return (Criteria) this;
        }

        public Criteria andLeftbottompointNotLike(String value) {
            addCriterion("LEFTBOTTOMPOINT not like", value, "leftbottompoint");
            return (Criteria) this;
        }

        public Criteria andLeftbottompointIn(List<String> values) {
            addCriterion("LEFTBOTTOMPOINT in", values, "leftbottompoint");
            return (Criteria) this;
        }

        public Criteria andLeftbottompointNotIn(List<String> values) {
            addCriterion("LEFTBOTTOMPOINT not in", values, "leftbottompoint");
            return (Criteria) this;
        }

        public Criteria andLeftbottompointBetween(String value1, String value2) {
            addCriterion("LEFTBOTTOMPOINT between", value1, value2, "leftbottompoint");
            return (Criteria) this;
        }

        public Criteria andLeftbottompointNotBetween(String value1, String value2) {
            addCriterion("LEFTBOTTOMPOINT not between", value1, value2, "leftbottompoint");
            return (Criteria) this;
        }

        public Criteria andRightbottompointIsNull() {
            addCriterion("RIGHTBOTTOMPOINT is null");
            return (Criteria) this;
        }

        public Criteria andRightbottompointIsNotNull() {
            addCriterion("RIGHTBOTTOMPOINT is not null");
            return (Criteria) this;
        }

        public Criteria andRightbottompointEqualTo(String value) {
            addCriterion("RIGHTBOTTOMPOINT =", value, "rightbottompoint");
            return (Criteria) this;
        }

        public Criteria andRightbottompointNotEqualTo(String value) {
            addCriterion("RIGHTBOTTOMPOINT <>", value, "rightbottompoint");
            return (Criteria) this;
        }

        public Criteria andRightbottompointGreaterThan(String value) {
            addCriterion("RIGHTBOTTOMPOINT >", value, "rightbottompoint");
            return (Criteria) this;
        }

        public Criteria andRightbottompointGreaterThanOrEqualTo(String value) {
            addCriterion("RIGHTBOTTOMPOINT >=", value, "rightbottompoint");
            return (Criteria) this;
        }

        public Criteria andRightbottompointLessThan(String value) {
            addCriterion("RIGHTBOTTOMPOINT <", value, "rightbottompoint");
            return (Criteria) this;
        }

        public Criteria andRightbottompointLessThanOrEqualTo(String value) {
            addCriterion("RIGHTBOTTOMPOINT <=", value, "rightbottompoint");
            return (Criteria) this;
        }

        public Criteria andRightbottompointLike(String value) {
            addCriterion("RIGHTBOTTOMPOINT like", value, "rightbottompoint");
            return (Criteria) this;
        }

        public Criteria andRightbottompointNotLike(String value) {
            addCriterion("RIGHTBOTTOMPOINT not like", value, "rightbottompoint");
            return (Criteria) this;
        }

        public Criteria andRightbottompointIn(List<String> values) {
            addCriterion("RIGHTBOTTOMPOINT in", values, "rightbottompoint");
            return (Criteria) this;
        }

        public Criteria andRightbottompointNotIn(List<String> values) {
            addCriterion("RIGHTBOTTOMPOINT not in", values, "rightbottompoint");
            return (Criteria) this;
        }

        public Criteria andRightbottompointBetween(String value1, String value2) {
            addCriterion("RIGHTBOTTOMPOINT between", value1, value2, "rightbottompoint");
            return (Criteria) this;
        }

        public Criteria andRightbottompointNotBetween(String value1, String value2) {
            addCriterion("RIGHTBOTTOMPOINT not between", value1, value2, "rightbottompoint");
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
     * This class corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated do_not_delete_during_merge Sun Sep 06 20:26:39 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table INTER_MAP_RECT_INFO
     *
     * @mbggenerated Sun Sep 06 20:26:39 CST 2015
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