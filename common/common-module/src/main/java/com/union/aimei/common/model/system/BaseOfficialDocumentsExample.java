package com.union.aimei.common.model.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class BaseOfficialDocumentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseOfficialDocumentsExample() {
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

        public Criteria andDocumentsNameIsNull() {
            addCriterion("documents_name is null");
            return (Criteria) this;
        }

        public Criteria andDocumentsNameIsNotNull() {
            addCriterion("documents_name is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentsNameEqualTo(String value) {
            addCriterion("documents_name =", value, "documentsName");
            return (Criteria) this;
        }

        public Criteria andDocumentsNameNotEqualTo(String value) {
            addCriterion("documents_name <>", value, "documentsName");
            return (Criteria) this;
        }

        public Criteria andDocumentsNameGreaterThan(String value) {
            addCriterion("documents_name >", value, "documentsName");
            return (Criteria) this;
        }

        public Criteria andDocumentsNameGreaterThanOrEqualTo(String value) {
            addCriterion("documents_name >=", value, "documentsName");
            return (Criteria) this;
        }

        public Criteria andDocumentsNameLessThan(String value) {
            addCriterion("documents_name <", value, "documentsName");
            return (Criteria) this;
        }

        public Criteria andDocumentsNameLessThanOrEqualTo(String value) {
            addCriterion("documents_name <=", value, "documentsName");
            return (Criteria) this;
        }

        public Criteria andDocumentsNameLike(String value) {
            addCriterion("documents_name like", value, "documentsName");
            return (Criteria) this;
        }

        public Criteria andDocumentsNameNotLike(String value) {
            addCriterion("documents_name not like", value, "documentsName");
            return (Criteria) this;
        }

        public Criteria andDocumentsNameIn(List<String> values) {
            addCriterion("documents_name in", values, "documentsName");
            return (Criteria) this;
        }

        public Criteria andDocumentsNameNotIn(List<String> values) {
            addCriterion("documents_name not in", values, "documentsName");
            return (Criteria) this;
        }

        public Criteria andDocumentsNameBetween(String value1, String value2) {
            addCriterion("documents_name between", value1, value2, "documentsName");
            return (Criteria) this;
        }

        public Criteria andDocumentsNameNotBetween(String value1, String value2) {
            addCriterion("documents_name not between", value1, value2, "documentsName");
            return (Criteria) this;
        }

        public Criteria andDocumentsCodeIsNull() {
            addCriterion("documents_code is null");
            return (Criteria) this;
        }

        public Criteria andDocumentsCodeIsNotNull() {
            addCriterion("documents_code is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentsCodeEqualTo(String value) {
            addCriterion("documents_code =", value, "documentsCode");
            return (Criteria) this;
        }

        public Criteria andDocumentsCodeNotEqualTo(String value) {
            addCriterion("documents_code <>", value, "documentsCode");
            return (Criteria) this;
        }

        public Criteria andDocumentsCodeGreaterThan(String value) {
            addCriterion("documents_code >", value, "documentsCode");
            return (Criteria) this;
        }

        public Criteria andDocumentsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("documents_code >=", value, "documentsCode");
            return (Criteria) this;
        }

        public Criteria andDocumentsCodeLessThan(String value) {
            addCriterion("documents_code <", value, "documentsCode");
            return (Criteria) this;
        }

        public Criteria andDocumentsCodeLessThanOrEqualTo(String value) {
            addCriterion("documents_code <=", value, "documentsCode");
            return (Criteria) this;
        }

        public Criteria andDocumentsCodeLike(String value) {
            addCriterion("documents_code like", value, "documentsCode");
            return (Criteria) this;
        }

        public Criteria andDocumentsCodeNotLike(String value) {
            addCriterion("documents_code not like", value, "documentsCode");
            return (Criteria) this;
        }

        public Criteria andDocumentsCodeIn(List<String> values) {
            addCriterion("documents_code in", values, "documentsCode");
            return (Criteria) this;
        }

        public Criteria andDocumentsCodeNotIn(List<String> values) {
            addCriterion("documents_code not in", values, "documentsCode");
            return (Criteria) this;
        }

        public Criteria andDocumentsCodeBetween(String value1, String value2) {
            addCriterion("documents_code between", value1, value2, "documentsCode");
            return (Criteria) this;
        }

        public Criteria andDocumentsCodeNotBetween(String value1, String value2) {
            addCriterion("documents_code not between", value1, value2, "documentsCode");
            return (Criteria) this;
        }

        public Criteria andDocumentsDetailIsNull() {
            addCriterion("documents_detail is null");
            return (Criteria) this;
        }

        public Criteria andDocumentsDetailIsNotNull() {
            addCriterion("documents_detail is not null");
            return (Criteria) this;
        }

        public Criteria andDocumentsDetailEqualTo(String value) {
            addCriterion("documents_detail =", value, "documentsDetail");
            return (Criteria) this;
        }

        public Criteria andDocumentsDetailNotEqualTo(String value) {
            addCriterion("documents_detail <>", value, "documentsDetail");
            return (Criteria) this;
        }

        public Criteria andDocumentsDetailGreaterThan(String value) {
            addCriterion("documents_detail >", value, "documentsDetail");
            return (Criteria) this;
        }

        public Criteria andDocumentsDetailGreaterThanOrEqualTo(String value) {
            addCriterion("documents_detail >=", value, "documentsDetail");
            return (Criteria) this;
        }

        public Criteria andDocumentsDetailLessThan(String value) {
            addCriterion("documents_detail <", value, "documentsDetail");
            return (Criteria) this;
        }

        public Criteria andDocumentsDetailLessThanOrEqualTo(String value) {
            addCriterion("documents_detail <=", value, "documentsDetail");
            return (Criteria) this;
        }

        public Criteria andDocumentsDetailLike(String value) {
            addCriterion("documents_detail like", value, "documentsDetail");
            return (Criteria) this;
        }

        public Criteria andDocumentsDetailNotLike(String value) {
            addCriterion("documents_detail not like", value, "documentsDetail");
            return (Criteria) this;
        }

        public Criteria andDocumentsDetailIn(List<String> values) {
            addCriterion("documents_detail in", values, "documentsDetail");
            return (Criteria) this;
        }

        public Criteria andDocumentsDetailNotIn(List<String> values) {
            addCriterion("documents_detail not in", values, "documentsDetail");
            return (Criteria) this;
        }

        public Criteria andDocumentsDetailBetween(String value1, String value2) {
            addCriterion("documents_detail between", value1, value2, "documentsDetail");
            return (Criteria) this;
        }

        public Criteria andDocumentsDetailNotBetween(String value1, String value2) {
            addCriterion("documents_detail not between", value1, value2, "documentsDetail");
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