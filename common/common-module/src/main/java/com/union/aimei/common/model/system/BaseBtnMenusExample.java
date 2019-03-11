package com.union.aimei.common.model.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class BaseBtnMenusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseBtnMenusExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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

    protected abstract static class AbstractGeneratedCriteria {
        protected List<Criterion> criteria;

        protected AbstractGeneratedCriteria() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBtnNameIsNull() {
            addCriterion("btn_name is null");
            return (Criteria) this;
        }

        public Criteria andBtnNameIsNotNull() {
            addCriterion("btn_name is not null");
            return (Criteria) this;
        }

        public Criteria andBtnNameEqualTo(String value) {
            addCriterion("btn_name =", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameNotEqualTo(String value) {
            addCriterion("btn_name <>", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameGreaterThan(String value) {
            addCriterion("btn_name >", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameGreaterThanOrEqualTo(String value) {
            addCriterion("btn_name >=", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameLessThan(String value) {
            addCriterion("btn_name <", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameLessThanOrEqualTo(String value) {
            addCriterion("btn_name <=", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameLike(String value) {
            addCriterion("btn_name like", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameNotLike(String value) {
            addCriterion("btn_name not like", value, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameIn(List<String> values) {
            addCriterion("btn_name in", values, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameNotIn(List<String> values) {
            addCriterion("btn_name not in", values, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameBetween(String value1, String value2) {
            addCriterion("btn_name between", value1, value2, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnNameNotBetween(String value1, String value2) {
            addCriterion("btn_name not between", value1, value2, "btnName");
            return (Criteria) this;
        }

        public Criteria andBtnDescIsNull() {
            addCriterion("btn_desc is null");
            return (Criteria) this;
        }

        public Criteria andBtnDescIsNotNull() {
            addCriterion("btn_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBtnDescEqualTo(String value) {
            addCriterion("btn_desc =", value, "btnDesc");
            return (Criteria) this;
        }

        public Criteria andBtnDescNotEqualTo(String value) {
            addCriterion("btn_desc <>", value, "btnDesc");
            return (Criteria) this;
        }

        public Criteria andBtnDescGreaterThan(String value) {
            addCriterion("btn_desc >", value, "btnDesc");
            return (Criteria) this;
        }

        public Criteria andBtnDescGreaterThanOrEqualTo(String value) {
            addCriterion("btn_desc >=", value, "btnDesc");
            return (Criteria) this;
        }

        public Criteria andBtnDescLessThan(String value) {
            addCriterion("btn_desc <", value, "btnDesc");
            return (Criteria) this;
        }

        public Criteria andBtnDescLessThanOrEqualTo(String value) {
            addCriterion("btn_desc <=", value, "btnDesc");
            return (Criteria) this;
        }

        public Criteria andBtnDescLike(String value) {
            addCriterion("btn_desc like", value, "btnDesc");
            return (Criteria) this;
        }

        public Criteria andBtnDescNotLike(String value) {
            addCriterion("btn_desc not like", value, "btnDesc");
            return (Criteria) this;
        }

        public Criteria andBtnDescIn(List<String> values) {
            addCriterion("btn_desc in", values, "btnDesc");
            return (Criteria) this;
        }

        public Criteria andBtnDescNotIn(List<String> values) {
            addCriterion("btn_desc not in", values, "btnDesc");
            return (Criteria) this;
        }

        public Criteria andBtnDescBetween(String value1, String value2) {
            addCriterion("btn_desc between", value1, value2, "btnDesc");
            return (Criteria) this;
        }

        public Criteria andBtnDescNotBetween(String value1, String value2) {
            addCriterion("btn_desc not between", value1, value2, "btnDesc");
            return (Criteria) this;
        }

        public Criteria andBtnCodeIsNull() {
            addCriterion("btn_code is null");
            return (Criteria) this;
        }

        public Criteria andBtnCodeIsNotNull() {
            addCriterion("btn_code is not null");
            return (Criteria) this;
        }

        public Criteria andBtnCodeEqualTo(Integer value) {
            addCriterion("btn_code =", value, "btnCode");
            return (Criteria) this;
        }

        public Criteria andBtnCodeNotEqualTo(Integer value) {
            addCriterion("btn_code <>", value, "btnCode");
            return (Criteria) this;
        }

        public Criteria andBtnCodeGreaterThan(Integer value) {
            addCriterion("btn_code >", value, "btnCode");
            return (Criteria) this;
        }

        public Criteria andBtnCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("btn_code >=", value, "btnCode");
            return (Criteria) this;
        }

        public Criteria andBtnCodeLessThan(Integer value) {
            addCriterion("btn_code <", value, "btnCode");
            return (Criteria) this;
        }

        public Criteria andBtnCodeLessThanOrEqualTo(Integer value) {
            addCriterion("btn_code <=", value, "btnCode");
            return (Criteria) this;
        }

        public Criteria andBtnCodeIn(List<Integer> values) {
            addCriterion("btn_code in", values, "btnCode");
            return (Criteria) this;
        }

        public Criteria andBtnCodeNotIn(List<Integer> values) {
            addCriterion("btn_code not in", values, "btnCode");
            return (Criteria) this;
        }

        public Criteria andBtnCodeBetween(Integer value1, Integer value2) {
            addCriterion("btn_code between", value1, value2, "btnCode");
            return (Criteria) this;
        }

        public Criteria andBtnCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("btn_code not between", value1, value2, "btnCode");
            return (Criteria) this;
        }

        public Criteria andBtnIndexIsNull() {
            addCriterion("btn_index is null");
            return (Criteria) this;
        }

        public Criteria andBtnIndexIsNotNull() {
            addCriterion("btn_index is not null");
            return (Criteria) this;
        }

        public Criteria andBtnIndexEqualTo(Integer value) {
            addCriterion("btn_index =", value, "btnIndex");
            return (Criteria) this;
        }

        public Criteria andBtnIndexNotEqualTo(Integer value) {
            addCriterion("btn_index <>", value, "btnIndex");
            return (Criteria) this;
        }

        public Criteria andBtnIndexGreaterThan(Integer value) {
            addCriterion("btn_index >", value, "btnIndex");
            return (Criteria) this;
        }

        public Criteria andBtnIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("btn_index >=", value, "btnIndex");
            return (Criteria) this;
        }

        public Criteria andBtnIndexLessThan(Integer value) {
            addCriterion("btn_index <", value, "btnIndex");
            return (Criteria) this;
        }

        public Criteria andBtnIndexLessThanOrEqualTo(Integer value) {
            addCriterion("btn_index <=", value, "btnIndex");
            return (Criteria) this;
        }

        public Criteria andBtnIndexIn(List<Integer> values) {
            addCriterion("btn_index in", values, "btnIndex");
            return (Criteria) this;
        }

        public Criteria andBtnIndexNotIn(List<Integer> values) {
            addCriterion("btn_index not in", values, "btnIndex");
            return (Criteria) this;
        }

        public Criteria andBtnIndexBetween(Integer value1, Integer value2) {
            addCriterion("btn_index between", value1, value2, "btnIndex");
            return (Criteria) this;
        }

        public Criteria andBtnIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("btn_index not between", value1, value2, "btnIndex");
            return (Criteria) this;
        }

        public Criteria andOperCodeIsNull() {
            addCriterion("oper_code is null");
            return (Criteria) this;
        }

        public Criteria andOperCodeIsNotNull() {
            addCriterion("oper_code is not null");
            return (Criteria) this;
        }

        public Criteria andOperCodeEqualTo(String value) {
            addCriterion("oper_code =", value, "operCode");
            return (Criteria) this;
        }

        public Criteria andOperCodeNotEqualTo(String value) {
            addCriterion("oper_code <>", value, "operCode");
            return (Criteria) this;
        }

        public Criteria andOperCodeGreaterThan(String value) {
            addCriterion("oper_code >", value, "operCode");
            return (Criteria) this;
        }

        public Criteria andOperCodeGreaterThanOrEqualTo(String value) {
            addCriterion("oper_code >=", value, "operCode");
            return (Criteria) this;
        }

        public Criteria andOperCodeLessThan(String value) {
            addCriterion("oper_code <", value, "operCode");
            return (Criteria) this;
        }

        public Criteria andOperCodeLessThanOrEqualTo(String value) {
            addCriterion("oper_code <=", value, "operCode");
            return (Criteria) this;
        }

        public Criteria andOperCodeLike(String value) {
            addCriterion("oper_code like", value, "operCode");
            return (Criteria) this;
        }

        public Criteria andOperCodeNotLike(String value) {
            addCriterion("oper_code not like", value, "operCode");
            return (Criteria) this;
        }

        public Criteria andOperCodeIn(List<String> values) {
            addCriterion("oper_code in", values, "operCode");
            return (Criteria) this;
        }

        public Criteria andOperCodeNotIn(List<String> values) {
            addCriterion("oper_code not in", values, "operCode");
            return (Criteria) this;
        }

        public Criteria andOperCodeBetween(String value1, String value2) {
            addCriterion("oper_code between", value1, value2, "operCode");
            return (Criteria) this;
        }

        public Criteria andOperCodeNotBetween(String value1, String value2) {
            addCriterion("oper_code not between", value1, value2, "operCode");
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

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }
    }

    public static class Criteria extends AbstractGeneratedCriteria {

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
    }
}