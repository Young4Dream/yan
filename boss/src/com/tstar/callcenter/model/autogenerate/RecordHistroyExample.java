package com.tstar.callcenter.model.autogenerate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordHistroyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecordHistroyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdEqualTo(long value) {
            addCriterion("ID =", new Long(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(long value) {
            addCriterion("ID <>", new Long(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(long value) {
            addCriterion("ID >", new Long(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(long value) {
            addCriterion("ID >=", new Long(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(long value) {
            addCriterion("ID <", new Long(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(long value) {
            addCriterion("ID <=", new Long(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(long value1, long value2) {
            addCriterion("ID between", new Long(value1), new Long(value2), "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(long value1, long value2) {
            addCriterion("ID not between", new Long(value1), new Long(value2), "id");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("FILE_PATH is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("FILE_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("FILE_PATH =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("FILE_PATH <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("FILE_PATH >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_PATH >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("FILE_PATH <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("FILE_PATH <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("FILE_PATH like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("FILE_PATH not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("FILE_PATH in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("FILE_PATH not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("FILE_PATH between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("FILE_PATH not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNull() {
            addCriterion("CREAT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIsNotNull() {
            addCriterion("CREAT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatTimeEqualTo(Date value) {
            addCriterion("CREAT_TIME =", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotEqualTo(Date value) {
            addCriterion("CREAT_TIME <>", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThan(Date value) {
            addCriterion("CREAT_TIME >", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREAT_TIME >=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThan(Date value) {
            addCriterion("CREAT_TIME <", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREAT_TIME <=", value, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeIn(List<Date> values) {
            addCriterion("CREAT_TIME in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotIn(List<Date> values) {
            addCriterion("CREAT_TIME not in", values, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeBetween(Date value1, Date value2) {
            addCriterion("CREAT_TIME between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andCreatTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREAT_TIME not between", value1, value2, "creatTime");
            return (Criteria) this;
        }

        public Criteria andEmplNoIsNull() {
            addCriterion("EMPL_NO is null");
            return (Criteria) this;
        }

        public Criteria andEmplNoIsNotNull() {
            addCriterion("EMPL_NO is not null");
            return (Criteria) this;
        }

        public Criteria andEmplNoEqualTo(String value) {
            addCriterion("EMPL_NO =", value, "emplNo");
            return (Criteria) this;
        }

        public Criteria andEmplNoNotEqualTo(String value) {
            addCriterion("EMPL_NO <>", value, "emplNo");
            return (Criteria) this;
        }

        public Criteria andEmplNoGreaterThan(String value) {
            addCriterion("EMPL_NO >", value, "emplNo");
            return (Criteria) this;
        }

        public Criteria andEmplNoGreaterThanOrEqualTo(String value) {
            addCriterion("EMPL_NO >=", value, "emplNo");
            return (Criteria) this;
        }

        public Criteria andEmplNoLessThan(String value) {
            addCriterion("EMPL_NO <", value, "emplNo");
            return (Criteria) this;
        }

        public Criteria andEmplNoLessThanOrEqualTo(String value) {
            addCriterion("EMPL_NO <=", value, "emplNo");
            return (Criteria) this;
        }

        public Criteria andEmplNoLike(String value) {
            addCriterion("EMPL_NO like", value, "emplNo");
            return (Criteria) this;
        }

        public Criteria andEmplNoNotLike(String value) {
            addCriterion("EMPL_NO not like", value, "emplNo");
            return (Criteria) this;
        }

        public Criteria andEmplNoIn(List<String> values) {
            addCriterion("EMPL_NO in", values, "emplNo");
            return (Criteria) this;
        }

        public Criteria andEmplNoNotIn(List<String> values) {
            addCriterion("EMPL_NO not in", values, "emplNo");
            return (Criteria) this;
        }

        public Criteria andEmplNoBetween(String value1, String value2) {
            addCriterion("EMPL_NO between", value1, value2, "emplNo");
            return (Criteria) this;
        }

        public Criteria andEmplNoNotBetween(String value1, String value2) {
            addCriterion("EMPL_NO not between", value1, value2, "emplNo");
            return (Criteria) this;
        }

        public Criteria andEmplNameIsNull() {
            addCriterion("EMPL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEmplNameIsNotNull() {
            addCriterion("EMPL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEmplNameEqualTo(String value) {
            addCriterion("EMPL_NAME =", value, "emplName");
            return (Criteria) this;
        }

        public Criteria andEmplNameNotEqualTo(String value) {
            addCriterion("EMPL_NAME <>", value, "emplName");
            return (Criteria) this;
        }

        public Criteria andEmplNameGreaterThan(String value) {
            addCriterion("EMPL_NAME >", value, "emplName");
            return (Criteria) this;
        }

        public Criteria andEmplNameGreaterThanOrEqualTo(String value) {
            addCriterion("EMPL_NAME >=", value, "emplName");
            return (Criteria) this;
        }

        public Criteria andEmplNameLessThan(String value) {
            addCriterion("EMPL_NAME <", value, "emplName");
            return (Criteria) this;
        }

        public Criteria andEmplNameLessThanOrEqualTo(String value) {
            addCriterion("EMPL_NAME <=", value, "emplName");
            return (Criteria) this;
        }

        public Criteria andEmplNameLike(String value) {
            addCriterion("EMPL_NAME like", value, "emplName");
            return (Criteria) this;
        }

        public Criteria andEmplNameNotLike(String value) {
            addCriterion("EMPL_NAME not like", value, "emplName");
            return (Criteria) this;
        }

        public Criteria andEmplNameIn(List<String> values) {
            addCriterion("EMPL_NAME in", values, "emplName");
            return (Criteria) this;
        }

        public Criteria andEmplNameNotIn(List<String> values) {
            addCriterion("EMPL_NAME not in", values, "emplName");
            return (Criteria) this;
        }

        public Criteria andEmplNameBetween(String value1, String value2) {
            addCriterion("EMPL_NAME between", value1, value2, "emplName");
            return (Criteria) this;
        }

        public Criteria andEmplNameNotBetween(String value1, String value2) {
            addCriterion("EMPL_NAME not between", value1, value2, "emplName");
            return (Criteria) this;
        }

        public Criteria andUserTelIsNull() {
            addCriterion("USER_TEL is null");
            return (Criteria) this;
        }

        public Criteria andUserTelIsNotNull() {
            addCriterion("USER_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andUserTelEqualTo(String value) {
            addCriterion("USER_TEL =", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotEqualTo(String value) {
            addCriterion("USER_TEL <>", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelGreaterThan(String value) {
            addCriterion("USER_TEL >", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelGreaterThanOrEqualTo(String value) {
            addCriterion("USER_TEL >=", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLessThan(String value) {
            addCriterion("USER_TEL <", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLessThanOrEqualTo(String value) {
            addCriterion("USER_TEL <=", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelLike(String value) {
            addCriterion("USER_TEL like", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotLike(String value) {
            addCriterion("USER_TEL not like", value, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelIn(List<String> values) {
            addCriterion("USER_TEL in", values, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotIn(List<String> values) {
            addCriterion("USER_TEL not in", values, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelBetween(String value1, String value2) {
            addCriterion("USER_TEL between", value1, value2, "userTel");
            return (Criteria) this;
        }

        public Criteria andUserTelNotBetween(String value1, String value2) {
            addCriterion("USER_TEL not between", value1, value2, "userTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelIsNull() {
            addCriterion("CUSTOMER_TEL is null");
            return (Criteria) this;
        }

        public Criteria andCustomerTelIsNotNull() {
            addCriterion("CUSTOMER_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerTelEqualTo(String value) {
            addCriterion("CUSTOMER_TEL =", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelNotEqualTo(String value) {
            addCriterion("CUSTOMER_TEL <>", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelGreaterThan(String value) {
            addCriterion("CUSTOMER_TEL >", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_TEL >=", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelLessThan(String value) {
            addCriterion("CUSTOMER_TEL <", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelLessThanOrEqualTo(String value) {
            addCriterion("CUSTOMER_TEL <=", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelLike(String value) {
            addCriterion("CUSTOMER_TEL like", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelNotLike(String value) {
            addCriterion("CUSTOMER_TEL not like", value, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelIn(List<String> values) {
            addCriterion("CUSTOMER_TEL in", values, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelNotIn(List<String> values) {
            addCriterion("CUSTOMER_TEL not in", values, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelBetween(String value1, String value2) {
            addCriterion("CUSTOMER_TEL between", value1, value2, "customerTel");
            return (Criteria) this;
        }

        public Criteria andCustomerTelNotBetween(String value1, String value2) {
            addCriterion("CUSTOMER_TEL not between", value1, value2, "customerTel");
            return (Criteria) this;
        }

        public Criteria andMemo1IsNull() {
            addCriterion("MEMO1 is null");
            return (Criteria) this;
        }

        public Criteria andMemo1IsNotNull() {
            addCriterion("MEMO1 is not null");
            return (Criteria) this;
        }

        public Criteria andMemo1EqualTo(String value) {
            addCriterion("MEMO1 =", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotEqualTo(String value) {
            addCriterion("MEMO1 <>", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1GreaterThan(String value) {
            addCriterion("MEMO1 >", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1GreaterThanOrEqualTo(String value) {
            addCriterion("MEMO1 >=", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1LessThan(String value) {
            addCriterion("MEMO1 <", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1LessThanOrEqualTo(String value) {
            addCriterion("MEMO1 <=", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1Like(String value) {
            addCriterion("MEMO1 like", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotLike(String value) {
            addCriterion("MEMO1 not like", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1In(List<String> values) {
            addCriterion("MEMO1 in", values, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotIn(List<String> values) {
            addCriterion("MEMO1 not in", values, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1Between(String value1, String value2) {
            addCriterion("MEMO1 between", value1, value2, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotBetween(String value1, String value2) {
            addCriterion("MEMO1 not between", value1, value2, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo2IsNull() {
            addCriterion("MEMO2 is null");
            return (Criteria) this;
        }

        public Criteria andMemo2IsNotNull() {
            addCriterion("MEMO2 is not null");
            return (Criteria) this;
        }

        public Criteria andMemo2EqualTo(String value) {
            addCriterion("MEMO2 =", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotEqualTo(String value) {
            addCriterion("MEMO2 <>", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2GreaterThan(String value) {
            addCriterion("MEMO2 >", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2GreaterThanOrEqualTo(String value) {
            addCriterion("MEMO2 >=", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2LessThan(String value) {
            addCriterion("MEMO2 <", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2LessThanOrEqualTo(String value) {
            addCriterion("MEMO2 <=", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2Like(String value) {
            addCriterion("MEMO2 like", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotLike(String value) {
            addCriterion("MEMO2 not like", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2In(List<String> values) {
            addCriterion("MEMO2 in", values, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotIn(List<String> values) {
            addCriterion("MEMO2 not in", values, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2Between(String value1, String value2) {
            addCriterion("MEMO2 between", value1, value2, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotBetween(String value1, String value2) {
            addCriterion("MEMO2 not between", value1, value2, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo3IsNull() {
            addCriterion("MEMO3 is null");
            return (Criteria) this;
        }

        public Criteria andMemo3IsNotNull() {
            addCriterion("MEMO3 is not null");
            return (Criteria) this;
        }

        public Criteria andMemo3EqualTo(String value) {
            addCriterion("MEMO3 =", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3NotEqualTo(String value) {
            addCriterion("MEMO3 <>", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3GreaterThan(String value) {
            addCriterion("MEMO3 >", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3GreaterThanOrEqualTo(String value) {
            addCriterion("MEMO3 >=", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3LessThan(String value) {
            addCriterion("MEMO3 <", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3LessThanOrEqualTo(String value) {
            addCriterion("MEMO3 <=", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3Like(String value) {
            addCriterion("MEMO3 like", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3NotLike(String value) {
            addCriterion("MEMO3 not like", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3In(List<String> values) {
            addCriterion("MEMO3 in", values, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3NotIn(List<String> values) {
            addCriterion("MEMO3 not in", values, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3Between(String value1, String value2) {
            addCriterion("MEMO3 between", value1, value2, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3NotBetween(String value1, String value2) {
            addCriterion("MEMO3 not between", value1, value2, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo4IsNull() {
            addCriterion("MEMO4 is null");
            return (Criteria) this;
        }

        public Criteria andMemo4IsNotNull() {
            addCriterion("MEMO4 is not null");
            return (Criteria) this;
        }

        public Criteria andMemo4EqualTo(String value) {
            addCriterion("MEMO4 =", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4NotEqualTo(String value) {
            addCriterion("MEMO4 <>", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4GreaterThan(String value) {
            addCriterion("MEMO4 >", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4GreaterThanOrEqualTo(String value) {
            addCriterion("MEMO4 >=", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4LessThan(String value) {
            addCriterion("MEMO4 <", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4LessThanOrEqualTo(String value) {
            addCriterion("MEMO4 <=", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4Like(String value) {
            addCriterion("MEMO4 like", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4NotLike(String value) {
            addCriterion("MEMO4 not like", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4In(List<String> values) {
            addCriterion("MEMO4 in", values, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4NotIn(List<String> values) {
            addCriterion("MEMO4 not in", values, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4Between(String value1, String value2) {
            addCriterion("MEMO4 between", value1, value2, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4NotBetween(String value1, String value2) {
            addCriterion("MEMO4 not between", value1, value2, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo5IsNull() {
            addCriterion("MEMO5 is null");
            return (Criteria) this;
        }

        public Criteria andMemo5IsNotNull() {
            addCriterion("MEMO5 is not null");
            return (Criteria) this;
        }

        public Criteria andMemo5EqualTo(String value) {
            addCriterion("MEMO5 =", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5NotEqualTo(String value) {
            addCriterion("MEMO5 <>", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5GreaterThan(String value) {
            addCriterion("MEMO5 >", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5GreaterThanOrEqualTo(String value) {
            addCriterion("MEMO5 >=", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5LessThan(String value) {
            addCriterion("MEMO5 <", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5LessThanOrEqualTo(String value) {
            addCriterion("MEMO5 <=", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5Like(String value) {
            addCriterion("MEMO5 like", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5NotLike(String value) {
            addCriterion("MEMO5 not like", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5In(List<String> values) {
            addCriterion("MEMO5 in", values, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5NotIn(List<String> values) {
            addCriterion("MEMO5 not in", values, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5Between(String value1, String value2) {
            addCriterion("MEMO5 between", value1, value2, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5NotBetween(String value1, String value2) {
            addCriterion("MEMO5 not between", value1, value2, "memo5");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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