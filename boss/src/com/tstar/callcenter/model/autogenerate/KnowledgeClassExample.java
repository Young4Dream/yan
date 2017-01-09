package com.tstar.callcenter.model.autogenerate;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KnowledgeClassExample() {
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

        public Criteria andKlcIdIsNull() {
            addCriterion("KLC_ID is null");
            return (Criteria) this;
        }

        public Criteria andKlcIdIsNotNull() {
            addCriterion("KLC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andKlcIdEqualTo(Long value) {
            addCriterion("KLC_ID =", value, "klcId");
            return (Criteria) this;
        }

        public Criteria andKlcIdNotEqualTo(Long value) {
            addCriterion("KLC_ID <>", value, "klcId");
            return (Criteria) this;
        }

        public Criteria andKlcIdGreaterThan(Long value) {
            addCriterion("KLC_ID >", value, "klcId");
            return (Criteria) this;
        }

        public Criteria andKlcIdGreaterThanOrEqualTo(Long value) {
            addCriterion("KLC_ID >=", value, "klcId");
            return (Criteria) this;
        }

        public Criteria andKlcIdLessThan(Long value) {
            addCriterion("KLC_ID <", value, "klcId");
            return (Criteria) this;
        }

        public Criteria andKlcIdLessThanOrEqualTo(Long value) {
            addCriterion("KLC_ID <=", value, "klcId");
            return (Criteria) this;
        }

        public Criteria andKlcIdIn(List<Long> values) {
            addCriterion("KLC_ID in", values, "klcId");
            return (Criteria) this;
        }

        public Criteria andKlcIdNotIn(List<Long> values) {
            addCriterion("KLC_ID not in", values, "klcId");
            return (Criteria) this;
        }

        public Criteria andKlcIdBetween(Long value1, Long value2) {
            addCriterion("KLC_ID between", value1, value2, "klcId");
            return (Criteria) this;
        }

        public Criteria andKlcIdNotBetween(Long value1, Long value2) {
            addCriterion("KLC_ID not between", value1, value2, "klcId");
            return (Criteria) this;
        }

        public Criteria andKlcNameIsNull() {
            addCriterion("KLC_NAME is null");
            return (Criteria) this;
        }

        public Criteria andKlcNameIsNotNull() {
            addCriterion("KLC_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andKlcNameEqualTo(String value) {
            addCriterion("KLC_NAME =", value, "klcName");
            return (Criteria) this;
        }

        public Criteria andKlcNameNotEqualTo(String value) {
            addCriterion("KLC_NAME <>", value, "klcName");
            return (Criteria) this;
        }

        public Criteria andKlcNameGreaterThan(String value) {
            addCriterion("KLC_NAME >", value, "klcName");
            return (Criteria) this;
        }

        public Criteria andKlcNameGreaterThanOrEqualTo(String value) {
            addCriterion("KLC_NAME >=", value, "klcName");
            return (Criteria) this;
        }

        public Criteria andKlcNameLessThan(String value) {
            addCriterion("KLC_NAME <", value, "klcName");
            return (Criteria) this;
        }

        public Criteria andKlcNameLessThanOrEqualTo(String value) {
            addCriterion("KLC_NAME <=", value, "klcName");
            return (Criteria) this;
        }

        public Criteria andKlcNameLike(String value) {
            addCriterion("KLC_NAME like", value, "klcName");
            return (Criteria) this;
        }

        public Criteria andKlcNameNotLike(String value) {
            addCriterion("KLC_NAME not like", value, "klcName");
            return (Criteria) this;
        }

        public Criteria andKlcNameIn(List<String> values) {
            addCriterion("KLC_NAME in", values, "klcName");
            return (Criteria) this;
        }

        public Criteria andKlcNameNotIn(List<String> values) {
            addCriterion("KLC_NAME not in", values, "klcName");
            return (Criteria) this;
        }

        public Criteria andKlcNameBetween(String value1, String value2) {
            addCriterion("KLC_NAME between", value1, value2, "klcName");
            return (Criteria) this;
        }

        public Criteria andKlcNameNotBetween(String value1, String value2) {
            addCriterion("KLC_NAME not between", value1, value2, "klcName");
            return (Criteria) this;
        }

        public Criteria andKlcParentidIsNull() {
            addCriterion("KLC_PARENTID is null");
            return (Criteria) this;
        }

        public Criteria andKlcParentidIsNotNull() {
            addCriterion("KLC_PARENTID is not null");
            return (Criteria) this;
        }

        public Criteria andKlcParentidEqualTo(Long value) {
            addCriterion("KLC_PARENTID =", value, "klcParentid");
            return (Criteria) this;
        }

        public Criteria andKlcParentidNotEqualTo(Long value) {
            addCriterion("KLC_PARENTID <>", value, "klcParentid");
            return (Criteria) this;
        }

        public Criteria andKlcParentidGreaterThan(Long value) {
            addCriterion("KLC_PARENTID >", value, "klcParentid");
            return (Criteria) this;
        }

        public Criteria andKlcParentidGreaterThanOrEqualTo(Long value) {
            addCriterion("KLC_PARENTID >=", value, "klcParentid");
            return (Criteria) this;
        }

        public Criteria andKlcParentidLessThan(Long value) {
            addCriterion("KLC_PARENTID <", value, "klcParentid");
            return (Criteria) this;
        }

        public Criteria andKlcParentidLessThanOrEqualTo(Long value) {
            addCriterion("KLC_PARENTID <=", value, "klcParentid");
            return (Criteria) this;
        }

        public Criteria andKlcParentidIn(List<Long> values) {
            addCriterion("KLC_PARENTID in", values, "klcParentid");
            return (Criteria) this;
        }

        public Criteria andKlcParentidNotIn(List<Long> values) {
            addCriterion("KLC_PARENTID not in", values, "klcParentid");
            return (Criteria) this;
        }

        public Criteria andKlcParentidBetween(Long value1, Long value2) {
            addCriterion("KLC_PARENTID between", value1, value2, "klcParentid");
            return (Criteria) this;
        }

        public Criteria andKlcParentidNotBetween(Long value1, Long value2) {
            addCriterion("KLC_PARENTID not between", value1, value2, "klcParentid");
            return (Criteria) this;
        }

        public Criteria andKlcOrderIsNull() {
            addCriterion("KLC_ORDER is null");
            return (Criteria) this;
        }

        public Criteria andKlcOrderIsNotNull() {
            addCriterion("KLC_ORDER is not null");
            return (Criteria) this;
        }

        public Criteria andKlcOrderEqualTo(Long value) {
            addCriterion("KLC_ORDER =", value, "klcOrder");
            return (Criteria) this;
        }

        public Criteria andKlcOrderNotEqualTo(Long value) {
            addCriterion("KLC_ORDER <>", value, "klcOrder");
            return (Criteria) this;
        }

        public Criteria andKlcOrderGreaterThan(Long value) {
            addCriterion("KLC_ORDER >", value, "klcOrder");
            return (Criteria) this;
        }

        public Criteria andKlcOrderGreaterThanOrEqualTo(Long value) {
            addCriterion("KLC_ORDER >=", value, "klcOrder");
            return (Criteria) this;
        }

        public Criteria andKlcOrderLessThan(Long value) {
            addCriterion("KLC_ORDER <", value, "klcOrder");
            return (Criteria) this;
        }

        public Criteria andKlcOrderLessThanOrEqualTo(Long value) {
            addCriterion("KLC_ORDER <=", value, "klcOrder");
            return (Criteria) this;
        }

        public Criteria andKlcOrderIn(List<Long> values) {
            addCriterion("KLC_ORDER in", values, "klcOrder");
            return (Criteria) this;
        }

        public Criteria andKlcOrderNotIn(List<Long> values) {
            addCriterion("KLC_ORDER not in", values, "klcOrder");
            return (Criteria) this;
        }

        public Criteria andKlcOrderBetween(Long value1, Long value2) {
            addCriterion("KLC_ORDER between", value1, value2, "klcOrder");
            return (Criteria) this;
        }

        public Criteria andKlcOrderNotBetween(Long value1, Long value2) {
            addCriterion("KLC_ORDER not between", value1, value2, "klcOrder");
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