package com.tstar.callcenter.model.autogenerate;

import java.util.ArrayList;
import java.util.List;

public class Query114UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public Query114UserExample() {
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

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
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

        public Criteria andBm1IsNull() {
            addCriterion("BM1 is null");
            return (Criteria) this;
        }

        public Criteria andBm1IsNotNull() {
            addCriterion("BM1 is not null");
            return (Criteria) this;
        }

        public Criteria andBm1EqualTo(String value) {
            addCriterion("BM1 =", value, "bm1");
            return (Criteria) this;
        }

        public Criteria andBm1NotEqualTo(String value) {
            addCriterion("BM1 <>", value, "bm1");
            return (Criteria) this;
        }

        public Criteria andBm1GreaterThan(String value) {
            addCriterion("BM1 >", value, "bm1");
            return (Criteria) this;
        }

        public Criteria andBm1GreaterThanOrEqualTo(String value) {
            addCriterion("BM1 >=", value, "bm1");
            return (Criteria) this;
        }

        public Criteria andBm1LessThan(String value) {
            addCriterion("BM1 <", value, "bm1");
            return (Criteria) this;
        }

        public Criteria andBm1LessThanOrEqualTo(String value) {
            addCriterion("BM1 <=", value, "bm1");
            return (Criteria) this;
        }

        public Criteria andBm1Like(String value) {
            addCriterion("BM1 like", value, "bm1");
            return (Criteria) this;
        }

        public Criteria andBm1NotLike(String value) {
            addCriterion("BM1 not like", value, "bm1");
            return (Criteria) this;
        }

        public Criteria andBm1In(List<String> values) {
            addCriterion("BM1 in", values, "bm1");
            return (Criteria) this;
        }

        public Criteria andBm1NotIn(List<String> values) {
            addCriterion("BM1 not in", values, "bm1");
            return (Criteria) this;
        }

        public Criteria andBm1Between(String value1, String value2) {
            addCriterion("BM1 between", value1, value2, "bm1");
            return (Criteria) this;
        }

        public Criteria andBm1NotBetween(String value1, String value2) {
            addCriterion("BM1 not between", value1, value2, "bm1");
            return (Criteria) this;
        }

        public Criteria andBm2IsNull() {
            addCriterion("BM2 is null");
            return (Criteria) this;
        }

        public Criteria andBm2IsNotNull() {
            addCriterion("BM2 is not null");
            return (Criteria) this;
        }

        public Criteria andBm2EqualTo(String value) {
            addCriterion("BM2 =", value, "bm2");
            return (Criteria) this;
        }

        public Criteria andBm2NotEqualTo(String value) {
            addCriterion("BM2 <>", value, "bm2");
            return (Criteria) this;
        }

        public Criteria andBm2GreaterThan(String value) {
            addCriterion("BM2 >", value, "bm2");
            return (Criteria) this;
        }

        public Criteria andBm2GreaterThanOrEqualTo(String value) {
            addCriterion("BM2 >=", value, "bm2");
            return (Criteria) this;
        }

        public Criteria andBm2LessThan(String value) {
            addCriterion("BM2 <", value, "bm2");
            return (Criteria) this;
        }

        public Criteria andBm2LessThanOrEqualTo(String value) {
            addCriterion("BM2 <=", value, "bm2");
            return (Criteria) this;
        }

        public Criteria andBm2Like(String value) {
            addCriterion("BM2 like", value, "bm2");
            return (Criteria) this;
        }

        public Criteria andBm2NotLike(String value) {
            addCriterion("BM2 not like", value, "bm2");
            return (Criteria) this;
        }

        public Criteria andBm2In(List<String> values) {
            addCriterion("BM2 in", values, "bm2");
            return (Criteria) this;
        }

        public Criteria andBm2NotIn(List<String> values) {
            addCriterion("BM2 not in", values, "bm2");
            return (Criteria) this;
        }

        public Criteria andBm2Between(String value1, String value2) {
            addCriterion("BM2 between", value1, value2, "bm2");
            return (Criteria) this;
        }

        public Criteria andBm2NotBetween(String value1, String value2) {
            addCriterion("BM2 not between", value1, value2, "bm2");
            return (Criteria) this;
        }

        public Criteria andBm3IsNull() {
            addCriterion("BM3 is null");
            return (Criteria) this;
        }

        public Criteria andBm3IsNotNull() {
            addCriterion("BM3 is not null");
            return (Criteria) this;
        }

        public Criteria andBm3EqualTo(String value) {
            addCriterion("BM3 =", value, "bm3");
            return (Criteria) this;
        }

        public Criteria andBm3NotEqualTo(String value) {
            addCriterion("BM3 <>", value, "bm3");
            return (Criteria) this;
        }

        public Criteria andBm3GreaterThan(String value) {
            addCriterion("BM3 >", value, "bm3");
            return (Criteria) this;
        }

        public Criteria andBm3GreaterThanOrEqualTo(String value) {
            addCriterion("BM3 >=", value, "bm3");
            return (Criteria) this;
        }

        public Criteria andBm3LessThan(String value) {
            addCriterion("BM3 <", value, "bm3");
            return (Criteria) this;
        }

        public Criteria andBm3LessThanOrEqualTo(String value) {
            addCriterion("BM3 <=", value, "bm3");
            return (Criteria) this;
        }

        public Criteria andBm3Like(String value) {
            addCriterion("BM3 like", value, "bm3");
            return (Criteria) this;
        }

        public Criteria andBm3NotLike(String value) {
            addCriterion("BM3 not like", value, "bm3");
            return (Criteria) this;
        }

        public Criteria andBm3In(List<String> values) {
            addCriterion("BM3 in", values, "bm3");
            return (Criteria) this;
        }

        public Criteria andBm3NotIn(List<String> values) {
            addCriterion("BM3 not in", values, "bm3");
            return (Criteria) this;
        }

        public Criteria andBm3Between(String value1, String value2) {
            addCriterion("BM3 between", value1, value2, "bm3");
            return (Criteria) this;
        }

        public Criteria andBm3NotBetween(String value1, String value2) {
            addCriterion("BM3 not between", value1, value2, "bm3");
            return (Criteria) this;
        }

        public Criteria andBm4IsNull() {
            addCriterion("BM4 is null");
            return (Criteria) this;
        }

        public Criteria andBm4IsNotNull() {
            addCriterion("BM4 is not null");
            return (Criteria) this;
        }

        public Criteria andBm4EqualTo(String value) {
            addCriterion("BM4 =", value, "bm4");
            return (Criteria) this;
        }

        public Criteria andBm4NotEqualTo(String value) {
            addCriterion("BM4 <>", value, "bm4");
            return (Criteria) this;
        }

        public Criteria andBm4GreaterThan(String value) {
            addCriterion("BM4 >", value, "bm4");
            return (Criteria) this;
        }

        public Criteria andBm4GreaterThanOrEqualTo(String value) {
            addCriterion("BM4 >=", value, "bm4");
            return (Criteria) this;
        }

        public Criteria andBm4LessThan(String value) {
            addCriterion("BM4 <", value, "bm4");
            return (Criteria) this;
        }

        public Criteria andBm4LessThanOrEqualTo(String value) {
            addCriterion("BM4 <=", value, "bm4");
            return (Criteria) this;
        }

        public Criteria andBm4Like(String value) {
            addCriterion("BM4 like", value, "bm4");
            return (Criteria) this;
        }

        public Criteria andBm4NotLike(String value) {
            addCriterion("BM4 not like", value, "bm4");
            return (Criteria) this;
        }

        public Criteria andBm4In(List<String> values) {
            addCriterion("BM4 in", values, "bm4");
            return (Criteria) this;
        }

        public Criteria andBm4NotIn(List<String> values) {
            addCriterion("BM4 not in", values, "bm4");
            return (Criteria) this;
        }

        public Criteria andBm4Between(String value1, String value2) {
            addCriterion("BM4 between", value1, value2, "bm4");
            return (Criteria) this;
        }

        public Criteria andBm4NotBetween(String value1, String value2) {
            addCriterion("BM4 not between", value1, value2, "bm4");
            return (Criteria) this;
        }

        public Criteria andIndex1IsNull() {
            addCriterion("INDEX1 is null");
            return (Criteria) this;
        }

        public Criteria andIndex1IsNotNull() {
            addCriterion("INDEX1 is not null");
            return (Criteria) this;
        }

        public Criteria andIndex1EqualTo(String value) {
            addCriterion("INDEX1 =", value, "index1");
            return (Criteria) this;
        }

        public Criteria andIndex1NotEqualTo(String value) {
            addCriterion("INDEX1 <>", value, "index1");
            return (Criteria) this;
        }

        public Criteria andIndex1GreaterThan(String value) {
            addCriterion("INDEX1 >", value, "index1");
            return (Criteria) this;
        }

        public Criteria andIndex1GreaterThanOrEqualTo(String value) {
            addCriterion("INDEX1 >=", value, "index1");
            return (Criteria) this;
        }

        public Criteria andIndex1LessThan(String value) {
            addCriterion("INDEX1 <", value, "index1");
            return (Criteria) this;
        }

        public Criteria andIndex1LessThanOrEqualTo(String value) {
            addCriterion("INDEX1 <=", value, "index1");
            return (Criteria) this;
        }

        public Criteria andIndex1Like(String value) {
            addCriterion("INDEX1 like", value, "index1");
            return (Criteria) this;
        }

        public Criteria andIndex1NotLike(String value) {
            addCriterion("INDEX1 not like", value, "index1");
            return (Criteria) this;
        }

        public Criteria andIndex1In(List<String> values) {
            addCriterion("INDEX1 in", values, "index1");
            return (Criteria) this;
        }

        public Criteria andIndex1NotIn(List<String> values) {
            addCriterion("INDEX1 not in", values, "index1");
            return (Criteria) this;
        }

        public Criteria andIndex1Between(String value1, String value2) {
            addCriterion("INDEX1 between", value1, value2, "index1");
            return (Criteria) this;
        }

        public Criteria andIndex1NotBetween(String value1, String value2) {
            addCriterion("INDEX1 not between", value1, value2, "index1");
            return (Criteria) this;
        }

        public Criteria andIndex2IsNull() {
            addCriterion("INDEX2 is null");
            return (Criteria) this;
        }

        public Criteria andIndex2IsNotNull() {
            addCriterion("INDEX2 is not null");
            return (Criteria) this;
        }

        public Criteria andIndex2EqualTo(String value) {
            addCriterion("INDEX2 =", value, "index2");
            return (Criteria) this;
        }

        public Criteria andIndex2NotEqualTo(String value) {
            addCriterion("INDEX2 <>", value, "index2");
            return (Criteria) this;
        }

        public Criteria andIndex2GreaterThan(String value) {
            addCriterion("INDEX2 >", value, "index2");
            return (Criteria) this;
        }

        public Criteria andIndex2GreaterThanOrEqualTo(String value) {
            addCriterion("INDEX2 >=", value, "index2");
            return (Criteria) this;
        }

        public Criteria andIndex2LessThan(String value) {
            addCriterion("INDEX2 <", value, "index2");
            return (Criteria) this;
        }

        public Criteria andIndex2LessThanOrEqualTo(String value) {
            addCriterion("INDEX2 <=", value, "index2");
            return (Criteria) this;
        }

        public Criteria andIndex2Like(String value) {
            addCriterion("INDEX2 like", value, "index2");
            return (Criteria) this;
        }

        public Criteria andIndex2NotLike(String value) {
            addCriterion("INDEX2 not like", value, "index2");
            return (Criteria) this;
        }

        public Criteria andIndex2In(List<String> values) {
            addCriterion("INDEX2 in", values, "index2");
            return (Criteria) this;
        }

        public Criteria andIndex2NotIn(List<String> values) {
            addCriterion("INDEX2 not in", values, "index2");
            return (Criteria) this;
        }

        public Criteria andIndex2Between(String value1, String value2) {
            addCriterion("INDEX2 between", value1, value2, "index2");
            return (Criteria) this;
        }

        public Criteria andIndex2NotBetween(String value1, String value2) {
            addCriterion("INDEX2 not between", value1, value2, "index2");
            return (Criteria) this;
        }

        public Criteria andIndex3IsNull() {
            addCriterion("INDEX3 is null");
            return (Criteria) this;
        }

        public Criteria andIndex3IsNotNull() {
            addCriterion("INDEX3 is not null");
            return (Criteria) this;
        }

        public Criteria andIndex3EqualTo(String value) {
            addCriterion("INDEX3 =", value, "index3");
            return (Criteria) this;
        }

        public Criteria andIndex3NotEqualTo(String value) {
            addCriterion("INDEX3 <>", value, "index3");
            return (Criteria) this;
        }

        public Criteria andIndex3GreaterThan(String value) {
            addCriterion("INDEX3 >", value, "index3");
            return (Criteria) this;
        }

        public Criteria andIndex3GreaterThanOrEqualTo(String value) {
            addCriterion("INDEX3 >=", value, "index3");
            return (Criteria) this;
        }

        public Criteria andIndex3LessThan(String value) {
            addCriterion("INDEX3 <", value, "index3");
            return (Criteria) this;
        }

        public Criteria andIndex3LessThanOrEqualTo(String value) {
            addCriterion("INDEX3 <=", value, "index3");
            return (Criteria) this;
        }

        public Criteria andIndex3Like(String value) {
            addCriterion("INDEX3 like", value, "index3");
            return (Criteria) this;
        }

        public Criteria andIndex3NotLike(String value) {
            addCriterion("INDEX3 not like", value, "index3");
            return (Criteria) this;
        }

        public Criteria andIndex3In(List<String> values) {
            addCriterion("INDEX3 in", values, "index3");
            return (Criteria) this;
        }

        public Criteria andIndex3NotIn(List<String> values) {
            addCriterion("INDEX3 not in", values, "index3");
            return (Criteria) this;
        }

        public Criteria andIndex3Between(String value1, String value2) {
            addCriterion("INDEX3 between", value1, value2, "index3");
            return (Criteria) this;
        }

        public Criteria andIndex3NotBetween(String value1, String value2) {
            addCriterion("INDEX3 not between", value1, value2, "index3");
            return (Criteria) this;
        }

        public Criteria andIndex4IsNull() {
            addCriterion("INDEX4 is null");
            return (Criteria) this;
        }

        public Criteria andIndex4IsNotNull() {
            addCriterion("INDEX4 is not null");
            return (Criteria) this;
        }

        public Criteria andIndex4EqualTo(String value) {
            addCriterion("INDEX4 =", value, "index4");
            return (Criteria) this;
        }

        public Criteria andIndex4NotEqualTo(String value) {
            addCriterion("INDEX4 <>", value, "index4");
            return (Criteria) this;
        }

        public Criteria andIndex4GreaterThan(String value) {
            addCriterion("INDEX4 >", value, "index4");
            return (Criteria) this;
        }

        public Criteria andIndex4GreaterThanOrEqualTo(String value) {
            addCriterion("INDEX4 >=", value, "index4");
            return (Criteria) this;
        }

        public Criteria andIndex4LessThan(String value) {
            addCriterion("INDEX4 <", value, "index4");
            return (Criteria) this;
        }

        public Criteria andIndex4LessThanOrEqualTo(String value) {
            addCriterion("INDEX4 <=", value, "index4");
            return (Criteria) this;
        }

        public Criteria andIndex4Like(String value) {
            addCriterion("INDEX4 like", value, "index4");
            return (Criteria) this;
        }

        public Criteria andIndex4NotLike(String value) {
            addCriterion("INDEX4 not like", value, "index4");
            return (Criteria) this;
        }

        public Criteria andIndex4In(List<String> values) {
            addCriterion("INDEX4 in", values, "index4");
            return (Criteria) this;
        }

        public Criteria andIndex4NotIn(List<String> values) {
            addCriterion("INDEX4 not in", values, "index4");
            return (Criteria) this;
        }

        public Criteria andIndex4Between(String value1, String value2) {
            addCriterion("INDEX4 between", value1, value2, "index4");
            return (Criteria) this;
        }

        public Criteria andIndex4NotBetween(String value1, String value2) {
            addCriterion("INDEX4 not between", value1, value2, "index4");
            return (Criteria) this;
        }

        public Criteria andIndex5IsNull() {
            addCriterion("INDEX5 is null");
            return (Criteria) this;
        }

        public Criteria andIndex5IsNotNull() {
            addCriterion("INDEX5 is not null");
            return (Criteria) this;
        }

        public Criteria andIndex5EqualTo(String value) {
            addCriterion("INDEX5 =", value, "index5");
            return (Criteria) this;
        }

        public Criteria andIndex5NotEqualTo(String value) {
            addCriterion("INDEX5 <>", value, "index5");
            return (Criteria) this;
        }

        public Criteria andIndex5GreaterThan(String value) {
            addCriterion("INDEX5 >", value, "index5");
            return (Criteria) this;
        }

        public Criteria andIndex5GreaterThanOrEqualTo(String value) {
            addCriterion("INDEX5 >=", value, "index5");
            return (Criteria) this;
        }

        public Criteria andIndex5LessThan(String value) {
            addCriterion("INDEX5 <", value, "index5");
            return (Criteria) this;
        }

        public Criteria andIndex5LessThanOrEqualTo(String value) {
            addCriterion("INDEX5 <=", value, "index5");
            return (Criteria) this;
        }

        public Criteria andIndex5Like(String value) {
            addCriterion("INDEX5 like", value, "index5");
            return (Criteria) this;
        }

        public Criteria andIndex5NotLike(String value) {
            addCriterion("INDEX5 not like", value, "index5");
            return (Criteria) this;
        }

        public Criteria andIndex5In(List<String> values) {
            addCriterion("INDEX5 in", values, "index5");
            return (Criteria) this;
        }

        public Criteria andIndex5NotIn(List<String> values) {
            addCriterion("INDEX5 not in", values, "index5");
            return (Criteria) this;
        }

        public Criteria andIndex5Between(String value1, String value2) {
            addCriterion("INDEX5 between", value1, value2, "index5");
            return (Criteria) this;
        }

        public Criteria andIndex5NotBetween(String value1, String value2) {
            addCriterion("INDEX5 not between", value1, value2, "index5");
            return (Criteria) this;
        }

        public Criteria andIndex6IsNull() {
            addCriterion("INDEX6 is null");
            return (Criteria) this;
        }

        public Criteria andIndex6IsNotNull() {
            addCriterion("INDEX6 is not null");
            return (Criteria) this;
        }

        public Criteria andIndex6EqualTo(String value) {
            addCriterion("INDEX6 =", value, "index6");
            return (Criteria) this;
        }

        public Criteria andIndex6NotEqualTo(String value) {
            addCriterion("INDEX6 <>", value, "index6");
            return (Criteria) this;
        }

        public Criteria andIndex6GreaterThan(String value) {
            addCriterion("INDEX6 >", value, "index6");
            return (Criteria) this;
        }

        public Criteria andIndex6GreaterThanOrEqualTo(String value) {
            addCriterion("INDEX6 >=", value, "index6");
            return (Criteria) this;
        }

        public Criteria andIndex6LessThan(String value) {
            addCriterion("INDEX6 <", value, "index6");
            return (Criteria) this;
        }

        public Criteria andIndex6LessThanOrEqualTo(String value) {
            addCriterion("INDEX6 <=", value, "index6");
            return (Criteria) this;
        }

        public Criteria andIndex6Like(String value) {
            addCriterion("INDEX6 like", value, "index6");
            return (Criteria) this;
        }

        public Criteria andIndex6NotLike(String value) {
            addCriterion("INDEX6 not like", value, "index6");
            return (Criteria) this;
        }

        public Criteria andIndex6In(List<String> values) {
            addCriterion("INDEX6 in", values, "index6");
            return (Criteria) this;
        }

        public Criteria andIndex6NotIn(List<String> values) {
            addCriterion("INDEX6 not in", values, "index6");
            return (Criteria) this;
        }

        public Criteria andIndex6Between(String value1, String value2) {
            addCriterion("INDEX6 between", value1, value2, "index6");
            return (Criteria) this;
        }

        public Criteria andIndex6NotBetween(String value1, String value2) {
            addCriterion("INDEX6 not between", value1, value2, "index6");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
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