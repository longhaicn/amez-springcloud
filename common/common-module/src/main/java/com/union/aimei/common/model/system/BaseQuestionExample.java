package com.union.aimei.common.model.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author liufeihua
 */
public class BaseQuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseQuestionExample() {
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

        public Criteria andQuestionTileIsNull() {
            addCriterion("question_tile is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTileIsNotNull() {
            addCriterion("question_tile is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTileEqualTo(String value) {
            addCriterion("question_tile =", value, "questionTile");
            return (Criteria) this;
        }

        public Criteria andQuestionTileNotEqualTo(String value) {
            addCriterion("question_tile <>", value, "questionTile");
            return (Criteria) this;
        }

        public Criteria andQuestionTileGreaterThan(String value) {
            addCriterion("question_tile >", value, "questionTile");
            return (Criteria) this;
        }

        public Criteria andQuestionTileGreaterThanOrEqualTo(String value) {
            addCriterion("question_tile >=", value, "questionTile");
            return (Criteria) this;
        }

        public Criteria andQuestionTileLessThan(String value) {
            addCriterion("question_tile <", value, "questionTile");
            return (Criteria) this;
        }

        public Criteria andQuestionTileLessThanOrEqualTo(String value) {
            addCriterion("question_tile <=", value, "questionTile");
            return (Criteria) this;
        }

        public Criteria andQuestionTileLike(String value) {
            addCriterion("question_tile like", value, "questionTile");
            return (Criteria) this;
        }

        public Criteria andQuestionTileNotLike(String value) {
            addCriterion("question_tile not like", value, "questionTile");
            return (Criteria) this;
        }

        public Criteria andQuestionTileIn(List<String> values) {
            addCriterion("question_tile in", values, "questionTile");
            return (Criteria) this;
        }

        public Criteria andQuestionTileNotIn(List<String> values) {
            addCriterion("question_tile not in", values, "questionTile");
            return (Criteria) this;
        }

        public Criteria andQuestionTileBetween(String value1, String value2) {
            addCriterion("question_tile between", value1, value2, "questionTile");
            return (Criteria) this;
        }

        public Criteria andQuestionTileNotBetween(String value1, String value2) {
            addCriterion("question_tile not between", value1, value2, "questionTile");
            return (Criteria) this;
        }

        public Criteria andQuestionContentIsNull() {
            addCriterion("question_content is null");
            return (Criteria) this;
        }

        public Criteria andQuestionContentIsNotNull() {
            addCriterion("question_content is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionContentEqualTo(String value) {
            addCriterion("question_content =", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotEqualTo(String value) {
            addCriterion("question_content <>", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentGreaterThan(String value) {
            addCriterion("question_content >", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentGreaterThanOrEqualTo(String value) {
            addCriterion("question_content >=", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentLessThan(String value) {
            addCriterion("question_content <", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentLessThanOrEqualTo(String value) {
            addCriterion("question_content <=", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentLike(String value) {
            addCriterion("question_content like", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotLike(String value) {
            addCriterion("question_content not like", value, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentIn(List<String> values) {
            addCriterion("question_content in", values, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotIn(List<String> values) {
            addCriterion("question_content not in", values, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentBetween(String value1, String value2) {
            addCriterion("question_content between", value1, value2, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionContentNotBetween(String value1, String value2) {
            addCriterion("question_content not between", value1, value2, "questionContent");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIdIsNull() {
            addCriterion("question_type_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIdIsNotNull() {
            addCriterion("question_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIdEqualTo(Byte value) {
            addCriterion("question_type_id =", value, "questionTypeId");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIdNotEqualTo(Byte value) {
            addCriterion("question_type_id <>", value, "questionTypeId");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIdGreaterThan(Byte value) {
            addCriterion("question_type_id >", value, "questionTypeId");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("question_type_id >=", value, "questionTypeId");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIdLessThan(Byte value) {
            addCriterion("question_type_id <", value, "questionTypeId");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIdLessThanOrEqualTo(Byte value) {
            addCriterion("question_type_id <=", value, "questionTypeId");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIdIn(List<Byte> values) {
            addCriterion("question_type_id in", values, "questionTypeId");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIdNotIn(List<Byte> values) {
            addCriterion("question_type_id not in", values, "questionTypeId");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIdBetween(Byte value1, Byte value2) {
            addCriterion("question_type_id between", value1, value2, "questionTypeId");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIdNotBetween(Byte value1, Byte value2) {
            addCriterion("question_type_id not between", value1, value2, "questionTypeId");
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