package com.tstar.callcenter.model.autogenerate;

import java.util.ArrayList;
import java.util.List;

public class SkillInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SkillInfoExample() {
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

        public Criteria andSkillIdIsNull() {
            addCriterion("skill_id is null");
            return (Criteria) this;
        }

        public Criteria andSkillIdIsNotNull() {
            addCriterion("skill_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkillIdEqualTo(long value) {
            addCriterion("skill_id =", new Long(value), "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdNotEqualTo(long value) {
            addCriterion("skill_id <>", new Long(value), "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdGreaterThan(long value) {
            addCriterion("skill_id >", new Long(value), "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdGreaterThanOrEqualTo(long value) {
            addCriterion("skill_id >=", new Long(value), "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdLessThan(long value) {
            addCriterion("skill_id <", new Long(value), "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdLessThanOrEqualTo(long value) {
            addCriterion("skill_id <=", new Long(value), "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdIn(List<Long> values) {
            addCriterion("skill_id in", values, "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdNotIn(List<Long> values) {
            addCriterion("skill_id not in", values, "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdBetween(long value1, long value2) {
            addCriterion("skill_id between", new Long(value1), new Long(value2), "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillIdNotBetween(long value1, long value2) {
            addCriterion("skill_id not between", new Long(value1), new Long(value2), "skillId");
            return (Criteria) this;
        }

        public Criteria andSkillCodeIsNull() {
            addCriterion("skill_code is null");
            return (Criteria) this;
        }

        public Criteria andSkillCodeIsNotNull() {
            addCriterion("skill_code is not null");
            return (Criteria) this;
        }

        public Criteria andSkillCodeEqualTo(String value) {
            addCriterion("skill_code =", value, "skillCode");
            return (Criteria) this;
        }

        public Criteria andSkillCodeNotEqualTo(String value) {
            addCriterion("skill_code <>", value, "skillCode");
            return (Criteria) this;
        }

        public Criteria andSkillCodeGreaterThan(String value) {
            addCriterion("skill_code >", value, "skillCode");
            return (Criteria) this;
        }

        public Criteria andSkillCodeGreaterThanOrEqualTo(String value) {
            addCriterion("skill_code >=", value, "skillCode");
            return (Criteria) this;
        }

        public Criteria andSkillCodeLessThan(String value) {
            addCriterion("skill_code <", value, "skillCode");
            return (Criteria) this;
        }

        public Criteria andSkillCodeLessThanOrEqualTo(String value) {
            addCriterion("skill_code <=", value, "skillCode");
            return (Criteria) this;
        }

        public Criteria andSkillCodeLike(String value) {
            addCriterion("skill_code like", value, "skillCode");
            return (Criteria) this;
        }

        public Criteria andSkillCodeNotLike(String value) {
            addCriterion("skill_code not like", value, "skillCode");
            return (Criteria) this;
        }

        public Criteria andSkillCodeIn(List<String> values) {
            addCriterion("skill_code in", values, "skillCode");
            return (Criteria) this;
        }

        public Criteria andSkillCodeNotIn(List<String> values) {
            addCriterion("skill_code not in", values, "skillCode");
            return (Criteria) this;
        }

        public Criteria andSkillCodeBetween(String value1, String value2) {
            addCriterion("skill_code between", value1, value2, "skillCode");
            return (Criteria) this;
        }

        public Criteria andSkillCodeNotBetween(String value1, String value2) {
            addCriterion("skill_code not between", value1, value2, "skillCode");
            return (Criteria) this;
        }

        public Criteria andSkillNameIsNull() {
            addCriterion("skill_name is null");
            return (Criteria) this;
        }

        public Criteria andSkillNameIsNotNull() {
            addCriterion("skill_name is not null");
            return (Criteria) this;
        }

        public Criteria andSkillNameEqualTo(String value) {
            addCriterion("skill_name =", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameNotEqualTo(String value) {
            addCriterion("skill_name <>", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameGreaterThan(String value) {
            addCriterion("skill_name >", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameGreaterThanOrEqualTo(String value) {
            addCriterion("skill_name >=", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameLessThan(String value) {
            addCriterion("skill_name <", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameLessThanOrEqualTo(String value) {
            addCriterion("skill_name <=", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameLike(String value) {
            addCriterion("skill_name like", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameNotLike(String value) {
            addCriterion("skill_name not like", value, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameIn(List<String> values) {
            addCriterion("skill_name in", values, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameNotIn(List<String> values) {
            addCriterion("skill_name not in", values, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameBetween(String value1, String value2) {
            addCriterion("skill_name between", value1, value2, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillNameNotBetween(String value1, String value2) {
            addCriterion("skill_name not between", value1, value2, "skillName");
            return (Criteria) this;
        }

        public Criteria andSkillTypeIsNull() {
            addCriterion("skill_type is null");
            return (Criteria) this;
        }

        public Criteria andSkillTypeIsNotNull() {
            addCriterion("skill_type is not null");
            return (Criteria) this;
        }

        public Criteria andSkillTypeEqualTo(String value) {
            addCriterion("skill_type =", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeNotEqualTo(String value) {
            addCriterion("skill_type <>", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeGreaterThan(String value) {
            addCriterion("skill_type >", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeGreaterThanOrEqualTo(String value) {
            addCriterion("skill_type >=", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeLessThan(String value) {
            addCriterion("skill_type <", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeLessThanOrEqualTo(String value) {
            addCriterion("skill_type <=", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeLike(String value) {
            addCriterion("skill_type like", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeNotLike(String value) {
            addCriterion("skill_type not like", value, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeIn(List<String> values) {
            addCriterion("skill_type in", values, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeNotIn(List<String> values) {
            addCriterion("skill_type not in", values, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeBetween(String value1, String value2) {
            addCriterion("skill_type between", value1, value2, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillTypeNotBetween(String value1, String value2) {
            addCriterion("skill_type not between", value1, value2, "skillType");
            return (Criteria) this;
        }

        public Criteria andSkillDescIsNull() {
            addCriterion("skill_desc is null");
            return (Criteria) this;
        }

        public Criteria andSkillDescIsNotNull() {
            addCriterion("skill_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSkillDescEqualTo(String value) {
            addCriterion("skill_desc =", value, "skillDesc");
            return (Criteria) this;
        }

        public Criteria andSkillDescNotEqualTo(String value) {
            addCriterion("skill_desc <>", value, "skillDesc");
            return (Criteria) this;
        }

        public Criteria andSkillDescGreaterThan(String value) {
            addCriterion("skill_desc >", value, "skillDesc");
            return (Criteria) this;
        }

        public Criteria andSkillDescGreaterThanOrEqualTo(String value) {
            addCriterion("skill_desc >=", value, "skillDesc");
            return (Criteria) this;
        }

        public Criteria andSkillDescLessThan(String value) {
            addCriterion("skill_desc <", value, "skillDesc");
            return (Criteria) this;
        }

        public Criteria andSkillDescLessThanOrEqualTo(String value) {
            addCriterion("skill_desc <=", value, "skillDesc");
            return (Criteria) this;
        }

        public Criteria andSkillDescLike(String value) {
            addCriterion("skill_desc like", value, "skillDesc");
            return (Criteria) this;
        }

        public Criteria andSkillDescNotLike(String value) {
            addCriterion("skill_desc not like", value, "skillDesc");
            return (Criteria) this;
        }

        public Criteria andSkillDescIn(List<String> values) {
            addCriterion("skill_desc in", values, "skillDesc");
            return (Criteria) this;
        }

        public Criteria andSkillDescNotIn(List<String> values) {
            addCriterion("skill_desc not in", values, "skillDesc");
            return (Criteria) this;
        }

        public Criteria andSkillDescBetween(String value1, String value2) {
            addCriterion("skill_desc between", value1, value2, "skillDesc");
            return (Criteria) this;
        }

        public Criteria andSkillDescNotBetween(String value1, String value2) {
            addCriterion("skill_desc not between", value1, value2, "skillDesc");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andParamIsNull() {
            addCriterion("param is null");
            return (Criteria) this;
        }

        public Criteria andParamIsNotNull() {
            addCriterion("param is not null");
            return (Criteria) this;
        }

        public Criteria andParamEqualTo(String value) {
            addCriterion("param =", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotEqualTo(String value) {
            addCriterion("param <>", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamGreaterThan(String value) {
            addCriterion("param >", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamGreaterThanOrEqualTo(String value) {
            addCriterion("param >=", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLessThan(String value) {
            addCriterion("param <", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLessThanOrEqualTo(String value) {
            addCriterion("param <=", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLike(String value) {
            addCriterion("param like", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotLike(String value) {
            addCriterion("param not like", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamIn(List<String> values) {
            addCriterion("param in", values, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotIn(List<String> values) {
            addCriterion("param not in", values, "param");
            return (Criteria) this;
        }

        public Criteria andParamBetween(String value1, String value2) {
            addCriterion("param between", value1, value2, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotBetween(String value1, String value2) {
            addCriterion("param not between", value1, value2, "param");
            return (Criteria) this;
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