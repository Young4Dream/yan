package com.tstar.callcenter.model.autogenerate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleInfoExample() {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(long value) {
            addCriterion("role_id =", new Long(value), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(long value) {
            addCriterion("role_id <>", new Long(value), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(long value) {
            addCriterion("role_id >", new Long(value), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(long value) {
            addCriterion("role_id >=", new Long(value), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(long value) {
            addCriterion("role_id <", new Long(value), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(long value) {
            addCriterion("role_id <=", new Long(value), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Long> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Long> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(long value1, long value2) {
            addCriterion("role_id between", new Long(value1), new Long(value2), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(long value1, long value2) {
            addCriterion("role_id not between", new Long(value1), new Long(value2), "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andIsAdminIsNull() {
            addCriterion("is_admin is null");
            return (Criteria) this;
        }

        public Criteria andIsAdminIsNotNull() {
            addCriterion("is_admin is not null");
            return (Criteria) this;
        }

        public Criteria andIsAdminEqualTo(long value) {
            addCriterion("is_admin =", new Long(value), "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotEqualTo(long value) {
            addCriterion("is_admin <>", new Long(value), "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminGreaterThan(long value) {
            addCriterion("is_admin >", new Long(value), "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminGreaterThanOrEqualTo(long value) {
            addCriterion("is_admin >=", new Long(value), "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminLessThan(long value) {
            addCriterion("is_admin <", new Long(value), "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminLessThanOrEqualTo(long value) {
            addCriterion("is_admin <=", new Long(value), "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminIn(List<Long> values) {
            addCriterion("is_admin in", values, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotIn(List<Long> values) {
            addCriterion("is_admin not in", values, "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminBetween(long value1, long value2) {
            addCriterion("is_admin between", new Long(value1), new Long(value2), "isAdmin");
            return (Criteria) this;
        }

        public Criteria andIsAdminNotBetween(long value1, long value2) {
            addCriterion("is_admin not between", new Long(value1), new Long(value2), "isAdmin");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andS1IsNull() {
            addCriterion("s1 is null");
            return (Criteria) this;
        }

        public Criteria andS1IsNotNull() {
            addCriterion("s1 is not null");
            return (Criteria) this;
        }

        public Criteria andS1EqualTo(String value) {
            addCriterion("s1 =", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1NotEqualTo(String value) {
            addCriterion("s1 <>", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1GreaterThan(String value) {
            addCriterion("s1 >", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1GreaterThanOrEqualTo(String value) {
            addCriterion("s1 >=", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1LessThan(String value) {
            addCriterion("s1 <", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1LessThanOrEqualTo(String value) {
            addCriterion("s1 <=", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1Like(String value) {
            addCriterion("s1 like", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1NotLike(String value) {
            addCriterion("s1 not like", value, "s1");
            return (Criteria) this;
        }

        public Criteria andS1In(List<String> values) {
            addCriterion("s1 in", values, "s1");
            return (Criteria) this;
        }

        public Criteria andS1NotIn(List<String> values) {
            addCriterion("s1 not in", values, "s1");
            return (Criteria) this;
        }

        public Criteria andS1Between(String value1, String value2) {
            addCriterion("s1 between", value1, value2, "s1");
            return (Criteria) this;
        }

        public Criteria andS1NotBetween(String value1, String value2) {
            addCriterion("s1 not between", value1, value2, "s1");
            return (Criteria) this;
        }

        public Criteria andS2IsNull() {
            addCriterion("s2 is null");
            return (Criteria) this;
        }

        public Criteria andS2IsNotNull() {
            addCriterion("s2 is not null");
            return (Criteria) this;
        }

        public Criteria andS2EqualTo(String value) {
            addCriterion("s2 =", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2NotEqualTo(String value) {
            addCriterion("s2 <>", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2GreaterThan(String value) {
            addCriterion("s2 >", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2GreaterThanOrEqualTo(String value) {
            addCriterion("s2 >=", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2LessThan(String value) {
            addCriterion("s2 <", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2LessThanOrEqualTo(String value) {
            addCriterion("s2 <=", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2Like(String value) {
            addCriterion("s2 like", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2NotLike(String value) {
            addCriterion("s2 not like", value, "s2");
            return (Criteria) this;
        }

        public Criteria andS2In(List<String> values) {
            addCriterion("s2 in", values, "s2");
            return (Criteria) this;
        }

        public Criteria andS2NotIn(List<String> values) {
            addCriterion("s2 not in", values, "s2");
            return (Criteria) this;
        }

        public Criteria andS2Between(String value1, String value2) {
            addCriterion("s2 between", value1, value2, "s2");
            return (Criteria) this;
        }

        public Criteria andS2NotBetween(String value1, String value2) {
            addCriterion("s2 not between", value1, value2, "s2");
            return (Criteria) this;
        }

        public Criteria andS3IsNull() {
            addCriterion("s3 is null");
            return (Criteria) this;
        }

        public Criteria andS3IsNotNull() {
            addCriterion("s3 is not null");
            return (Criteria) this;
        }

        public Criteria andS3EqualTo(String value) {
            addCriterion("s3 =", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3NotEqualTo(String value) {
            addCriterion("s3 <>", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3GreaterThan(String value) {
            addCriterion("s3 >", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3GreaterThanOrEqualTo(String value) {
            addCriterion("s3 >=", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3LessThan(String value) {
            addCriterion("s3 <", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3LessThanOrEqualTo(String value) {
            addCriterion("s3 <=", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3Like(String value) {
            addCriterion("s3 like", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3NotLike(String value) {
            addCriterion("s3 not like", value, "s3");
            return (Criteria) this;
        }

        public Criteria andS3In(List<String> values) {
            addCriterion("s3 in", values, "s3");
            return (Criteria) this;
        }

        public Criteria andS3NotIn(List<String> values) {
            addCriterion("s3 not in", values, "s3");
            return (Criteria) this;
        }

        public Criteria andS3Between(String value1, String value2) {
            addCriterion("s3 between", value1, value2, "s3");
            return (Criteria) this;
        }

        public Criteria andS3NotBetween(String value1, String value2) {
            addCriterion("s3 not between", value1, value2, "s3");
            return (Criteria) this;
        }

        public Criteria andNum1IsNull() {
            addCriterion("num1 is null");
            return (Criteria) this;
        }

        public Criteria andNum1IsNotNull() {
            addCriterion("num1 is not null");
            return (Criteria) this;
        }

        public Criteria andNum1EqualTo(long value) {
            addCriterion("num1 =", new Long(value), "num1");
            return (Criteria) this;
        }

        public Criteria andNum1NotEqualTo(long value) {
            addCriterion("num1 <>", new Long(value), "num1");
            return (Criteria) this;
        }

        public Criteria andNum1GreaterThan(long value) {
            addCriterion("num1 >", new Long(value), "num1");
            return (Criteria) this;
        }

        public Criteria andNum1GreaterThanOrEqualTo(long value) {
            addCriterion("num1 >=", new Long(value), "num1");
            return (Criteria) this;
        }

        public Criteria andNum1LessThan(long value) {
            addCriterion("num1 <", new Long(value), "num1");
            return (Criteria) this;
        }

        public Criteria andNum1LessThanOrEqualTo(long value) {
            addCriterion("num1 <=", new Long(value), "num1");
            return (Criteria) this;
        }

        public Criteria andNum1In(List<Long> values) {
            addCriterion("num1 in", values, "num1");
            return (Criteria) this;
        }

        public Criteria andNum1NotIn(List<Long> values) {
            addCriterion("num1 not in", values, "num1");
            return (Criteria) this;
        }

        public Criteria andNum1Between(long value1, long value2) {
            addCriterion("num1 between", new Long(value1), new Long(value2), "num1");
            return (Criteria) this;
        }

        public Criteria andNum1NotBetween(long value1, long value2) {
            addCriterion("num1 not between", new Long(value1), new Long(value2), "num1");
            return (Criteria) this;
        }

        public Criteria andNum2IsNull() {
            addCriterion("num2 is null");
            return (Criteria) this;
        }

        public Criteria andNum2IsNotNull() {
            addCriterion("num2 is not null");
            return (Criteria) this;
        }

        public Criteria andNum2EqualTo(long value) {
            addCriterion("num2 =", new Long(value), "num2");
            return (Criteria) this;
        }

        public Criteria andNum2NotEqualTo(long value) {
            addCriterion("num2 <>", new Long(value), "num2");
            return (Criteria) this;
        }

        public Criteria andNum2GreaterThan(long value) {
            addCriterion("num2 >", new Long(value), "num2");
            return (Criteria) this;
        }

        public Criteria andNum2GreaterThanOrEqualTo(long value) {
            addCriterion("num2 >=", new Long(value), "num2");
            return (Criteria) this;
        }

        public Criteria andNum2LessThan(long value) {
            addCriterion("num2 <", new Long(value), "num2");
            return (Criteria) this;
        }

        public Criteria andNum2LessThanOrEqualTo(long value) {
            addCriterion("num2 <=", new Long(value), "num2");
            return (Criteria) this;
        }

        public Criteria andNum2In(List<Long> values) {
            addCriterion("num2 in", values, "num2");
            return (Criteria) this;
        }

        public Criteria andNum2NotIn(List<Long> values) {
            addCriterion("num2 not in", values, "num2");
            return (Criteria) this;
        }

        public Criteria andNum2Between(long value1, long value2) {
            addCriterion("num2 between", new Long(value1), new Long(value2), "num2");
            return (Criteria) this;
        }

        public Criteria andNum2NotBetween(long value1, long value2) {
            addCriterion("num2 not between", new Long(value1), new Long(value2), "num2");
            return (Criteria) this;
        }

        public Criteria andNum3IsNull() {
            addCriterion("num3 is null");
            return (Criteria) this;
        }

        public Criteria andNum3IsNotNull() {
            addCriterion("num3 is not null");
            return (Criteria) this;
        }

        public Criteria andNum3EqualTo(long value) {
            addCriterion("num3 =", new Long(value), "num3");
            return (Criteria) this;
        }

        public Criteria andNum3NotEqualTo(long value) {
            addCriterion("num3 <>", new Long(value), "num3");
            return (Criteria) this;
        }

        public Criteria andNum3GreaterThan(long value) {
            addCriterion("num3 >", new Long(value), "num3");
            return (Criteria) this;
        }

        public Criteria andNum3GreaterThanOrEqualTo(long value) {
            addCriterion("num3 >=", new Long(value), "num3");
            return (Criteria) this;
        }

        public Criteria andNum3LessThan(long value) {
            addCriterion("num3 <", new Long(value), "num3");
            return (Criteria) this;
        }

        public Criteria andNum3LessThanOrEqualTo(long value) {
            addCriterion("num3 <=", new Long(value), "num3");
            return (Criteria) this;
        }

        public Criteria andNum3In(List<Long> values) {
            addCriterion("num3 in", values, "num3");
            return (Criteria) this;
        }

        public Criteria andNum3NotIn(List<Long> values) {
            addCriterion("num3 not in", values, "num3");
            return (Criteria) this;
        }

        public Criteria andNum3Between(long value1, long value2) {
            addCriterion("num3 between", new Long(value1), new Long(value2), "num3");
            return (Criteria) this;
        }

        public Criteria andNum3NotBetween(long value1, long value2) {
            addCriterion("num3 not between", new Long(value1), new Long(value2), "num3");
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