package com.tstar.callcenter.model.autogenerate;

import java.util.ArrayList;
import java.util.List;

public class SkillGroupsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SkillGroupsExample() {
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

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(long value) {
            addCriterion("group_id =", new Long(value), "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(long value) {
            addCriterion("group_id <>", new Long(value), "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(long value) {
            addCriterion("group_id >", new Long(value), "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(long value) {
            addCriterion("group_id >=", new Long(value), "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(long value) {
            addCriterion("group_id <", new Long(value), "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(long value) {
            addCriterion("group_id <=", new Long(value), "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Long> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Long> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(long value1, long value2) {
            addCriterion("group_id between", new Long(value1), new Long(value2), "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(long value1, long value2) {
            addCriterion("group_id not between", new Long(value1), new Long(value2), "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(long value) {
            addCriterion("parent_id =", new Long(value), "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(long value) {
            addCriterion("parent_id <>", new Long(value), "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(long value) {
            addCriterion("parent_id >", new Long(value), "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(long value) {
            addCriterion("parent_id >=", new Long(value), "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(long value) {
            addCriterion("parent_id <", new Long(value), "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(long value) {
            addCriterion("parent_id <=", new Long(value), "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(long value1, long value2) {
            addCriterion("parent_id between", new Long(value1), new Long(value2), "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(long value1, long value2) {
            addCriterion("parent_id not between", new Long(value1), new Long(value2), "parentId");
            return (Criteria) this;
        }

        public Criteria andMemo1IsNull() {
            addCriterion("memo1 is null");
            return (Criteria) this;
        }

        public Criteria andMemo1IsNotNull() {
            addCriterion("memo1 is not null");
            return (Criteria) this;
        }

        public Criteria andMemo1EqualTo(String value) {
            addCriterion("memo1 =", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotEqualTo(String value) {
            addCriterion("memo1 <>", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1GreaterThan(String value) {
            addCriterion("memo1 >", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1GreaterThanOrEqualTo(String value) {
            addCriterion("memo1 >=", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1LessThan(String value) {
            addCriterion("memo1 <", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1LessThanOrEqualTo(String value) {
            addCriterion("memo1 <=", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1Like(String value) {
            addCriterion("memo1 like", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotLike(String value) {
            addCriterion("memo1 not like", value, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1In(List<String> values) {
            addCriterion("memo1 in", values, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotIn(List<String> values) {
            addCriterion("memo1 not in", values, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1Between(String value1, String value2) {
            addCriterion("memo1 between", value1, value2, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo1NotBetween(String value1, String value2) {
            addCriterion("memo1 not between", value1, value2, "memo1");
            return (Criteria) this;
        }

        public Criteria andMemo2IsNull() {
            addCriterion("memo2 is null");
            return (Criteria) this;
        }

        public Criteria andMemo2IsNotNull() {
            addCriterion("memo2 is not null");
            return (Criteria) this;
        }

        public Criteria andMemo2EqualTo(String value) {
            addCriterion("memo2 =", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotEqualTo(String value) {
            addCriterion("memo2 <>", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2GreaterThan(String value) {
            addCriterion("memo2 >", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2GreaterThanOrEqualTo(String value) {
            addCriterion("memo2 >=", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2LessThan(String value) {
            addCriterion("memo2 <", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2LessThanOrEqualTo(String value) {
            addCriterion("memo2 <=", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2Like(String value) {
            addCriterion("memo2 like", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotLike(String value) {
            addCriterion("memo2 not like", value, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2In(List<String> values) {
            addCriterion("memo2 in", values, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotIn(List<String> values) {
            addCriterion("memo2 not in", values, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2Between(String value1, String value2) {
            addCriterion("memo2 between", value1, value2, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo2NotBetween(String value1, String value2) {
            addCriterion("memo2 not between", value1, value2, "memo2");
            return (Criteria) this;
        }

        public Criteria andMemo3IsNull() {
            addCriterion("memo3 is null");
            return (Criteria) this;
        }

        public Criteria andMemo3IsNotNull() {
            addCriterion("memo3 is not null");
            return (Criteria) this;
        }

        public Criteria andMemo3EqualTo(String value) {
            addCriterion("memo3 =", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3NotEqualTo(String value) {
            addCriterion("memo3 <>", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3GreaterThan(String value) {
            addCriterion("memo3 >", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3GreaterThanOrEqualTo(String value) {
            addCriterion("memo3 >=", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3LessThan(String value) {
            addCriterion("memo3 <", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3LessThanOrEqualTo(String value) {
            addCriterion("memo3 <=", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3Like(String value) {
            addCriterion("memo3 like", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3NotLike(String value) {
            addCriterion("memo3 not like", value, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3In(List<String> values) {
            addCriterion("memo3 in", values, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3NotIn(List<String> values) {
            addCriterion("memo3 not in", values, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3Between(String value1, String value2) {
            addCriterion("memo3 between", value1, value2, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo3NotBetween(String value1, String value2) {
            addCriterion("memo3 not between", value1, value2, "memo3");
            return (Criteria) this;
        }

        public Criteria andMemo4IsNull() {
            addCriterion("memo4 is null");
            return (Criteria) this;
        }

        public Criteria andMemo4IsNotNull() {
            addCriterion("memo4 is not null");
            return (Criteria) this;
        }

        public Criteria andMemo4EqualTo(String value) {
            addCriterion("memo4 =", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4NotEqualTo(String value) {
            addCriterion("memo4 <>", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4GreaterThan(String value) {
            addCriterion("memo4 >", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4GreaterThanOrEqualTo(String value) {
            addCriterion("memo4 >=", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4LessThan(String value) {
            addCriterion("memo4 <", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4LessThanOrEqualTo(String value) {
            addCriterion("memo4 <=", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4Like(String value) {
            addCriterion("memo4 like", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4NotLike(String value) {
            addCriterion("memo4 not like", value, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4In(List<String> values) {
            addCriterion("memo4 in", values, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4NotIn(List<String> values) {
            addCriterion("memo4 not in", values, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4Between(String value1, String value2) {
            addCriterion("memo4 between", value1, value2, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo4NotBetween(String value1, String value2) {
            addCriterion("memo4 not between", value1, value2, "memo4");
            return (Criteria) this;
        }

        public Criteria andMemo5IsNull() {
            addCriterion("memo5 is null");
            return (Criteria) this;
        }

        public Criteria andMemo5IsNotNull() {
            addCriterion("memo5 is not null");
            return (Criteria) this;
        }

        public Criteria andMemo5EqualTo(String value) {
            addCriterion("memo5 =", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5NotEqualTo(String value) {
            addCriterion("memo5 <>", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5GreaterThan(String value) {
            addCriterion("memo5 >", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5GreaterThanOrEqualTo(String value) {
            addCriterion("memo5 >=", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5LessThan(String value) {
            addCriterion("memo5 <", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5LessThanOrEqualTo(String value) {
            addCriterion("memo5 <=", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5Like(String value) {
            addCriterion("memo5 like", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5NotLike(String value) {
            addCriterion("memo5 not like", value, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5In(List<String> values) {
            addCriterion("memo5 in", values, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5NotIn(List<String> values) {
            addCriterion("memo5 not in", values, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5Between(String value1, String value2) {
            addCriterion("memo5 between", value1, value2, "memo5");
            return (Criteria) this;
        }

        public Criteria andMemo5NotBetween(String value1, String value2) {
            addCriterion("memo5 not between", value1, value2, "memo5");
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