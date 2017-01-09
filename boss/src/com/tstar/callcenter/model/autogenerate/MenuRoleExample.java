package com.tstar.callcenter.model.autogenerate;

import java.util.ArrayList;
import java.util.List;

public class MenuRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuRoleExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(long value) {
            addCriterion("id =", new Long(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(long value) {
            addCriterion("id <>", new Long(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(long value) {
            addCriterion("id >", new Long(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(long value) {
            addCriterion("id >=", new Long(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(long value) {
            addCriterion("id <", new Long(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(long value) {
            addCriterion("id <=", new Long(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(long value1, long value2) {
            addCriterion("id between", new Long(value1), new Long(value2), "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(long value1, long value2) {
            addCriterion("id not between", new Long(value1), new Long(value2), "id");
            return (Criteria) this;
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(long value) {
            addCriterion("menu_id =", new Long(value), "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(long value) {
            addCriterion("menu_id <>", new Long(value), "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(long value) {
            addCriterion("menu_id >", new Long(value), "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(long value) {
            addCriterion("menu_id >=", new Long(value), "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(long value) {
            addCriterion("menu_id <", new Long(value), "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(long value) {
            addCriterion("menu_id <=", new Long(value), "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Long> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Long> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(long value1, long value2) {
            addCriterion("menu_id between", new Long(value1), new Long(value2), "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(long value1, long value2) {
            addCriterion("menu_id not between", new Long(value1), new Long(value2), "menuId");
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