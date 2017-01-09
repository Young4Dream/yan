package com.tstar.callcenter.model.autogenerate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(long value) {
            addCriterion("USER_ID =", new Long(value), "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(long value) {
            addCriterion("USER_ID <>", new Long(value), "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(long value) {
            addCriterion("USER_ID >", new Long(value), "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(long value) {
            addCriterion("USER_ID >=", new Long(value), "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(long value) {
            addCriterion("USER_ID <", new Long(value), "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(long value) {
            addCriterion("USER_ID <=", new Long(value), "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(long value1, long value2) {
            addCriterion("USER_ID between", new Long(value1), new Long(value2), "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(long value1, long value2) {
            addCriterion("USER_ID not between", new Long(value1), new Long(value2), "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(long value) {
            addCriterion("ROLE_ID =", new Long(value), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(long value) {
            addCriterion("ROLE_ID <>", new Long(value), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(long value) {
            addCriterion("ROLE_ID >", new Long(value), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(long value) {
            addCriterion("ROLE_ID >=", new Long(value), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(long value) {
            addCriterion("ROLE_ID <", new Long(value), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(long value) {
            addCriterion("ROLE_ID <=", new Long(value), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Long> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Long> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(long value1, long value2) {
            addCriterion("ROLE_ID between", new Long(value1), new Long(value2), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(long value1, long value2) {
            addCriterion("ROLE_ID not between", new Long(value1), new Long(value2), "roleId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
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

        public Criteria andS1IsNull() {
            addCriterion("S1 is null");
            return (Criteria) this;
        }

        public Criteria andS1IsNotNull() {
            addCriterion("S1 is not null");
            return (Criteria) this;
        }

        public Criteria andS1EqualTo(String value) {
            addCriterion("S1 =", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1NotEqualTo(String value) {
            addCriterion("S1 <>", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1GreaterThan(String value) {
            addCriterion("S1 >", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1GreaterThanOrEqualTo(String value) {
            addCriterion("S1 >=", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1LessThan(String value) {
            addCriterion("S1 <", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1LessThanOrEqualTo(String value) {
            addCriterion("S1 <=", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1Like(String value) {
            addCriterion("S1 like", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1NotLike(String value) {
            addCriterion("S1 not like", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1In(List<String> values) {
            addCriterion("S1 in", values, "s1");
            return (Criteria) this;
        }

        public Criteria andS1NotIn(List<String> values) {
            addCriterion("S1 not in", values, "s1");
            return (Criteria) this;
        }

        public Criteria andS1Between(String value1, String value2) {
            addCriterion("S1 between", value1, value2, "s1");
            return (Criteria) this;
        }

        public Criteria andS1NotBetween(String value1, String value2) {
            addCriterion("S1 not between", value1, value2, "s1");
            return (Criteria) this;
        }

        public Criteria andS2IsNull() {
            addCriterion("S2 is null");
            return (Criteria) this;
        }

        public Criteria andS2IsNotNull() {
            addCriterion("S2 is not null");
            return (Criteria) this;
        }

        public Criteria andS2EqualTo(String value) {
            addCriterion("S2 =", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2NotEqualTo(String value) {
            addCriterion("S2 <>", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2GreaterThan(String value) {
            addCriterion("S2 >", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2GreaterThanOrEqualTo(String value) {
            addCriterion("S2 >=", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2LessThan(String value) {
            addCriterion("S2 <", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2LessThanOrEqualTo(String value) {
            addCriterion("S2 <=", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2Like(String value) {
            addCriterion("S2 like", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2NotLike(String value) {
            addCriterion("S2 not like", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2In(List<String> values) {
            addCriterion("S2 in", values, "s2");
            return (Criteria) this;
        }

        public Criteria andS2NotIn(List<String> values) {
            addCriterion("S2 not in", values, "s2");
            return (Criteria) this;
        }

        public Criteria andS2Between(String value1, String value2) {
            addCriterion("S2 between", value1, value2, "s2");
            return (Criteria) this;
        }

        public Criteria andS2NotBetween(String value1, String value2) {
            addCriterion("S2 not between", value1, value2, "s2");
            return (Criteria) this;
        }

        public Criteria andS3IsNull() {
            addCriterion("S3 is null");
            return (Criteria) this;
        }

        public Criteria andS3IsNotNull() {
            addCriterion("S3 is not null");
            return (Criteria) this;
        }

        public Criteria andS3EqualTo(String value) {
            addCriterion("S3 =", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3NotEqualTo(String value) {
            addCriterion("S3 <>", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3GreaterThan(String value) {
            addCriterion("S3 >", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3GreaterThanOrEqualTo(String value) {
            addCriterion("S3 >=", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3LessThan(String value) {
            addCriterion("S3 <", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3LessThanOrEqualTo(String value) {
            addCriterion("S3 <=", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3Like(String value) {
            addCriterion("S3 like", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3NotLike(String value) {
            addCriterion("S3 not like", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3In(List<String> values) {
            addCriterion("S3 in", values, "s3");
            return (Criteria) this;
        }

        public Criteria andS3NotIn(List<String> values) {
            addCriterion("S3 not in", values, "s3");
            return (Criteria) this;
        }

        public Criteria andS3Between(String value1, String value2) {
            addCriterion("S3 between", value1, value2, "s3");
            return (Criteria) this;
        }

        public Criteria andS3NotBetween(String value1, String value2) {
            addCriterion("S3 not between", value1, value2, "s3");
            return (Criteria) this;
        }

        public Criteria andS4IsNull() {
            addCriterion("S4 is null");
            return (Criteria) this;
        }

        public Criteria andS4IsNotNull() {
            addCriterion("S4 is not null");
            return (Criteria) this;
        }

        public Criteria andS4EqualTo(String value) {
            addCriterion("S4 =", value, "s4");
            return (Criteria) this;
        }

        public Criteria andS4NotEqualTo(String value) {
            addCriterion("S4 <>", value, "s4");
            return (Criteria) this;
        }

        public Criteria andS4GreaterThan(String value) {
            addCriterion("S4 >", value, "s4");
            return (Criteria) this;
        }

        public Criteria andS4GreaterThanOrEqualTo(String value) {
            addCriterion("S4 >=", value, "s4");
            return (Criteria) this;
        }

        public Criteria andS4LessThan(String value) {
            addCriterion("S4 <", value, "s4");
            return (Criteria) this;
        }

        public Criteria andS4LessThanOrEqualTo(String value) {
            addCriterion("S4 <=", value, "s4");
            return (Criteria) this;
        }

        public Criteria andS4Like(String value) {
            addCriterion("S4 like", value, "s4");
            return (Criteria) this;
        }

        public Criteria andS4NotLike(String value) {
            addCriterion("S4 not like", value, "s4");
            return (Criteria) this;
        }

        public Criteria andS4In(List<String> values) {
            addCriterion("S4 in", values, "s4");
            return (Criteria) this;
        }

        public Criteria andS4NotIn(List<String> values) {
            addCriterion("S4 not in", values, "s4");
            return (Criteria) this;
        }

        public Criteria andS4Between(String value1, String value2) {
            addCriterion("S4 between", value1, value2, "s4");
            return (Criteria) this;
        }

        public Criteria andS4NotBetween(String value1, String value2) {
            addCriterion("S4 not between", value1, value2, "s4");
            return (Criteria) this;
        }

        public Criteria andS5IsNull() {
            addCriterion("S5 is null");
            return (Criteria) this;
        }

        public Criteria andS5IsNotNull() {
            addCriterion("S5 is not null");
            return (Criteria) this;
        }

        public Criteria andS5EqualTo(String value) {
            addCriterion("S5 =", value, "s5");
            return (Criteria) this;
        }

        public Criteria andS5NotEqualTo(String value) {
            addCriterion("S5 <>", value, "s5");
            return (Criteria) this;
        }

        public Criteria andS5GreaterThan(String value) {
            addCriterion("S5 >", value, "s5");
            return (Criteria) this;
        }

        public Criteria andS5GreaterThanOrEqualTo(String value) {
            addCriterion("S5 >=", value, "s5");
            return (Criteria) this;
        }

        public Criteria andS5LessThan(String value) {
            addCriterion("S5 <", value, "s5");
            return (Criteria) this;
        }

        public Criteria andS5LessThanOrEqualTo(String value) {
            addCriterion("S5 <=", value, "s5");
            return (Criteria) this;
        }

        public Criteria andS5Like(String value) {
            addCriterion("S5 like", value, "s5");
            return (Criteria) this;
        }

        public Criteria andS5NotLike(String value) {
            addCriterion("S5 not like", value, "s5");
            return (Criteria) this;
        }

        public Criteria andS5In(List<String> values) {
            addCriterion("S5 in", values, "s5");
            return (Criteria) this;
        }

        public Criteria andS5NotIn(List<String> values) {
            addCriterion("S5 not in", values, "s5");
            return (Criteria) this;
        }

        public Criteria andS5Between(String value1, String value2) {
            addCriterion("S5 between", value1, value2, "s5");
            return (Criteria) this;
        }

        public Criteria andS5NotBetween(String value1, String value2) {
            addCriterion("S5 not between", value1, value2, "s5");
            return (Criteria) this;
        }

        public Criteria andNum1IsNull() {
            addCriterion("NUM1 is null");
            return (Criteria) this;
        }

        public Criteria andNum1IsNotNull() {
            addCriterion("NUM1 is not null");
            return (Criteria) this;
        }

        public Criteria andNum1EqualTo(long value) {
            addCriterion("NUM1 =", new Long(value), "num1");
            return (Criteria) this;
        }

        public Criteria andNum1NotEqualTo(long value) {
            addCriterion("NUM1 <>", new Long(value), "num1");
            return (Criteria) this;
        }

        public Criteria andNum1GreaterThan(long value) {
            addCriterion("NUM1 >", new Long(value), "num1");
            return (Criteria) this;
        }

        public Criteria andNum1GreaterThanOrEqualTo(long value) {
            addCriterion("NUM1 >=", new Long(value), "num1");
            return (Criteria) this;
        }

        public Criteria andNum1LessThan(long value) {
            addCriterion("NUM1 <", new Long(value), "num1");
            return (Criteria) this;
        }

        public Criteria andNum1LessThanOrEqualTo(long value) {
            addCriterion("NUM1 <=", new Long(value), "num1");
            return (Criteria) this;
        }

        public Criteria andNum1In(List<Long> values) {
            addCriterion("NUM1 in", values, "num1");
            return (Criteria) this;
        }

        public Criteria andNum1NotIn(List<Long> values) {
            addCriterion("NUM1 not in", values, "num1");
            return (Criteria) this;
        }

        public Criteria andNum1Between(long value1, long value2) {
            addCriterion("NUM1 between", new Long(value1), new Long(value2), "num1");
            return (Criteria) this;
        }

        public Criteria andNum1NotBetween(long value1, long value2) {
            addCriterion("NUM1 not between", new Long(value1), new Long(value2), "num1");
            return (Criteria) this;
        }

        public Criteria andNum2IsNull() {
            addCriterion("NUM2 is null");
            return (Criteria) this;
        }

        public Criteria andNum2IsNotNull() {
            addCriterion("NUM2 is not null");
            return (Criteria) this;
        }

        public Criteria andNum2EqualTo(long value) {
            addCriterion("NUM2 =", new Long(value), "num2");
            return (Criteria) this;
        }

        public Criteria andNum2NotEqualTo(long value) {
            addCriterion("NUM2 <>", new Long(value), "num2");
            return (Criteria) this;
        }

        public Criteria andNum2GreaterThan(long value) {
            addCriterion("NUM2 >", new Long(value), "num2");
            return (Criteria) this;
        }

        public Criteria andNum2GreaterThanOrEqualTo(long value) {
            addCriterion("NUM2 >=", new Long(value), "num2");
            return (Criteria) this;
        }

        public Criteria andNum2LessThan(long value) {
            addCriterion("NUM2 <", new Long(value), "num2");
            return (Criteria) this;
        }

        public Criteria andNum2LessThanOrEqualTo(long value) {
            addCriterion("NUM2 <=", new Long(value), "num2");
            return (Criteria) this;
        }

        public Criteria andNum2In(List<Long> values) {
            addCriterion("NUM2 in", values, "num2");
            return (Criteria) this;
        }

        public Criteria andNum2NotIn(List<Long> values) {
            addCriterion("NUM2 not in", values, "num2");
            return (Criteria) this;
        }

        public Criteria andNum2Between(long value1, long value2) {
            addCriterion("NUM2 between", new Long(value1), new Long(value2), "num2");
            return (Criteria) this;
        }

        public Criteria andNum2NotBetween(long value1, long value2) {
            addCriterion("NUM2 not between", new Long(value1), new Long(value2), "num2");
            return (Criteria) this;
        }

        public Criteria andNum3IsNull() {
            addCriterion("NUM3 is null");
            return (Criteria) this;
        }

        public Criteria andNum3IsNotNull() {
            addCriterion("NUM3 is not null");
            return (Criteria) this;
        }

        public Criteria andNum3EqualTo(long value) {
            addCriterion("NUM3 =", new Long(value), "num3");
            return (Criteria) this;
        }

        public Criteria andNum3NotEqualTo(long value) {
            addCriterion("NUM3 <>", new Long(value), "num3");
            return (Criteria) this;
        }

        public Criteria andNum3GreaterThan(long value) {
            addCriterion("NUM3 >", new Long(value), "num3");
            return (Criteria) this;
        }

        public Criteria andNum3GreaterThanOrEqualTo(long value) {
            addCriterion("NUM3 >=", new Long(value), "num3");
            return (Criteria) this;
        }

        public Criteria andNum3LessThan(long value) {
            addCriterion("NUM3 <", new Long(value), "num3");
            return (Criteria) this;
        }

        public Criteria andNum3LessThanOrEqualTo(long value) {
            addCriterion("NUM3 <=", new Long(value), "num3");
            return (Criteria) this;
        }

        public Criteria andNum3In(List<Long> values) {
            addCriterion("NUM3 in", values, "num3");
            return (Criteria) this;
        }

        public Criteria andNum3NotIn(List<Long> values) {
            addCriterion("NUM3 not in", values, "num3");
            return (Criteria) this;
        }

        public Criteria andNum3Between(long value1, long value2) {
            addCriterion("NUM3 between", new Long(value1), new Long(value2), "num3");
            return (Criteria) this;
        }

        public Criteria andNum3NotBetween(long value1, long value2) {
            addCriterion("NUM3 not between", new Long(value1), new Long(value2), "num3");
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