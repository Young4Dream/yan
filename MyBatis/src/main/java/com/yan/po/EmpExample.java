package com.yan.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmpExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andEmpnoIsNull() {
            addCriterion("EMPNO is null");
            return (Criteria) this;
        }

        public Criteria andEmpnoIsNotNull() {
            addCriterion("EMPNO is not null");
            return (Criteria) this;
        }

        public Criteria andEmpnoEqualTo(Short value) {
            addCriterion("EMPNO =", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoNotEqualTo(Short value) {
            addCriterion("EMPNO <>", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoGreaterThan(Short value) {
            addCriterion("EMPNO >", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoGreaterThanOrEqualTo(Short value) {
            addCriterion("EMPNO >=", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoLessThan(Short value) {
            addCriterion("EMPNO <", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoLessThanOrEqualTo(Short value) {
            addCriterion("EMPNO <=", value, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoIn(List<Short> values) {
            addCriterion("EMPNO in", values, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoNotIn(List<Short> values) {
            addCriterion("EMPNO not in", values, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoBetween(Short value1, Short value2) {
            addCriterion("EMPNO between", value1, value2, "empno");
            return (Criteria) this;
        }

        public Criteria andEmpnoNotBetween(Short value1, Short value2) {
            addCriterion("EMPNO not between", value1, value2, "empno");
            return (Criteria) this;
        }

        public Criteria andEnameIsNull() {
            addCriterion("ENAME is null");
            return (Criteria) this;
        }

        public Criteria andEnameIsNotNull() {
            addCriterion("ENAME is not null");
            return (Criteria) this;
        }

        public Criteria andEnameEqualTo(String value) {
            addCriterion("ENAME =", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotEqualTo(String value) {
            addCriterion("ENAME <>", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThan(String value) {
            addCriterion("ENAME >", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameGreaterThanOrEqualTo(String value) {
            addCriterion("ENAME >=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThan(String value) {
            addCriterion("ENAME <", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLessThanOrEqualTo(String value) {
            addCriterion("ENAME <=", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameLike(String value) {
            addCriterion("ENAME like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotLike(String value) {
            addCriterion("ENAME not like", value, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameIn(List<String> values) {
            addCriterion("ENAME in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotIn(List<String> values) {
            addCriterion("ENAME not in", values, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameBetween(String value1, String value2) {
            addCriterion("ENAME between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andEnameNotBetween(String value1, String value2) {
            addCriterion("ENAME not between", value1, value2, "ename");
            return (Criteria) this;
        }

        public Criteria andJobIsNull() {
            addCriterion("JOB is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("JOB is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(String value) {
            addCriterion("JOB =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(String value) {
            addCriterion("JOB <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(String value) {
            addCriterion("JOB >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(String value) {
            addCriterion("JOB >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(String value) {
            addCriterion("JOB <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(String value) {
            addCriterion("JOB <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLike(String value) {
            addCriterion("JOB like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotLike(String value) {
            addCriterion("JOB not like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<String> values) {
            addCriterion("JOB in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<String> values) {
            addCriterion("JOB not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(String value1, String value2) {
            addCriterion("JOB between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(String value1, String value2) {
            addCriterion("JOB not between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andMgrIsNull() {
            addCriterion("MGR is null");
            return (Criteria) this;
        }

        public Criteria andMgrIsNotNull() {
            addCriterion("MGR is not null");
            return (Criteria) this;
        }

        public Criteria andMgrEqualTo(Short value) {
            addCriterion("MGR =", value, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrNotEqualTo(Short value) {
            addCriterion("MGR <>", value, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrGreaterThan(Short value) {
            addCriterion("MGR >", value, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrGreaterThanOrEqualTo(Short value) {
            addCriterion("MGR >=", value, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrLessThan(Short value) {
            addCriterion("MGR <", value, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrLessThanOrEqualTo(Short value) {
            addCriterion("MGR <=", value, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrIn(List<Short> values) {
            addCriterion("MGR in", values, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrNotIn(List<Short> values) {
            addCriterion("MGR not in", values, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrBetween(Short value1, Short value2) {
            addCriterion("MGR between", value1, value2, "mgr");
            return (Criteria) this;
        }

        public Criteria andMgrNotBetween(Short value1, Short value2) {
            addCriterion("MGR not between", value1, value2, "mgr");
            return (Criteria) this;
        }

        public Criteria andHiredateIsNull() {
            addCriterion("HIREDATE is null");
            return (Criteria) this;
        }

        public Criteria andHiredateIsNotNull() {
            addCriterion("HIREDATE is not null");
            return (Criteria) this;
        }

        public Criteria andHiredateEqualTo(Date value) {
            addCriterionForJDBCDate("HIREDATE =", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotEqualTo(Date value) {
            addCriterionForJDBCDate("HIREDATE <>", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateGreaterThan(Date value) {
            addCriterionForJDBCDate("HIREDATE >", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("HIREDATE >=", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateLessThan(Date value) {
            addCriterionForJDBCDate("HIREDATE <", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("HIREDATE <=", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateIn(List<Date> values) {
            addCriterionForJDBCDate("HIREDATE in", values, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotIn(List<Date> values) {
            addCriterionForJDBCDate("HIREDATE not in", values, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("HIREDATE between", value1, value2, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("HIREDATE not between", value1, value2, "hiredate");
            return (Criteria) this;
        }

        public Criteria andSalIsNull() {
            addCriterion("SAL is null");
            return (Criteria) this;
        }

        public Criteria andSalIsNotNull() {
            addCriterion("SAL is not null");
            return (Criteria) this;
        }

        public Criteria andSalEqualTo(BigDecimal value) {
            addCriterion("SAL =", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalNotEqualTo(BigDecimal value) {
            addCriterion("SAL <>", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalGreaterThan(BigDecimal value) {
            addCriterion("SAL >", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SAL >=", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalLessThan(BigDecimal value) {
            addCriterion("SAL <", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SAL <=", value, "sal");
            return (Criteria) this;
        }

        public Criteria andSalIn(List<BigDecimal> values) {
            addCriterion("SAL in", values, "sal");
            return (Criteria) this;
        }

        public Criteria andSalNotIn(List<BigDecimal> values) {
            addCriterion("SAL not in", values, "sal");
            return (Criteria) this;
        }

        public Criteria andSalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SAL between", value1, value2, "sal");
            return (Criteria) this;
        }

        public Criteria andSalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SAL not between", value1, value2, "sal");
            return (Criteria) this;
        }

        public Criteria andCommIsNull() {
            addCriterion("COMM is null");
            return (Criteria) this;
        }

        public Criteria andCommIsNotNull() {
            addCriterion("COMM is not null");
            return (Criteria) this;
        }

        public Criteria andCommEqualTo(BigDecimal value) {
            addCriterion("COMM =", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotEqualTo(BigDecimal value) {
            addCriterion("COMM <>", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommGreaterThan(BigDecimal value) {
            addCriterion("COMM >", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COMM >=", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommLessThan(BigDecimal value) {
            addCriterion("COMM <", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COMM <=", value, "comm");
            return (Criteria) this;
        }

        public Criteria andCommIn(List<BigDecimal> values) {
            addCriterion("COMM in", values, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotIn(List<BigDecimal> values) {
            addCriterion("COMM not in", values, "comm");
            return (Criteria) this;
        }

        public Criteria andCommBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMM between", value1, value2, "comm");
            return (Criteria) this;
        }

        public Criteria andCommNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COMM not between", value1, value2, "comm");
            return (Criteria) this;
        }

        public Criteria andDeptnoIsNull() {
            addCriterion("DEPTNO is null");
            return (Criteria) this;
        }

        public Criteria andDeptnoIsNotNull() {
            addCriterion("DEPTNO is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnoEqualTo(Short value) {
            addCriterion("DEPTNO =", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoNotEqualTo(Short value) {
            addCriterion("DEPTNO <>", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoGreaterThan(Short value) {
            addCriterion("DEPTNO >", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoGreaterThanOrEqualTo(Short value) {
            addCriterion("DEPTNO >=", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoLessThan(Short value) {
            addCriterion("DEPTNO <", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoLessThanOrEqualTo(Short value) {
            addCriterion("DEPTNO <=", value, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoIn(List<Short> values) {
            addCriterion("DEPTNO in", values, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoNotIn(List<Short> values) {
            addCriterion("DEPTNO not in", values, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoBetween(Short value1, Short value2) {
            addCriterion("DEPTNO between", value1, value2, "deptno");
            return (Criteria) this;
        }

        public Criteria andDeptnoNotBetween(Short value1, Short value2) {
            addCriterion("DEPTNO not between", value1, value2, "deptno");
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