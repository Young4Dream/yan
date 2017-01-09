package com.tstar.callcenter.model.autogenerate;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KnowledgeExample() {
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

        public Criteria andKlIdIsNull() {
            addCriterion("KL_ID is null");
            return (Criteria) this;
        }

        public Criteria andKlIdIsNotNull() {
            addCriterion("KL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andKlIdEqualTo(Long value) {
            addCriterion("KL_ID =", value, "klId");
            return (Criteria) this;
        }

        public Criteria andKlIdNotEqualTo(Long value) {
            addCriterion("KL_ID <>", value, "klId");
            return (Criteria) this;
        }

        public Criteria andKlIdGreaterThan(Long value) {
            addCriterion("KL_ID >", value, "klId");
            return (Criteria) this;
        }

        public Criteria andKlIdGreaterThanOrEqualTo(Long value) {
            addCriterion("KL_ID >=", value, "klId");
            return (Criteria) this;
        }

        public Criteria andKlIdLessThan(Long value) {
            addCriterion("KL_ID <", value, "klId");
            return (Criteria) this;
        }

        public Criteria andKlIdLessThanOrEqualTo(Long value) {
            addCriterion("KL_ID <=", value, "klId");
            return (Criteria) this;
        }

        public Criteria andKlIdIn(List<Long> values) {
            addCriterion("KL_ID in", values, "klId");
            return (Criteria) this;
        }

        public Criteria andKlIdNotIn(List<Long> values) {
            addCriterion("KL_ID not in", values, "klId");
            return (Criteria) this;
        }

        public Criteria andKlIdBetween(Long value1, Long value2) {
            addCriterion("KL_ID between", value1, value2, "klId");
            return (Criteria) this;
        }

        public Criteria andKlIdNotBetween(Long value1, Long value2) {
            addCriterion("KL_ID not between", value1, value2, "klId");
            return (Criteria) this;
        }

        public Criteria andKlTitleIsNull() {
            addCriterion("KL_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andKlTitleIsNotNull() {
            addCriterion("KL_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andKlTitleEqualTo(String value) {
            addCriterion("KL_TITLE =", value, "klTitle");
            return (Criteria) this;
        }

        public Criteria andKlTitleNotEqualTo(String value) {
            addCriterion("KL_TITLE <>", value, "klTitle");
            return (Criteria) this;
        }

        public Criteria andKlTitleGreaterThan(String value) {
            addCriterion("KL_TITLE >", value, "klTitle");
            return (Criteria) this;
        }

        public Criteria andKlTitleGreaterThanOrEqualTo(String value) {
            addCriterion("KL_TITLE >=", value, "klTitle");
            return (Criteria) this;
        }

        public Criteria andKlTitleLessThan(String value) {
            addCriterion("KL_TITLE <", value, "klTitle");
            return (Criteria) this;
        }

        public Criteria andKlTitleLessThanOrEqualTo(String value) {
            addCriterion("KL_TITLE <=", value, "klTitle");
            return (Criteria) this;
        }

        public Criteria andKlTitleLike(String value) {
            addCriterion("KL_TITLE like", value, "klTitle");
            return (Criteria) this;
        }

        public Criteria andKlTitleNotLike(String value) {
            addCriterion("KL_TITLE not like", value, "klTitle");
            return (Criteria) this;
        }

        public Criteria andKlTitleIn(List<String> values) {
            addCriterion("KL_TITLE in", values, "klTitle");
            return (Criteria) this;
        }

        public Criteria andKlTitleNotIn(List<String> values) {
            addCriterion("KL_TITLE not in", values, "klTitle");
            return (Criteria) this;
        }

        public Criteria andKlTitleBetween(String value1, String value2) {
            addCriterion("KL_TITLE between", value1, value2, "klTitle");
            return (Criteria) this;
        }

        public Criteria andKlTitleNotBetween(String value1, String value2) {
            addCriterion("KL_TITLE not between", value1, value2, "klTitle");
            return (Criteria) this;
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

        public Criteria andKlFileUrlIsNull() {
            addCriterion("KL_FILE_URL is null");
            return (Criteria) this;
        }

        public Criteria andKlFileUrlIsNotNull() {
            addCriterion("KL_FILE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andKlFileUrlEqualTo(String value) {
            addCriterion("KL_FILE_URL =", value, "klFileUrl");
            return (Criteria) this;
        }

        public Criteria andKlFileUrlNotEqualTo(String value) {
            addCriterion("KL_FILE_URL <>", value, "klFileUrl");
            return (Criteria) this;
        }

        public Criteria andKlFileUrlGreaterThan(String value) {
            addCriterion("KL_FILE_URL >", value, "klFileUrl");
            return (Criteria) this;
        }

        public Criteria andKlFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("KL_FILE_URL >=", value, "klFileUrl");
            return (Criteria) this;
        }

        public Criteria andKlFileUrlLessThan(String value) {
            addCriterion("KL_FILE_URL <", value, "klFileUrl");
            return (Criteria) this;
        }

        public Criteria andKlFileUrlLessThanOrEqualTo(String value) {
            addCriterion("KL_FILE_URL <=", value, "klFileUrl");
            return (Criteria) this;
        }

        public Criteria andKlFileUrlLike(String value) {
            addCriterion("KL_FILE_URL like", value, "klFileUrl");
            return (Criteria) this;
        }

        public Criteria andKlFileUrlNotLike(String value) {
            addCriterion("KL_FILE_URL not like", value, "klFileUrl");
            return (Criteria) this;
        }

        public Criteria andKlFileUrlIn(List<String> values) {
            addCriterion("KL_FILE_URL in", values, "klFileUrl");
            return (Criteria) this;
        }

        public Criteria andKlFileUrlNotIn(List<String> values) {
            addCriterion("KL_FILE_URL not in", values, "klFileUrl");
            return (Criteria) this;
        }

        public Criteria andKlFileUrlBetween(String value1, String value2) {
            addCriterion("KL_FILE_URL between", value1, value2, "klFileUrl");
            return (Criteria) this;
        }

        public Criteria andKlFileUrlNotBetween(String value1, String value2) {
            addCriterion("KL_FILE_URL not between", value1, value2, "klFileUrl");
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